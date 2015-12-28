package mx.com.factmex.app.client.to.response;

import java.util.ArrayList;
import java.util.List;

import mx.com.factmex.app.client.to.model.Serie;

public class ListSeriesResponse extends Response {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4021585320563086251L;
	List<Serie> series = new ArrayList<Serie>();

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	
}
