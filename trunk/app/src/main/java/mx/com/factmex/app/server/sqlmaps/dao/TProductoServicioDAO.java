package mx.com.factmex.app.server.sqlmaps.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import mx.com.factmex.app.server.sqlmaps.model.TProductoServicio;
import mx.com.factmex.app.server.sqlmaps.model.TProductoServicioExample;

public interface TProductoServicioDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int countByExample(TProductoServicioExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int deleteByExample(TProductoServicioExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int deleteByPrimaryKey(String idProductoServicio) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	void insert(TProductoServicio record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	void insertSelective(TProductoServicio record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	List selectByExample(TProductoServicioExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	TProductoServicio selectByPrimaryKey(String idProductoServicio)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByExampleSelective(TProductoServicio record,
			TProductoServicioExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByExample(TProductoServicio record,
			TProductoServicioExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByPrimaryKeySelective(TProductoServicio record)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByPrimaryKey(TProductoServicio record) throws SQLException;
}