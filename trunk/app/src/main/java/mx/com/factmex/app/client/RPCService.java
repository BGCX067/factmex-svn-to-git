package mx.com.factmex.app.client;

import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.Response;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface RPCService extends RemoteService {

	public static final String SERVICE_URI = "rpcservice";

	public static class Util {

		public static RPCServiceAsync getInstance() {

			RPCServiceAsync instance = (RPCServiceAsync) GWT
					.create(RPCService.class);
			ServiceDefTarget target = (ServiceDefTarget) instance;
			target.setServiceEntryPoint(GWT.getModuleBaseURL() + SERVICE_URI);
			return instance;
		}
	}
	
	public Response invoke(Request request);
	public boolean isActiveSession();
}
