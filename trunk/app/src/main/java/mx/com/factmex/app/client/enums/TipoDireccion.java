package mx.com.factmex.app.client.enums;

public enum TipoDireccion {
	FISCAL(1),
	OTRA(2);
	private int idTipoDireccion;
	TipoDireccion(int idTipo){
		this.idTipoDireccion = idTipo;
	}
	
	public int getIdTipoDireccion(){
		return this.idTipoDireccion;
	}
	
}
