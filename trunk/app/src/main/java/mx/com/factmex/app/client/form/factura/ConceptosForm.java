package mx.com.factmex.app.client.form.factura;


import mx.com.factmex.app.client.util.ConvertUtil;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.SortNormalizer;

public class ConceptosForm extends Canvas {
	public ListGrid conceptosGrid;
	public ConceptosForm(){
		
		conceptosGrid = new ListGrid();
        conceptosGrid.setWidth(550);
        conceptosGrid.setHeight(224);
        conceptosGrid.setShowAllRecords(true);
        conceptosGrid.setCellHeight(22);
        //countryGrid.setDataSource(CountryXmlDS.getInstance());
        conceptosGrid.setShowRecordComponents(true);        
        conceptosGrid.setShowRecordComponentsByCell(true);
        conceptosGrid.setCanRemoveRecords(true);
        

        ListGridField cantidadField = new ListGridField("cantidad", "Cantidad");
        cantidadField.setType(ListGridFieldType.INTEGER);
        cantidadField.setShowGridSummary(true);
        cantidadField.setRequired(true);
        
        ListGridField unidadField = new ListGridField("unidad", "Unidad");
        unidadField.setShowGridSummary(false);
        
        ListGridField descripcionField = new ListGridField("descripcion", "Descripcion");
        descripcionField.setRequired(true);
        
        ListGridField valorUnitarioField = new ListGridField("valorunitario", "Valor Unitario");
        valorUnitarioField.setShowGridSummary(true);
        valorUnitarioField.setType(ListGridFieldType.FLOAT);
        
        valorUnitarioField.setCellFormatter(new CellFormatter() {  
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
        
 
        ListGridField importeField = new ListGridField("importe", "Importe");
        importeField.setType(ListGridFieldType.FLOAT);
        importeField.setShowGridSummary(true);
        importeField.setCanEdit(false);	
        importeField.setIncludeInRecordSummary(true);
        importeField.setSummaryFunction(SummaryFunctionType.SUM);
        
        importeField.setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");
                    Double importe = new Double(ConvertUtil.convertIsNumberNull(record.getAttribute("cantidad"))).doubleValue() * new Double(ConvertUtil.convertIsNumberNull(record.getAttribute("valorunitario"))).doubleValue();
                    record.setAttribute("importe" , importe);
                    return "$" + nf.format(importe);  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        }); 
       
        
        conceptosGrid.setFields(cantidadField, unidadField, descripcionField, valorUnitarioField, importeField);

        //countryGrid.setAutoFetchData(true);
        conceptosGrid.setShowGridSummary(true);
        conceptosGrid.setCanEdit(true);
        conceptosGrid.setEditEvent(ListGridEditEvent.CLICK);
        conceptosGrid.setListEndEditAction(RowEndEditAction.NEXT);

        

        IButton button = new IButton("Agregar");
        button.setTop(250);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                conceptosGrid.startEditingNew();
            }
        });
        
        
        this.addChild(conceptosGrid);
        this.addChild(button);
	}

}
