package mx.com.factmex.app.client.to.model;

import java.io.Serializable;

public class ReporteMensual implements Serializable{
	public ReporteMensual(){
		
	}
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
		this.mes = mes;
	}
}
