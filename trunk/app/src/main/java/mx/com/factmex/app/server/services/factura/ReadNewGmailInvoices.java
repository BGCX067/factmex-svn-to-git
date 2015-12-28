package mx.com.factmex.app.server.services.factura;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.search.FlagTerm;

import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.ParseComprobanteException;
import mx.com.factmex.app.server.services.rpc.FacturaService;

public class ReadNewGmailInvoices {
	private Folder folder = null;
	private Message message = null;
	private Message[] messages = null;
	private String idEmisor = null;
	public ReadNewGmailInvoices(String idEmisor){
		this.idEmisor = idEmisor;
	}
	public void retriveNewXMLMessages(String gmailUser, String gmailPwd, String xmlPath) throws MessagingException, IOException, ParseComprobanteException, SQLException, Exception {
		Properties prop = new Properties();

    	// Deshabilitamos TLS
    	prop.setProperty("mail.pop3.starttls.enable", "false");

    	// Hay que usar SSL
    	prop.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory" );
    	prop.setProperty("mail.imap.socketFactory.fallback", "false");

    	// Puerto 995 para conectarse.
    	prop.setProperty("mail.imap.port","995");
    	prop.setProperty("mail.imap.connectiontimeout", "5000"); 
    	prop.setProperty("mail.imap.timeout", "5000"); 
    	prop.setProperty("mail.imap.socketFactory.port", "995");

    	Session sesion = Session.getInstance(prop);

    	// Para obtener un log más extenso.
    	//sesion.setDebug(true);
    	
    	Store store = sesion.getStore("imaps");
    	store.connect("imap.gmail.com",gmailUser,gmailPwd);
		//store.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER,SMTP_AUTH_PWD);

		// Get a handle on the default folder
		folder = store.getDefaultFolder();

		// Retrieve the "Inbox"
		folder = folder.getFolder("INBOX");

		//Reading the Email Index in Read / Write Mode
		folder.open(Folder.READ_WRITE);

	    messages = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));


		// Retrieve the messages
		//messages = folder.getMessages();

		if (messages.length == 0) {
			System.out.println("No Message to Read");
		} else {
			System.out.println("Total new Messages Found:" + messages.length + "");
		}

		// Loop over all of the messages
		for (int messageNumber = 0; messageNumber < messages.length; messageNumber++) {

			// Retrieve the next message to be read
			message = messages[messageNumber];
			
			if (!message.isSet(Flags.Flag.SEEN) && !message.isSet(Flags.Flag.ANSWERED)) {
				//Here you will read all the email content which are unread
				 System.out.println("From:"+message.getFrom()[0].toString());
	        	 System.out.println("Subject:"+message.getSubject());
	        	 //TODO Marcar como visto el mensaje
	        	 //message.setFlag(Flags.Flag.SEEN, true);
	        	 
	        	 //Get attachments
	        	 Multipart multipart = (Multipart) message.getContent();
	        	 for (int i=0, n=multipart.getCount(); i<n; i++) {
	        	   Part part = multipart.getBodyPart(i);

	        	   String disposition = part.getDisposition();

	        	   if (disposition != null && disposition.equals("ATTACHMENT")) {
	        		   //Se registra el archivo en base de datos
	        		  FacturaService facturaService = new FacturaService();
	        		  facturaService.idEmisor = idEmisor;
	        	     if(part.getFileName().endsWith(".xml")){
	        	    	 if(convertStreamToString(part.getInputStream()).contains("Comprobante")){
	        	    		 	//String fileName = System.currentTimeMillis() + "";
	        	    		 	 //File file = new File( xmlPath + fileName + ".xml");
	        	    		 	String fileName = part.getFileName();
	        	    		 	File pathXmlrecibidos = new File(xmlPath);
	        	    		 	if(!pathXmlrecibidos.exists()){
	        	    	        	pathXmlrecibidos.mkdir();
	        	    		 	}
	        	    		 	File file = new File(pathXmlrecibidos+"\\"+fileName);
	        					 FileOutputStream out = new FileOutputStream(pathXmlrecibidos+"\\"+fileName);
	        					 InputStream is = part.getInputStream();
	        		    	     int write = 0;
	        		    	     while (-1!=(write=is.read()))
	        		    	     {
	        		    	        out.write(write);
	        		    	     }
	        		    	     
	        		    	     //Tipo de comprobante: 1
	        		    	     facturaService.registraFacturaDB(fileName, file , "3" , "1" , null); //Estatus recibido para comprobantes
	        		    	     String imagen  = FacturaService.getParameterString(idEmisor,ParametrosEnum.RUTA_IMAGEN_FACTURA.getParam());
	        		    	     String coordenadas  = FacturaService.getParameterString(idEmisor,ParametrosEnum.RUTA_COORDENADAS_FACTURA.getParam());
	        		    	     String anoMes = formatDate(new Date(), "yyyy-MM");
	        		    	     String pdfPath = FacturaService.getParameterString(idEmisor,ParametrosEnum.RUTA_PDF_FACTURAS.getParam())+"\\"+anoMes+"\\recibidas";
	        		    	     File validaPathPdf = new File(pdfPath);
	        		    	    if(!validaPathPdf.exists()){
	        		    	    	 validaPathPdf.mkdir();
	        		    	     }
	        		 	         LIB cfdLibrary = new LIB();
	        		    	     cfdLibrary.CreaPDF(xmlPath +"\\"+ fileName.substring(0,fileName.length()-4) + ".xml", imagen, pdfPath +"\\"+ fileName.substring(0,fileName.length()-4) + ".pdf", "Mexico", coordenadas);
	        				
	        	    	 }
		        	     
	        	     }

	        	   }
	        	 }


			}
		}

		
		folder.close(true);
		store.close();
	}
		public String formatDate(Date date, String format){
			Format formatter = new SimpleDateFormat(format);
			return formatter.format(date);
		}

	public String convertStreamToString(InputStream is)
    throws IOException {
				/*
				 * To convert the InputStream to String we use the
				 * Reader.read(char[] buffer) method. We iterate until the
				 * Reader return -1 which means there's no more data to
				 * read. We use the StringWriter class to produce the string.
				 */
				if (is != null) {
				    Writer writer = new StringWriter();
				
				    char[] buffer = new char[1024];
				    try {
				        Reader reader = new BufferedReader(
				                new InputStreamReader(is, "UTF-8"));
				        int n;
				        while ((n = reader.read(buffer)) != -1) {
				            writer.write(buffer, 0, n);
				        }
				    } finally {
				        is.close();
				    }
				    return writer.toString();
				} else {        
				    return "";
				}
	}
}