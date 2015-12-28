package mx.com.factmex.app.server.sqlmaps.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CTipoDireccionExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table C_TIPO_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table C_TIPO_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected List oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public CTipoDireccionExample() {
		oredCriteria = new ArrayList();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected CTipoDireccionExample(CTipoDireccionExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public List getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_DIRECCION
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
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table C_TIPO_DIRECCION
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table C_TIPO_DIRECCION
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

		public Criteria andIdTipoDireccionIsNull() {
			addCriterion("ID_TIPO_DIRECCION is null");
			return this;
		}

		public Criteria andIdTipoDireccionIsNotNull() {
			addCriterion("ID_TIPO_DIRECCION is not null");
			return this;
		}

		public Criteria andIdTipoDireccionEqualTo(String value) {
			addCriterion("ID_TIPO_DIRECCION =", value, "idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionNotEqualTo(String value) {
			addCriterion("ID_TIPO_DIRECCION <>", value, "idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionGreaterThan(String value) {
			addCriterion("ID_TIPO_DIRECCION >", value, "idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionGreaterThanOrEqualTo(String value) {
			addCriterion("ID_TIPO_DIRECCION >=", value, "idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionLessThan(String value) {
			addCriterion("ID_TIPO_DIRECCION <", value, "idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionLessThanOrEqualTo(String value) {
			addCriterion("ID_TIPO_DIRECCION <=", value, "idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionLike(String value) {
			addCriterion("ID_TIPO_DIRECCION like", value, "idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionNotLike(String value) {
			addCriterion("ID_TIPO_DIRECCION not like", value, "idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionIn(List values) {
			addCriterion("ID_TIPO_DIRECCION in", values, "idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionNotIn(List values) {
			addCriterion("ID_TIPO_DIRECCION not in", values, "idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionBetween(String value1, String value2) {
			addCriterion("ID_TIPO_DIRECCION between", value1, value2,
					"idTipoDireccion");
			return this;
		}

		public Criteria andIdTipoDireccionNotBetween(String value1,
				String value2) {
			addCriterion("ID_TIPO_DIRECCION not between", value1, value2,
					"idTipoDireccion");
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
	}
}