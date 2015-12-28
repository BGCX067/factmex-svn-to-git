package mx.com.factmex.app.client.form.factura;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;
import mx.com.factmex.app.client.PanelFactory;
import mx.com.factmex.app.client.ShowcasePanel;
import mx.com.factmex.app.client.grid.FacturasGrid;

public class FacturasEnviadasForm extends ShowcasePanel {
    private static final String DESCRIPTION = "En esta pantalla se muestran todas las facturas , " + 
    		"que han sido generadas.";


    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	FacturasEnviadasForm panel = new FacturasEnviadasForm();
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

        
        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(10);
        vLayout.addMember(new FacturasGrid(this, "1"));
        

        return vLayout;
    }
   
    public String getIntro() {
        return DESCRIPTION;
    }

}