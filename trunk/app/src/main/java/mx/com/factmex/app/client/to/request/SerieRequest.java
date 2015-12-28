package mx.com.factmex.app.client.to.request;

import mx.com.factmex.app.client.to.model.Serie;

public class SerieRequest extends Request {
	/**
	 * SERIAL
	 */
	private static final long serialVersionUID = -2531837947910635993L;
	Serie serie = new Serie();
	public SerieRequest(){
		
	}
	public SerieRequest(String string, String string2) {
		super(string , string2);
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
}
