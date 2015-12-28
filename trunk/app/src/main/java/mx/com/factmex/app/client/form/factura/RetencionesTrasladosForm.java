package mx.com.factmex.app.client.form.factura;


import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.SortNormalizer;

public class RetencionesTrasladosForm extends Canvas {
	public RetencionesTrasladosForm(){
		
		final ListGrid retencionesGrid = new ListGrid();
        retencionesGrid.setWidth(550);
        retencionesGrid.setHeight(224);
        retencionesGrid.setShowAllRecords(true);
        retencionesGrid.setCellHeight(22);
        //countryGrid.setDataSource(CountryXmlDS.getInstance());

        

        ListGridField impuestoField = new ListGridField("impuesto", "Impuesto");
        impuestoField.setShowGridSummary(false);
        impuestoField.setRequired(true);
        
        ListGridField tasaField = new ListGridField("tasa", "Tasa");
        tasaField.setShowGridSummary(false);
        tasaField.setType(ListGridFieldType.FLOAT);
        tasaField.setRequired(true);
        
        ListGridField importeField = new ListGridField("importe", "Importe");
        importeField.setType(ListGridFieldType.FLOAT);
        importeField.setShowGridSummary(true);
        importeField.setRequired(true);
       
        
        retencionesGrid.setFields(impuestoField, tasaField, importeField);

        //countryGrid.setAutoFetchData(true);
        retencionesGrid.setCanEdit(true);
        retencionesGrid.setShowGridSummary(true);
        retencionesGrid.setEditEvent(ListGridEditEvent.CLICK);
        retencionesGrid.setListEndEditAction(RowEndEditAction.NEXT);
        

        IButton button = new IButton("Agregar");
        button.setTop(250);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                retencionesGrid.startEditingNew();
            }
        });
        
        IButton buttonEliminar = new IButton("Eliminar");
        buttonEliminar.setTop(300);
        buttonEliminar.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                retencionesGrid.removeSelectedData();
            }
        });
        
        this.addChild(retencionesGrid);
        this.addChild(button);
        this.addChild(buttonEliminar);
	}

}
