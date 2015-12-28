package mx.com.factmex.app.client.to.response;

import mx.com.factmex.app.client.to.request.FacturaRequest;

public class FacturaResponse extends Response {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8121087495152406285L;
	private FacturaRequest request;

	public FacturaResponse(){
		
	}
	public FacturaRequest getRequest() {
		return request;
	}

	public void setRequest(FacturaRequest request) {
		this.request = request;
	}
	
}
