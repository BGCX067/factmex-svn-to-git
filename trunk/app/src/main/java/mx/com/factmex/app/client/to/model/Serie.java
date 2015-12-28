package mx.com.factmex.app.client.to.model;

import java.io.Serializable;

public class Serie implements Serializable{

	private static final long serialVersionUID = -3714700119638374642L;
	public Serie(){
		
	}
	private String idSerie;
	private String serie;
	private String folioInicial;
	private String anioAprobacion;
	private String noAprobacion;
	private String folioFinal;
	
	public String getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(String idSerie) {
		this.idSerie = idSerie;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getFolioInicial() {
		return folioInicial;
	}
	public void setFolioInicial(String folioInicial) {
		this.folioInicial = folioInicial;
	}
	public String getAnioAprobacion() {
		return anioAprobacion;
	}
	public void setAnioAprobacion(String anioAprobacion) {
		this.anioAprobacion = anioAprobacion;
	}
	public String getNoAprobacion() {
		return noAprobacion;
	}
	public void setNoAprobacion(String noAprobacion) {
		this.noAprobacion = noAprobacion;
	}
	public String getFolioFinal() {
		return folioFinal;
	}
	public void setFolioFinal(String folioFinal) {
		this.folioFinal = folioFinal;
	}

	
	
	
	
}
