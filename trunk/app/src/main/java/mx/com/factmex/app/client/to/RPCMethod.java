package mx.com.factmex.app.client.to;

import java.io.Serializable;

public enum RPCMethod implements Serializable {
	validaUsuario("validaUsuario");
	
	String name;
	RPCMethod(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
