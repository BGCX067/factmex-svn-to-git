package mx.com.factmex.app.server.sqlmaps.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import mx.com.factmex.app.server.sqlmaps.model.TDireccion;
import mx.com.factmex.app.server.sqlmaps.model.TDireccionExample;

public class TDireccionDAOImpl implements TDireccionDAO {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private SqlMapClient sqlMapClient;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public TDireccionDAOImpl(SqlMapClient sqlMapClient) {
		super();
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int countByExample(TDireccionExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"T_DIRECCION.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int deleteByExample(TDireccionExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"T_DIRECCION.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int deleteByPrimaryKey(String idDireccion) throws SQLException {
		TDireccion key = new TDireccion();
		key.setIdDireccion(idDireccion);
		int rows = sqlMapClient.delete(
				"T_DIRECCION.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void insert(TDireccion record) throws SQLException {
		sqlMapClient.insert("T_DIRECCION.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void insertSelective(TDireccion record) throws SQLException {
		sqlMapClient.insert("T_DIRECCION.ibatorgenerated_insertSelective",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public List selectByExample(TDireccionExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"T_DIRECCION.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public TDireccion selectByPrimaryKey(String idDireccion)
			throws SQLException {
		TDireccion key = new TDireccion();
		key.setIdDireccion(idDireccion);
		TDireccion record = (TDireccion) sqlMapClient.queryForObject(
				"T_DIRECCION.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int updateByExampleSelective(TDireccion record,
			TDireccionExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"T_DIRECCION.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int updateByExample(TDireccion record, TDireccionExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"T_DIRECCION.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int updateByPrimaryKeySelective(TDireccion record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"T_DIRECCION.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public int updateByPrimaryKey(TDireccion record) throws SQLException {
		int rows = sqlMapClient.update(
				"T_DIRECCION.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table T_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	private static class UpdateByExampleParms extends TDireccionExample {
		private Object record;

		public UpdateByExampleParms(Object record, TDireccionExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}