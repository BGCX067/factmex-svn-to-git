package mx.com.factmex.app.server.sqlmaps.model;

import java.math.BigDecimal;

public class CEstatus {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column C_ESTATUS.ID_ESTATUS
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String idEstatus;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column C_ESTATUS.NOMBRE
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String nombre;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column C_ESTATUS.DESCRIPCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String descripcion;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column C_ESTATUS.ID_ESTATUS
	 * @return  the value of C_ESTATUS.ID_ESTATUS
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getIdEstatus() {
		return idEstatus;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column C_ESTATUS.ID_ESTATUS
	 * @param idEstatus  the value for C_ESTATUS.ID_ESTATUS
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setIdEstatus(String idEstatus) {
		this.idEstatus = idEstatus;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column C_ESTATUS.NOMBRE
	 * @return  the value of C_ESTATUS.NOMBRE
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column C_ESTATUS.NOMBRE
	 * @param nombre  the value for C_ESTATUS.NOMBRE
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column C_ESTATUS.DESCRIPCION
	 * @return  the value of C_ESTATUS.DESCRIPCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column C_ESTATUS.DESCRIPCION
	 * @param descripcion  the value for C_ESTATUS.DESCRIPCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}