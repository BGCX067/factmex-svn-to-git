import javax.swing.JFrame;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFactMexForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String url = "http://127.0.0.1:8080/mx.com.factmex.app.Application/Application.html";
	public static String propertiesFile = "C:\\factmex\\factmex.properties";
	private static String jarFile = "C:\\factmex\\app-0.0.1-SNAPSHOT-standalone.jar";
    public JLabel jLabel1 = new JLabel();
    public JButton btnCambiar = new JButton();
    public JTextField txtBaseDatos = new JTextField();
    public JTextArea txtEventos = new JTextArea();
    private Process process;
    Properties properties;

    public MainFactMexForm() {
        try {
        	
        	jbInit();
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void inicia() throws IOException{
    	Process p = Runtime.getRuntime().exec("java -jar " + jarFile);
    	process = p;
    	Properties prop = new Properties();
		prop.load(new FileInputStream(propertiesFile));
    	this.properties = prop;
    	txtBaseDatos.setText(properties.get("jdbc.url").toString().replaceAll("jdbc:sqlite:", ""));
    	initApplication();
    }

    private void jbInit() throws Exception {
    	this.setResizable(false);
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(500, 283));
        this.setTitle( "Facturación Electronica" );
        jLabel1.setText("Base de Datos (factmex.db)");
        jLabel1.setBounds(new Rectangle(5, 210, 200, 15));
        jLabel1.setFont(new Font("Tahoma", 1, 14));
        btnCambiar.setText("Cambiar");
        btnCambiar.setBounds(new Rectangle(400, 205, 75, 21));
        btnCambiar.setFont(new Font("Tahoma", 2, 11));
        btnCambiar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        txtBaseDatos.setBounds(new Rectangle(5, 230, 480, 20));
        txtBaseDatos.setEnabled(false);
        //txtEventos.setBounds(new Rectangle(5, 15, 480, 180));
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(new Rectangle(5, 15, 480, 180));
        scroll.setAutoscrolls(true);
        scroll.setViewportView(txtEventos);
       
        this.getContentPane().add(scroll, null);
        this.getContentPane().add(txtBaseDatos, null);
        this.getContentPane().add(btnCambiar, null);
        this.getContentPane().add(jLabel1, null);
        this.addWindowListener( new WindowAdapter() {
        	   public void windowOpened( WindowEvent e ){
        	     }
        	   public void windowClosing( WindowEvent e ){
        		   process.destroy();
        	     }
        	   } ); 
        	
        }
    

    private void jButton1_actionPerformed(ActionEvent e) {
    	try{
    	JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("c:\\factmex"));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
          public boolean accept(File f) {
            return f.getName().toLowerCase().equals("factmex.db")
                || f.isDirectory();
          }

          public String getDescription() {
            return "Base de Datos de Facturación Electronica (factmex.db)";
          }
        });

        int r = chooser.showOpenDialog(new JFrame());
        if (r == JFileChooser.APPROVE_OPTION) {
          String path = chooser.getSelectedFile().getAbsolutePath();
          properties.setProperty("jdbc.url", "jdbc:sqlite:" + path);
          txtBaseDatos.setText(path);
          try {
			properties.store(new FileOutputStream(propertiesFile), null);
			process.destroy();
			//inicia();
			} catch (FileNotFoundException e1) {
				txtEventos.setText(e1.getMessage());
			} catch (IOException e1) {
				txtEventos.setText(e1.getMessage());
			}
        }
    	}catch(Exception ex){
    		txtEventos.setText(ex.getMessage());
    	}
    }
    
    public void initApplication(){
    	try{
    		txtEventos.setText("");
	    	boolean started = false;
	    	InputStream in = process.getInputStream();
			StringBuilder sb = new StringBuilder();
			int c;
				while((c=in.read()) != -1){ 
					sb.append((char)c);
					txtEventos.setText(sb.toString());
					if(!started && txtEventos.getText().contains("HTTP Listener started")){
						started = true;
						sb.append("\nIniciando " + url);
						java.net.URI uri = new java.net.URI( url );
						java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
						desktop.browse( uri );
					}
				}
			in.close();
		
		}catch(IOException e) {
			txtEventos.setText(txtEventos.getText() + e.getMessage());
			System.err.println("Error en la carga");
		}catch(URISyntaxException e) {
			txtEventos.setText(txtEventos.getText() + e.getMessage());
			System.err.println("Error en la carga");
		}
    }
}
