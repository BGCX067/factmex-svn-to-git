package mx.com.factmex.app.client.to.response;

import java.io.Serializable;

import mx.com.factmex.app.client.to.Session;

public class Response implements Serializable {
	private static final long serialVersionUID = 7539724991985728594L;
	private Session session;
	private String simpleValue;
	public String getSimpleValue() {
		return simpleValue;
	}
	public void setSimpleValue(String simpleValue) {
		this.simpleValue = simpleValue;
	}
	public Response(){

		session = new Session();
	}
	public Response(boolean success, String message){

		session = new Session();
		this.success = success;
		this.message = message;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	private boolean success;
	private String message;
	private String data[][];
	public String[][] getData() {
		return data;
	}
	public void setData(String[][] data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
