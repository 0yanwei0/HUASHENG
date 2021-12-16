package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.List;

public class HsXsdddjysTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HsXsdddjysTbExample() {
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

        public Criteria andXspzIsNull() {
            addCriterion("xspz is null");
            return (Criteria) this;
        }

        public Criteria andXspzIsNotNull() {
            addCriterion("xspz is not null");
            return (Criteria) this;
        }

        public Criteria andXspzEqualTo(String value) {
            addCriterion("xspz =", value, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzNotEqualTo(String value) {
            addCriterion("xspz <>", value, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzGreaterThan(String value) {
            addCriterion("xspz >", value, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzGreaterThanOrEqualTo(String value) {
            addCriterion("xspz >=", value, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzLessThan(String value) {
            addCriterion("xspz <", value, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzLessThanOrEqualTo(String value) {
            addCriterion("xspz <=", value, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzLike(String value) {
            addCriterion("xspz like", value, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzNotLike(String value) {
            addCriterion("xspz not like", value, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzIn(List<String> values) {
            addCriterion("xspz in", values, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzNotIn(List<String> values) {
            addCriterion("xspz not in", values, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzBetween(String value1, String value2) {
            addCriterion("xspz between", value1, value2, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzNotBetween(String value1, String value2) {
            addCriterion("xspz not between", value1, value2, "xspz");
            return (Criteria) this;
        }

        public Criteria andXspzxmIsNull() {
            addCriterion("xspzxm is null");
            return (Criteria) this;
        }

        public Criteria andXspzxmIsNotNull() {
            addCriterion("xspzxm is not null");
            return (Criteria) this;
        }

        public Criteria andXspzxmEqualTo(String value) {
            addCriterion("xspzxm =", value, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmNotEqualTo(String value) {
            addCriterion("xspzxm <>", value, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmGreaterThan(String value) {
            addCriterion("xspzxm >", value, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmGreaterThanOrEqualTo(String value) {
            addCriterion("xspzxm >=", value, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmLessThan(String value) {
            addCriterion("xspzxm <", value, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmLessThanOrEqualTo(String value) {
            addCriterion("xspzxm <=", value, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmLike(String value) {
            addCriterion("xspzxm like", value, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmNotLike(String value) {
            addCriterion("xspzxm not like", value, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmIn(List<String> values) {
            addCriterion("xspzxm in", values, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmNotIn(List<String> values) {
            addCriterion("xspzxm not in", values, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmBetween(String value1, String value2) {
            addCriterion("xspzxm between", value1, value2, "xspzxm");
            return (Criteria) this;
        }

        public Criteria andXspzxmNotBetween(String value1, String value2) {
            addCriterion("xspzxm not between", value1, value2, "xspzxm");
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

        public Criteria andDdslIsNull() {
            addCriterion("ddsl is null");
            return (Criteria) this;
        }

        public Criteria andDdslIsNotNull() {
            addCriterion("ddsl is not null");
            return (Criteria) this;
        }

        public Criteria andDdslEqualTo(Double value) {
            addCriterion("ddsl =", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslNotEqualTo(Double value) {
            addCriterion("ddsl <>", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslGreaterThan(Double value) {
            addCriterion("ddsl >", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslGreaterThanOrEqualTo(Double value) {
            addCriterion("ddsl >=", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslLessThan(Double value) {
            addCriterion("ddsl <", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslLessThanOrEqualTo(Double value) {
            addCriterion("ddsl <=", value, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslIn(List<Double> values) {
            addCriterion("ddsl in", values, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslNotIn(List<Double> values) {
            addCriterion("ddsl not in", values, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslBetween(Double value1, Double value2) {
            addCriterion("ddsl between", value1, value2, "ddsl");
            return (Criteria) this;
        }

        public Criteria andDdslNotBetween(Double value1, Double value2) {
            addCriterion("ddsl not between", value1, value2, "ddsl");
            return (Criteria) this;
        }

        public Criteria andXsdwIsNull() {
            addCriterion("xsdw is null");
            return (Criteria) this;
        }

        public Criteria andXsdwIsNotNull() {
            addCriterion("xsdw is not null");
            return (Criteria) this;
        }

        public Criteria andXsdwEqualTo(String value) {
            addCriterion("xsdw =", value, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwNotEqualTo(String value) {
            addCriterion("xsdw <>", value, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwGreaterThan(String value) {
            addCriterion("xsdw >", value, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwGreaterThanOrEqualTo(String value) {
            addCriterion("xsdw >=", value, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwLessThan(String value) {
            addCriterion("xsdw <", value, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwLessThanOrEqualTo(String value) {
            addCriterion("xsdw <=", value, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwLike(String value) {
            addCriterion("xsdw like", value, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwNotLike(String value) {
            addCriterion("xsdw not like", value, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwIn(List<String> values) {
            addCriterion("xsdw in", values, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwNotIn(List<String> values) {
            addCriterion("xsdw not in", values, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwBetween(String value1, String value2) {
            addCriterion("xsdw between", value1, value2, "xsdw");
            return (Criteria) this;
        }

        public Criteria andXsdwNotBetween(String value1, String value2) {
            addCriterion("xsdw not between", value1, value2, "xsdw");
            return (Criteria) this;
        }

        public Criteria andDhlxIsNull() {
            addCriterion("dhlx is null");
            return (Criteria) this;
        }

        public Criteria andDhlxIsNotNull() {
            addCriterion("dhlx is not null");
            return (Criteria) this;
        }

        public Criteria andDhlxEqualTo(String value) {
            addCriterion("dhlx =", value, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxNotEqualTo(String value) {
            addCriterion("dhlx <>", value, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxGreaterThan(String value) {
            addCriterion("dhlx >", value, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxGreaterThanOrEqualTo(String value) {
            addCriterion("dhlx >=", value, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxLessThan(String value) {
            addCriterion("dhlx <", value, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxLessThanOrEqualTo(String value) {
            addCriterion("dhlx <=", value, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxLike(String value) {
            addCriterion("dhlx like", value, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxNotLike(String value) {
            addCriterion("dhlx not like", value, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxIn(List<String> values) {
            addCriterion("dhlx in", values, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxNotIn(List<String> values) {
            addCriterion("dhlx not in", values, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxBetween(String value1, String value2) {
            addCriterion("dhlx between", value1, value2, "dhlx");
            return (Criteria) this;
        }

        public Criteria andDhlxNotBetween(String value1, String value2) {
            addCriterion("dhlx not between", value1, value2, "dhlx");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdIsNull() {
            addCriterion("cjptcdgd is null");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdIsNotNull() {
            addCriterion("cjptcdgd is not null");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdEqualTo(String value) {
            addCriterion("cjptcdgd =", value, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdNotEqualTo(String value) {
            addCriterion("cjptcdgd <>", value, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdGreaterThan(String value) {
            addCriterion("cjptcdgd >", value, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdGreaterThanOrEqualTo(String value) {
            addCriterion("cjptcdgd >=", value, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdLessThan(String value) {
            addCriterion("cjptcdgd <", value, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdLessThanOrEqualTo(String value) {
            addCriterion("cjptcdgd <=", value, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdLike(String value) {
            addCriterion("cjptcdgd like", value, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdNotLike(String value) {
            addCriterion("cjptcdgd not like", value, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdIn(List<String> values) {
            addCriterion("cjptcdgd in", values, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdNotIn(List<String> values) {
            addCriterion("cjptcdgd not in", values, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdBetween(String value1, String value2) {
            addCriterion("cjptcdgd between", value1, value2, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcdgdNotBetween(String value1, String value2) {
            addCriterion("cjptcdgd not between", value1, value2, "cjptcdgd");
            return (Criteria) this;
        }

        public Criteria andCjptcjIsNull() {
            addCriterion("cjptcj is null");
            return (Criteria) this;
        }

        public Criteria andCjptcjIsNotNull() {
            addCriterion("cjptcj is not null");
            return (Criteria) this;
        }

        public Criteria andCjptcjEqualTo(String value) {
            addCriterion("cjptcj =", value, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjNotEqualTo(String value) {
            addCriterion("cjptcj <>", value, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjGreaterThan(String value) {
            addCriterion("cjptcj >", value, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjGreaterThanOrEqualTo(String value) {
            addCriterion("cjptcj >=", value, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjLessThan(String value) {
            addCriterion("cjptcj <", value, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjLessThanOrEqualTo(String value) {
            addCriterion("cjptcj <=", value, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjLike(String value) {
            addCriterion("cjptcj like", value, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjNotLike(String value) {
            addCriterion("cjptcj not like", value, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjIn(List<String> values) {
            addCriterion("cjptcj in", values, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjNotIn(List<String> values) {
            addCriterion("cjptcj not in", values, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjBetween(String value1, String value2) {
            addCriterion("cjptcj between", value1, value2, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andCjptcjNotBetween(String value1, String value2) {
            addCriterion("cjptcj not between", value1, value2, "cjptcj");
            return (Criteria) this;
        }

        public Criteria andQtIsNull() {
            addCriterion("qt is null");
            return (Criteria) this;
        }

        public Criteria andQtIsNotNull() {
            addCriterion("qt is not null");
            return (Criteria) this;
        }

        public Criteria andQtEqualTo(String value) {
            addCriterion("qt =", value, "qt");
            return (Criteria) this;
        }

        public Criteria andQtNotEqualTo(String value) {
            addCriterion("qt <>", value, "qt");
            return (Criteria) this;
        }

        public Criteria andQtGreaterThan(String value) {
            addCriterion("qt >", value, "qt");
            return (Criteria) this;
        }

        public Criteria andQtGreaterThanOrEqualTo(String value) {
            addCriterion("qt >=", value, "qt");
            return (Criteria) this;
        }

        public Criteria andQtLessThan(String value) {
            addCriterion("qt <", value, "qt");
            return (Criteria) this;
        }

        public Criteria andQtLessThanOrEqualTo(String value) {
            addCriterion("qt <=", value, "qt");
            return (Criteria) this;
        }

        public Criteria andQtLike(String value) {
            addCriterion("qt like", value, "qt");
            return (Criteria) this;
        }

        public Criteria andQtNotLike(String value) {
            addCriterion("qt not like", value, "qt");
            return (Criteria) this;
        }

        public Criteria andQtIn(List<String> values) {
            addCriterion("qt in", values, "qt");
            return (Criteria) this;
        }

        public Criteria andQtNotIn(List<String> values) {
            addCriterion("qt not in", values, "qt");
            return (Criteria) this;
        }

        public Criteria andQtBetween(String value1, String value2) {
            addCriterion("qt between", value1, value2, "qt");
            return (Criteria) this;
        }

        public Criteria andQtNotBetween(String value1, String value2) {
            addCriterion("qt not between", value1, value2, "qt");
            return (Criteria) this;
        }

        public Criteria andGcgdIsNull() {
            addCriterion("gcgd is null");
            return (Criteria) this;
        }

        public Criteria andGcgdIsNotNull() {
            addCriterion("gcgd is not null");
            return (Criteria) this;
        }

        public Criteria andGcgdEqualTo(String value) {
            addCriterion("gcgd =", value, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdNotEqualTo(String value) {
            addCriterion("gcgd <>", value, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdGreaterThan(String value) {
            addCriterion("gcgd >", value, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdGreaterThanOrEqualTo(String value) {
            addCriterion("gcgd >=", value, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdLessThan(String value) {
            addCriterion("gcgd <", value, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdLessThanOrEqualTo(String value) {
            addCriterion("gcgd <=", value, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdLike(String value) {
            addCriterion("gcgd like", value, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdNotLike(String value) {
            addCriterion("gcgd not like", value, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdIn(List<String> values) {
            addCriterion("gcgd in", values, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdNotIn(List<String> values) {
            addCriterion("gcgd not in", values, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdBetween(String value1, String value2) {
            addCriterion("gcgd between", value1, value2, "gcgd");
            return (Criteria) this;
        }

        public Criteria andGcgdNotBetween(String value1, String value2) {
            addCriterion("gcgd not between", value1, value2, "gcgd");
            return (Criteria) this;
        }

        public Criteria andCpbmIsNull() {
            addCriterion("cpbm is null");
            return (Criteria) this;
        }

        public Criteria andCpbmIsNotNull() {
            addCriterion("cpbm is not null");
            return (Criteria) this;
        }

        public Criteria andCpbmEqualTo(String value) {
            addCriterion("cpbm =", value, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmNotEqualTo(String value) {
            addCriterion("cpbm <>", value, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmGreaterThan(String value) {
            addCriterion("cpbm >", value, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmGreaterThanOrEqualTo(String value) {
            addCriterion("cpbm >=", value, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmLessThan(String value) {
            addCriterion("cpbm <", value, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmLessThanOrEqualTo(String value) {
            addCriterion("cpbm <=", value, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmLike(String value) {
            addCriterion("cpbm like", value, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmNotLike(String value) {
            addCriterion("cpbm not like", value, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmIn(List<String> values) {
            addCriterion("cpbm in", values, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmNotIn(List<String> values) {
            addCriterion("cpbm not in", values, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmBetween(String value1, String value2) {
            addCriterion("cpbm between", value1, value2, "cpbm");
            return (Criteria) this;
        }

        public Criteria andCpbmNotBetween(String value1, String value2) {
            addCriterion("cpbm not between", value1, value2, "cpbm");
            return (Criteria) this;
        }

        public Criteria andJjIsNull() {
            addCriterion("jj is null");
            return (Criteria) this;
        }

        public Criteria andJjIsNotNull() {
            addCriterion("jj is not null");
            return (Criteria) this;
        }

        public Criteria andJjEqualTo(Double value) {
            addCriterion("jj =", value, "jj");
            return (Criteria) this;
        }

        public Criteria andJjNotEqualTo(Double value) {
            addCriterion("jj <>", value, "jj");
            return (Criteria) this;
        }

        public Criteria andJjGreaterThan(Double value) {
            addCriterion("jj >", value, "jj");
            return (Criteria) this;
        }

        public Criteria andJjGreaterThanOrEqualTo(Double value) {
            addCriterion("jj >=", value, "jj");
            return (Criteria) this;
        }

        public Criteria andJjLessThan(Double value) {
            addCriterion("jj <", value, "jj");
            return (Criteria) this;
        }

        public Criteria andJjLessThanOrEqualTo(Double value) {
            addCriterion("jj <=", value, "jj");
            return (Criteria) this;
        }

        public Criteria andJjIn(List<Double> values) {
            addCriterion("jj in", values, "jj");
            return (Criteria) this;
        }

        public Criteria andJjNotIn(List<Double> values) {
            addCriterion("jj not in", values, "jj");
            return (Criteria) this;
        }

        public Criteria andJjBetween(Double value1, Double value2) {
            addCriterion("jj between", value1, value2, "jj");
            return (Criteria) this;
        }

        public Criteria andJjNotBetween(Double value1, Double value2) {
            addCriterion("jj not between", value1, value2, "jj");
            return (Criteria) this;
        }

        public Criteria andJzIsNull() {
            addCriterion("jz is null");
            return (Criteria) this;
        }

        public Criteria andJzIsNotNull() {
            addCriterion("jz is not null");
            return (Criteria) this;
        }

        public Criteria andJzEqualTo(Double value) {
            addCriterion("jz =", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzNotEqualTo(Double value) {
            addCriterion("jz <>", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzGreaterThan(Double value) {
            addCriterion("jz >", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzGreaterThanOrEqualTo(Double value) {
            addCriterion("jz >=", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzLessThan(Double value) {
            addCriterion("jz <", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzLessThanOrEqualTo(Double value) {
            addCriterion("jz <=", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzIn(List<Double> values) {
            addCriterion("jz in", values, "jz");
            return (Criteria) this;
        }

        public Criteria andJzNotIn(List<Double> values) {
            addCriterion("jz not in", values, "jz");
            return (Criteria) this;
        }

        public Criteria andJzBetween(Double value1, Double value2) {
            addCriterion("jz between", value1, value2, "jz");
            return (Criteria) this;
        }

        public Criteria andJzNotBetween(Double value1, Double value2) {
            addCriterion("jz not between", value1, value2, "jz");
            return (Criteria) this;
        }

        public Criteria andPzhbIsNull() {
            addCriterion("pzhb is null");
            return (Criteria) this;
        }

        public Criteria andPzhbIsNotNull() {
            addCriterion("pzhb is not null");
            return (Criteria) this;
        }

        public Criteria andPzhbEqualTo(String value) {
            addCriterion("pzhb =", value, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbNotEqualTo(String value) {
            addCriterion("pzhb <>", value, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbGreaterThan(String value) {
            addCriterion("pzhb >", value, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbGreaterThanOrEqualTo(String value) {
            addCriterion("pzhb >=", value, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbLessThan(String value) {
            addCriterion("pzhb <", value, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbLessThanOrEqualTo(String value) {
            addCriterion("pzhb <=", value, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbLike(String value) {
            addCriterion("pzhb like", value, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbNotLike(String value) {
            addCriterion("pzhb not like", value, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbIn(List<String> values) {
            addCriterion("pzhb in", values, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbNotIn(List<String> values) {
            addCriterion("pzhb not in", values, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbBetween(String value1, String value2) {
            addCriterion("pzhb between", value1, value2, "pzhb");
            return (Criteria) this;
        }

        public Criteria andPzhbNotBetween(String value1, String value2) {
            addCriterion("pzhb not between", value1, value2, "pzhb");
            return (Criteria) this;
        }

        public Criteria andCjrqIsNull() {
            addCriterion("cjrq is null");
            return (Criteria) this;
        }

        public Criteria andCjrqIsNotNull() {
            addCriterion("cjrq is not null");
            return (Criteria) this;
        }

        public Criteria andCjrqEqualTo(String value) {
            addCriterion("cjrq =", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqNotEqualTo(String value) {
            addCriterion("cjrq <>", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqGreaterThan(String value) {
            addCriterion("cjrq >", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqGreaterThanOrEqualTo(String value) {
            addCriterion("cjrq >=", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqLessThan(String value) {
            addCriterion("cjrq <", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqLessThanOrEqualTo(String value) {
            addCriterion("cjrq <=", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqLike(String value) {
            addCriterion("cjrq like", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqNotLike(String value) {
            addCriterion("cjrq not like", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqIn(List<String> values) {
            addCriterion("cjrq in", values, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqNotIn(List<String> values) {
            addCriterion("cjrq not in", values, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqBetween(String value1, String value2) {
            addCriterion("cjrq between", value1, value2, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqNotBetween(String value1, String value2) {
            addCriterion("cjrq not between", value1, value2, "cjrq");
            return (Criteria) this;
        }

        public Criteria andXszzIsNull() {
            addCriterion("xszz is null");
            return (Criteria) this;
        }

        public Criteria andXszzIsNotNull() {
            addCriterion("xszz is not null");
            return (Criteria) this;
        }

        public Criteria andXszzEqualTo(String value) {
            addCriterion("xszz =", value, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzNotEqualTo(String value) {
            addCriterion("xszz <>", value, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzGreaterThan(String value) {
            addCriterion("xszz >", value, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzGreaterThanOrEqualTo(String value) {
            addCriterion("xszz >=", value, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzLessThan(String value) {
            addCriterion("xszz <", value, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzLessThanOrEqualTo(String value) {
            addCriterion("xszz <=", value, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzLike(String value) {
            addCriterion("xszz like", value, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzNotLike(String value) {
            addCriterion("xszz not like", value, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzIn(List<String> values) {
            addCriterion("xszz in", values, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzNotIn(List<String> values) {
            addCriterion("xszz not in", values, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzBetween(String value1, String value2) {
            addCriterion("xszz between", value1, value2, "xszz");
            return (Criteria) this;
        }

        public Criteria andXszzNotBetween(String value1, String value2) {
            addCriterion("xszz not between", value1, value2, "xszz");
            return (Criteria) this;
        }

        public Criteria andFxqdIsNull() {
            addCriterion("fxqd is null");
            return (Criteria) this;
        }

        public Criteria andFxqdIsNotNull() {
            addCriterion("fxqd is not null");
            return (Criteria) this;
        }

        public Criteria andFxqdEqualTo(String value) {
            addCriterion("fxqd =", value, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdNotEqualTo(String value) {
            addCriterion("fxqd <>", value, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdGreaterThan(String value) {
            addCriterion("fxqd >", value, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdGreaterThanOrEqualTo(String value) {
            addCriterion("fxqd >=", value, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdLessThan(String value) {
            addCriterion("fxqd <", value, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdLessThanOrEqualTo(String value) {
            addCriterion("fxqd <=", value, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdLike(String value) {
            addCriterion("fxqd like", value, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdNotLike(String value) {
            addCriterion("fxqd not like", value, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdIn(List<String> values) {
            addCriterion("fxqd in", values, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdNotIn(List<String> values) {
            addCriterion("fxqd not in", values, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdBetween(String value1, String value2) {
            addCriterion("fxqd between", value1, value2, "fxqd");
            return (Criteria) this;
        }

        public Criteria andFxqdNotBetween(String value1, String value2) {
            addCriterion("fxqd not between", value1, value2, "fxqd");
            return (Criteria) this;
        }

        public Criteria andJxskhbmIsNull() {
            addCriterion("jxskhbm is null");
            return (Criteria) this;
        }

        public Criteria andJxskhbmIsNotNull() {
            addCriterion("jxskhbm is not null");
            return (Criteria) this;
        }

        public Criteria andJxskhbmEqualTo(String value) {
            addCriterion("jxskhbm =", value, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmNotEqualTo(String value) {
            addCriterion("jxskhbm <>", value, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmGreaterThan(String value) {
            addCriterion("jxskhbm >", value, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmGreaterThanOrEqualTo(String value) {
            addCriterion("jxskhbm >=", value, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmLessThan(String value) {
            addCriterion("jxskhbm <", value, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmLessThanOrEqualTo(String value) {
            addCriterion("jxskhbm <=", value, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmLike(String value) {
            addCriterion("jxskhbm like", value, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmNotLike(String value) {
            addCriterion("jxskhbm not like", value, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmIn(List<String> values) {
            addCriterion("jxskhbm in", values, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmNotIn(List<String> values) {
            addCriterion("jxskhbm not in", values, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmBetween(String value1, String value2) {
            addCriterion("jxskhbm between", value1, value2, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andJxskhbmNotBetween(String value1, String value2) {
            addCriterion("jxskhbm not between", value1, value2, "jxskhbm");
            return (Criteria) this;
        }

        public Criteria andDhdhIsNull() {
            addCriterion("dhdh is null");
            return (Criteria) this;
        }

        public Criteria andDhdhIsNotNull() {
            addCriterion("dhdh is not null");
            return (Criteria) this;
        }

        public Criteria andDhdhEqualTo(String value) {
            addCriterion("dhdh =", value, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhNotEqualTo(String value) {
            addCriterion("dhdh <>", value, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhGreaterThan(String value) {
            addCriterion("dhdh >", value, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhGreaterThanOrEqualTo(String value) {
            addCriterion("dhdh >=", value, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhLessThan(String value) {
            addCriterion("dhdh <", value, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhLessThanOrEqualTo(String value) {
            addCriterion("dhdh <=", value, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhLike(String value) {
            addCriterion("dhdh like", value, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhNotLike(String value) {
            addCriterion("dhdh not like", value, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhIn(List<String> values) {
            addCriterion("dhdh in", values, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhNotIn(List<String> values) {
            addCriterion("dhdh not in", values, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhBetween(String value1, String value2) {
            addCriterion("dhdh between", value1, value2, "dhdh");
            return (Criteria) this;
        }

        public Criteria andDhdhNotBetween(String value1, String value2) {
            addCriterion("dhdh not between", value1, value2, "dhdh");
            return (Criteria) this;
        }

        public Criteria andThIsNull() {
            addCriterion("th is null");
            return (Criteria) this;
        }

        public Criteria andThIsNotNull() {
            addCriterion("th is not null");
            return (Criteria) this;
        }

        public Criteria andThEqualTo(String value) {
            addCriterion("th =", value, "th");
            return (Criteria) this;
        }

        public Criteria andThNotEqualTo(String value) {
            addCriterion("th <>", value, "th");
            return (Criteria) this;
        }

        public Criteria andThGreaterThan(String value) {
            addCriterion("th >", value, "th");
            return (Criteria) this;
        }

        public Criteria andThGreaterThanOrEqualTo(String value) {
            addCriterion("th >=", value, "th");
            return (Criteria) this;
        }

        public Criteria andThLessThan(String value) {
            addCriterion("th <", value, "th");
            return (Criteria) this;
        }

        public Criteria andThLessThanOrEqualTo(String value) {
            addCriterion("th <=", value, "th");
            return (Criteria) this;
        }

        public Criteria andThLike(String value) {
            addCriterion("th like", value, "th");
            return (Criteria) this;
        }

        public Criteria andThNotLike(String value) {
            addCriterion("th not like", value, "th");
            return (Criteria) this;
        }

        public Criteria andThIn(List<String> values) {
            addCriterion("th in", values, "th");
            return (Criteria) this;
        }

        public Criteria andThNotIn(List<String> values) {
            addCriterion("th not in", values, "th");
            return (Criteria) this;
        }

        public Criteria andThBetween(String value1, String value2) {
            addCriterion("th between", value1, value2, "th");
            return (Criteria) this;
        }

        public Criteria andThNotBetween(String value1, String value2) {
            addCriterion("th not between", value1, value2, "th");
            return (Criteria) this;
        }

        public Criteria andJjztIsNull() {
            addCriterion("jjzt is null");
            return (Criteria) this;
        }

        public Criteria andJjztIsNotNull() {
            addCriterion("jjzt is not null");
            return (Criteria) this;
        }

        public Criteria andJjztEqualTo(String value) {
            addCriterion("jjzt =", value, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztNotEqualTo(String value) {
            addCriterion("jjzt <>", value, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztGreaterThan(String value) {
            addCriterion("jjzt >", value, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztGreaterThanOrEqualTo(String value) {
            addCriterion("jjzt >=", value, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztLessThan(String value) {
            addCriterion("jjzt <", value, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztLessThanOrEqualTo(String value) {
            addCriterion("jjzt <=", value, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztLike(String value) {
            addCriterion("jjzt like", value, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztNotLike(String value) {
            addCriterion("jjzt not like", value, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztIn(List<String> values) {
            addCriterion("jjzt in", values, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztNotIn(List<String> values) {
            addCriterion("jjzt not in", values, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztBetween(String value1, String value2) {
            addCriterion("jjzt between", value1, value2, "jjzt");
            return (Criteria) this;
        }

        public Criteria andJjztNotBetween(String value1, String value2) {
            addCriterion("jjzt not between", value1, value2, "jjzt");
            return (Criteria) this;
        }

        public Criteria andQxyyIsNull() {
            addCriterion("qxyy is null");
            return (Criteria) this;
        }

        public Criteria andQxyyIsNotNull() {
            addCriterion("qxyy is not null");
            return (Criteria) this;
        }

        public Criteria andQxyyEqualTo(String value) {
            addCriterion("qxyy =", value, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyNotEqualTo(String value) {
            addCriterion("qxyy <>", value, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyGreaterThan(String value) {
            addCriterion("qxyy >", value, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyGreaterThanOrEqualTo(String value) {
            addCriterion("qxyy >=", value, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyLessThan(String value) {
            addCriterion("qxyy <", value, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyLessThanOrEqualTo(String value) {
            addCriterion("qxyy <=", value, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyLike(String value) {
            addCriterion("qxyy like", value, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyNotLike(String value) {
            addCriterion("qxyy not like", value, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyIn(List<String> values) {
            addCriterion("qxyy in", values, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyNotIn(List<String> values) {
            addCriterion("qxyy not in", values, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyBetween(String value1, String value2) {
            addCriterion("qxyy between", value1, value2, "qxyy");
            return (Criteria) this;
        }

        public Criteria andQxyyNotBetween(String value1, String value2) {
            addCriterion("qxyy not between", value1, value2, "qxyy");
            return (Criteria) this;
        }

        public Criteria andThyyIsNull() {
            addCriterion("thyy is null");
            return (Criteria) this;
        }

        public Criteria andThyyIsNotNull() {
            addCriterion("thyy is not null");
            return (Criteria) this;
        }

        public Criteria andThyyEqualTo(String value) {
            addCriterion("thyy =", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyNotEqualTo(String value) {
            addCriterion("thyy <>", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyGreaterThan(String value) {
            addCriterion("thyy >", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyGreaterThanOrEqualTo(String value) {
            addCriterion("thyy >=", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyLessThan(String value) {
            addCriterion("thyy <", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyLessThanOrEqualTo(String value) {
            addCriterion("thyy <=", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyLike(String value) {
            addCriterion("thyy like", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyNotLike(String value) {
            addCriterion("thyy not like", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyIn(List<String> values) {
            addCriterion("thyy in", values, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyNotIn(List<String> values) {
            addCriterion("thyy not in", values, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyBetween(String value1, String value2) {
            addCriterion("thyy between", value1, value2, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyNotBetween(String value1, String value2) {
            addCriterion("thyy not between", value1, value2, "thyy");
            return (Criteria) this;
        }

        public Criteria andJjyyIsNull() {
            addCriterion("jjyy is null");
            return (Criteria) this;
        }

        public Criteria andJjyyIsNotNull() {
            addCriterion("jjyy is not null");
            return (Criteria) this;
        }

        public Criteria andJjyyEqualTo(String value) {
            addCriterion("jjyy =", value, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyNotEqualTo(String value) {
            addCriterion("jjyy <>", value, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyGreaterThan(String value) {
            addCriterion("jjyy >", value, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyGreaterThanOrEqualTo(String value) {
            addCriterion("jjyy >=", value, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyLessThan(String value) {
            addCriterion("jjyy <", value, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyLessThanOrEqualTo(String value) {
            addCriterion("jjyy <=", value, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyLike(String value) {
            addCriterion("jjyy like", value, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyNotLike(String value) {
            addCriterion("jjyy not like", value, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyIn(List<String> values) {
            addCriterion("jjyy in", values, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyNotIn(List<String> values) {
            addCriterion("jjyy not in", values, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyBetween(String value1, String value2) {
            addCriterion("jjyy between", value1, value2, "jjyy");
            return (Criteria) this;
        }

        public Criteria andJjyyNotBetween(String value1, String value2) {
            addCriterion("jjyy not between", value1, value2, "jjyy");
            return (Criteria) this;
        }

        public Criteria andCpmsIsNull() {
            addCriterion("cpms is null");
            return (Criteria) this;
        }

        public Criteria andCpmsIsNotNull() {
            addCriterion("cpms is not null");
            return (Criteria) this;
        }

        public Criteria andCpmsEqualTo(String value) {
            addCriterion("cpms =", value, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsNotEqualTo(String value) {
            addCriterion("cpms <>", value, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsGreaterThan(String value) {
            addCriterion("cpms >", value, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsGreaterThanOrEqualTo(String value) {
            addCriterion("cpms >=", value, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsLessThan(String value) {
            addCriterion("cpms <", value, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsLessThanOrEqualTo(String value) {
            addCriterion("cpms <=", value, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsLike(String value) {
            addCriterion("cpms like", value, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsNotLike(String value) {
            addCriterion("cpms not like", value, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsIn(List<String> values) {
            addCriterion("cpms in", values, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsNotIn(List<String> values) {
            addCriterion("cpms not in", values, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsBetween(String value1, String value2) {
            addCriterion("cpms between", value1, value2, "cpms");
            return (Criteria) this;
        }

        public Criteria andCpmsNotBetween(String value1, String value2) {
            addCriterion("cpms not between", value1, value2, "cpms");
            return (Criteria) this;
        }

        public Criteria andWlzmsIsNull() {
            addCriterion("wlzms is null");
            return (Criteria) this;
        }

        public Criteria andWlzmsIsNotNull() {
            addCriterion("wlzms is not null");
            return (Criteria) this;
        }

        public Criteria andWlzmsEqualTo(String value) {
            addCriterion("wlzms =", value, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsNotEqualTo(String value) {
            addCriterion("wlzms <>", value, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsGreaterThan(String value) {
            addCriterion("wlzms >", value, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsGreaterThanOrEqualTo(String value) {
            addCriterion("wlzms >=", value, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsLessThan(String value) {
            addCriterion("wlzms <", value, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsLessThanOrEqualTo(String value) {
            addCriterion("wlzms <=", value, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsLike(String value) {
            addCriterion("wlzms like", value, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsNotLike(String value) {
            addCriterion("wlzms not like", value, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsIn(List<String> values) {
            addCriterion("wlzms in", values, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsNotIn(List<String> values) {
            addCriterion("wlzms not in", values, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsBetween(String value1, String value2) {
            addCriterion("wlzms between", value1, value2, "wlzms");
            return (Criteria) this;
        }

        public Criteria andWlzmsNotBetween(String value1, String value2) {
            addCriterion("wlzms not between", value1, value2, "wlzms");
            return (Criteria) this;
        }

        public Criteria andJxskhmcIsNull() {
            addCriterion("jxskhmc is null");
            return (Criteria) this;
        }

        public Criteria andJxskhmcIsNotNull() {
            addCriterion("jxskhmc is not null");
            return (Criteria) this;
        }

        public Criteria andJxskhmcEqualTo(String value) {
            addCriterion("jxskhmc =", value, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcNotEqualTo(String value) {
            addCriterion("jxskhmc <>", value, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcGreaterThan(String value) {
            addCriterion("jxskhmc >", value, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcGreaterThanOrEqualTo(String value) {
            addCriterion("jxskhmc >=", value, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcLessThan(String value) {
            addCriterion("jxskhmc <", value, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcLessThanOrEqualTo(String value) {
            addCriterion("jxskhmc <=", value, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcLike(String value) {
            addCriterion("jxskhmc like", value, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcNotLike(String value) {
            addCriterion("jxskhmc not like", value, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcIn(List<String> values) {
            addCriterion("jxskhmc in", values, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcNotIn(List<String> values) {
            addCriterion("jxskhmc not in", values, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcBetween(String value1, String value2) {
            addCriterion("jxskhmc between", value1, value2, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andJxskhmcNotBetween(String value1, String value2) {
            addCriterion("jxskhmc not between", value1, value2, "jxskhmc");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzIsNull() {
            addCriterion("bzjgtjjz is null");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzIsNotNull() {
            addCriterion("bzjgtjjz is not null");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzEqualTo(Double value) {
            addCriterion("bzjgtjjz =", value, "bzjgtjjz");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzNotEqualTo(Double value) {
            addCriterion("bzjgtjjz <>", value, "bzjgtjjz");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzGreaterThan(Double value) {
            addCriterion("bzjgtjjz >", value, "bzjgtjjz");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzGreaterThanOrEqualTo(Double value) {
            addCriterion("bzjgtjjz >=", value, "bzjgtjjz");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzLessThan(Double value) {
            addCriterion("bzjgtjjz <", value, "bzjgtjjz");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzLessThanOrEqualTo(Double value) {
            addCriterion("bzjgtjjz <=", value, "bzjgtjjz");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzIn(List<Double> values) {
            addCriterion("bzjgtjjz in", values, "bzjgtjjz");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzNotIn(List<Double> values) {
            addCriterion("bzjgtjjz not in", values, "bzjgtjjz");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzBetween(Double value1, Double value2) {
            addCriterion("bzjgtjjz between", value1, value2, "bzjgtjjz");
            return (Criteria) this;
        }

        public Criteria andBzjgtjjzNotBetween(Double value1, Double value2) {
            addCriterion("bzjgtjjz not between", value1, value2, "bzjgtjjz");
            return (Criteria) this;
        }

        public Criteria andBzjgjeIsNull() {
            addCriterion("bzjgje is null");
            return (Criteria) this;
        }

        public Criteria andBzjgjeIsNotNull() {
            addCriterion("bzjgje is not null");
            return (Criteria) this;
        }

        public Criteria andBzjgjeEqualTo(Double value) {
            addCriterion("bzjgje =", value, "bzjgje");
            return (Criteria) this;
        }

        public Criteria andBzjgjeNotEqualTo(Double value) {
            addCriterion("bzjgje <>", value, "bzjgje");
            return (Criteria) this;
        }

        public Criteria andBzjgjeGreaterThan(Double value) {
            addCriterion("bzjgje >", value, "bzjgje");
            return (Criteria) this;
        }

        public Criteria andBzjgjeGreaterThanOrEqualTo(Double value) {
            addCriterion("bzjgje >=", value, "bzjgje");
            return (Criteria) this;
        }

        public Criteria andBzjgjeLessThan(Double value) {
            addCriterion("bzjgje <", value, "bzjgje");
            return (Criteria) this;
        }

        public Criteria andBzjgjeLessThanOrEqualTo(Double value) {
            addCriterion("bzjgje <=", value, "bzjgje");
            return (Criteria) this;
        }

        public Criteria andBzjgjeIn(List<Double> values) {
            addCriterion("bzjgje in", values, "bzjgje");
            return (Criteria) this;
        }

        public Criteria andBzjgjeNotIn(List<Double> values) {
            addCriterion("bzjgje not in", values, "bzjgje");
            return (Criteria) this;
        }

        public Criteria andBzjgjeBetween(Double value1, Double value2) {
            addCriterion("bzjgje between", value1, value2, "bzjgje");
            return (Criteria) this;
        }

        public Criteria andBzjgjeNotBetween(Double value1, Double value2) {
            addCriterion("bzjgje not between", value1, value2, "bzjgje");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzIsNull() {
            addCriterion("khzktjjz is null");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzIsNotNull() {
            addCriterion("khzktjjz is not null");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzEqualTo(Double value) {
            addCriterion("khzktjjz =", value, "khzktjjz");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzNotEqualTo(Double value) {
            addCriterion("khzktjjz <>", value, "khzktjjz");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzGreaterThan(Double value) {
            addCriterion("khzktjjz >", value, "khzktjjz");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzGreaterThanOrEqualTo(Double value) {
            addCriterion("khzktjjz >=", value, "khzktjjz");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzLessThan(Double value) {
            addCriterion("khzktjjz <", value, "khzktjjz");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzLessThanOrEqualTo(Double value) {
            addCriterion("khzktjjz <=", value, "khzktjjz");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzIn(List<Double> values) {
            addCriterion("khzktjjz in", values, "khzktjjz");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzNotIn(List<Double> values) {
            addCriterion("khzktjjz not in", values, "khzktjjz");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzBetween(Double value1, Double value2) {
            addCriterion("khzktjjz between", value1, value2, "khzktjjz");
            return (Criteria) this;
        }

        public Criteria andKhzktjjzNotBetween(Double value1, Double value2) {
            addCriterion("khzktjjz not between", value1, value2, "khzktjjz");
            return (Criteria) this;
        }

        public Criteria andKhzkjeIsNull() {
            addCriterion("khzkje is null");
            return (Criteria) this;
        }

        public Criteria andKhzkjeIsNotNull() {
            addCriterion("khzkje is not null");
            return (Criteria) this;
        }

        public Criteria andKhzkjeEqualTo(Double value) {
            addCriterion("khzkje =", value, "khzkje");
            return (Criteria) this;
        }

        public Criteria andKhzkjeNotEqualTo(Double value) {
            addCriterion("khzkje <>", value, "khzkje");
            return (Criteria) this;
        }

        public Criteria andKhzkjeGreaterThan(Double value) {
            addCriterion("khzkje >", value, "khzkje");
            return (Criteria) this;
        }

        public Criteria andKhzkjeGreaterThanOrEqualTo(Double value) {
            addCriterion("khzkje >=", value, "khzkje");
            return (Criteria) this;
        }

        public Criteria andKhzkjeLessThan(Double value) {
            addCriterion("khzkje <", value, "khzkje");
            return (Criteria) this;
        }

        public Criteria andKhzkjeLessThanOrEqualTo(Double value) {
            addCriterion("khzkje <=", value, "khzkje");
            return (Criteria) this;
        }

        public Criteria andKhzkjeIn(List<Double> values) {
            addCriterion("khzkje in", values, "khzkje");
            return (Criteria) this;
        }

        public Criteria andKhzkjeNotIn(List<Double> values) {
            addCriterion("khzkje not in", values, "khzkje");
            return (Criteria) this;
        }

        public Criteria andKhzkjeBetween(Double value1, Double value2) {
            addCriterion("khzkje between", value1, value2, "khzkje");
            return (Criteria) this;
        }

        public Criteria andKhzkjeNotBetween(Double value1, Double value2) {
            addCriterion("khzkje not between", value1, value2, "khzkje");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzIsNull() {
            addCriterion("syfltjjz is null");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzIsNotNull() {
            addCriterion("syfltjjz is not null");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzEqualTo(Double value) {
            addCriterion("syfltjjz =", value, "syfltjjz");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzNotEqualTo(Double value) {
            addCriterion("syfltjjz <>", value, "syfltjjz");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzGreaterThan(Double value) {
            addCriterion("syfltjjz >", value, "syfltjjz");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzGreaterThanOrEqualTo(Double value) {
            addCriterion("syfltjjz >=", value, "syfltjjz");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzLessThan(Double value) {
            addCriterion("syfltjjz <", value, "syfltjjz");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzLessThanOrEqualTo(Double value) {
            addCriterion("syfltjjz <=", value, "syfltjjz");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzIn(List<Double> values) {
            addCriterion("syfltjjz in", values, "syfltjjz");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzNotIn(List<Double> values) {
            addCriterion("syfltjjz not in", values, "syfltjjz");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzBetween(Double value1, Double value2) {
            addCriterion("syfltjjz between", value1, value2, "syfltjjz");
            return (Criteria) this;
        }

        public Criteria andSyfltjjzNotBetween(Double value1, Double value2) {
            addCriterion("syfltjjz not between", value1, value2, "syfltjjz");
            return (Criteria) this;
        }

        public Criteria andSyfljeIsNull() {
            addCriterion("syflje is null");
            return (Criteria) this;
        }

        public Criteria andSyfljeIsNotNull() {
            addCriterion("syflje is not null");
            return (Criteria) this;
        }

        public Criteria andSyfljeEqualTo(Double value) {
            addCriterion("syflje =", value, "syflje");
            return (Criteria) this;
        }

        public Criteria andSyfljeNotEqualTo(Double value) {
            addCriterion("syflje <>", value, "syflje");
            return (Criteria) this;
        }

        public Criteria andSyfljeGreaterThan(Double value) {
            addCriterion("syflje >", value, "syflje");
            return (Criteria) this;
        }

        public Criteria andSyfljeGreaterThanOrEqualTo(Double value) {
            addCriterion("syflje >=", value, "syflje");
            return (Criteria) this;
        }

        public Criteria andSyfljeLessThan(Double value) {
            addCriterion("syflje <", value, "syflje");
            return (Criteria) this;
        }

        public Criteria andSyfljeLessThanOrEqualTo(Double value) {
            addCriterion("syflje <=", value, "syflje");
            return (Criteria) this;
        }

        public Criteria andSyfljeIn(List<Double> values) {
            addCriterion("syflje in", values, "syflje");
            return (Criteria) this;
        }

        public Criteria andSyfljeNotIn(List<Double> values) {
            addCriterion("syflje not in", values, "syflje");
            return (Criteria) this;
        }

        public Criteria andSyfljeBetween(Double value1, Double value2) {
            addCriterion("syflje between", value1, value2, "syflje");
            return (Criteria) this;
        }

        public Criteria andSyfljeNotBetween(Double value1, Double value2) {
            addCriterion("syflje not between", value1, value2, "syflje");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzIsNull() {
            addCriterion("cdbltjjz is null");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzIsNotNull() {
            addCriterion("cdbltjjz is not null");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzEqualTo(Double value) {
            addCriterion("cdbltjjz =", value, "cdbltjjz");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzNotEqualTo(Double value) {
            addCriterion("cdbltjjz <>", value, "cdbltjjz");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzGreaterThan(Double value) {
            addCriterion("cdbltjjz >", value, "cdbltjjz");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzGreaterThanOrEqualTo(Double value) {
            addCriterion("cdbltjjz >=", value, "cdbltjjz");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzLessThan(Double value) {
            addCriterion("cdbltjjz <", value, "cdbltjjz");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzLessThanOrEqualTo(Double value) {
            addCriterion("cdbltjjz <=", value, "cdbltjjz");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzIn(List<Double> values) {
            addCriterion("cdbltjjz in", values, "cdbltjjz");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzNotIn(List<Double> values) {
            addCriterion("cdbltjjz not in", values, "cdbltjjz");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzBetween(Double value1, Double value2) {
            addCriterion("cdbltjjz between", value1, value2, "cdbltjjz");
            return (Criteria) this;
        }

        public Criteria andCdbltjjzNotBetween(Double value1, Double value2) {
            addCriterion("cdbltjjz not between", value1, value2, "cdbltjjz");
            return (Criteria) this;
        }

        public Criteria andCdbljeIsNull() {
            addCriterion("cdblje is null");
            return (Criteria) this;
        }

        public Criteria andCdbljeIsNotNull() {
            addCriterion("cdblje is not null");
            return (Criteria) this;
        }

        public Criteria andCdbljeEqualTo(Double value) {
            addCriterion("cdblje =", value, "cdblje");
            return (Criteria) this;
        }

        public Criteria andCdbljeNotEqualTo(Double value) {
            addCriterion("cdblje <>", value, "cdblje");
            return (Criteria) this;
        }

        public Criteria andCdbljeGreaterThan(Double value) {
            addCriterion("cdblje >", value, "cdblje");
            return (Criteria) this;
        }

        public Criteria andCdbljeGreaterThanOrEqualTo(Double value) {
            addCriterion("cdblje >=", value, "cdblje");
            return (Criteria) this;
        }

        public Criteria andCdbljeLessThan(Double value) {
            addCriterion("cdblje <", value, "cdblje");
            return (Criteria) this;
        }

        public Criteria andCdbljeLessThanOrEqualTo(Double value) {
            addCriterion("cdblje <=", value, "cdblje");
            return (Criteria) this;
        }

        public Criteria andCdbljeIn(List<Double> values) {
            addCriterion("cdblje in", values, "cdblje");
            return (Criteria) this;
        }

        public Criteria andCdbljeNotIn(List<Double> values) {
            addCriterion("cdblje not in", values, "cdblje");
            return (Criteria) this;
        }

        public Criteria andCdbljeBetween(Double value1, Double value2) {
            addCriterion("cdblje between", value1, value2, "cdblje");
            return (Criteria) this;
        }

        public Criteria andCdbljeNotBetween(Double value1, Double value2) {
            addCriterion("cdblje not between", value1, value2, "cdblje");
            return (Criteria) this;
        }

        public Criteria andXxstjjzIsNull() {
            addCriterion("xxstjjz is null");
            return (Criteria) this;
        }

        public Criteria andXxstjjzIsNotNull() {
            addCriterion("xxstjjz is not null");
            return (Criteria) this;
        }

        public Criteria andXxstjjzEqualTo(Double value) {
            addCriterion("xxstjjz =", value, "xxstjjz");
            return (Criteria) this;
        }

        public Criteria andXxstjjzNotEqualTo(Double value) {
            addCriterion("xxstjjz <>", value, "xxstjjz");
            return (Criteria) this;
        }

        public Criteria andXxstjjzGreaterThan(Double value) {
            addCriterion("xxstjjz >", value, "xxstjjz");
            return (Criteria) this;
        }

        public Criteria andXxstjjzGreaterThanOrEqualTo(Double value) {
            addCriterion("xxstjjz >=", value, "xxstjjz");
            return (Criteria) this;
        }

        public Criteria andXxstjjzLessThan(Double value) {
            addCriterion("xxstjjz <", value, "xxstjjz");
            return (Criteria) this;
        }

        public Criteria andXxstjjzLessThanOrEqualTo(Double value) {
            addCriterion("xxstjjz <=", value, "xxstjjz");
            return (Criteria) this;
        }

        public Criteria andXxstjjzIn(List<Double> values) {
            addCriterion("xxstjjz in", values, "xxstjjz");
            return (Criteria) this;
        }

        public Criteria andXxstjjzNotIn(List<Double> values) {
            addCriterion("xxstjjz not in", values, "xxstjjz");
            return (Criteria) this;
        }

        public Criteria andXxstjjzBetween(Double value1, Double value2) {
            addCriterion("xxstjjz between", value1, value2, "xxstjjz");
            return (Criteria) this;
        }

        public Criteria andXxstjjzNotBetween(Double value1, Double value2) {
            addCriterion("xxstjjz not between", value1, value2, "xxstjjz");
            return (Criteria) this;
        }

        public Criteria andXsjeIsNull() {
            addCriterion("xsje is null");
            return (Criteria) this;
        }

        public Criteria andXsjeIsNotNull() {
            addCriterion("xsje is not null");
            return (Criteria) this;
        }

        public Criteria andXsjeEqualTo(Double value) {
            addCriterion("xsje =", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeNotEqualTo(Double value) {
            addCriterion("xsje <>", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeGreaterThan(Double value) {
            addCriterion("xsje >", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeGreaterThanOrEqualTo(Double value) {
            addCriterion("xsje >=", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeLessThan(Double value) {
            addCriterion("xsje <", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeLessThanOrEqualTo(Double value) {
            addCriterion("xsje <=", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeIn(List<Double> values) {
            addCriterion("xsje in", values, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeNotIn(List<Double> values) {
            addCriterion("xsje not in", values, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeBetween(Double value1, Double value2) {
            addCriterion("xsje between", value1, value2, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeNotBetween(Double value1, Double value2) {
            addCriterion("xsje not between", value1, value2, "xsje");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzIsNull() {
            addCriterion("bzcbgjtjjz is null");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzIsNotNull() {
            addCriterion("bzcbgjtjjz is not null");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzEqualTo(Double value) {
            addCriterion("bzcbgjtjjz =", value, "bzcbgjtjjz");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzNotEqualTo(Double value) {
            addCriterion("bzcbgjtjjz <>", value, "bzcbgjtjjz");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzGreaterThan(Double value) {
            addCriterion("bzcbgjtjjz >", value, "bzcbgjtjjz");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzGreaterThanOrEqualTo(Double value) {
            addCriterion("bzcbgjtjjz >=", value, "bzcbgjtjjz");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzLessThan(Double value) {
            addCriterion("bzcbgjtjjz <", value, "bzcbgjtjjz");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzLessThanOrEqualTo(Double value) {
            addCriterion("bzcbgjtjjz <=", value, "bzcbgjtjjz");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzIn(List<Double> values) {
            addCriterion("bzcbgjtjjz in", values, "bzcbgjtjjz");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzNotIn(List<Double> values) {
            addCriterion("bzcbgjtjjz not in", values, "bzcbgjtjjz");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzBetween(Double value1, Double value2) {
            addCriterion("bzcbgjtjjz between", value1, value2, "bzcbgjtjjz");
            return (Criteria) this;
        }

        public Criteria andBzcbgjtjjzNotBetween(Double value1, Double value2) {
            addCriterion("bzcbgjtjjz not between", value1, value2, "bzcbgjtjjz");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeIsNull() {
            addCriterion("bzcbgjje is null");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeIsNotNull() {
            addCriterion("bzcbgjje is not null");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeEqualTo(Double value) {
            addCriterion("bzcbgjje =", value, "bzcbgjje");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeNotEqualTo(Double value) {
            addCriterion("bzcbgjje <>", value, "bzcbgjje");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeGreaterThan(Double value) {
            addCriterion("bzcbgjje >", value, "bzcbgjje");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeGreaterThanOrEqualTo(Double value) {
            addCriterion("bzcbgjje >=", value, "bzcbgjje");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeLessThan(Double value) {
            addCriterion("bzcbgjje <", value, "bzcbgjje");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeLessThanOrEqualTo(Double value) {
            addCriterion("bzcbgjje <=", value, "bzcbgjje");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeIn(List<Double> values) {
            addCriterion("bzcbgjje in", values, "bzcbgjje");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeNotIn(List<Double> values) {
            addCriterion("bzcbgjje not in", values, "bzcbgjje");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeBetween(Double value1, Double value2) {
            addCriterion("bzcbgjje between", value1, value2, "bzcbgjje");
            return (Criteria) this;
        }

        public Criteria andBzcbgjjeNotBetween(Double value1, Double value2) {
            addCriterion("bzcbgjje not between", value1, value2, "bzcbgjje");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzIsNull() {
            addCriterion("jsjtjjz is null");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzIsNotNull() {
            addCriterion("jsjtjjz is not null");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzEqualTo(Double value) {
            addCriterion("jsjtjjz =", value, "jsjtjjz");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzNotEqualTo(Double value) {
            addCriterion("jsjtjjz <>", value, "jsjtjjz");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzGreaterThan(Double value) {
            addCriterion("jsjtjjz >", value, "jsjtjjz");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzGreaterThanOrEqualTo(Double value) {
            addCriterion("jsjtjjz >=", value, "jsjtjjz");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzLessThan(Double value) {
            addCriterion("jsjtjjz <", value, "jsjtjjz");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzLessThanOrEqualTo(Double value) {
            addCriterion("jsjtjjz <=", value, "jsjtjjz");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzIn(List<Double> values) {
            addCriterion("jsjtjjz in", values, "jsjtjjz");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzNotIn(List<Double> values) {
            addCriterion("jsjtjjz not in", values, "jsjtjjz");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzBetween(Double value1, Double value2) {
            addCriterion("jsjtjjz between", value1, value2, "jsjtjjz");
            return (Criteria) this;
        }

        public Criteria andJsjtjjzNotBetween(Double value1, Double value2) {
            addCriterion("jsjtjjz not between", value1, value2, "jsjtjjz");
            return (Criteria) this;
        }

        public Criteria andJsjjeIsNull() {
            addCriterion("jsjje is null");
            return (Criteria) this;
        }

        public Criteria andJsjjeIsNotNull() {
            addCriterion("jsjje is not null");
            return (Criteria) this;
        }

        public Criteria andJsjjeEqualTo(Double value) {
            addCriterion("jsjje =", value, "jsjje");
            return (Criteria) this;
        }

        public Criteria andJsjjeNotEqualTo(Double value) {
            addCriterion("jsjje <>", value, "jsjje");
            return (Criteria) this;
        }

        public Criteria andJsjjeGreaterThan(Double value) {
            addCriterion("jsjje >", value, "jsjje");
            return (Criteria) this;
        }

        public Criteria andJsjjeGreaterThanOrEqualTo(Double value) {
            addCriterion("jsjje >=", value, "jsjje");
            return (Criteria) this;
        }

        public Criteria andJsjjeLessThan(Double value) {
            addCriterion("jsjje <", value, "jsjje");
            return (Criteria) this;
        }

        public Criteria andJsjjeLessThanOrEqualTo(Double value) {
            addCriterion("jsjje <=", value, "jsjje");
            return (Criteria) this;
        }

        public Criteria andJsjjeIn(List<Double> values) {
            addCriterion("jsjje in", values, "jsjje");
            return (Criteria) this;
        }

        public Criteria andJsjjeNotIn(List<Double> values) {
            addCriterion("jsjje not in", values, "jsjje");
            return (Criteria) this;
        }

        public Criteria andJsjjeBetween(Double value1, Double value2) {
            addCriterion("jsjje between", value1, value2, "jsjje");
            return (Criteria) this;
        }

        public Criteria andJsjjeNotBetween(Double value1, Double value2) {
            addCriterion("jsjje not between", value1, value2, "jsjje");
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

        public Criteria andCpmcIsNull() {
            addCriterion("cpmc is null");
            return (Criteria) this;
        }

        public Criteria andCpmcIsNotNull() {
            addCriterion("cpmc is not null");
            return (Criteria) this;
        }

        public Criteria andCpmcEqualTo(String value) {
            addCriterion("cpmc =", value, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcNotEqualTo(String value) {
            addCriterion("cpmc <>", value, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcGreaterThan(String value) {
            addCriterion("cpmc >", value, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcGreaterThanOrEqualTo(String value) {
            addCriterion("cpmc >=", value, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcLessThan(String value) {
            addCriterion("cpmc <", value, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcLessThanOrEqualTo(String value) {
            addCriterion("cpmc <=", value, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcLike(String value) {
            addCriterion("cpmc like", value, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcNotLike(String value) {
            addCriterion("cpmc not like", value, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcIn(List<String> values) {
            addCriterion("cpmc in", values, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcNotIn(List<String> values) {
            addCriterion("cpmc not in", values, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcBetween(String value1, String value2) {
            addCriterion("cpmc between", value1, value2, "cpmc");
            return (Criteria) this;
        }

        public Criteria andCpmcNotBetween(String value1, String value2) {
            addCriterion("cpmc not between", value1, value2, "cpmc");
            return (Criteria) this;
        }

        public Criteria andPsphIsNull() {
            addCriterion("psph is null");
            return (Criteria) this;
        }

        public Criteria andPsphIsNotNull() {
            addCriterion("psph is not null");
            return (Criteria) this;
        }

        public Criteria andPsphEqualTo(String value) {
            addCriterion("psph =", value, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphNotEqualTo(String value) {
            addCriterion("psph <>", value, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphGreaterThan(String value) {
            addCriterion("psph >", value, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphGreaterThanOrEqualTo(String value) {
            addCriterion("psph >=", value, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphLessThan(String value) {
            addCriterion("psph <", value, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphLessThanOrEqualTo(String value) {
            addCriterion("psph <=", value, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphLike(String value) {
            addCriterion("psph like", value, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphNotLike(String value) {
            addCriterion("psph not like", value, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphIn(List<String> values) {
            addCriterion("psph in", values, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphNotIn(List<String> values) {
            addCriterion("psph not in", values, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphBetween(String value1, String value2) {
            addCriterion("psph between", value1, value2, "psph");
            return (Criteria) this;
        }

        public Criteria andPsphNotBetween(String value1, String value2) {
            addCriterion("psph not between", value1, value2, "psph");
            return (Criteria) this;
        }

        public Criteria andGgxhIsNull() {
            addCriterion("ggxh is null");
            return (Criteria) this;
        }

        public Criteria andGgxhIsNotNull() {
            addCriterion("ggxh is not null");
            return (Criteria) this;
        }

        public Criteria andGgxhEqualTo(String value) {
            addCriterion("ggxh =", value, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhNotEqualTo(String value) {
            addCriterion("ggxh <>", value, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhGreaterThan(String value) {
            addCriterion("ggxh >", value, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhGreaterThanOrEqualTo(String value) {
            addCriterion("ggxh >=", value, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhLessThan(String value) {
            addCriterion("ggxh <", value, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhLessThanOrEqualTo(String value) {
            addCriterion("ggxh <=", value, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhLike(String value) {
            addCriterion("ggxh like", value, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhNotLike(String value) {
            addCriterion("ggxh not like", value, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhIn(List<String> values) {
            addCriterion("ggxh in", values, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhNotIn(List<String> values) {
            addCriterion("ggxh not in", values, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhBetween(String value1, String value2) {
            addCriterion("ggxh between", value1, value2, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgxhNotBetween(String value1, String value2) {
            addCriterion("ggxh not between", value1, value2, "ggxh");
            return (Criteria) this;
        }

        public Criteria andGgrqIsNull() {
            addCriterion("ggrq is null");
            return (Criteria) this;
        }

        public Criteria andGgrqIsNotNull() {
            addCriterion("ggrq is not null");
            return (Criteria) this;
        }

        public Criteria andGgrqEqualTo(String value) {
            addCriterion("ggrq =", value, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqNotEqualTo(String value) {
            addCriterion("ggrq <>", value, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqGreaterThan(String value) {
            addCriterion("ggrq >", value, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqGreaterThanOrEqualTo(String value) {
            addCriterion("ggrq >=", value, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqLessThan(String value) {
            addCriterion("ggrq <", value, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqLessThanOrEqualTo(String value) {
            addCriterion("ggrq <=", value, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqLike(String value) {
            addCriterion("ggrq like", value, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqNotLike(String value) {
            addCriterion("ggrq not like", value, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqIn(List<String> values) {
            addCriterion("ggrq in", values, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqNotIn(List<String> values) {
            addCriterion("ggrq not in", values, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqBetween(String value1, String value2) {
            addCriterion("ggrq between", value1, value2, "ggrq");
            return (Criteria) this;
        }

        public Criteria andGgrqNotBetween(String value1, String value2) {
            addCriterion("ggrq not between", value1, value2, "ggrq");
            return (Criteria) this;
        }

        public Criteria andXspzlxIsNull() {
            addCriterion("xspzlx is null");
            return (Criteria) this;
        }

        public Criteria andXspzlxIsNotNull() {
            addCriterion("xspzlx is not null");
            return (Criteria) this;
        }

        public Criteria andXspzlxEqualTo(String value) {
            addCriterion("xspzlx =", value, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxNotEqualTo(String value) {
            addCriterion("xspzlx <>", value, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxGreaterThan(String value) {
            addCriterion("xspzlx >", value, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxGreaterThanOrEqualTo(String value) {
            addCriterion("xspzlx >=", value, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxLessThan(String value) {
            addCriterion("xspzlx <", value, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxLessThanOrEqualTo(String value) {
            addCriterion("xspzlx <=", value, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxLike(String value) {
            addCriterion("xspzlx like", value, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxNotLike(String value) {
            addCriterion("xspzlx not like", value, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxIn(List<String> values) {
            addCriterion("xspzlx in", values, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxNotIn(List<String> values) {
            addCriterion("xspzlx not in", values, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxBetween(String value1, String value2) {
            addCriterion("xspzlx between", value1, value2, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andXspzlxNotBetween(String value1, String value2) {
            addCriterion("xspzlx not between", value1, value2, "xspzlx");
            return (Criteria) this;
        }

        public Criteria andCjnyIsNull() {
            addCriterion("cjny is null");
            return (Criteria) this;
        }

        public Criteria andCjnyIsNotNull() {
            addCriterion("cjny is not null");
            return (Criteria) this;
        }

        public Criteria andCjnyEqualTo(String value) {
            addCriterion("cjny =", value, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyNotEqualTo(String value) {
            addCriterion("cjny <>", value, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyGreaterThan(String value) {
            addCriterion("cjny >", value, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyGreaterThanOrEqualTo(String value) {
            addCriterion("cjny >=", value, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyLessThan(String value) {
            addCriterion("cjny <", value, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyLessThanOrEqualTo(String value) {
            addCriterion("cjny <=", value, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyLike(String value) {
            addCriterion("cjny like", value, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyNotLike(String value) {
            addCriterion("cjny not like", value, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyIn(List<String> values) {
            addCriterion("cjny in", values, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyNotIn(List<String> values) {
            addCriterion("cjny not in", values, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyBetween(String value1, String value2) {
            addCriterion("cjny between", value1, value2, "cjny");
            return (Criteria) this;
        }

        public Criteria andCjnyNotBetween(String value1, String value2) {
            addCriterion("cjny not between", value1, value2, "cjny");
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