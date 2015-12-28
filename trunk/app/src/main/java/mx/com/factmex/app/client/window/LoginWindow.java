package mx.com.factmex.app.client.window;

import mx.com.factmex.app.client.RPCService;
import mx.com.factmex.app.client.RPCServiceAsync;
import mx.com.factmex.app.client.ds.CboEmisoresDS;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.request.ValidaUsuarioRequest;
import mx.com.factmex.app.client.to.response.Response;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

public class LoginWindow extends Window {
	LoginWindow currentWindow;
	public LoginWindow() {
		final ValuesManager vm = new ValuesManager();
		currentWindow = this;
		this.setWidth(300);  
		this.setHeight(150);  
		this.setTitle("Seguridad");  
		this.setShowMinimizeButton(false);  
		this.setIsModal(true);  
		this.setShowModalMask(true);  
		this.setCanDrag(false);
		this.setShowCloseButton(false);
        this.centerInPage();  
       
        
        this.setHeaderIcon("icons/16/person.png");
        final DynamicForm form = new DynamicForm();
        form.setWidth100();  
        form.setPadding(5);
        form.setLayoutAlign(VerticalAlignment.BOTTOM);  
        final TextItem txtUsuario = new TextItem();  
        txtUsuario.setTitle("Usuario");
        txtUsuario.setRequired(true);
        
        final PasswordItem txtPassword = new PasswordItem();
        txtPassword.setTitle("Password");
        txtPassword.setRequired(true);
        
        final SelectItem cboEmisores = new SelectItem();  
        final CboEmisoresDS cboEmisoresDS = new CboEmisoresDS();
        //cboEmisores.setName("nombre");  
        cboEmisores.setDisplayField("nombre");
        cboEmisores.setValueField("idEmisor");
        cboEmisores.setPickListWidth(210);  
        cboEmisores.setTitle("Emisor");  
        cboEmisores.setRequired(true);
        cboEmisores.setOptionDataSource(cboEmisoresDS);
        form.setValuesManager(vm);
        
        HLayout buttonLayout = new HLayout(15);
        buttonLayout.setAlign(Alignment.CENTER);
        final IButton buttonAceptar = new IButton("Aceptar");
        buttonAceptar.setDisabled(true);
        
        final IButton buttonCancelar = new IButton("Limpiar");  
        
        buttonAceptar.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {  
            	vm.validate();
				if (!form.hasErrors()) {
					RPCServiceAsync service = RPCService.Util.getInstance();
					ValidaUsuarioRequest validaUsuarioRequest = new ValidaUsuarioRequest("LoginService" , "validaUsuario");
					validaUsuarioRequest.setUsuario(txtUsuario.getValue().toString());
					validaUsuarioRequest.setPassword(txtPassword.getValue().toString());
					validaUsuarioRequest.setIdEmisor(new Integer(cboEmisores.getValue().toString()));
					buttonAceptar.setDisabled(true);
					service.invoke(validaUsuarioRequest, new AsyncCallback<Response>() {
						public void onFailure(Throwable caught) {
							SC.say("Error al obtener los datos de la aplicacion: " + caught.getMessage());
							buttonAceptar.setDisabled(false);
						}

						public void onSuccess(Response response) {
							if(response.isSuccess()){
								if(response.getMessage() != null){
									SC.say(response.getMessage());
								}
								currentWindow.destroy();
							} else {
								SC.warn(response.getMessage());
								buttonAceptar.setDisabled(false);
							}
						}
					});
				}
                
            }  
        });  
        buttonLayout.addMember(buttonAceptar);
        
        buttonCancelar.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {  
                txtUsuario.setValue("");
                txtPassword.setValue("");
                
            }  
        });  
        buttonLayout.addMember(buttonCancelar);
        form.setFields(txtUsuario, txtPassword, cboEmisores);  
        this.addItem(form);  
        this.addItem(buttonLayout);
        
        
        RPCServiceAsync service = RPCService.Util.getInstance();
		service.invoke(new Request("EmisorService" , "obtenEmisoresCompaniaActual"), new AsyncCallback<Response>() {
			public void onFailure(Throwable caught) {
				SC.say("Error al obtener los datos de la aplicacion: " + caught.getMessage());
			}

			public void onSuccess(Response response) {
				buttonAceptar.setDisabled(false);
				for(String [] data : response.getData()){
					ListGridRecord record = new ListGridRecord();
					record.setAttribute("idEmisor", data[0]);
					record.setAttribute("nombre", data[1]);
					cboEmisoresDS.addData(record);
				}
			}
		});
        
	}
}
