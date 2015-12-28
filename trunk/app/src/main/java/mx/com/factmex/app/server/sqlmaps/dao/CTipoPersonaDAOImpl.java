package mx.com.factmex.app.server.sqlmaps.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import mx.com.factmex.app.server.sqlmaps.model.CTipoPersona;
import mx.com.factmex.app.server.sqlmaps.model.CTipoPersonaExample;

public class CTipoPersonaDAOImpl implements CTipoPersonaDAO {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private SqlMapClient sqlMapClient;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public CTipoPersonaDAOImpl(SqlMapClient sqlMapClient) {
		super();
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int countByExample(CTipoPersonaExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"C_TIPO_PERSONA.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int deleteByExample(CTipoPersonaExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"C_TIPO_PERSONA.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int deleteByPrimaryKey(String idTipoPersona) throws SQLException {
		CTipoPersona key = new CTipoPersona();
		key.setIdTipoPersona(idTipoPersona);
		int rows = sqlMapClient.delete(
				"C_TIPO_PERSONA.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void insert(CTipoPersona record) throws SQLException {
		sqlMapClient.insert("C_TIPO_PERSONA.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void insertSelective(CTipoPersona record) throws SQLException {
		sqlMapClient.insert("C_TIPO_PERSONA.ibatorgenerated_insertSelective",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public List selectByExample(CTipoPersonaExample example)
			throws SQLException {
		List list = sqlMapClient.queryForList(
				"C_TIPO_PERSONA.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public CTipoPersona selectByPrimaryKey(String idTipoPersona)
			throws SQLException {
		CTipoPersona key = new CTipoPersona();
		key.setIdTipoPersona(idTipoPersona);
		CTipoPersona record = (CTipoPersona) sqlMapClient.queryForObject(
				"C_TIPO_PERSONA.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int updateByExampleSelective(CTipoPersona record,
			CTipoPersonaExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"C_TIPO_PERSONA.ibatorgenerated_updateByExampleSelective",
				parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int updateByExample(CTipoPersona record, CTipoPersonaExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"C_TIPO_PERSONA.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int updateByPrimaryKeySelective(CTipoPersona record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"C_TIPO_PERSONA.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int updateByPrimaryKey(CTipoPersona record) throws SQLException {
		int rows = sqlMapClient.update(
				"C_TIPO_PERSONA.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table C_TIPO_PERSONA
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private static class UpdateByExampleParms extends CTipoPersonaExample {
		private Object record;

		public UpdateByExampleParms(Object record, CTipoPersonaExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}