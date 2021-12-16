package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.List;

public class SapScjhwlTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SapScjhwlTbExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGzrqIsNull() {
            addCriterion("gzrq is null");
            return (Criteria) this;
        }

        public Criteria andGzrqIsNotNull() {
            addCriterion("gzrq is not null");
            return (Criteria) this;
        }

        public Criteria andGzrqEqualTo(String value) {
            addCriterion("gzrq =", value, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqNotEqualTo(String value) {
            addCriterion("gzrq <>", value, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqGreaterThan(String value) {
            addCriterion("gzrq >", value, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqGreaterThanOrEqualTo(String value) {
            addCriterion("gzrq >=", value, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqLessThan(String value) {
            addCriterion("gzrq <", value, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqLessThanOrEqualTo(String value) {
            addCriterion("gzrq <=", value, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqLike(String value) {
            addCriterion("gzrq like", value, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqNotLike(String value) {
            addCriterion("gzrq not like", value, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqIn(List<String> values) {
            addCriterion("gzrq in", values, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqNotIn(List<String> values) {
            addCriterion("gzrq not in", values, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqBetween(String value1, String value2) {
            addCriterion("gzrq between", value1, value2, "gzrq");
            return (Criteria) this;
        }

        public Criteria andGzrqNotBetween(String value1, String value2) {
            addCriterion("gzrq not between", value1, value2, "gzrq");
            return (Criteria) this;
        }

        public Criteria andWlzbmIsNull() {
            addCriterion("wlzbm is null");
            return (Criteria) this;
        }

        public Criteria andWlzbmIsNotNull() {
            addCriterion("wlzbm is not null");
            return (Criteria) this;
        }

        public Criteria andWlzbmEqualTo(String value) {
            addCriterion("wlzbm =", value, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmNotEqualTo(String value) {
            addCriterion("wlzbm <>", value, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmGreaterThan(String value) {
            addCriterion("wlzbm >", value, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmGreaterThanOrEqualTo(String value) {
            addCriterion("wlzbm >=", value, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmLessThan(String value) {
            addCriterion("wlzbm <", value, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmLessThanOrEqualTo(String value) {
            addCriterion("wlzbm <=", value, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmLike(String value) {
            addCriterion("wlzbm like", value, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmNotLike(String value) {
            addCriterion("wlzbm not like", value, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmIn(List<String> values) {
            addCriterion("wlzbm in", values, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmNotIn(List<String> values) {
            addCriterion("wlzbm not in", values, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmBetween(String value1, String value2) {
            addCriterion("wlzbm between", value1, value2, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzbmNotBetween(String value1, String value2) {
            addCriterion("wlzbm not between", value1, value2, "wlzbm");
            return (Criteria) this;
        }

        public Criteria andWlzmcIsNull() {
            addCriterion("wlzmc is null");
            return (Criteria) this;
        }

        public Criteria andWlzmcIsNotNull() {
            addCriterion("wlzmc is not null");
            return (Criteria) this;
        }

        public Criteria andWlzmcEqualTo(String value) {
            addCriterion("wlzmc =", value, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcNotEqualTo(String value) {
            addCriterion("wlzmc <>", value, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcGreaterThan(String value) {
            addCriterion("wlzmc >", value, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcGreaterThanOrEqualTo(String value) {
            addCriterion("wlzmc >=", value, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcLessThan(String value) {
            addCriterion("wlzmc <", value, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcLessThanOrEqualTo(String value) {
            addCriterion("wlzmc <=", value, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcLike(String value) {
            addCriterion("wlzmc like", value, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcNotLike(String value) {
            addCriterion("wlzmc not like", value, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcIn(List<String> values) {
            addCriterion("wlzmc in", values, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcNotIn(List<String> values) {
            addCriterion("wlzmc not in", values, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcBetween(String value1, String value2) {
            addCriterion("wlzmc between", value1, value2, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andWlzmcNotBetween(String value1, String value2) {
            addCriterion("wlzmc not between", value1, value2, "wlzmc");
            return (Criteria) this;
        }

        public Criteria andDrjhIsNull() {
            addCriterion("drjh is null");
            return (Criteria) this;
        }

        public Criteria andDrjhIsNotNull() {
            addCriterion("drjh is not null");
            return (Criteria) this;
        }

        public Criteria andDrjhEqualTo(Integer value) {
            addCriterion("drjh =", value, "drjh");
            return (Criteria) this;
        }

        public Criteria andDrjhNotEqualTo(Integer value) {
            addCriterion("drjh <>", value, "drjh");
            return (Criteria) this;
        }

        public Criteria andDrjhGreaterThan(Integer value) {
            addCriterion("drjh >", value, "drjh");
            return (Criteria) this;
        }

        public Criteria andDrjhGreaterThanOrEqualTo(Integer value) {
            addCriterion("drjh >=", value, "drjh");
            return (Criteria) this;
        }

        public Criteria andDrjhLessThan(Integer value) {
            addCriterion("drjh <", value, "drjh");
            return (Criteria) this;
        }

        public Criteria andDrjhLessThanOrEqualTo(Integer value) {
            addCriterion("drjh <=", value, "drjh");
            return (Criteria) this;
        }

        public Criteria andDrjhIn(List<Integer> values) {
            addCriterion("drjh in", values, "drjh");
            return (Criteria) this;
        }

        public Criteria andDrjhNotIn(List<Integer> values) {
            addCriterion("drjh not in", values, "drjh");
            return (Criteria) this;
        }

        public Criteria andDrjhBetween(Integer value1, Integer value2) {
            addCriterion("drjh between", value1, value2, "drjh");
            return (Criteria) this;
        }

        public Criteria andDrjhNotBetween(Integer value1, Integer value2) {
            addCriterion("drjh not between", value1, value2, "drjh");
            return (Criteria) this;
        }

        public Criteria andDyljIsNull() {
            addCriterion("dylj is null");
            return (Criteria) this;
        }

        public Criteria andDyljIsNotNull() {
            addCriterion("dylj is not null");
            return (Criteria) this;
        }

        public Criteria andDyljEqualTo(Integer value) {
            addCriterion("dylj =", value, "dylj");
            return (Criteria) this;
        }

        public Criteria andDyljNotEqualTo(Integer value) {
            addCriterion("dylj <>", value, "dylj");
            return (Criteria) this;
        }

        public Criteria andDyljGreaterThan(Integer value) {
            addCriterion("dylj >", value, "dylj");
            return (Criteria) this;
        }

        public Criteria andDyljGreaterThanOrEqualTo(Integer value) {
            addCriterion("dylj >=", value, "dylj");
            return (Criteria) this;
        }

        public Criteria andDyljLessThan(Integer value) {
            addCriterion("dylj <", value, "dylj");
            return (Criteria) this;
        }

        public Criteria andDyljLessThanOrEqualTo(Integer value) {
            addCriterion("dylj <=", value, "dylj");
            return (Criteria) this;
        }

        public Criteria andDyljIn(List<Integer> values) {
            addCriterion("dylj in", values, "dylj");
            return (Criteria) this;
        }

        public Criteria andDyljNotIn(List<Integer> values) {
            addCriterion("dylj not in", values, "dylj");
            return (Criteria) this;
        }

        public Criteria andDyljBetween(Integer value1, Integer value2) {
            addCriterion("dylj between", value1, value2, "dylj");
            return (Criteria) this;
        }

        public Criteria andDyljNotBetween(Integer value1, Integer value2) {
            addCriterion("dylj not between", value1, value2, "dylj");
            return (Criteria) this;
        }

        public Criteria andDyrjIsNull() {
            addCriterion("dyrj is null");
            return (Criteria) this;
        }

        public Criteria andDyrjIsNotNull() {
            addCriterion("dyrj is not null");
            return (Criteria) this;
        }

        public Criteria andDyrjEqualTo(Integer value) {
            addCriterion("dyrj =", value, "dyrj");
            return (Criteria) this;
        }

        public Criteria andDyrjNotEqualTo(Integer value) {
            addCriterion("dyrj <>", value, "dyrj");
            return (Criteria) this;
        }

        public Criteria andDyrjGreaterThan(Integer value) {
            addCriterion("dyrj >", value, "dyrj");
            return (Criteria) this;
        }

        public Criteria andDyrjGreaterThanOrEqualTo(Integer value) {
            addCriterion("dyrj >=", value, "dyrj");
            return (Criteria) this;
        }

        public Criteria andDyrjLessThan(Integer value) {
            addCriterion("dyrj <", value, "dyrj");
            return (Criteria) this;
        }

        public Criteria andDyrjLessThanOrEqualTo(Integer value) {
            addCriterion("dyrj <=", value, "dyrj");
            return (Criteria) this;
        }

        public Criteria andDyrjIn(List<Integer> values) {
            addCriterion("dyrj in", values, "dyrj");
            return (Criteria) this;
        }

        public Criteria andDyrjNotIn(List<Integer> values) {
            addCriterion("dyrj not in", values, "dyrj");
            return (Criteria) this;
        }

        public Criteria andDyrjBetween(Integer value1, Integer value2) {
            addCriterion("dyrj between", value1, value2, "dyrj");
            return (Criteria) this;
        }

        public Criteria andDyrjNotBetween(Integer value1, Integer value2) {
            addCriterion("dyrj not between", value1, value2, "dyrj");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}