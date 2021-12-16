package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.List;

public class HsYygdtcTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HsYygdtcTbExample() {
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

        public Criteria andJxsIsNull() {
            addCriterion("jxs is null");
            return (Criteria) this;
        }

        public Criteria andJxsIsNotNull() {
            addCriterion("jxs is not null");
            return (Criteria) this;
        }

        public Criteria andJxsEqualTo(String value) {
            addCriterion("jxs =", value, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsNotEqualTo(String value) {
            addCriterion("jxs <>", value, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsGreaterThan(String value) {
            addCriterion("jxs >", value, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsGreaterThanOrEqualTo(String value) {
            addCriterion("jxs >=", value, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsLessThan(String value) {
            addCriterion("jxs <", value, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsLessThanOrEqualTo(String value) {
            addCriterion("jxs <=", value, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsLike(String value) {
            addCriterion("jxs like", value, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsNotLike(String value) {
            addCriterion("jxs not like", value, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsIn(List<String> values) {
            addCriterion("jxs in", values, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsNotIn(List<String> values) {
            addCriterion("jxs not in", values, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsBetween(String value1, String value2) {
            addCriterion("jxs between", value1, value2, "jxs");
            return (Criteria) this;
        }

        public Criteria andJxsNotBetween(String value1, String value2) {
            addCriterion("jxs not between", value1, value2, "jxs");
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

        public Criteria andMdsIsNull() {
            addCriterion("mds is null");
            return (Criteria) this;
        }

        public Criteria andMdsIsNotNull() {
            addCriterion("mds is not null");
            return (Criteria) this;
        }

        public Criteria andMdsEqualTo(Integer value) {
            addCriterion("mds =", value, "mds");
            return (Criteria) this;
        }

        public Criteria andMdsNotEqualTo(Integer value) {
            addCriterion("mds <>", value, "mds");
            return (Criteria) this;
        }

        public Criteria andMdsGreaterThan(Integer value) {
            addCriterion("mds >", value, "mds");
            return (Criteria) this;
        }

        public Criteria andMdsGreaterThanOrEqualTo(Integer value) {
            addCriterion("mds >=", value, "mds");
            return (Criteria) this;
        }

        public Criteria andMdsLessThan(Integer value) {
            addCriterion("mds <", value, "mds");
            return (Criteria) this;
        }

        public Criteria andMdsLessThanOrEqualTo(Integer value) {
            addCriterion("mds <=", value, "mds");
            return (Criteria) this;
        }

        public Criteria andMdsIn(List<Integer> values) {
            addCriterion("mds in", values, "mds");
            return (Criteria) this;
        }

        public Criteria andMdsNotIn(List<Integer> values) {
            addCriterion("mds not in", values, "mds");
            return (Criteria) this;
        }

        public Criteria andMdsBetween(Integer value1, Integer value2) {
            addCriterion("mds between", value1, value2, "mds");
            return (Criteria) this;
        }

        public Criteria andMdsNotBetween(Integer value1, Integer value2) {
            addCriterion("mds not between", value1, value2, "mds");
            return (Criteria) this;
        }

        public Criteria andP01IsNull() {
            addCriterion("p01 is null");
            return (Criteria) this;
        }

        public Criteria andP01IsNotNull() {
            addCriterion("p01 is not null");
            return (Criteria) this;
        }

        public Criteria andP01EqualTo(String value) {
            addCriterion("p01 =", value, "p01");
            return (Criteria) this;
        }

        public Criteria andP01NotEqualTo(String value) {
            addCriterion("p01 <>", value, "p01");
            return (Criteria) this;
        }

        public Criteria andP01GreaterThan(String value) {
            addCriterion("p01 >", value, "p01");
            return (Criteria) this;
        }

        public Criteria andP01GreaterThanOrEqualTo(String value) {
            addCriterion("p01 >=", value, "p01");
            return (Criteria) this;
        }

        public Criteria andP01LessThan(String value) {
            addCriterion("p01 <", value, "p01");
            return (Criteria) this;
        }

        public Criteria andP01LessThanOrEqualTo(String value) {
            addCriterion("p01 <=", value, "p01");
            return (Criteria) this;
        }

        public Criteria andP01Like(String value) {
            addCriterion("p01 like", value, "p01");
            return (Criteria) this;
        }

        public Criteria andP01NotLike(String value) {
            addCriterion("p01 not like", value, "p01");
            return (Criteria) this;
        }

        public Criteria andP01In(List<String> values) {
            addCriterion("p01 in", values, "p01");
            return (Criteria) this;
        }

        public Criteria andP01NotIn(List<String> values) {
            addCriterion("p01 not in", values, "p01");
            return (Criteria) this;
        }

        public Criteria andP01Between(String value1, String value2) {
            addCriterion("p01 between", value1, value2, "p01");
            return (Criteria) this;
        }

        public Criteria andP01NotBetween(String value1, String value2) {
            addCriterion("p01 not between", value1, value2, "p01");
            return (Criteria) this;
        }

        public Criteria andP02IsNull() {
            addCriterion("p02 is null");
            return (Criteria) this;
        }

        public Criteria andP02IsNotNull() {
            addCriterion("p02 is not null");
            return (Criteria) this;
        }

        public Criteria andP02EqualTo(String value) {
            addCriterion("p02 =", value, "p02");
            return (Criteria) this;
        }

        public Criteria andP02NotEqualTo(String value) {
            addCriterion("p02 <>", value, "p02");
            return (Criteria) this;
        }

        public Criteria andP02GreaterThan(String value) {
            addCriterion("p02 >", value, "p02");
            return (Criteria) this;
        }

        public Criteria andP02GreaterThanOrEqualTo(String value) {
            addCriterion("p02 >=", value, "p02");
            return (Criteria) this;
        }

        public Criteria andP02LessThan(String value) {
            addCriterion("p02 <", value, "p02");
            return (Criteria) this;
        }

        public Criteria andP02LessThanOrEqualTo(String value) {
            addCriterion("p02 <=", value, "p02");
            return (Criteria) this;
        }

        public Criteria andP02Like(String value) {
            addCriterion("p02 like", value, "p02");
            return (Criteria) this;
        }

        public Criteria andP02NotLike(String value) {
            addCriterion("p02 not like", value, "p02");
            return (Criteria) this;
        }

        public Criteria andP02In(List<String> values) {
            addCriterion("p02 in", values, "p02");
            return (Criteria) this;
        }

        public Criteria andP02NotIn(List<String> values) {
            addCriterion("p02 not in", values, "p02");
            return (Criteria) this;
        }

        public Criteria andP02Between(String value1, String value2) {
            addCriterion("p02 between", value1, value2, "p02");
            return (Criteria) this;
        }

        public Criteria andP02NotBetween(String value1, String value2) {
            addCriterion("p02 not between", value1, value2, "p02");
            return (Criteria) this;
        }

        public Criteria andP03IsNull() {
            addCriterion("p03 is null");
            return (Criteria) this;
        }

        public Criteria andP03IsNotNull() {
            addCriterion("p03 is not null");
            return (Criteria) this;
        }

        public Criteria andP03EqualTo(String value) {
            addCriterion("p03 =", value, "p03");
            return (Criteria) this;
        }

        public Criteria andP03NotEqualTo(String value) {
            addCriterion("p03 <>", value, "p03");
            return (Criteria) this;
        }

        public Criteria andP03GreaterThan(String value) {
            addCriterion("p03 >", value, "p03");
            return (Criteria) this;
        }

        public Criteria andP03GreaterThanOrEqualTo(String value) {
            addCriterion("p03 >=", value, "p03");
            return (Criteria) this;
        }

        public Criteria andP03LessThan(String value) {
            addCriterion("p03 <", value, "p03");
            return (Criteria) this;
        }

        public Criteria andP03LessThanOrEqualTo(String value) {
            addCriterion("p03 <=", value, "p03");
            return (Criteria) this;
        }

        public Criteria andP03Like(String value) {
            addCriterion("p03 like", value, "p03");
            return (Criteria) this;
        }

        public Criteria andP03NotLike(String value) {
            addCriterion("p03 not like", value, "p03");
            return (Criteria) this;
        }

        public Criteria andP03In(List<String> values) {
            addCriterion("p03 in", values, "p03");
            return (Criteria) this;
        }

        public Criteria andP03NotIn(List<String> values) {
            addCriterion("p03 not in", values, "p03");
            return (Criteria) this;
        }

        public Criteria andP03Between(String value1, String value2) {
            addCriterion("p03 between", value1, value2, "p03");
            return (Criteria) this;
        }

        public Criteria andP03NotBetween(String value1, String value2) {
            addCriterion("p03 not between", value1, value2, "p03");
            return (Criteria) this;
        }

        public Criteria andXdjeIsNull() {
            addCriterion("xdje is null");
            return (Criteria) this;
        }

        public Criteria andXdjeIsNotNull() {
            addCriterion("xdje is not null");
            return (Criteria) this;
        }

        public Criteria andXdjeEqualTo(Double value) {
            addCriterion("xdje =", value, "xdje");
            return (Criteria) this;
        }

        public Criteria andXdjeNotEqualTo(Double value) {
            addCriterion("xdje <>", value, "xdje");
            return (Criteria) this;
        }

        public Criteria andXdjeGreaterThan(Double value) {
            addCriterion("xdje >", value, "xdje");
            return (Criteria) this;
        }

        public Criteria andXdjeGreaterThanOrEqualTo(Double value) {
            addCriterion("xdje >=", value, "xdje");
            return (Criteria) this;
        }

        public Criteria andXdjeLessThan(Double value) {
            addCriterion("xdje <", value, "xdje");
            return (Criteria) this;
        }

        public Criteria andXdjeLessThanOrEqualTo(Double value) {
            addCriterion("xdje <=", value, "xdje");
            return (Criteria) this;
        }

        public Criteria andXdjeIn(List<Double> values) {
            addCriterion("xdje in", values, "xdje");
            return (Criteria) this;
        }

        public Criteria andXdjeNotIn(List<Double> values) {
            addCriterion("xdje not in", values, "xdje");
            return (Criteria) this;
        }

        public Criteria andXdjeBetween(Double value1, Double value2) {
            addCriterion("xdje between", value1, value2, "xdje");
            return (Criteria) this;
        }

        public Criteria andXdjeNotBetween(Double value1, Double value2) {
            addCriterion("xdje not between", value1, value2, "xdje");
            return (Criteria) this;
        }

        public Criteria andYskjeIsNull() {
            addCriterion("yskje is null");
            return (Criteria) this;
        }

        public Criteria andYskjeIsNotNull() {
            addCriterion("yskje is not null");
            return (Criteria) this;
        }

        public Criteria andYskjeEqualTo(Double value) {
            addCriterion("yskje =", value, "yskje");
            return (Criteria) this;
        }

        public Criteria andYskjeNotEqualTo(Double value) {
            addCriterion("yskje <>", value, "yskje");
            return (Criteria) this;
        }

        public Criteria andYskjeGreaterThan(Double value) {
            addCriterion("yskje >", value, "yskje");
            return (Criteria) this;
        }

        public Criteria andYskjeGreaterThanOrEqualTo(Double value) {
            addCriterion("yskje >=", value, "yskje");
            return (Criteria) this;
        }

        public Criteria andYskjeLessThan(Double value) {
            addCriterion("yskje <", value, "yskje");
            return (Criteria) this;
        }

        public Criteria andYskjeLessThanOrEqualTo(Double value) {
            addCriterion("yskje <=", value, "yskje");
            return (Criteria) this;
        }

        public Criteria andYskjeIn(List<Double> values) {
            addCriterion("yskje in", values, "yskje");
            return (Criteria) this;
        }

        public Criteria andYskjeNotIn(List<Double> values) {
            addCriterion("yskje not in", values, "yskje");
            return (Criteria) this;
        }

        public Criteria andYskjeBetween(Double value1, Double value2) {
            addCriterion("yskje between", value1, value2, "yskje");
            return (Criteria) this;
        }

        public Criteria andYskjeNotBetween(Double value1, Double value2) {
            addCriterion("yskje not between", value1, value2, "yskje");
            return (Criteria) this;
        }

        public Criteria andXsskjeIsNull() {
            addCriterion("xsskje is null");
            return (Criteria) this;
        }

        public Criteria andXsskjeIsNotNull() {
            addCriterion("xsskje is not null");
            return (Criteria) this;
        }

        public Criteria andXsskjeEqualTo(Double value) {
            addCriterion("xsskje =", value, "xsskje");
            return (Criteria) this;
        }

        public Criteria andXsskjeNotEqualTo(Double value) {
            addCriterion("xsskje <>", value, "xsskje");
            return (Criteria) this;
        }

        public Criteria andXsskjeGreaterThan(Double value) {
            addCriterion("xsskje >", value, "xsskje");
            return (Criteria) this;
        }

        public Criteria andXsskjeGreaterThanOrEqualTo(Double value) {
            addCriterion("xsskje >=", value, "xsskje");
            return (Criteria) this;
        }

        public Criteria andXsskjeLessThan(Double value) {
            addCriterion("xsskje <", value, "xsskje");
            return (Criteria) this;
        }

        public Criteria andXsskjeLessThanOrEqualTo(Double value) {
            addCriterion("xsskje <=", value, "xsskje");
            return (Criteria) this;
        }

        public Criteria andXsskjeIn(List<Double> values) {
            addCriterion("xsskje in", values, "xsskje");
            return (Criteria) this;
        }

        public Criteria andXsskjeNotIn(List<Double> values) {
            addCriterion("xsskje not in", values, "xsskje");
            return (Criteria) this;
        }

        public Criteria andXsskjeBetween(Double value1, Double value2) {
            addCriterion("xsskje between", value1, value2, "xsskje");
            return (Criteria) this;
        }

        public Criteria andXsskjeNotBetween(Double value1, Double value2) {
            addCriterion("xsskje not between", value1, value2, "xsskje");
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

        public Criteria andDjjxsIsNull() {
            addCriterion("djjxs is null");
            return (Criteria) this;
        }

        public Criteria andDjjxsIsNotNull() {
            addCriterion("djjxs is not null");
            return (Criteria) this;
        }

        public Criteria andDjjxsEqualTo(Double value) {
            addCriterion("djjxs =", value, "djjxs");
            return (Criteria) this;
        }

        public Criteria andDjjxsNotEqualTo(Double value) {
            addCriterion("djjxs <>", value, "djjxs");
            return (Criteria) this;
        }

        public Criteria andDjjxsGreaterThan(Double value) {
            addCriterion("djjxs >", value, "djjxs");
            return (Criteria) this;
        }

        public Criteria andDjjxsGreaterThanOrEqualTo(Double value) {
            addCriterion("djjxs >=", value, "djjxs");
            return (Criteria) this;
        }

        public Criteria andDjjxsLessThan(Double value) {
            addCriterion("djjxs <", value, "djjxs");
            return (Criteria) this;
        }

        public Criteria andDjjxsLessThanOrEqualTo(Double value) {
            addCriterion("djjxs <=", value, "djjxs");
            return (Criteria) this;
        }

        public Criteria andDjjxsIn(List<Double> values) {
            addCriterion("djjxs in", values, "djjxs");
            return (Criteria) this;
        }

        public Criteria andDjjxsNotIn(List<Double> values) {
            addCriterion("djjxs not in", values, "djjxs");
            return (Criteria) this;
        }

        public Criteria andDjjxsBetween(Double value1, Double value2) {
            addCriterion("djjxs between", value1, value2, "djjxs");
            return (Criteria) this;
        }

        public Criteria andDjjxsNotBetween(Double value1, Double value2) {
            addCriterion("djjxs not between", value1, value2, "djjxs");
            return (Criteria) this;
        }

        public Criteria andDjqyjlIsNull() {
            addCriterion("djqyjl is null");
            return (Criteria) this;
        }

        public Criteria andDjqyjlIsNotNull() {
            addCriterion("djqyjl is not null");
            return (Criteria) this;
        }

        public Criteria andDjqyjlEqualTo(Double value) {
            addCriterion("djqyjl =", value, "djqyjl");
            return (Criteria) this;
        }

        public Criteria andDjqyjlNotEqualTo(Double value) {
            addCriterion("djqyjl <>", value, "djqyjl");
            return (Criteria) this;
        }

        public Criteria andDjqyjlGreaterThan(Double value) {
            addCriterion("djqyjl >", value, "djqyjl");
            return (Criteria) this;
        }

        public Criteria andDjqyjlGreaterThanOrEqualTo(Double value) {
            addCriterion("djqyjl >=", value, "djqyjl");
            return (Criteria) this;
        }

        public Criteria andDjqyjlLessThan(Double value) {
            addCriterion("djqyjl <", value, "djqyjl");
            return (Criteria) this;
        }

        public Criteria andDjqyjlLessThanOrEqualTo(Double value) {
            addCriterion("djqyjl <=", value, "djqyjl");
            return (Criteria) this;
        }

        public Criteria andDjqyjlIn(List<Double> values) {
            addCriterion("djqyjl in", values, "djqyjl");
            return (Criteria) this;
        }

        public Criteria andDjqyjlNotIn(List<Double> values) {
            addCriterion("djqyjl not in", values, "djqyjl");
            return (Criteria) this;
        }

        public Criteria andDjqyjlBetween(Double value1, Double value2) {
            addCriterion("djqyjl between", value1, value2, "djqyjl");
            return (Criteria) this;
        }

        public Criteria andDjqyjlNotBetween(Double value1, Double value2) {
            addCriterion("djqyjl not between", value1, value2, "djqyjl");
            return (Criteria) this;
        }

        public Criteria andDdtcxsIsNull() {
            addCriterion("ddtcxs is null");
            return (Criteria) this;
        }

        public Criteria andDdtcxsIsNotNull() {
            addCriterion("ddtcxs is not null");
            return (Criteria) this;
        }

        public Criteria andDdtcxsEqualTo(Double value) {
            addCriterion("ddtcxs =", value, "ddtcxs");
            return (Criteria) this;
        }

        public Criteria andDdtcxsNotEqualTo(Double value) {
            addCriterion("ddtcxs <>", value, "ddtcxs");
            return (Criteria) this;
        }

        public Criteria andDdtcxsGreaterThan(Double value) {
            addCriterion("ddtcxs >", value, "ddtcxs");
            return (Criteria) this;
        }

        public Criteria andDdtcxsGreaterThanOrEqualTo(Double value) {
            addCriterion("ddtcxs >=", value, "ddtcxs");
            return (Criteria) this;
        }

        public Criteria andDdtcxsLessThan(Double value) {
            addCriterion("ddtcxs <", value, "ddtcxs");
            return (Criteria) this;
        }

        public Criteria andDdtcxsLessThanOrEqualTo(Double value) {
            addCriterion("ddtcxs <=", value, "ddtcxs");
            return (Criteria) this;
        }

        public Criteria andDdtcxsIn(List<Double> values) {
            addCriterion("ddtcxs in", values, "ddtcxs");
            return (Criteria) this;
        }

        public Criteria andDdtcxsNotIn(List<Double> values) {
            addCriterion("ddtcxs not in", values, "ddtcxs");
            return (Criteria) this;
        }

        public Criteria andDdtcxsBetween(Double value1, Double value2) {
            addCriterion("ddtcxs between", value1, value2, "ddtcxs");
            return (Criteria) this;
        }

        public Criteria andDdtcxsNotBetween(Double value1, Double value2) {
            addCriterion("ddtcxs not between", value1, value2, "ddtcxs");
            return (Criteria) this;
        }

        public Criteria andDdxstcIsNull() {
            addCriterion("ddxstc is null");
            return (Criteria) this;
        }

        public Criteria andDdxstcIsNotNull() {
            addCriterion("ddxstc is not null");
            return (Criteria) this;
        }

        public Criteria andDdxstcEqualTo(Double value) {
            addCriterion("ddxstc =", value, "ddxstc");
            return (Criteria) this;
        }

        public Criteria andDdxstcNotEqualTo(Double value) {
            addCriterion("ddxstc <>", value, "ddxstc");
            return (Criteria) this;
        }

        public Criteria andDdxstcGreaterThan(Double value) {
            addCriterion("ddxstc >", value, "ddxstc");
            return (Criteria) this;
        }

        public Criteria andDdxstcGreaterThanOrEqualTo(Double value) {
            addCriterion("ddxstc >=", value, "ddxstc");
            return (Criteria) this;
        }

        public Criteria andDdxstcLessThan(Double value) {
            addCriterion("ddxstc <", value, "ddxstc");
            return (Criteria) this;
        }

        public Criteria andDdxstcLessThanOrEqualTo(Double value) {
            addCriterion("ddxstc <=", value, "ddxstc");
            return (Criteria) this;
        }

        public Criteria andDdxstcIn(List<Double> values) {
            addCriterion("ddxstc in", values, "ddxstc");
            return (Criteria) this;
        }

        public Criteria andDdxstcNotIn(List<Double> values) {
            addCriterion("ddxstc not in", values, "ddxstc");
            return (Criteria) this;
        }

        public Criteria andDdxstcBetween(Double value1, Double value2) {
            addCriterion("ddxstc between", value1, value2, "ddxstc");
            return (Criteria) this;
        }

        public Criteria andDdxstcNotBetween(Double value1, Double value2) {
            addCriterion("ddxstc not between", value1, value2, "ddxstc");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsIsNull() {
            addCriterion("ddewtcxs is null");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsIsNotNull() {
            addCriterion("ddewtcxs is not null");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsEqualTo(Double value) {
            addCriterion("ddewtcxs =", value, "ddewtcxs");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsNotEqualTo(Double value) {
            addCriterion("ddewtcxs <>", value, "ddewtcxs");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsGreaterThan(Double value) {
            addCriterion("ddewtcxs >", value, "ddewtcxs");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsGreaterThanOrEqualTo(Double value) {
            addCriterion("ddewtcxs >=", value, "ddewtcxs");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsLessThan(Double value) {
            addCriterion("ddewtcxs <", value, "ddewtcxs");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsLessThanOrEqualTo(Double value) {
            addCriterion("ddewtcxs <=", value, "ddewtcxs");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsIn(List<Double> values) {
            addCriterion("ddewtcxs in", values, "ddewtcxs");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsNotIn(List<Double> values) {
            addCriterion("ddewtcxs not in", values, "ddewtcxs");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsBetween(Double value1, Double value2) {
            addCriterion("ddewtcxs between", value1, value2, "ddewtcxs");
            return (Criteria) this;
        }

        public Criteria andDdewtcxsNotBetween(Double value1, Double value2) {
            addCriterion("ddewtcxs not between", value1, value2, "ddewtcxs");
            return (Criteria) this;
        }

        public Criteria andDdewxstcIsNull() {
            addCriterion("ddewxstc is null");
            return (Criteria) this;
        }

        public Criteria andDdewxstcIsNotNull() {
            addCriterion("ddewxstc is not null");
            return (Criteria) this;
        }

        public Criteria andDdewxstcEqualTo(Double value) {
            addCriterion("ddewxstc =", value, "ddewxstc");
            return (Criteria) this;
        }

        public Criteria andDdewxstcNotEqualTo(Double value) {
            addCriterion("ddewxstc <>", value, "ddewxstc");
            return (Criteria) this;
        }

        public Criteria andDdewxstcGreaterThan(Double value) {
            addCriterion("ddewxstc >", value, "ddewxstc");
            return (Criteria) this;
        }

        public Criteria andDdewxstcGreaterThanOrEqualTo(Double value) {
            addCriterion("ddewxstc >=", value, "ddewxstc");
            return (Criteria) this;
        }

        public Criteria andDdewxstcLessThan(Double value) {
            addCriterion("ddewxstc <", value, "ddewxstc");
            return (Criteria) this;
        }

        public Criteria andDdewxstcLessThanOrEqualTo(Double value) {
            addCriterion("ddewxstc <=", value, "ddewxstc");
            return (Criteria) this;
        }

        public Criteria andDdewxstcIn(List<Double> values) {
            addCriterion("ddewxstc in", values, "ddewxstc");
            return (Criteria) this;
        }

        public Criteria andDdewxstcNotIn(List<Double> values) {
            addCriterion("ddewxstc not in", values, "ddewxstc");
            return (Criteria) this;
        }

        public Criteria andDdewxstcBetween(Double value1, Double value2) {
            addCriterion("ddewxstc between", value1, value2, "ddewxstc");
            return (Criteria) this;
        }

        public Criteria andDdewxstcNotBetween(Double value1, Double value2) {
            addCriterion("ddewxstc not between", value1, value2, "ddewxstc");
            return (Criteria) this;
        }

        public Criteria andYyjlIsNull() {
            addCriterion("yyjl is null");
            return (Criteria) this;
        }

        public Criteria andYyjlIsNotNull() {
            addCriterion("yyjl is not null");
            return (Criteria) this;
        }

        public Criteria andYyjlEqualTo(String value) {
            addCriterion("yyjl =", value, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlNotEqualTo(String value) {
            addCriterion("yyjl <>", value, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlGreaterThan(String value) {
            addCriterion("yyjl >", value, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlGreaterThanOrEqualTo(String value) {
            addCriterion("yyjl >=", value, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlLessThan(String value) {
            addCriterion("yyjl <", value, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlLessThanOrEqualTo(String value) {
            addCriterion("yyjl <=", value, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlLike(String value) {
            addCriterion("yyjl like", value, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlNotLike(String value) {
            addCriterion("yyjl not like", value, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlIn(List<String> values) {
            addCriterion("yyjl in", values, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlNotIn(List<String> values) {
            addCriterion("yyjl not in", values, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlBetween(String value1, String value2) {
            addCriterion("yyjl between", value1, value2, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYyjlNotBetween(String value1, String value2) {
            addCriterion("yyjl not between", value1, value2, "yyjl");
            return (Criteria) this;
        }

        public Criteria andYxjIsNull() {
            addCriterion("yxj is null");
            return (Criteria) this;
        }

        public Criteria andYxjIsNotNull() {
            addCriterion("yxj is not null");
            return (Criteria) this;
        }

        public Criteria andYxjEqualTo(Double value) {
            addCriterion("yxj =", value, "yxj");
            return (Criteria) this;
        }

        public Criteria andYxjNotEqualTo(Double value) {
            addCriterion("yxj <>", value, "yxj");
            return (Criteria) this;
        }

        public Criteria andYxjGreaterThan(Double value) {
            addCriterion("yxj >", value, "yxj");
            return (Criteria) this;
        }

        public Criteria andYxjGreaterThanOrEqualTo(Double value) {
            addCriterion("yxj >=", value, "yxj");
            return (Criteria) this;
        }

        public Criteria andYxjLessThan(Double value) {
            addCriterion("yxj <", value, "yxj");
            return (Criteria) this;
        }

        public Criteria andYxjLessThanOrEqualTo(Double value) {
            addCriterion("yxj <=", value, "yxj");
            return (Criteria) this;
        }

        public Criteria andYxjIn(List<Double> values) {
            addCriterion("yxj in", values, "yxj");
            return (Criteria) this;
        }

        public Criteria andYxjNotIn(List<Double> values) {
            addCriterion("yxj not in", values, "yxj");
            return (Criteria) this;
        }

        public Criteria andYxjBetween(Double value1, Double value2) {
            addCriterion("yxj between", value1, value2, "yxj");
            return (Criteria) this;
        }

        public Criteria andYxjNotBetween(Double value1, Double value2) {
            addCriterion("yxj not between", value1, value2, "yxj");
            return (Criteria) this;
        }

        public Criteria andJyyskIsNull() {
            addCriterion("jyysk is null");
            return (Criteria) this;
        }

        public Criteria andJyyskIsNotNull() {
            addCriterion("jyysk is not null");
            return (Criteria) this;
        }

        public Criteria andJyyskEqualTo(Double value) {
            addCriterion("jyysk =", value, "jyysk");
            return (Criteria) this;
        }

        public Criteria andJyyskNotEqualTo(Double value) {
            addCriterion("jyysk <>", value, "jyysk");
            return (Criteria) this;
        }

        public Criteria andJyyskGreaterThan(Double value) {
            addCriterion("jyysk >", value, "jyysk");
            return (Criteria) this;
        }

        public Criteria andJyyskGreaterThanOrEqualTo(Double value) {
            addCriterion("jyysk >=", value, "jyysk");
            return (Criteria) this;
        }

        public Criteria andJyyskLessThan(Double value) {
            addCriterion("jyysk <", value, "jyysk");
            return (Criteria) this;
        }

        public Criteria andJyyskLessThanOrEqualTo(Double value) {
            addCriterion("jyysk <=", value, "jyysk");
            return (Criteria) this;
        }

        public Criteria andJyyskIn(List<Double> values) {
            addCriterion("jyysk in", values, "jyysk");
            return (Criteria) this;
        }

        public Criteria andJyyskNotIn(List<Double> values) {
            addCriterion("jyysk not in", values, "jyysk");
            return (Criteria) this;
        }

        public Criteria andJyyskBetween(Double value1, Double value2) {
            addCriterion("jyysk between", value1, value2, "jyysk");
            return (Criteria) this;
        }

        public Criteria andJyyskNotBetween(Double value1, Double value2) {
            addCriterion("jyysk not between", value1, value2, "jyysk");
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