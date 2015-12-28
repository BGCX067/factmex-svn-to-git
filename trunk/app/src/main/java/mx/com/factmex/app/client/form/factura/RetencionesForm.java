package mx.com.factmex.app.client.form.factura;


import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class RetencionesForm extends Canvas {
	public ListGrid retencionesGrid;
	public RetencionesForm(){
		
		retencionesGrid = new ListGrid();
        retencionesGrid.setWidth(550);
        retencionesGrid.setHeight(224);
        retencionesGrid.setShowAllRecords(true);
        retencionesGrid.setCellHeight(22);
        //countryGrid.setDataSource(CountryXmlDS.getInstance());

        retencionesGrid.setShowRecordComponents(true);        
        retencionesGrid.setShowRecordComponentsByCell(true);
        retencionesGrid.setCanRemoveRecords(true);
        

        SelectItem impuestoSelectItem = new SelectItem();  
        impuestoSelectItem.setValueMap("ISR", "IVA");
        
        ListGridField impuestoField = new ListGridField("impuesto", "Impuesto");
        impuestoField.setEditorType(impuestoSelectItem);
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
        importeField.setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return "$" + nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        }); 
       
        
        retencionesGrid.setFields(impuestoField, tasaField);

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
      
        
        this.addChild(retencionesGrid);
        this.addChild(button);
	}

}
