package mx.com.factmex.app.server.sqlmaps.model;

import java.math.BigDecimal;
import java.util.Date;

public class TUsuario {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column T_USUARIO.ID_USUARIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String idUsuario;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column T_USUARIO.NOMBRE
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String nombre;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column T_USUARIO.APELLIDOS
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String apellidos;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column T_USUARIO.USUARIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String usuario;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column T_USUARIO.PASSWORD
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String password;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column T_USUARIO.FECHA_FIN
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String fechaFin;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column T_USUARIO.ID_PERFIL
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String idPerfil;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column T_USUARIO.ID_EMISOR
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private String idEmisor;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column T_USUARIO.ID_USUARIO
	 * @return  the value of T_USUARIO.ID_USUARIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getIdUsuario() {
		return idUsuario;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column T_USUARIO.ID_USUARIO
	 * @param idUsuario  the value for T_USUARIO.ID_USUARIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column T_USUARIO.NOMBRE
	 * @return  the value of T_USUARIO.NOMBRE
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column T_USUARIO.NOMBRE
	 * @param nombre  the value for T_USUARIO.NOMBRE
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column T_USUARIO.APELLIDOS
	 * @return  the value of T_USUARIO.APELLIDOS
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column T_USUARIO.APELLIDOS
	 * @param apellidos  the value for T_USUARIO.APELLIDOS
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column T_USUARIO.USUARIO
	 * @return  the value of T_USUARIO.USUARIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column T_USUARIO.USUARIO
	 * @param usuario  the value for T_USUARIO.USUARIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column T_USUARIO.PASSWORD
	 * @return  the value of T_USUARIO.PASSWORD
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column T_USUARIO.PASSWORD
	 * @param password  the value for T_USUARIO.PASSWORD
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column T_USUARIO.FECHA_FIN
	 * @return  the value of T_USUARIO.FECHA_FIN
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getFechaFin() {
		return fechaFin;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column T_USUARIO.FECHA_FIN
	 * @param fechaFin  the value for T_USUARIO.FECHA_FIN
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column T_USUARIO.ID_PERFIL
	 * @return  the value of T_USUARIO.ID_PERFIL
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getIdPerfil() {
		return idPerfil;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column T_USUARIO.ID_PERFIL
	 * @param idPerfil  the value for T_USUARIO.ID_PERFIL
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column T_USUARIO.ID_EMISOR
	 * @return  the value of T_USUARIO.ID_EMISOR
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getIdEmisor() {
		return idEmisor;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column T_USUARIO.ID_EMISOR
	 * @param idEmisor  the value for T_USUARIO.ID_EMISOR
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setIdEmisor(String idEmisor) {
		this.idEmisor = idEmisor;
	}
}