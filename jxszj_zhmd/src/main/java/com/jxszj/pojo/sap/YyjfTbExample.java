package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.List;

public class YyjfTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YyjfTbExample() {
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

        public Criteria andZrsIsNull() {
            addCriterion("zrs is null");
            return (Criteria) this;
        }

        public Criteria andZrsIsNotNull() {
            addCriterion("zrs is not null");
            return (Criteria) this;
        }

        public Criteria andZrsEqualTo(Integer value) {
            addCriterion("zrs =", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsNotEqualTo(Integer value) {
            addCriterion("zrs <>", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsGreaterThan(Integer value) {
            addCriterion("zrs >", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("zrs >=", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsLessThan(Integer value) {
            addCriterion("zrs <", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsLessThanOrEqualTo(Integer value) {
            addCriterion("zrs <=", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsIn(List<Integer> values) {
            addCriterion("zrs in", values, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsNotIn(List<Integer> values) {
            addCriterion("zrs not in", values, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsBetween(Integer value1, Integer value2) {
            addCriterion("zrs between", value1, value2, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsNotBetween(Integer value1, Integer value2) {
            addCriterion("zrs not between", value1, value2, "zrs");
            return (Criteria) this;
        }

        public Criteria andZjfIsNull() {
            addCriterion("zjf is null");
            return (Criteria) this;
        }

        public Criteria andZjfIsNotNull() {
            addCriterion("zjf is not null");
            return (Criteria) this;
        }

        public Criteria andZjfEqualTo(Double value) {
            addCriterion("zjf =", value, "zjf");
            return (Criteria) this;
        }

        public Criteria andZjfNotEqualTo(Double value) {
            addCriterion("zjf <>", value, "zjf");
            return (Criteria) this;
        }

        public Criteria andZjfGreaterThan(Double value) {
            addCriterion("zjf >", value, "zjf");
            return (Criteria) this;
        }

        public Criteria andZjfGreaterThanOrEqualTo(Double value) {
            addCriterion("zjf >=", value, "zjf");
            return (Criteria) this;
        }

        public Criteria andZjfLessThan(Double value) {
            addCriterion("zjf <", value, "zjf");
            return (Criteria) this;
        }

        public Criteria andZjfLessThanOrEqualTo(Double value) {
            addCriterion("zjf <=", value, "zjf");
            return (Criteria) this;
        }

        public Criteria andZjfIn(List<Double> values) {
            addCriterion("zjf in", values, "zjf");
            return (Criteria) this;
        }

        public Criteria andZjfNotIn(List<Double> values) {
            addCriterion("zjf not in", values, "zjf");
            return (Criteria) this;
        }

        public Criteria andZjfBetween(Double value1, Double value2) {
            addCriterion("zjf between", value1, value2, "zjf");
            return (Criteria) this;
        }

        public Criteria andZjfNotBetween(Double value1, Double value2) {
            addCriterion("zjf not between", value1, value2, "zjf");
            return (Criteria) this;
        }

        public Criteria andRjjfIsNull() {
            addCriterion("rjjf is null");
            return (Criteria) this;
        }

        public Criteria andRjjfIsNotNull() {
            addCriterion("rjjf is not null");
            return (Criteria) this;
        }

        public Criteria andRjjfEqualTo(Double value) {
            addCriterion("rjjf =", value, "rjjf");
            return (Criteria) this;
        }

        public Criteria andRjjfNotEqualTo(Double value) {
            addCriterion("rjjf <>", value, "rjjf");
            return (Criteria) this;
        }

        public Criteria andRjjfGreaterThan(Double value) {
            addCriterion("rjjf >", value, "rjjf");
            return (Criteria) this;
        }

        public Criteria andRjjfGreaterThanOrEqualTo(Double value) {
            addCriterion("rjjf >=", value, "rjjf");
            return (Criteria) this;
        }

        public Criteria andRjjfLessThan(Double value) {
            addCriterion("rjjf <", value, "rjjf");
            return (Criteria) this;
        }

        public Criteria andRjjfLessThanOrEqualTo(Double value) {
            addCriterion("rjjf <=", value, "rjjf");
            return (Criteria) this;
        }

        public Criteria andRjjfIn(List<Double> values) {
            addCriterion("rjjf in", values, "rjjf");
            return (Criteria) this;
        }

        public Criteria andRjjfNotIn(List<Double> values) {
            addCriterion("rjjf not in", values, "rjjf");
            return (Criteria) this;
        }

        public Criteria andRjjfBetween(Double value1, Double value2) {
            addCriterion("rjjf between", value1, value2, "rjjf");
            return (Criteria) this;
        }

        public Criteria andRjjfNotBetween(Double value1, Double value2) {
            addCriterion("rjjf not between", value1, value2, "rjjf");
            return (Criteria) this;
        }

        public Criteria andNyIsNull() {
            addCriterion("ny is null");
            return (Criteria) this;
        }

        public Criteria andNyIsNotNull() {
            addCriterion("ny is not null");
            return (Criteria) this;
        }

        public Criteria andNyEqualTo(String value) {
            addCriterion("ny =", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyNotEqualTo(String value) {
            addCriterion("ny <>", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyGreaterThan(String value) {
            addCriterion("ny >", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyGreaterThanOrEqualTo(String value) {
            addCriterion("ny >=", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyLessThan(String value) {
            addCriterion("ny <", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyLessThanOrEqualTo(String value) {
            addCriterion("ny <=", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyLike(String value) {
            addCriterion("ny like", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyNotLike(String value) {
            addCriterion("ny not like", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyIn(List<String> values) {
            addCriterion("ny in", values, "ny");
            return (Criteria) this;
        }

        public Criteria andNyNotIn(List<String> values) {
            addCriterion("ny not in", values, "ny");
            return (Criteria) this;
        }

        public Criteria andNyBetween(String value1, String value2) {
            addCriterion("ny between", value1, value2, "ny");
            return (Criteria) this;
        }

        public Criteria andNyNotBetween(String value1, String value2) {
            addCriterion("ny not between", value1, value2, "ny");
            return (Criteria) this;
        }

        public Criteria andPpIsNull() {
            addCriterion("pp is null");
            return (Criteria) this;
        }

        public Criteria andPpIsNotNull() {
            addCriterion("pp is not null");
            return (Criteria) this;
        }

        public Criteria andPpEqualTo(String value) {
            addCriterion("pp =", value, "pp");
            return (Criteria) this;
        }

        public Criteria andPpNotEqualTo(String value) {
            addCriterion("pp <>", value, "pp");
            return (Criteria) this;
        }

        public Criteria andPpGreaterThan(String value) {
            addCriterion("pp >", value, "pp");
            return (Criteria) this;
        }

        public Criteria andPpGreaterThanOrEqualTo(String value) {
            addCriterion("pp >=", value, "pp");
            return (Criteria) this;
        }

        public Criteria andPpLessThan(String value) {
            addCriterion("pp <", value, "pp");
            return (Criteria) this;
        }

        public Criteria andPpLessThanOrEqualTo(String value) {
            addCriterion("pp <=", value, "pp");
            return (Criteria) this;
        }

        public Criteria andPpLike(String value) {
            addCriterion("pp like", value, "pp");
            return (Criteria) this;
        }

        public Criteria andPpNotLike(String value) {
            addCriterion("pp not like", value, "pp");
            return (Criteria) this;
        }

        public Criteria andPpIn(List<String> values) {
            addCriterion("pp in", values, "pp");
            return (Criteria) this;
        }

        public Criteria andPpNotIn(List<String> values) {
            addCriterion("pp not in", values, "pp");
            return (Criteria) this;
        }

        public Criteria andPpBetween(String value1, String value2) {
            addCriterion("pp between", value1, value2, "pp");
            return (Criteria) this;
        }

        public Criteria andPpNotBetween(String value1, String value2) {
            addCriterion("pp not between", value1, value2, "pp");
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