package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.List;

public class HsXsmlfxTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HsXsmlfxTbExample() {
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

        public Criteria andCpxlIsNull() {
            addCriterion("cpxl is null");
            return (Criteria) this;
        }

        public Criteria andCpxlIsNotNull() {
            addCriterion("cpxl is not null");
            return (Criteria) this;
        }

        public Criteria andCpxlEqualTo(String value) {
            addCriterion("cpxl =", value, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlNotEqualTo(String value) {
            addCriterion("cpxl <>", value, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlGreaterThan(String value) {
            addCriterion("cpxl >", value, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlGreaterThanOrEqualTo(String value) {
            addCriterion("cpxl >=", value, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlLessThan(String value) {
            addCriterion("cpxl <", value, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlLessThanOrEqualTo(String value) {
            addCriterion("cpxl <=", value, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlLike(String value) {
            addCriterion("cpxl like", value, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlNotLike(String value) {
            addCriterion("cpxl not like", value, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlIn(List<String> values) {
            addCriterion("cpxl in", values, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlNotIn(List<String> values) {
            addCriterion("cpxl not in", values, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlBetween(String value1, String value2) {
            addCriterion("cpxl between", value1, value2, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCpxlNotBetween(String value1, String value2) {
            addCriterion("cpxl not between", value1, value2, "cpxl");
            return (Criteria) this;
        }

        public Criteria andCkjhIsNull() {
            addCriterion("ckjh is null");
            return (Criteria) this;
        }

        public Criteria andCkjhIsNotNull() {
            addCriterion("ckjh is not null");
            return (Criteria) this;
        }

        public Criteria andCkjhEqualTo(String value) {
            addCriterion("ckjh =", value, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhNotEqualTo(String value) {
            addCriterion("ckjh <>", value, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhGreaterThan(String value) {
            addCriterion("ckjh >", value, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhGreaterThanOrEqualTo(String value) {
            addCriterion("ckjh >=", value, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhLessThan(String value) {
            addCriterion("ckjh <", value, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhLessThanOrEqualTo(String value) {
            addCriterion("ckjh <=", value, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhLike(String value) {
            addCriterion("ckjh like", value, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhNotLike(String value) {
            addCriterion("ckjh not like", value, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhIn(List<String> values) {
            addCriterion("ckjh in", values, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhNotIn(List<String> values) {
            addCriterion("ckjh not in", values, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhBetween(String value1, String value2) {
            addCriterion("ckjh between", value1, value2, "ckjh");
            return (Criteria) this;
        }

        public Criteria andCkjhNotBetween(String value1, String value2) {
            addCriterion("ckjh not between", value1, value2, "ckjh");
            return (Criteria) this;
        }

        public Criteria andWxjhxmIsNull() {
            addCriterion("wxjhxm is null");
            return (Criteria) this;
        }

        public Criteria andWxjhxmIsNotNull() {
            addCriterion("wxjhxm is not null");
            return (Criteria) this;
        }

        public Criteria andWxjhxmEqualTo(String value) {
            addCriterion("wxjhxm =", value, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmNotEqualTo(String value) {
            addCriterion("wxjhxm <>", value, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmGreaterThan(String value) {
            addCriterion("wxjhxm >", value, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmGreaterThanOrEqualTo(String value) {
            addCriterion("wxjhxm >=", value, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmLessThan(String value) {
            addCriterion("wxjhxm <", value, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmLessThanOrEqualTo(String value) {
            addCriterion("wxjhxm <=", value, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmLike(String value) {
            addCriterion("wxjhxm like", value, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmNotLike(String value) {
            addCriterion("wxjhxm not like", value, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmIn(List<String> values) {
            addCriterion("wxjhxm in", values, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmNotIn(List<String> values) {
            addCriterion("wxjhxm not in", values, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmBetween(String value1, String value2) {
            addCriterion("wxjhxm between", value1, value2, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andWxjhxmNotBetween(String value1, String value2) {
            addCriterion("wxjhxm not between", value1, value2, "wxjhxm");
            return (Criteria) this;
        }

        public Criteria andJhlxIsNull() {
            addCriterion("jhlx is null");
            return (Criteria) this;
        }

        public Criteria andJhlxIsNotNull() {
            addCriterion("jhlx is not null");
            return (Criteria) this;
        }

        public Criteria andJhlxEqualTo(String value) {
            addCriterion("jhlx =", value, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxNotEqualTo(String value) {
            addCriterion("jhlx <>", value, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxGreaterThan(String value) {
            addCriterion("jhlx >", value, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxGreaterThanOrEqualTo(String value) {
            addCriterion("jhlx >=", value, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxLessThan(String value) {
            addCriterion("jhlx <", value, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxLessThanOrEqualTo(String value) {
            addCriterion("jhlx <=", value, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxLike(String value) {
            addCriterion("jhlx like", value, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxNotLike(String value) {
            addCriterion("jhlx not like", value, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxIn(List<String> values) {
            addCriterion("jhlx in", values, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxNotIn(List<String> values) {
            addCriterion("jhlx not in", values, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxBetween(String value1, String value2) {
            addCriterion("jhlx between", value1, value2, "jhlx");
            return (Criteria) this;
        }

        public Criteria andJhlxNotBetween(String value1, String value2) {
            addCriterion("jhlx not between", value1, value2, "jhlx");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqIsNull() {
            addCriterion("sjhwydrq is null");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqIsNotNull() {
            addCriterion("sjhwydrq is not null");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqEqualTo(String value) {
            addCriterion("sjhwydrq =", value, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqNotEqualTo(String value) {
            addCriterion("sjhwydrq <>", value, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqGreaterThan(String value) {
            addCriterion("sjhwydrq >", value, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqGreaterThanOrEqualTo(String value) {
            addCriterion("sjhwydrq >=", value, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqLessThan(String value) {
            addCriterion("sjhwydrq <", value, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqLessThanOrEqualTo(String value) {
            addCriterion("sjhwydrq <=", value, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqLike(String value) {
            addCriterion("sjhwydrq like", value, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqNotLike(String value) {
            addCriterion("sjhwydrq not like", value, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqIn(List<String> values) {
            addCriterion("sjhwydrq in", values, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqNotIn(List<String> values) {
            addCriterion("sjhwydrq not in", values, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqBetween(String value1, String value2) {
            addCriterion("sjhwydrq between", value1, value2, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andSjhwydrqNotBetween(String value1, String value2) {
            addCriterion("sjhwydrq not between", value1, value2, "sjhwydrq");
            return (Criteria) this;
        }

        public Criteria andHwydztIsNull() {
            addCriterion("hwydzt is null");
            return (Criteria) this;
        }

        public Criteria andHwydztIsNotNull() {
            addCriterion("hwydzt is not null");
            return (Criteria) this;
        }

        public Criteria andHwydztEqualTo(String value) {
            addCriterion("hwydzt =", value, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztNotEqualTo(String value) {
            addCriterion("hwydzt <>", value, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztGreaterThan(String value) {
            addCriterion("hwydzt >", value, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztGreaterThanOrEqualTo(String value) {
            addCriterion("hwydzt >=", value, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztLessThan(String value) {
            addCriterion("hwydzt <", value, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztLessThanOrEqualTo(String value) {
            addCriterion("hwydzt <=", value, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztLike(String value) {
            addCriterion("hwydzt like", value, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztNotLike(String value) {
            addCriterion("hwydzt not like", value, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztIn(List<String> values) {
            addCriterion("hwydzt in", values, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztNotIn(List<String> values) {
            addCriterion("hwydzt not in", values, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztBetween(String value1, String value2) {
            addCriterion("hwydzt between", value1, value2, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andHwydztNotBetween(String value1, String value2) {
            addCriterion("hwydzt not between", value1, value2, "hwydzt");
            return (Criteria) this;
        }

        public Criteria andWlIsNull() {
            addCriterion("wl is null");
            return (Criteria) this;
        }

        public Criteria andWlIsNotNull() {
            addCriterion("wl is not null");
            return (Criteria) this;
        }

        public Criteria andWlEqualTo(String value) {
            addCriterion("wl =", value, "wl");
            return (Criteria) this;
        }

        public Criteria andWlNotEqualTo(String value) {
            addCriterion("wl <>", value, "wl");
            return (Criteria) this;
        }

        public Criteria andWlGreaterThan(String value) {
            addCriterion("wl >", value, "wl");
            return (Criteria) this;
        }

        public Criteria andWlGreaterThanOrEqualTo(String value) {
            addCriterion("wl >=", value, "wl");
            return (Criteria) this;
        }

        public Criteria andWlLessThan(String value) {
            addCriterion("wl <", value, "wl");
            return (Criteria) this;
        }

        public Criteria andWlLessThanOrEqualTo(String value) {
            addCriterion("wl <=", value, "wl");
            return (Criteria) this;
        }

        public Criteria andWlLike(String value) {
            addCriterion("wl like", value, "wl");
            return (Criteria) this;
        }

        public Criteria andWlNotLike(String value) {
            addCriterion("wl not like", value, "wl");
            return (Criteria) this;
        }

        public Criteria andWlIn(List<String> values) {
            addCriterion("wl in", values, "wl");
            return (Criteria) this;
        }

        public Criteria andWlNotIn(List<String> values) {
            addCriterion("wl not in", values, "wl");
            return (Criteria) this;
        }

        public Criteria andWlBetween(String value1, String value2) {
            addCriterion("wl between", value1, value2, "wl");
            return (Criteria) this;
        }

        public Criteria andWlNotBetween(String value1, String value2) {
            addCriterion("wl not between", value1, value2, "wl");
            return (Criteria) this;
        }

        public Criteria andXmmsIsNull() {
            addCriterion("xmms is null");
            return (Criteria) this;
        }

        public Criteria andXmmsIsNotNull() {
            addCriterion("xmms is not null");
            return (Criteria) this;
        }

        public Criteria andXmmsEqualTo(String value) {
            addCriterion("xmms =", value, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsNotEqualTo(String value) {
            addCriterion("xmms <>", value, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsGreaterThan(String value) {
            addCriterion("xmms >", value, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsGreaterThanOrEqualTo(String value) {
            addCriterion("xmms >=", value, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsLessThan(String value) {
            addCriterion("xmms <", value, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsLessThanOrEqualTo(String value) {
            addCriterion("xmms <=", value, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsLike(String value) {
            addCriterion("xmms like", value, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsNotLike(String value) {
            addCriterion("xmms not like", value, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsIn(List<String> values) {
            addCriterion("xmms in", values, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsNotIn(List<String> values) {
            addCriterion("xmms not in", values, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsBetween(String value1, String value2) {
            addCriterion("xmms between", value1, value2, "xmms");
            return (Criteria) this;
        }

        public Criteria andXmmsNotBetween(String value1, String value2) {
            addCriterion("xmms not between", value1, value2, "xmms");
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

        public Criteria andJhslIsNull() {
            addCriterion("jhsl is null");
            return (Criteria) this;
        }

        public Criteria andJhslIsNotNull() {
            addCriterion("jhsl is not null");
            return (Criteria) this;
        }

        public Criteria andJhslEqualTo(Double value) {
            addCriterion("jhsl =", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslNotEqualTo(Double value) {
            addCriterion("jhsl <>", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslGreaterThan(Double value) {
            addCriterion("jhsl >", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslGreaterThanOrEqualTo(Double value) {
            addCriterion("jhsl >=", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslLessThan(Double value) {
            addCriterion("jhsl <", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslLessThanOrEqualTo(Double value) {
            addCriterion("jhsl <=", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslIn(List<Double> values) {
            addCriterion("jhsl in", values, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslNotIn(List<Double> values) {
            addCriterion("jhsl not in", values, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslBetween(Double value1, Double value2) {
            addCriterion("jhsl between", value1, value2, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslNotBetween(Double value1, Double value2) {
            addCriterion("jhsl not between", value1, value2, "jhsl");
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

        public Criteria andHwydlxIsNull() {
            addCriterion("hwydlx is null");
            return (Criteria) this;
        }

        public Criteria andHwydlxIsNotNull() {
            addCriterion("hwydlx is not null");
            return (Criteria) this;
        }

        public Criteria andHwydlxEqualTo(String value) {
            addCriterion("hwydlx =", value, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxNotEqualTo(String value) {
            addCriterion("hwydlx <>", value, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxGreaterThan(String value) {
            addCriterion("hwydlx >", value, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxGreaterThanOrEqualTo(String value) {
            addCriterion("hwydlx >=", value, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxLessThan(String value) {
            addCriterion("hwydlx <", value, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxLessThanOrEqualTo(String value) {
            addCriterion("hwydlx <=", value, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxLike(String value) {
            addCriterion("hwydlx like", value, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxNotLike(String value) {
            addCriterion("hwydlx not like", value, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxIn(List<String> values) {
            addCriterion("hwydlx in", values, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxNotIn(List<String> values) {
            addCriterion("hwydlx not in", values, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxBetween(String value1, String value2) {
            addCriterion("hwydlx between", value1, value2, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andHwydlxNotBetween(String value1, String value2) {
            addCriterion("hwydlx not between", value1, value2, "hwydlx");
            return (Criteria) this;
        }

        public Criteria andCkpzIsNull() {
            addCriterion("ckpz is null");
            return (Criteria) this;
        }

        public Criteria andCkpzIsNotNull() {
            addCriterion("ckpz is not null");
            return (Criteria) this;
        }

        public Criteria andCkpzEqualTo(String value) {
            addCriterion("ckpz =", value, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzNotEqualTo(String value) {
            addCriterion("ckpz <>", value, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzGreaterThan(String value) {
            addCriterion("ckpz >", value, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzGreaterThanOrEqualTo(String value) {
            addCriterion("ckpz >=", value, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzLessThan(String value) {
            addCriterion("ckpz <", value, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzLessThanOrEqualTo(String value) {
            addCriterion("ckpz <=", value, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzLike(String value) {
            addCriterion("ckpz like", value, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzNotLike(String value) {
            addCriterion("ckpz not like", value, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzIn(List<String> values) {
            addCriterion("ckpz in", values, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzNotIn(List<String> values) {
            addCriterion("ckpz not in", values, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzBetween(String value1, String value2) {
            addCriterion("ckpz between", value1, value2, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkpzNotBetween(String value1, String value2) {
            addCriterion("ckpz not between", value1, value2, "ckpz");
            return (Criteria) this;
        }

        public Criteria andCkxmIsNull() {
            addCriterion("ckxm is null");
            return (Criteria) this;
        }

        public Criteria andCkxmIsNotNull() {
            addCriterion("ckxm is not null");
            return (Criteria) this;
        }

        public Criteria andCkxmEqualTo(String value) {
            addCriterion("ckxm =", value, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmNotEqualTo(String value) {
            addCriterion("ckxm <>", value, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmGreaterThan(String value) {
            addCriterion("ckxm >", value, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmGreaterThanOrEqualTo(String value) {
            addCriterion("ckxm >=", value, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmLessThan(String value) {
            addCriterion("ckxm <", value, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmLessThanOrEqualTo(String value) {
            addCriterion("ckxm <=", value, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmLike(String value) {
            addCriterion("ckxm like", value, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmNotLike(String value) {
            addCriterion("ckxm not like", value, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmIn(List<String> values) {
            addCriterion("ckxm in", values, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmNotIn(List<String> values) {
            addCriterion("ckxm not in", values, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmBetween(String value1, String value2) {
            addCriterion("ckxm between", value1, value2, "ckxm");
            return (Criteria) this;
        }

        public Criteria andCkxmNotBetween(String value1, String value2) {
            addCriterion("ckxm not between", value1, value2, "ckxm");
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

        public Criteria andXxsjeIsNull() {
            addCriterion("xxsje is null");
            return (Criteria) this;
        }

        public Criteria andXxsjeIsNotNull() {
            addCriterion("xxsje is not null");
            return (Criteria) this;
        }

        public Criteria andXxsjeEqualTo(Double value) {
            addCriterion("xxsje =", value, "xxsje");
            return (Criteria) this;
        }

        public Criteria andXxsjeNotEqualTo(Double value) {
            addCriterion("xxsje <>", value, "xxsje");
            return (Criteria) this;
        }

        public Criteria andXxsjeGreaterThan(Double value) {
            addCriterion("xxsje >", value, "xxsje");
            return (Criteria) this;
        }

        public Criteria andXxsjeGreaterThanOrEqualTo(Double value) {
            addCriterion("xxsje >=", value, "xxsje");
            return (Criteria) this;
        }

        public Criteria andXxsjeLessThan(Double value) {
            addCriterion("xxsje <", value, "xxsje");
            return (Criteria) this;
        }

        public Criteria andXxsjeLessThanOrEqualTo(Double value) {
            addCriterion("xxsje <=", value, "xxsje");
            return (Criteria) this;
        }

        public Criteria andXxsjeIn(List<Double> values) {
            addCriterion("xxsje in", values, "xxsje");
            return (Criteria) this;
        }

        public Criteria andXxsjeNotIn(List<Double> values) {
            addCriterion("xxsje not in", values, "xxsje");
            return (Criteria) this;
        }

        public Criteria andXxsjeBetween(Double value1, Double value2) {
            addCriterion("xxsje between", value1, value2, "xxsje");
            return (Criteria) this;
        }

        public Criteria andXxsjeNotBetween(Double value1, Double value2) {
            addCriterion("xxsje not between", value1, value2, "xxsje");
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