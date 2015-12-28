package mx.com.factmex.app.client.form.factura;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import mx.com.factmex.app.client.PanelFactory;
import mx.com.factmex.app.client.ShowcasePanel;
import mx.com.factmex.app.client.grid.ClientesGrid;
import mx.com.factmex.app.client.window.ClienteWindow;

public class ListClientesForm extends ShowcasePanel {
    private static final String DESCRIPTION = "En esta pantalla se muestran todos los clientes , " + 
    		"para un emisor determinado.";

   
    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	ListClientesForm panel = new ListClientesForm();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public Canvas getViewPanel() {
    	 final ClientesGrid clientesGrid = new ClientesGrid();
    	 clientesGrid.updateData();
    	 VLayout vLayout = new VLayout();
    	 vLayout.setMembersMargin(10);
    	 IButton button = new IButton();  
         button.setIconAlign("CENTER");
         button.setHeight(30);  
         button.setWidth(120);              
         button.setIcon("silk/new.png");  
         button.setTitle("Nuevo Cliente");
         button.addClickHandler(new ClickHandler() {  
             public void onClick(ClickEvent event) {  
             	ClienteWindow clienteWindow = new ClienteWindow("I" , "Nuevo Cliente", "Nuevo Cliente", clientesGrid);
             	clienteWindow.show();
             }  
         });
    	 vLayout.addMember(button);
    	 vLayout.addMember(clientesGrid);
        
        return vLayout;
    }
   
    public String getIntro() {
        return DESCRIPTION;
    }

}