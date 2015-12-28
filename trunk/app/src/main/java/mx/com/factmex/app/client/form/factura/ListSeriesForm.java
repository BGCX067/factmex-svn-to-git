package mx.com.factmex.app.client.form.factura;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import mx.com.factmex.app.client.PanelFactory;
import mx.com.factmex.app.client.ShowcasePanel;
import mx.com.factmex.app.client.grid.ClientesGrid;
import mx.com.factmex.app.client.grid.SeriesGrid;
import mx.com.factmex.app.client.window.ClienteWindow;
import mx.com.factmex.app.client.window.SerieWindow;

public class ListSeriesForm extends ShowcasePanel {
    private static final String DESCRIPTION = "En esta pantalla se muestran todas las series , " + 
    		"para un emisor determinado.";

   
    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	ListSeriesForm panel = new ListSeriesForm();
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
    	 final SeriesGrid seriesGrid = new SeriesGrid(this);
    	 seriesGrid.updateData();
    	 VLayout vLayout = new VLayout();
    	 vLayout.setMembersMargin(10);
    	 IButton button = new IButton();  
         button.setIconAlign("CENTER");
         button.setHeight(30);  
         button.setWidth(120);              
         button.setIcon("silk/new.png");  
         button.setTitle("Nueva Serie");
         button.addClickHandler(new ClickHandler() {  
             public void onClick(ClickEvent event) {  
            	 SerieWindow serieWindow = new SerieWindow("I" , "Nueva Serie", "Nueva Serie", seriesGrid);
             	serieWindow.show();
             }  
         });
    	 vLayout.addMember(button);
    	 vLayout.addMember(seriesGrid);
        
        return vLayout;
    }
   
    public String getIntro() {
        return DESCRIPTION;
    }

}