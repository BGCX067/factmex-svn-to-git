package mx.com.factmex.app.client.form.factura;

import java.util.LinkedHashMap;

import mx.com.factmex.app.client.PanelFactory;
import mx.com.factmex.app.client.RPCService;
import mx.com.factmex.app.client.RPCServiceAsync;
import mx.com.factmex.app.client.ShowcasePanel;
import mx.com.factmex.app.client.to.request.ReporteMensualRequest;
import mx.com.factmex.app.client.to.response.Response;
import mx.com.factmex.app.client.util.ConvertUtil;
import mx.com.factmex.app.client.window.DescargarComprobanteWindow;
import mx.com.factmex.app.client.window.DescargarReporteWindow;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class ReporteMensualForm extends ShowcasePanel {
	public ComboBoxItem cboAnio;
	public ComboBoxItem cboMes;
	public TextItem itemAno;
	public IButton button;
	private static final String DESCRIPTION = "En esta pantalla seleccionaras el anio y mes"
			+ " del Reporte Mensual a generar";

	public static class Factory implements PanelFactory {
		private String id;

		public Canvas create() {
			ReporteMensualForm panel = new ReporteMensualForm();
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

		final DynamicForm form = new DynamicForm();
		
		cboAnio= new ComboBoxItem();
		cboAnio.setTitle("Anio");
		cboAnio.setType("Anio");
		LinkedHashMap<String, String> valores = new LinkedHashMap<String, String>();
		valores.put("2010", "2010");
		valores.put("2011", "2011");
		valores.put("2012", "2012");
		valores.put("2013", "2013");
		valores.put("2014", "2014");
		valores.put("2015", "2015");
		cboAnio.setValueMap(valores);
		cboAnio.setRequired(true);
		cboMes = new ComboBoxItem();
		cboMes.setTitle("Mes");
		cboMes.setType("Mes");
		//cboMes.setWidth(150);
		LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
		valueMap.put("01", "Enero");
		valueMap.put("02", "Febrero");
		valueMap.put("03", "Marzo");
		valueMap.put("04", "Abril");
		valueMap.put("05", "Mayo");
		valueMap.put("06", "Junio");
		valueMap.put("07", "Julio");
		valueMap.put("08", "Agosto");
		valueMap.put("09", "Septiembre");
		valueMap.put("10", "Octubre");
		valueMap.put("11", "Noviembre");
		valueMap.put("12", "Diciembre");
		cboMes.setValueMap(valueMap);
		cboMes.setRequired(true);
		form.setItems(cboAnio, cboMes);
		form.draw();
		VLayout vLayout = new VLayout();
		vLayout.setMembersMargin(10);

		button = new IButton();
		button.setIconAlign("CENTER");
		button.setHeight(30);
		button.setWidth(120);
		button.setIcon("silk/new.png");
		button.setTitle("Genera Reporte Mensual");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(cboAnio.getValue()==""||cboAnio.getValue()==null||cboMes.getValue()==""||cboMes.getValue()==null){
					SC.warn("Debe capturar los datos de anio y mes");
					return;
				}else{
					generaReporte();
				}
				

			}
		});
		vLayout.addMember(form);
		vLayout.addMember(button);

		return vLayout;
	}

	public void generaReporte() {
		DescargarReporteWindow descargaWindow = new DescargarReporteWindow(new Integer(ConvertUtil.convertIsNull(cboAnio.getValue())), new Integer(ConvertUtil.convertIsNull(cboMes.getValue())));
		descargaWindow.show();
		/*
		final RPCServiceAsync service = RPCService.Util.getInstance();
		final ReporteMensualRequest request = new ReporteMensualRequest(
				"ReporteService", "generaReporte");
		request.setAno(ConvertUtil.convertIsNull(itemAno.getValue()));
		request.setMes(ConvertUtil.convertIsNull(cboMes.getValue()));
		service.invoke(request, new AsyncCallback<Response>() {
			public void onFailure(Throwable caught) {
				SC.say("Error al obtener los datos de la aplicacion: "
						+ caught.getMessage());
			}

			public void onSuccess(Response response) {
				if (response.isSuccess()) {
					SC.say(response.getMessage());
					button.setDisabled(true);
				} else {
					SC.warn(response.getMessage());
					
					button.setDisabled(false);
				}
			}
		});
		*/
	}

	public String getIntro() {
		return DESCRIPTION;
	}

}
