package mx.com.factmex.app.server.sqlmaps.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import mx.com.factmex.app.server.sqlmaps.model.TDireccion;
import mx.com.factmex.app.server.sqlmaps.model.TDireccionExample;

public interface TDireccionDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int countByExample(TDireccionExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int deleteByExample(TDireccionExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int deleteByPrimaryKey(String idDireccion) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	void insert(TDireccion record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	void insertSelective(TDireccion record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	List selectByExample(TDireccionExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	TDireccion selectByPrimaryKey(String idDireccion) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByExampleSelective(TDireccion record, TDireccionExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByExample(TDireccion record, TDireccionExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByPrimaryKeySelective(TDireccion record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByPrimaryKey(TDireccion record) throws SQLException;
}