package mx.com.factmex.app.server.sqlmaps.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CParametroExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected List oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public CParametroExample() {
		oredCriteria = new ArrayList();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected CParametroExample(CParametroExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public List getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table C_PARAMETRO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public static class Criteria {
		protected List criteriaWithoutValue;
		protected List criteriaWithSingleValue;
		protected List criteriaWithListValue;
		protected List criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList();
			criteriaWithSingleValue = new ArrayList();
			criteriaWithListValue = new ArrayList();
			criteriaWithBetweenValue = new ArrayList();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition, List values,
				String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List list = new ArrayList();
			list.add(value1);
			list.add(value2);
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andIdParametroIsNull() {
			addCriterion("ID_PARAMETRO is null");
			return this;
		}

		public Criteria andIdParametroIsNotNull() {
			addCriterion("ID_PARAMETRO is not null");
			return this;
		}

		public Criteria andIdParametroEqualTo(String value) {
			addCriterion("ID_PARAMETRO =", value, "idParametro");
			return this;
		}

		public Criteria andIdParametroNotEqualTo(String value) {
			addCriterion("ID_PARAMETRO <>", value, "idParametro");
			return this;
		}

		public Criteria andIdParametroGreaterThan(String value) {
			addCriterion("ID_PARAMETRO >", value, "idParametro");
			return this;
		}

		public Criteria andIdParametroGreaterThanOrEqualTo(String value) {
			addCriterion("ID_PARAMETRO >=", value, "idParametro");
			return this;
		}

		public Criteria andIdParametroLessThan(String value) {
			addCriterion("ID_PARAMETRO <", value, "idParametro");
			return this;
		}

		public Criteria andIdParametroLessThanOrEqualTo(String value) {
			addCriterion("ID_PARAMETRO <=", value, "idParametro");
			return this;
		}

		public Criteria andIdParametroLike(String value) {
			addCriterion("ID_PARAMETRO like", value, "idParametro");
			return this;
		}

		public Criteria andIdParametroNotLike(String value) {
			addCriterion("ID_PARAMETRO not like", value, "idParametro");
			return this;
		}

		public Criteria andIdParametroIn(List values) {
			addCriterion("ID_PARAMETRO in", values, "idParametro");
			return this;
		}

		public Criteria andIdParametroNotIn(List values) {
			addCriterion("ID_PARAMETRO not in", values, "idParametro");
			return this;
		}

		public Criteria andIdParametroBetween(String value1, String value2) {
			addCriterion("ID_PARAMETRO between", value1, value2, "idParametro");
			return this;
		}

		public Criteria andIdParametroNotBetween(String value1, String value2) {
			addCriterion("ID_PARAMETRO not between", value1, value2,
					"idParametro");
			return this;
		}

		public Criteria andNombreIsNull() {
			addCriterion("NOMBRE is null");
			return this;
		}

		public Criteria andNombreIsNotNull() {
			addCriterion("NOMBRE is not null");
			return this;
		}

		public Criteria andNombreEqualTo(String value) {
			addCriterion("NOMBRE =", value, "nombre");
			return this;
		}

		public Criteria andNombreNotEqualTo(String value) {
			addCriterion("NOMBRE <>", value, "nombre");
			return this;
		}

		public Criteria andNombreGreaterThan(String value) {
			addCriterion("NOMBRE >", value, "nombre");
			return this;
		}

		public Criteria andNombreGreaterThanOrEqualTo(String value) {
			addCriterion("NOMBRE >=", value, "nombre");
			return this;
		}

		public Criteria andNombreLessThan(String value) {
			addCriterion("NOMBRE <", value, "nombre");
			return this;
		}

		public Criteria andNombreLessThanOrEqualTo(String value) {
			addCriterion("NOMBRE <=", value, "nombre");
			return this;
		}

		public Criteria andNombreLike(String value) {
			addCriterion("NOMBRE like", value, "nombre");
			return this;
		}

		public Criteria andNombreNotLike(String value) {
			addCriterion("NOMBRE not like", value, "nombre");
			return this;
		}

		public Criteria andNombreIn(List values) {
			addCriterion("NOMBRE in", values, "nombre");
			return this;
		}

		public Criteria andNombreNotIn(List values) {
			addCriterion("NOMBRE not in", values, "nombre");
			return this;
		}

		public Criteria andNombreBetween(String value1, String value2) {
			addCriterion("NOMBRE between", value1, value2, "nombre");
			return this;
		}

		public Criteria andNombreNotBetween(String value1, String value2) {
			addCriterion("NOMBRE not between", value1, value2, "nombre");
			return this;
		}

		public Criteria andDescripcionIsNull() {
			addCriterion("DESCRIPCION is null");
			return this;
		}

		public Criteria andDescripcionIsNotNull() {
			addCriterion("DESCRIPCION is not null");
			return this;
		}

		public Criteria andDescripcionEqualTo(String value) {
			addCriterion("DESCRIPCION =", value, "descripcion");
			return this;
		}

		public Criteria andDescripcionNotEqualTo(String value) {
			addCriterion("DESCRIPCION <>", value, "descripcion");
			return this;
		}

		public Criteria andDescripcionGreaterThan(String value) {
			addCriterion("DESCRIPCION >", value, "descripcion");
			return this;
		}

		public Criteria andDescripcionGreaterThanOrEqualTo(String value) {
			addCriterion("DESCRIPCION >=", value, "descripcion");
			return this;
		}

		public Criteria andDescripcionLessThan(String value) {
			addCriterion("DESCRIPCION <", value, "descripcion");
			return this;
		}

		public Criteria andDescripcionLessThanOrEqualTo(String value) {
			addCriterion("DESCRIPCION <=", value, "descripcion");
			return this;
		}

		public Criteria andDescripcionLike(String value) {
			addCriterion("DESCRIPCION like", value, "descripcion");
			return this;
		}

		public Criteria andDescripcionNotLike(String value) {
			addCriterion("DESCRIPCION not like", value, "descripcion");
			return this;
		}

		public Criteria andDescripcionIn(List values) {
			addCriterion("DESCRIPCION in", values, "descripcion");
			return this;
		}

		public Criteria andDescripcionNotIn(List values) {
			addCriterion("DESCRIPCION not in", values, "descripcion");
			return this;
		}

		public Criteria andDescripcionBetween(String value1, String value2) {
			addCriterion("DESCRIPCION between", value1, value2, "descripcion");
			return this;
		}

		public Criteria andDescripcionNotBetween(String value1, String value2) {
			addCriterion("DESCRIPCION not between", value1, value2,
					"descripcion");
			return this;
		}

		public Criteria andValorNumericoIsNull() {
			addCriterion("VALOR_NUMERICO is null");
			return this;
		}

		public Criteria andValorNumericoIsNotNull() {
			addCriterion("VALOR_NUMERICO is not null");
			return this;
		}

		public Criteria andValorNumericoEqualTo(String value) {
			addCriterion("VALOR_NUMERICO =", value, "valorNumerico");
			return this;
		}

		public Criteria andValorNumericoNotEqualTo(String value) {
			addCriterion("VALOR_NUMERICO <>", value, "valorNumerico");
			return this;
		}

		public Criteria andValorNumericoGreaterThan(String value) {
			addCriterion("VALOR_NUMERICO >", value, "valorNumerico");
			return this;
		}

		public Criteria andValorNumericoGreaterThanOrEqualTo(String value) {
			addCriterion("VALOR_NUMERICO >=", value, "valorNumerico");
			return this;
		}

		public Criteria andValorNumericoLessThan(String value) {
			addCriterion("VALOR_NUMERICO <", value, "valorNumerico");
			return this;
		}

		public Criteria andValorNumericoLessThanOrEqualTo(String value) {
			addCriterion("VALOR_NUMERICO <=", value, "valorNumerico");
			return this;
		}

		public Criteria andValorNumericoLike(String value) {
			addCriterion("VALOR_NUMERICO like", value, "valorNumerico");
			return this;
		}

		public Criteria andValorNumericoNotLike(String value) {
			addCriterion("VALOR_NUMERICO not like", value, "valorNumerico");
			return this;
		}

		public Criteria andValorNumericoIn(List values) {
			addCriterion("VALOR_NUMERICO in", values, "valorNumerico");
			return this;
		}

		public Criteria andValorNumericoNotIn(List values) {
			addCriterion("VALOR_NUMERICO not in", values, "valorNumerico");
			return this;
		}

		public Criteria andValorNumericoBetween(String value1, String value2) {
			addCriterion("VALOR_NUMERICO between", value1, value2,
					"valorNumerico");
			return this;
		}

		public Criteria andValorNumericoNotBetween(String value1, String value2) {
			addCriterion("VALOR_NUMERICO not between", value1, value2,
					"valorNumerico");
			return this;
		}

		public Criteria andValorDecimalIsNull() {
			addCriterion("VALOR_DECIMAL is null");
			return this;
		}

		public Criteria andValorDecimalIsNotNull() {
			addCriterion("VALOR_DECIMAL is not null");
			return this;
		}

		public Criteria andValorDecimalEqualTo(String value) {
			addCriterion("VALOR_DECIMAL =", value, "valorDecimal");
			return this;
		}

		public Criteria andValorDecimalNotEqualTo(String value) {
			addCriterion("VALOR_DECIMAL <>", value, "valorDecimal");
			return this;
		}

		public Criteria andValorDecimalGreaterThan(String value) {
			addCriterion("VALOR_DECIMAL >", value, "valorDecimal");
			return this;
		}

		public Criteria andValorDecimalGreaterThanOrEqualTo(String value) {
			addCriterion("VALOR_DECIMAL >=", value, "valorDecimal");
			return this;
		}

		public Criteria andValorDecimalLessThan(String value) {
			addCriterion("VALOR_DECIMAL <", value, "valorDecimal");
			return this;
		}

		public Criteria andValorDecimalLessThanOrEqualTo(String value) {
			addCriterion("VALOR_DECIMAL <=", value, "valorDecimal");
			return this;
		}

		public Criteria andValorDecimalLike(String value) {
			addCriterion("VALOR_DECIMAL like", value, "valorDecimal");
			return this;
		}

		public Criteria andValorDecimalNotLike(String value) {
			addCriterion("VALOR_DECIMAL not like", value, "valorDecimal");
			return this;
		}

		public Criteria andValorDecimalIn(List values) {
			addCriterion("VALOR_DECIMAL in", values, "valorDecimal");
			return this;
		}

		public Criteria andValorDecimalNotIn(List values) {
			addCriterion("VALOR_DECIMAL not in", values, "valorDecimal");
			return this;
		}

		public Criteria andValorDecimalBetween(String value1, String value2) {
			addCriterion("VALOR_DECIMAL between", value1, value2,
					"valorDecimal");
			return this;
		}

		public Criteria andValorDecimalNotBetween(String value1, String value2) {
			addCriterion("VALOR_DECIMAL not between", value1, value2,
					"valorDecimal");
			return this;
		}

		public Criteria andValorCadenaIsNull() {
			addCriterion("VALOR_CADENA is null");
			return this;
		}

		public Criteria andValorCadenaIsNotNull() {
			addCriterion("VALOR_CADENA is not null");
			return this;
		}

		public Criteria andValorCadenaEqualTo(String value) {
			addCriterion("VALOR_CADENA =", value, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaNotEqualTo(String value) {
			addCriterion("VALOR_CADENA <>", value, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaGreaterThan(String value) {
			addCriterion("VALOR_CADENA >", value, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaGreaterThanOrEqualTo(String value) {
			addCriterion("VALOR_CADENA >=", value, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaLessThan(String value) {
			addCriterion("VALOR_CADENA <", value, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaLessThanOrEqualTo(String value) {
			addCriterion("VALOR_CADENA <=", value, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaLike(String value) {
			addCriterion("VALOR_CADENA like", value, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaNotLike(String value) {
			addCriterion("VALOR_CADENA not like", value, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaIn(List values) {
			addCriterion("VALOR_CADENA in", values, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaNotIn(List values) {
			addCriterion("VALOR_CADENA not in", values, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaBetween(String value1, String value2) {
			addCriterion("VALOR_CADENA between", value1, value2, "valorCadena");
			return this;
		}

		public Criteria andValorCadenaNotBetween(String value1, String value2) {
			addCriterion("VALOR_CADENA not between", value1, value2,
					"valorCadena");
			return this;
		}

		public Criteria andIdEmisorIsNull() {
			addCriterion("ID_EMISOR is null");
			return this;
		}

		public Criteria andIdEmisorIsNotNull() {
			addCriterion("ID_EMISOR is not null");
			return this;
		}

		public Criteria andIdEmisorEqualTo(String value) {
			addCriterion("ID_EMISOR =", value, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorNotEqualTo(String value) {
			addCriterion("ID_EMISOR <>", value, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorGreaterThan(String value) {
			addCriterion("ID_EMISOR >", value, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorGreaterThanOrEqualTo(String value) {
			addCriterion("ID_EMISOR >=", value, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorLessThan(String value) {
			addCriterion("ID_EMISOR <", value, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorLessThanOrEqualTo(String value) {
			addCriterion("ID_EMISOR <=", value, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorLike(String value) {
			addCriterion("ID_EMISOR like", value, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorNotLike(String value) {
			addCriterion("ID_EMISOR not like", value, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorIn(List values) {
			addCriterion("ID_EMISOR in", values, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorNotIn(List values) {
			addCriterion("ID_EMISOR not in", values, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorBetween(String value1, String value2) {
			addCriterion("ID_EMISOR between", value1, value2, "idEmisor");
			return this;
		}

		public Criteria andIdEmisorNotBetween(String value1, String value2) {
			addCriterion("ID_EMISOR not between", value1, value2, "idEmisor");
			return this;
		}
	}
}