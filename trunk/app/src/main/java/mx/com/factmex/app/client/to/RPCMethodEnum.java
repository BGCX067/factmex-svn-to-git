package mx.com.factmex.app.client.to;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public enum RPCMethodEnum implements Serializable, IsSerializable {
	
	
	validaUsuario("validaUsuario");
	private static final long serialVersionUID = 1L;
	String name;
	RPCMethodEnum(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
