package mx.com.factmex.app.client;

import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.Response;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RPCServiceAsync {

	public void invoke(Request request, AsyncCallback<Response> callback);
	public void isActiveSession(AsyncCallback callback);
}
