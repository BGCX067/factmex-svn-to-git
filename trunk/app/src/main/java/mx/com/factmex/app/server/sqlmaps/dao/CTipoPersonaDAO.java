package mx.com.factmex.app.server.sqlmaps.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import mx.com.factmex.app.server.sqlmaps.model.CTipoPersona;
import mx.com.factmex.app.server.sqlmaps.model.CTipoPersonaExample;

public interface CTipoPersonaDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int countByExample(CTipoPersonaExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int deleteByExample(CTipoPersonaExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int deleteByPrimaryKey(String idTipoPersona) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	void insert(CTipoPersona record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	void insertSelective(CTipoPersona record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	List selectByExample(CTipoPersonaExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	CTipoPersona selectByPrimaryKey(String idTipoPersona) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByExampleSelective(CTipoPersona record,
			CTipoPersonaExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByExample(CTipoPersona record, CTipoPersonaExample example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByPrimaryKeySelective(CTipoPersona record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	int updateByPrimaryKey(CTipoPersona record) throws SQLException;
}