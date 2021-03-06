package mx.com.factmex.app.server.sqlmaps.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TContactoExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table T_CONTACTO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table T_CONTACTO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected List oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_CONTACTO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public TContactoExample() {
		oredCriteria = new ArrayList();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_CONTACTO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected TContactoExample(TContactoExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_CONTACTO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_CONTACTO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_CONTACTO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public List getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_CONTACTO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_CONTACTO
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
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_CONTACTO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_CONTACTO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table T_CONTACTO
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

		public Criteria andIdContactoIsNull() {
			addCriterion("ID_CONTACTO is null");
			return this;
		}

		public Criteria andIdContactoIsNotNull() {
			addCriterion("ID_CONTACTO is not null");
			return this;
		}

		public Criteria andIdContactoEqualTo(String value) {
			addCriterion("ID_CONTACTO =", value, "idContacto");
			return this;
		}

		public Criteria andIdContactoNotEqualTo(String value) {
			addCriterion("ID_CONTACTO <>", value, "idContacto");
			return this;
		}

		public Criteria andIdContactoGreaterThan(String value) {
			addCriterion("ID_CONTACTO >", value, "idContacto");
			return this;
		}

		public Criteria andIdContactoGreaterThanOrEqualTo(String value) {
			addCriterion("ID_CONTACTO >=", value, "idContacto");
			return this;
		}

		public Criteria andIdContactoLessThan(String value) {
			addCriterion("ID_CONTACTO <", value, "idContacto");
			return this;
		}

		public Criteria andIdContactoLessThanOrEqualTo(String value) {
			addCriterion("ID_CONTACTO <=", value, "idContacto");
			return this;
		}

		public Criteria andIdContactoLike(String value) {
			addCriterion("ID_CONTACTO like", value, "idContacto");
			return this;
		}

		public Criteria andIdContactoNotLike(String value) {
			addCriterion("ID_CONTACTO not like", value, "idContacto");
			return this;
		}

		public Criteria andIdContactoIn(List values) {
			addCriterion("ID_CONTACTO in", values, "idContacto");
			return this;
		}

		public Criteria andIdContactoNotIn(List values) {
			addCriterion("ID_CONTACTO not in", values, "idContacto");
			return this;
		}

		public Criteria andIdContactoBetween(String value1, String value2) {
			addCriterion("ID_CONTACTO between", value1, value2, "idContacto");
			return this;
		}

		public Criteria andIdContactoNotBetween(String value1, String value2) {
			addCriterion("ID_CONTACTO not between", value1, value2,
					"idContacto");
			return this;
		}

		public Criteria andContactoIsNull() {
			addCriterion("CONTACTO is null");
			return this;
		}

		public Criteria andContactoIsNotNull() {
			addCriterion("CONTACTO is not null");
			return this;
		}

		public Criteria andContactoEqualTo(String value) {
			addCriterion("CONTACTO =", value, "contacto");
			return this;
		}

		public Criteria andContactoNotEqualTo(String value) {
			addCriterion("CONTACTO <>", value, "contacto");
			return this;
		}

		public Criteria andContactoGreaterThan(String value) {
			addCriterion("CONTACTO >", value, "contacto");
			return this;
		}

		public Criteria andContactoGreaterThanOrEqualTo(String value) {
			addCriterion("CONTACTO >=", value, "contacto");
			return this;
		}

		public Criteria andContactoLessThan(String value) {
			addCriterion("CONTACTO <", value, "contacto");
			return this;
		}

		public Criteria andContactoLessThanOrEqualTo(String value) {
			addCriterion("CONTACTO <=", value, "contacto");
			return this;
		}

		public Criteria andContactoLike(String value) {
			addCriterion("CONTACTO like", value, "contacto");
			return this;
		}

		public Criteria andContactoNotLike(String value) {
			addCriterion("CONTACTO not like", value, "contacto");
			return this;
		}

		public Criteria andContactoIn(List values) {
			addCriterion("CONTACTO in", values, "contacto");
			return this;
		}

		public Criteria andContactoNotIn(List values) {
			addCriterion("CONTACTO not in", values, "contacto");
			return this;
		}

		public Criteria andContactoBetween(String value1, String value2) {
			addCriterion("CONTACTO between", value1, value2, "contacto");
			return this;
		}

		public Criteria andContactoNotBetween(String value1, String value2) {
			addCriterion("CONTACTO not between", value1, value2, "contacto");
			return this;
		}

		public Criteria andIdTipoContactoIsNull() {
			addCriterion("ID_TIPO_CONTACTO is null");
			return this;
		}

		public Criteria andIdTipoContactoIsNotNull() {
			addCriterion("ID_TIPO_CONTACTO is not null");
			return this;
		}

		public Criteria andIdTipoContactoEqualTo(String value) {
			addCriterion("ID_TIPO_CONTACTO =", value, "idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoNotEqualTo(String value) {
			addCriterion("ID_TIPO_CONTACTO <>", value, "idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoGreaterThan(String value) {
			addCriterion("ID_TIPO_CONTACTO >", value, "idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoGreaterThanOrEqualTo(String value) {
			addCriterion("ID_TIPO_CONTACTO >=", value, "idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoLessThan(String value) {
			addCriterion("ID_TIPO_CONTACTO <", value, "idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoLessThanOrEqualTo(String value) {
			addCriterion("ID_TIPO_CONTACTO <=", value, "idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoLike(String value) {
			addCriterion("ID_TIPO_CONTACTO like", value, "idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoNotLike(String value) {
			addCriterion("ID_TIPO_CONTACTO not like", value, "idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoIn(List values) {
			addCriterion("ID_TIPO_CONTACTO in", values, "idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoNotIn(List values) {
			addCriterion("ID_TIPO_CONTACTO not in", values, "idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoBetween(String value1, String value2) {
			addCriterion("ID_TIPO_CONTACTO between", value1, value2,
					"idTipoContacto");
			return this;
		}

		public Criteria andIdTipoContactoNotBetween(String value1, String value2) {
			addCriterion("ID_TIPO_CONTACTO not between", value1, value2,
					"idTipoContacto");
			return this;
		}

		public Criteria andIdDireccionIsNull() {
			addCriterion("ID_DIRECCION is null");
			return this;
		}

		public Criteria andIdDireccionIsNotNull() {
			addCriterion("ID_DIRECCION is not null");
			return this;
		}

		public Criteria andIdDireccionEqualTo(String value) {
			addCriterion("ID_DIRECCION =", value, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionNotEqualTo(String value) {
			addCriterion("ID_DIRECCION <>", value, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionGreaterThan(String value) {
			addCriterion("ID_DIRECCION >", value, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionGreaterThanOrEqualTo(String value) {
			addCriterion("ID_DIRECCION >=", value, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionLessThan(String value) {
			addCriterion("ID_DIRECCION <", value, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionLessThanOrEqualTo(String value) {
			addCriterion("ID_DIRECCION <=", value, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionLike(String value) {
			addCriterion("ID_DIRECCION like", value, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionNotLike(String value) {
			addCriterion("ID_DIRECCION not like", value, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionIn(List values) {
			addCriterion("ID_DIRECCION in", values, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionNotIn(List values) {
			addCriterion("ID_DIRECCION not in", values, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionBetween(String value1, String value2) {
			addCriterion("ID_DIRECCION between", value1, value2, "idDireccion");
			return this;
		}

		public Criteria andIdDireccionNotBetween(String value1, String value2) {
			addCriterion("ID_DIRECCION not between", value1, value2,
					"idDireccion");
			return this;
		}
	}
}