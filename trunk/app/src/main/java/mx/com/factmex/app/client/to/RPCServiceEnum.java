package mx.com.factmex.app.client.to;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public enum RPCServiceEnum implements Serializable, IsSerializable {
	Factura("FacturaService"),
	Login("LoginService");
	
	String name;
	private static final long serialVersionUID = 1L;
	RPCServiceEnum(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
