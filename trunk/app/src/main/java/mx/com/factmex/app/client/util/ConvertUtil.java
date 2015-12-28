package mx.com.factmex.app.client.util;

import java.io.Serializable;

public class ConvertUtil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8289004184596026939L;

	public static String convertIsNull(Object obj){
		if(obj == null){
			return "";
		} else {
			return obj.toString();
		}
			
	}
	
	public static String convertIsNumberNull(Object obj){
		if(obj == null){
			return "0";
		} else {
			return obj.toString();
		}
			
	}
	
	public static boolean isNumeric(Object obj){
		try {
			new Integer(obj.toString());
			return true;
		} catch(Exception e){
			return false;
		}
	}
	

	public static double redondear(double numero,int digitos)
	{
	      int cifras=(int) Math.pow(10,digitos);
	      return Math.rint(numero*cifras)/cifras;
	}
}
