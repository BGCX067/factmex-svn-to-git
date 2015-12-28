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
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.SortNormalizer;

public class TrasladosForm extends Canvas {
	public ListGrid trasladosGrid;
	public TrasladosForm(){
		
		trasladosGrid = new ListGrid();
        trasladosGrid.setWidth(550);
        trasladosGrid.setHeight(224);
        trasladosGrid.setShowAllRecords(true);
        trasladosGrid.setCellHeight(22);
        trasladosGrid.setCanRemoveRecords(true);
        //countryGrid.setDataSource(CountryXmlDS.getInstance());

        
        SelectItem impuestoSelectItem = new SelectItem();  
        impuestoSelectItem.setValueMap("IEPS", "IVA");
        
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
       
        
        trasladosGrid.setFields(impuestoField, tasaField);

        //countryGrid.setAutoFetchData(true);
        trasladosGrid.setCanEdit(true);
        trasladosGrid.setShowGridSummary(true);
        trasladosGrid.setEditEvent(ListGridEditEvent.CLICK);
        trasladosGrid.setListEndEditAction(RowEndEditAction.NEXT);
        

        IButton button = new IButton("Agregar");
        button.setTop(250);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                trasladosGrid.startEditingNew();
            }
        });
        
        
        this.addChild(trasladosGrid);
        this.addChild(button);
	}

}
