package mx.com.factmex.app.client.to.request;

import java.io.Serializable;

import mx.com.factmex.app.client.to.Session;



public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5355195450776721794L;
	private String service;
	private String simpleValue = "";
	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getSimpleValue() {
		return simpleValue;
	}

	public void setSimpleValue(String simpleValue) {
		this.simpleValue = simpleValue;
	}

	public Request() {
		session = new Session();
	}
	
	public Request(String service, String method) {
		session = new Session();
		this.service = service;
		this.method = method;
	}
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	private String method;
}
