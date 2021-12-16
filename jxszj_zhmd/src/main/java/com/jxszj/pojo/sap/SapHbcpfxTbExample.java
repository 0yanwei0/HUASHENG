package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.List;

public class SapHbcpfxTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SapHbcpfxTbExample() {
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

        public Criteria andJxsmcIsNull() {
            addCriterion("jxsmc is null");
            return (Criteria) this;
        }

        public Criteria andJxsmcIsNotNull() {
            addCriterion("jxsmc is not null");
            return (Criteria) this;
        }

        public Criteria andJxsmcEqualTo(String value) {
            addCriterion("jxsmc =", value, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcNotEqualTo(String value) {
            addCriterion("jxsmc <>", value, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcGreaterThan(String value) {
            addCriterion("jxsmc >", value, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcGreaterThanOrEqualTo(String value) {
            addCriterion("jxsmc >=", value, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcLessThan(String value) {
            addCriterion("jxsmc <", value, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcLessThanOrEqualTo(String value) {
            addCriterion("jxsmc <=", value, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcLike(String value) {
            addCriterion("jxsmc like", value, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcNotLike(String value) {
            addCriterion("jxsmc not like", value, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcIn(List<String> values) {
            addCriterion("jxsmc in", values, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcNotIn(List<String> values) {
            addCriterion("jxsmc not in", values, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcBetween(String value1, String value2) {
            addCriterion("jxsmc between", value1, value2, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsmcNotBetween(String value1, String value2) {
            addCriterion("jxsmc not between", value1, value2, "jxsmc");
            return (Criteria) this;
        }

        public Criteria andJxsbmIsNull() {
            addCriterion("jxsbm is null");
            return (Criteria) this;
        }

        public Criteria andJxsbmIsNotNull() {
            addCriterion("jxsbm is not null");
            return (Criteria) this;
        }

        public Criteria andJxsbmEqualTo(String value) {
            addCriterion("jxsbm =", value, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmNotEqualTo(String value) {
            addCriterion("jxsbm <>", value, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmGreaterThan(String value) {
            addCriterion("jxsbm >", value, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmGreaterThanOrEqualTo(String value) {
            addCriterion("jxsbm >=", value, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmLessThan(String value) {
            addCriterion("jxsbm <", value, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmLessThanOrEqualTo(String value) {
            addCriterion("jxsbm <=", value, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmLike(String value) {
            addCriterion("jxsbm like", value, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmNotLike(String value) {
            addCriterion("jxsbm not like", value, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmIn(List<String> values) {
            addCriterion("jxsbm in", values, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmNotIn(List<String> values) {
            addCriterion("jxsbm not in", values, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmBetween(String value1, String value2) {
            addCriterion("jxsbm between", value1, value2, "jxsbm");
            return (Criteria) this;
        }

        public Criteria andJxsbmNotBetween(String value1, String value2) {
            addCriterion("jxsbm not between", value1, value2, "jxsbm");
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

        public Criteria andWlmcIsNull() {
            addCriterion("wlmc is null");
            return (Criteria) this;
        }

        public Criteria andWlmcIsNotNull() {
            addCriterion("wlmc is not null");
            return (Criteria) this;
        }

        public Criteria andWlmcEqualTo(String value) {
            addCriterion("wlmc =", value, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcNotEqualTo(String value) {
            addCriterion("wlmc <>", value, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcGreaterThan(String value) {
            addCriterion("wlmc >", value, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcGreaterThanOrEqualTo(String value) {
            addCriterion("wlmc >=", value, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcLessThan(String value) {
            addCriterion("wlmc <", value, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcLessThanOrEqualTo(String value) {
            addCriterion("wlmc <=", value, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcLike(String value) {
            addCriterion("wlmc like", value, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcNotLike(String value) {
            addCriterion("wlmc not like", value, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcIn(List<String> values) {
            addCriterion("wlmc in", values, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcNotIn(List<String> values) {
            addCriterion("wlmc not in", values, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcBetween(String value1, String value2) {
            addCriterion("wlmc between", value1, value2, "wlmc");
            return (Criteria) this;
        }

        public Criteria andWlmcNotBetween(String value1, String value2) {
            addCriterion("wlmc not between", value1, value2, "wlmc");
            return (Criteria) this;
        }

        public Criteria andJldjIsNull() {
            addCriterion("jldj is null");
            return (Criteria) this;
        }

        public Criteria andJldjIsNotNull() {
            addCriterion("jldj is not null");
            return (Criteria) this;
        }

        public Criteria andJldjEqualTo(Integer value) {
            addCriterion("jldj =", value, "jldj");
            return (Criteria) this;
        }

        public Criteria andJldjNotEqualTo(Integer value) {
            addCriterion("jldj <>", value, "jldj");
            return (Criteria) this;
        }

        public Criteria andJldjGreaterThan(Integer value) {
            addCriterion("jldj >", value, "jldj");
            return (Criteria) this;
        }

        public Criteria andJldjGreaterThanOrEqualTo(Integer value) {
            addCriterion("jldj >=", value, "jldj");
            return (Criteria) this;
        }

        public Criteria andJldjLessThan(Integer value) {
            addCriterion("jldj <", value, "jldj");
            return (Criteria) this;
        }

        public Criteria andJldjLessThanOrEqualTo(Integer value) {
            addCriterion("jldj <=", value, "jldj");
            return (Criteria) this;
        }

        public Criteria andJldjIn(List<Integer> values) {
            addCriterion("jldj in", values, "jldj");
            return (Criteria) this;
        }

        public Criteria andJldjNotIn(List<Integer> values) {
            addCriterion("jldj not in", values, "jldj");
            return (Criteria) this;
        }

        public Criteria andJldjBetween(Integer value1, Integer value2) {
            addCriterion("jldj between", value1, value2, "jldj");
            return (Criteria) this;
        }

        public Criteria andJldjNotBetween(Integer value1, Integer value2) {
            addCriterion("jldj not between", value1, value2, "jldj");
            return (Criteria) this;
        }

        public Criteria andBdslIsNull() {
            addCriterion("bdsl is null");
            return (Criteria) this;
        }

        public Criteria andBdslIsNotNull() {
            addCriterion("bdsl is not null");
            return (Criteria) this;
        }

        public Criteria andBdslEqualTo(Integer value) {
            addCriterion("bdsl =", value, "bdsl");
            return (Criteria) this;
        }

        public Criteria andBdslNotEqualTo(Integer value) {
            addCriterion("bdsl <>", value, "bdsl");
            return (Criteria) this;
        }

        public Criteria andBdslGreaterThan(Integer value) {
            addCriterion("bdsl >", value, "bdsl");
            return (Criteria) this;
        }

        public Criteria andBdslGreaterThanOrEqualTo(Integer value) {
            addCriterion("bdsl >=", value, "bdsl");
            return (Criteria) this;
        }

        public Criteria andBdslLessThan(Integer value) {
            addCriterion("bdsl <", value, "bdsl");
            return (Criteria) this;
        }

        public Criteria andBdslLessThanOrEqualTo(Integer value) {
            addCriterion("bdsl <=", value, "bdsl");
            return (Criteria) this;
        }

        public Criteria andBdslIn(List<Integer> values) {
            addCriterion("bdsl in", values, "bdsl");
            return (Criteria) this;
        }

        public Criteria andBdslNotIn(List<Integer> values) {
            addCriterion("bdsl not in", values, "bdsl");
            return (Criteria) this;
        }

        public Criteria andBdslBetween(Integer value1, Integer value2) {
            addCriterion("bdsl between", value1, value2, "bdsl");
            return (Criteria) this;
        }

        public Criteria andBdslNotBetween(Integer value1, Integer value2) {
            addCriterion("bdsl not between", value1, value2, "bdsl");
            return (Criteria) this;
        }

        public Criteria andJljeIsNull() {
            addCriterion("jlje is null");
            return (Criteria) this;
        }

        public Criteria andJljeIsNotNull() {
            addCriterion("jlje is not null");
            return (Criteria) this;
        }

        public Criteria andJljeEqualTo(Integer value) {
            addCriterion("jlje =", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeNotEqualTo(Integer value) {
            addCriterion("jlje <>", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeGreaterThan(Integer value) {
            addCriterion("jlje >", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jlje >=", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeLessThan(Integer value) {
            addCriterion("jlje <", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeLessThanOrEqualTo(Integer value) {
            addCriterion("jlje <=", value, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeIn(List<Integer> values) {
            addCriterion("jlje in", values, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeNotIn(List<Integer> values) {
            addCriterion("jlje not in", values, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeBetween(Integer value1, Integer value2) {
            addCriterion("jlje between", value1, value2, "jlje");
            return (Criteria) this;
        }

        public Criteria andJljeNotBetween(Integer value1, Integer value2) {
            addCriterion("jlje not between", value1, value2, "jlje");
            return (Criteria) this;
        }

        public Criteria andDdslIsNull() {
            addCriterion("ddsl is null");
            return (Criteria) this;
        }

        public Criteria andDdslIsNotNull() {
            addCriterion("ddsl is not null");
            return (Criteria) this;
        }

        public Criteria andDdslEqualTo(Integer value) {
            addCriterion("ddsl =", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslNotEqualTo(Integer value) {
            addCriterion("ddsl <>", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslGreaterThan(Integer value) {
            addCriterion("ddsl >", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslGreaterThanOrEqualTo(Integer value) {
            addCriterion("ddsl >=", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslLessThan(Integer value) {
            addCriterion("ddsl <", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslLessThanOrEqualTo(Integer value) {
            addCriterion("ddsl <=", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslIn(List<Integer> values) {
            addCriterion("ddsl in", values, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslNotIn(List<Integer> values) {
            addCriterion("ddsl not in", values, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslBetween(Integer value1, Integer value2) {
            addCriterion("ddsl between", value1, value2, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslNotBetween(Integer value1, Integer value2) {
            addCriterion("ddsl not between", value1, value2, "ddsl");
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

        public Criteria andBmwlIsNull() {
            addCriterion("bmwl is null");
            return (Criteria) this;
        }

        public Criteria andBmwlIsNotNull() {
            addCriterion("bmwl is not null");
            return (Criteria) this;
        }

        public Criteria andBmwlEqualTo(String value) {
            addCriterion("bmwl =", value, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlNotEqualTo(String value) {
            addCriterion("bmwl <>", value, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlGreaterThan(String value) {
            addCriterion("bmwl >", value, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlGreaterThanOrEqualTo(String value) {
            addCriterion("bmwl >=", value, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlLessThan(String value) {
            addCriterion("bmwl <", value, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlLessThanOrEqualTo(String value) {
            addCriterion("bmwl <=", value, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlLike(String value) {
            addCriterion("bmwl like", value, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlNotLike(String value) {
            addCriterion("bmwl not like", value, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlIn(List<String> values) {
            addCriterion("bmwl in", values, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlNotIn(List<String> values) {
            addCriterion("bmwl not in", values, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlBetween(String value1, String value2) {
            addCriterion("bmwl between", value1, value2, "bmwl");
            return (Criteria) this;
        }

        public Criteria andBmwlNotBetween(String value1, String value2) {
            addCriterion("bmwl not between", value1, value2, "bmwl");
            return (Criteria) this;
        }

        public Criteria andWlslIsNull() {
            addCriterion("wlsl is null");
            return (Criteria) this;
        }

        public Criteria andWlslIsNotNull() {
            addCriterion("wlsl is not null");
            return (Criteria) this;
        }

        public Criteria andWlslEqualTo(Integer value) {
            addCriterion("wlsl =", value, "wlsl");
            return (Criteria) this;
        }

        public Criteria andWlslNotEqualTo(Integer value) {
            addCriterion("wlsl <>", value, "wlsl");
            return (Criteria) this;
        }

        public Criteria andWlslGreaterThan(Integer value) {
            addCriterion("wlsl >", value, "wlsl");
            return (Criteria) this;
        }

        public Criteria andWlslGreaterThanOrEqualTo(Integer value) {
            addCriterion("wlsl >=", value, "wlsl");
            return (Criteria) this;
        }

        public Criteria andWlslLessThan(Integer value) {
            addCriterion("wlsl <", value, "wlsl");
            return (Criteria) this;
        }

        public Criteria andWlslLessThanOrEqualTo(Integer value) {
            addCriterion("wlsl <=", value, "wlsl");
            return (Criteria) this;
        }

        public Criteria andWlslIn(List<Integer> values) {
            addCriterion("wlsl in", values, "wlsl");
            return (Criteria) this;
        }

        public Criteria andWlslNotIn(List<Integer> values) {
            addCriterion("wlsl not in", values, "wlsl");
            return (Criteria) this;
        }

        public Criteria andWlslBetween(Integer value1, Integer value2) {
            addCriterion("wlsl between", value1, value2, "wlsl");
            return (Criteria) this;
        }

        public Criteria andWlslNotBetween(Integer value1, Integer value2) {
            addCriterion("wlsl not between", value1, value2, "wlsl");
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