package mx.com.factmex.app.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import mx.com.factmex.app.client.RPCService;
import mx.com.factmex.app.client.to.Session;
import mx.com.factmex.app.client.to.request.*;
import mx.com.factmex.app.client.to.response.Response;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RPCServiceImpl extends RemoteServiceServlet implements
		RPCService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String servicePackage = "mx.com.factmex.app.server.services.rpc.";
	
	public Response invoke(Request request) {
		Response response = new Response();
		updateSessionValues(request.getSession());
		String serviceName = servicePackage + request.getService();
		String methodName = request.getMethod();
		
		try {
			Class clazz=Class.forName(serviceName);
			Class[] parameter = new Class[1];
			parameter[0] = Request.class;
		    
			Method method = clazz.getMethod(methodName,parameter);
			response = (Response) method.invoke(clazz.newInstance(), request);
			updateSessionValues(response.getSession());
			return response;

		} catch (ClassNotFoundException e) {
			response.setSuccess(false);
			response.setMessage("Error en el sistema: " + e.getMessage());
		} catch (NoSuchMethodException e) {
			response.setSuccess(false);
			response.setMessage("Error en el sistema: " + e.getMessage());
		} catch (InvocationTargetException e) {
			response.setSuccess(false);
			response.setMessage("Error en el sistema: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			response.setSuccess(false);
			response.setMessage("Error en el sistema: " + e.getMessage());
		} catch (IllegalAccessException e) {
			response.setSuccess(false);
			response.setMessage("Error en el sistema: " + e.getMessage());
		} catch (InstantiationException e) {
			response.setSuccess(false);
			response.setMessage("Error en el sistema: " + e.getMessage());
		}
		
		
		return response;
	}
	
	public void updateSessionValues(Session session){
		HttpSession httpSession = this.getThreadLocalRequest().getSession();
		Enumeration<String> e = httpSession.getAttributeNames();
		while(e.hasMoreElements()){
			String attribute = e.nextElement();
			Object value = httpSession.getAttribute(attribute);
			if(value != null){
				session.setProperty(attribute, value.toString());
			}
		}
		
		Iterator<String> iterator = session.getData().keySet().iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			Object value = session.getProperty(key);
			httpSession.setAttribute(key, value);
		}
		
	}
	
	public boolean isActiveSession() {
		HttpSession httpSession = this.getThreadLocalRequest().getSession();
		return (httpSession.getAttribute(Session.Property.IDEMISOR.getName()) != null);
	}
	
}
