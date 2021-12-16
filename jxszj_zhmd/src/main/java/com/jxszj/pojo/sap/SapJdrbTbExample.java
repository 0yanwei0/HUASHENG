package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.List;

public class SapJdrbTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SapJdrbTbExample() {
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

        public Criteria andWlzIsNull() {
            addCriterion("wlz is null");
            return (Criteria) this;
        }

        public Criteria andWlzIsNotNull() {
            addCriterion("wlz is not null");
            return (Criteria) this;
        }

        public Criteria andWlzEqualTo(String value) {
            addCriterion("wlz =", value, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzNotEqualTo(String value) {
            addCriterion("wlz <>", value, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzGreaterThan(String value) {
            addCriterion("wlz >", value, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzGreaterThanOrEqualTo(String value) {
            addCriterion("wlz >=", value, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzLessThan(String value) {
            addCriterion("wlz <", value, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzLessThanOrEqualTo(String value) {
            addCriterion("wlz <=", value, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzLike(String value) {
            addCriterion("wlz like", value, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzNotLike(String value) {
            addCriterion("wlz not like", value, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzIn(List<String> values) {
            addCriterion("wlz in", values, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzNotIn(List<String> values) {
            addCriterion("wlz not in", values, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzBetween(String value1, String value2) {
            addCriterion("wlz between", value1, value2, "wlz");
            return (Criteria) this;
        }

        public Criteria andWlzNotBetween(String value1, String value2) {
            addCriterion("wlz not between", value1, value2, "wlz");
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

        public Criteria andRqIsNull() {
            addCriterion("rq is null");
            return (Criteria) this;
        }

        public Criteria andRqIsNotNull() {
            addCriterion("rq is not null");
            return (Criteria) this;
        }

        public Criteria andRqEqualTo(String value) {
            addCriterion("rq =", value, "rq");
            return (Criteria) this;
        }

        public Criteria andRqNotEqualTo(String value) {
            addCriterion("rq <>", value, "rq");
            return (Criteria) this;
        }

        public Criteria andRqGreaterThan(String value) {
            addCriterion("rq >", value, "rq");
            return (Criteria) this;
        }

        public Criteria andRqGreaterThanOrEqualTo(String value) {
            addCriterion("rq >=", value, "rq");
            return (Criteria) this;
        }

        public Criteria andRqLessThan(String value) {
            addCriterion("rq <", value, "rq");
            return (Criteria) this;
        }

        public Criteria andRqLessThanOrEqualTo(String value) {
            addCriterion("rq <=", value, "rq");
            return (Criteria) this;
        }

        public Criteria andRqLike(String value) {
            addCriterion("rq like", value, "rq");
            return (Criteria) this;
        }

        public Criteria andRqNotLike(String value) {
            addCriterion("rq not like", value, "rq");
            return (Criteria) this;
        }

        public Criteria andRqIn(List<String> values) {
            addCriterion("rq in", values, "rq");
            return (Criteria) this;
        }

        public Criteria andRqNotIn(List<String> values) {
            addCriterion("rq not in", values, "rq");
            return (Criteria) this;
        }

        public Criteria andRqBetween(String value1, String value2) {
            addCriterion("rq between", value1, value2, "rq");
            return (Criteria) this;
        }

        public Criteria andRqNotBetween(String value1, String value2) {
            addCriterion("rq not between", value1, value2, "rq");
            return (Criteria) this;
        }

        public Criteria andDrjdIsNull() {
            addCriterion("drjd is null");
            return (Criteria) this;
        }

        public Criteria andDrjdIsNotNull() {
            addCriterion("drjd is not null");
            return (Criteria) this;
        }

        public Criteria andDrjdEqualTo(Integer value) {
            addCriterion("drjd =", value, "drjd");
            return (Criteria) this;
        }

        public Criteria andDrjdNotEqualTo(Integer value) {
            addCriterion("drjd <>", value, "drjd");
            return (Criteria) this;
        }

        public Criteria andDrjdGreaterThan(Integer value) {
            addCriterion("drjd >", value, "drjd");
            return (Criteria) this;
        }

        public Criteria andDrjdGreaterThanOrEqualTo(Integer value) {
            addCriterion("drjd >=", value, "drjd");
            return (Criteria) this;
        }

        public Criteria andDrjdLessThan(Integer value) {
            addCriterion("drjd <", value, "drjd");
            return (Criteria) this;
        }

        public Criteria andDrjdLessThanOrEqualTo(Integer value) {
            addCriterion("drjd <=", value, "drjd");
            return (Criteria) this;
        }

        public Criteria andDrjdIn(List<Integer> values) {
            addCriterion("drjd in", values, "drjd");
            return (Criteria) this;
        }

        public Criteria andDrjdNotIn(List<Integer> values) {
            addCriterion("drjd not in", values, "drjd");
            return (Criteria) this;
        }

        public Criteria andDrjdBetween(Integer value1, Integer value2) {
            addCriterion("drjd between", value1, value2, "drjd");
            return (Criteria) this;
        }

        public Criteria andDrjdNotBetween(Integer value1, Integer value2) {
            addCriterion("drjd not between", value1, value2, "drjd");
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