package mx.com.factmex.app.client.to.request;

import mx.com.factmex.app.client.to.model.ReporteMensual;


public class ReporteMensualRequest extends Request {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ano;
	private String mes;
	
	public String getAno(){
		return ano;
	}
	public void setAno(String ano){
		this.ano=ano;
	}
	public String getMes(){
		return mes;
	}
	public void setMes(String mes){
		this.mes=mes;
	}
	ReporteMensual reporte = new ReporteMensual();
	
	public ReporteMensualRequest(){
		
	}
	public ReporteMensualRequest(String string, String string2) {
		super(string , string2);
	}

	public ReporteMensual getReporteMensual() {
		return reporte;
	}

	public void setReporteMensual(ReporteMensual reporte) {
		this.reporte = reporte;
	}
}