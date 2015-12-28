package mx.com.factmex.app.server.sqlmaps.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TProductoServicioExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected List oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public TProductoServicioExample() {
		oredCriteria = new ArrayList();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected TProductoServicioExample(TProductoServicioExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public List getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
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
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table T_PRODUCTO_SERVICIO
	 * @ibatorgenerated  Tue Oct 19 12:54:15 CDT 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table T_PRODUCTO_SERVICIO
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

		public Criteria andIdProductoServicioIsNull() {
			addCriterion("ID_PRODUCTO_SERVICIO is null");
			return this;
		}

		public Criteria andIdProductoServicioIsNotNull() {
			addCriterion("ID_PRODUCTO_SERVICIO is not null");
			return this;
		}

		public Criteria andIdProductoServicioEqualTo(String value) {
			addCriterion("ID_PRODUCTO_SERVICIO =", value, "idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioNotEqualTo(String value) {
			addCriterion("ID_PRODUCTO_SERVICIO <>", value, "idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioGreaterThan(String value) {
			addCriterion("ID_PRODUCTO_SERVICIO >", value, "idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioGreaterThanOrEqualTo(String value) {
			addCriterion("ID_PRODUCTO_SERVICIO >=", value, "idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioLessThan(String value) {
			addCriterion("ID_PRODUCTO_SERVICIO <", value, "idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioLessThanOrEqualTo(String value) {
			addCriterion("ID_PRODUCTO_SERVICIO <=", value, "idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioLike(String value) {
			addCriterion("ID_PRODUCTO_SERVICIO like", value,
					"idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioNotLike(String value) {
			addCriterion("ID_PRODUCTO_SERVICIO not like", value,
					"idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioIn(List values) {
			addCriterion("ID_PRODUCTO_SERVICIO in", values,
					"idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioNotIn(List values) {
			addCriterion("ID_PRODUCTO_SERVICIO not in", values,
					"idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioBetween(String value1,
				String value2) {
			addCriterion("ID_PRODUCTO_SERVICIO between", value1, value2,
					"idProductoServicio");
			return this;
		}

		public Criteria andIdProductoServicioNotBetween(String value1,
				String value2) {
			addCriterion("ID_PRODUCTO_SERVICIO not between", value1, value2,
					"idProductoServicio");
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

		public Criteria andPrecioIsNull() {
			addCriterion("PRECIO is null");
			return this;
		}

		public Criteria andPrecioIsNotNull() {
			addCriterion("PRECIO is not null");
			return this;
		}

		public Criteria andPrecioEqualTo(String value) {
			addCriterion("PRECIO =", value, "precio");
			return this;
		}

		public Criteria andPrecioNotEqualTo(String value) {
			addCriterion("PRECIO <>", value, "precio");
			return this;
		}

		public Criteria andPrecioGreaterThan(String value) {
			addCriterion("PRECIO >", value, "precio");
			return this;
		}

		public Criteria andPrecioGreaterThanOrEqualTo(String value) {
			addCriterion("PRECIO >=", value, "precio");
			return this;
		}

		public Criteria andPrecioLessThan(String value) {
			addCriterion("PRECIO <", value, "precio");
			return this;
		}

		public Criteria andPrecioLessThanOrEqualTo(String value) {
			addCriterion("PRECIO <=", value, "precio");
			return this;
		}

		public Criteria andPrecioLike(String value) {
			addCriterion("PRECIO like", value, "precio");
			return this;
		}

		public Criteria andPrecioNotLike(String value) {
			addCriterion("PRECIO not like", value, "precio");
			return this;
		}

		public Criteria andPrecioIn(List values) {
			addCriterion("PRECIO in", values, "precio");
			return this;
		}

		public Criteria andPrecioNotIn(List values) {
			addCriterion("PRECIO not in", values, "precio");
			return this;
		}

		public Criteria andPrecioBetween(String value1, String value2) {
			addCriterion("PRECIO between", value1, value2, "precio");
			return this;
		}

		public Criteria andPrecioNotBetween(String value1, String value2) {
			addCriterion("PRECIO not between", value1, value2, "precio");
			return this;
		}

		public Criteria andUnidadIsNull() {
			addCriterion("UNIDAD is null");
			return this;
		}

		public Criteria andUnidadIsNotNull() {
			addCriterion("UNIDAD is not null");
			return this;
		}

		public Criteria andUnidadEqualTo(String value) {
			addCriterion("UNIDAD =", value, "unidad");
			return this;
		}

		public Criteria andUnidadNotEqualTo(String value) {
			addCriterion("UNIDAD <>", value, "unidad");
			return this;
		}

		public Criteria andUnidadGreaterThan(String value) {
			addCriterion("UNIDAD >", value, "unidad");
			return this;
		}

		public Criteria andUnidadGreaterThanOrEqualTo(String value) {
			addCriterion("UNIDAD >=", value, "unidad");
			return this;
		}

		public Criteria andUnidadLessThan(String value) {
			addCriterion("UNIDAD <", value, "unidad");
			return this;
		}

		public Criteria andUnidadLessThanOrEqualTo(String value) {
			addCriterion("UNIDAD <=", value, "unidad");
			return this;
		}

		public Criteria andUnidadLike(String value) {
			addCriterion("UNIDAD like", value, "unidad");
			return this;
		}

		public Criteria andUnidadNotLike(String value) {
			addCriterion("UNIDAD not like", value, "unidad");
			return this;
		}

		public Criteria andUnidadIn(List values) {
			addCriterion("UNIDAD in", values, "unidad");
			return this;
		}

		public Criteria andUnidadNotIn(List values) {
			addCriterion("UNIDAD not in", values, "unidad");
			return this;
		}

		public Criteria andUnidadBetween(String value1, String value2) {
			addCriterion("UNIDAD between", value1, value2, "unidad");
			return this;
		}

		public Criteria andUnidadNotBetween(String value1, String value2) {
			addCriterion("UNIDAD not between", value1, value2, "unidad");
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