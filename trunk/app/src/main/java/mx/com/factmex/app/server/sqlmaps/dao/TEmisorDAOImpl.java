package mx.com.factmex.app.server.sqlmaps.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import mx.com.factmex.app.server.sqlmaps.model.TEmisor;
import mx.com.factmex.app.server.sqlmaps.model.TEmisorExample;

public class TEmisorDAOImpl implements TEmisorDAO {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	private SqlMapClient sqlMapClient;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public TEmisorDAOImpl(SqlMapClient sqlMapClient) {
		super();
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public int countByExample(TEmisorExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"T_EMISOR.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public int deleteByExample(TEmisorExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"T_EMISOR.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public int deleteByPrimaryKey(String idEmisor) throws SQLException {
		TEmisor key = new TEmisor();
		key.setIdEmisor(idEmisor);
		int rows = sqlMapClient.delete(
				"T_EMISOR.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public void insert(TEmisor record) throws SQLException {
		sqlMapClient.insert("T_EMISOR.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public void insertSelective(TEmisor record) throws SQLException {
		sqlMapClient.insert("T_EMISOR.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public List selectByExample(TEmisorExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"T_EMISOR.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public TEmisor selectByPrimaryKey(String idEmisor) throws SQLException {
		TEmisor key = new TEmisor();
		key.setIdEmisor(idEmisor);
		TEmisor record = (TEmisor) sqlMapClient.queryForObject(
				"T_EMISOR.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public int updateByExampleSelective(TEmisor record, TEmisorExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"T_EMISOR.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public int updateByExample(TEmisor record, TEmisorExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"T_EMISOR.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public int updateByPrimaryKeySelective(TEmisor record) throws SQLException {
		int rows = sqlMapClient.update(
				"T_EMISOR.ibatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	public int updateByPrimaryKey(TEmisor record) throws SQLException {
		int rows = sqlMapClient.update(
				"T_EMISOR.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table T_EMISOR
	 * @ibatorgenerated  Fri Oct 22 15:57:18 CDT 2010
	 */
	private static class UpdateByExampleParms extends TEmisorExample {
		private Object record;

		public UpdateByExampleParms(Object record, TEmisorExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}