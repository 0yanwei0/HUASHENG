package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.List;

public class HsGdtcTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HsGdtcTbExample() {
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

        public Criteria andGdIsNull() {
            addCriterion("gd is null");
            return (Criteria) this;
        }

        public Criteria andGdIsNotNull() {
            addCriterion("gd is not null");
            return (Criteria) this;
        }

        public Criteria andGdEqualTo(String value) {
            addCriterion("gd =", value, "gd");
            return (Criteria) this;
        }

        public Criteria andGdNotEqualTo(String value) {
            addCriterion("gd <>", value, "gd");
            return (Criteria) this;
        }

        public Criteria andGdGreaterThan(String value) {
            addCriterion("gd >", value, "gd");
            return (Criteria) this;
        }

        public Criteria andGdGreaterThanOrEqualTo(String value) {
            addCriterion("gd >=", value, "gd");
            return (Criteria) this;
        }

        public Criteria andGdLessThan(String value) {
            addCriterion("gd <", value, "gd");
            return (Criteria) this;
        }

        public Criteria andGdLessThanOrEqualTo(String value) {
            addCriterion("gd <=", value, "gd");
            return (Criteria) this;
        }

        public Criteria andGdLike(String value) {
            addCriterion("gd like", value, "gd");
            return (Criteria) this;
        }

        public Criteria andGdNotLike(String value) {
            addCriterion("gd not like", value, "gd");
            return (Criteria) this;
        }

        public Criteria andGdIn(List<String> values) {
            addCriterion("gd in", values, "gd");
            return (Criteria) this;
        }

        public Criteria andGdNotIn(List<String> values) {
            addCriterion("gd not in", values, "gd");
            return (Criteria) this;
        }

        public Criteria andGdBetween(String value1, String value2) {
            addCriterion("gd between", value1, value2, "gd");
            return (Criteria) this;
        }

        public Criteria andGdNotBetween(String value1, String value2) {
            addCriterion("gd not between", value1, value2, "gd");
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

        public Criteria andTcxsIsNull() {
            addCriterion("tcxs is null");
            return (Criteria) this;
        }

        public Criteria andTcxsIsNotNull() {
            addCriterion("tcxs is not null");
            return (Criteria) this;
        }

        public Criteria andTcxsEqualTo(Double value) {
            addCriterion("tcxs =", value, "tcxs");
            return (Criteria) this;
        }

        public Criteria andTcxsNotEqualTo(Double value) {
            addCriterion("tcxs <>", value, "tcxs");
            return (Criteria) this;
        }

        public Criteria andTcxsGreaterThan(Double value) {
            addCriterion("tcxs >", value, "tcxs");
            return (Criteria) this;
        }

        public Criteria andTcxsGreaterThanOrEqualTo(Double value) {
            addCriterion("tcxs >=", value, "tcxs");
            return (Criteria) this;
        }

        public Criteria andTcxsLessThan(Double value) {
            addCriterion("tcxs <", value, "tcxs");
            return (Criteria) this;
        }

        public Criteria andTcxsLessThanOrEqualTo(Double value) {
            addCriterion("tcxs <=", value, "tcxs");
            return (Criteria) this;
        }

        public Criteria andTcxsIn(List<Double> values) {
            addCriterion("tcxs in", values, "tcxs");
            return (Criteria) this;
        }

        public Criteria andTcxsNotIn(List<Double> values) {
            addCriterion("tcxs not in", values, "tcxs");
            return (Criteria) this;
        }

        public Criteria andTcxsBetween(Double value1, Double value2) {
            addCriterion("tcxs between", value1, value2, "tcxs");
            return (Criteria) this;
        }

        public Criteria andTcxsNotBetween(Double value1, Double value2) {
            addCriterion("tcxs not between", value1, value2, "tcxs");
            return (Criteria) this;
        }

        public Criteria andXstcIsNull() {
            addCriterion("xstc is null");
            return (Criteria) this;
        }

        public Criteria andXstcIsNotNull() {
            addCriterion("xstc is not null");
            return (Criteria) this;
        }

        public Criteria andXstcEqualTo(Double value) {
            addCriterion("xstc =", value, "xstc");
            return (Criteria) this;
        }

        public Criteria andXstcNotEqualTo(Double value) {
            addCriterion("xstc <>", value, "xstc");
            return (Criteria) this;
        }

        public Criteria andXstcGreaterThan(Double value) {
            addCriterion("xstc >", value, "xstc");
            return (Criteria) this;
        }

        public Criteria andXstcGreaterThanOrEqualTo(Double value) {
            addCriterion("xstc >=", value, "xstc");
            return (Criteria) this;
        }

        public Criteria andXstcLessThan(Double value) {
            addCriterion("xstc <", value, "xstc");
            return (Criteria) this;
        }

        public Criteria andXstcLessThanOrEqualTo(Double value) {
            addCriterion("xstc <=", value, "xstc");
            return (Criteria) this;
        }

        public Criteria andXstcIn(List<Double> values) {
            addCriterion("xstc in", values, "xstc");
            return (Criteria) this;
        }

        public Criteria andXstcNotIn(List<Double> values) {
            addCriterion("xstc not in", values, "xstc");
            return (Criteria) this;
        }

        public Criteria andXstcBetween(Double value1, Double value2) {
            addCriterion("xstc between", value1, value2, "xstc");
            return (Criteria) this;
        }

        public Criteria andXstcNotBetween(Double value1, Double value2) {
            addCriterion("xstc not between", value1, value2, "xstc");
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