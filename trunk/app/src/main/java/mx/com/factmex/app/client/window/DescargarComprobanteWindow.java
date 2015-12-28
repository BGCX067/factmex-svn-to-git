package mx.com.factmex.app.client.window;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public class DescargarComprobanteWindow extends Window {
	public DescargarComprobanteWindow(final int idComprobante) {
		this.setWidth(300);
		this.setHeight(100);
		this.setShowModalMask(true);
		this.setIsModal(true);  
		this.centerInPage();
		this.setTitle("Descargar Factura");
		
		final IButton xml = new IButton("XML");  
        xml.setWidth(100);  
        xml.setIcon("icons/16/xml.png");
        
        xml.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				com.google.gwt.user.client.Window.open(GWT.getModuleBaseURL() + "descargaFactura?tipo=xml&idComprobante=" + idComprobante, "_self", "");
			}
		});
        
        final IButton pdf = new IButton("PDF");  
        pdf.setWidth(100);  
        pdf.setIcon("icons/16/pdf.png");
        
        pdf.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				com.google.gwt.user.client.Window.open(GWT.getModuleBaseURL() + "descargaFactura?tipo=pdf&idComprobante=" + idComprobante, "_self", "");
			}
		});
		
		HLayout hLayout = new HLayout();
		hLayout.setAlign(VerticalAlignment.CENTER);
		hLayout.setAlign(Alignment.CENTER);
        hLayout.setMembersMargin(20);
        hLayout.setEdgeImage("edges/custom/sharpframe_10.png"); 
        hLayout.setLayoutMargin(10);
        hLayout.addMember(xml);  
        hLayout.addMember(pdf);  
        hLayout.setPageTop(40);
        
        this.addItem(hLayout);
	}
}
