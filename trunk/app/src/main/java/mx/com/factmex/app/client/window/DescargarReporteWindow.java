package mx.com.factmex.app.client.window;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public class DescargarReporteWindow extends Window {
	public DescargarReporteWindow(final int anio, final int mes) {
		this.setWidth(300);
		this.setHeight(100);
		this.setShowModalMask(true);
		this.setIsModal(true);  
		this.centerInPage();
		this.setTitle("Descargar Reporte");
		
		final IButton descarga = new IButton("Descarga");  
        descarga.setWidth(100);  
        descarga.setIcon("icons/16/save_as.png");
        
        descarga.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				com.google.gwt.user.client.Window.open(GWT.getModuleBaseURL() + "descargaReporte?anio="+anio+"&mes=" + mes, "_self", "");
			}
		});
        
        
		
		HLayout hLayout = new HLayout();
		hLayout.setAlign(VerticalAlignment.CENTER);
		hLayout.setAlign(Alignment.CENTER);
        hLayout.setMembersMargin(20);
        hLayout.setEdgeImage("edges/custom/sharpframe_10.png"); 
        hLayout.setLayoutMargin(10);
        hLayout.addMember(descarga);  
        hLayout.setPageTop(40);
        
        this.addItem(hLayout);
	}
}
