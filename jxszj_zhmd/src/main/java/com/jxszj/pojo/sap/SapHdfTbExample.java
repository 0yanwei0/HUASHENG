package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.List;

public class SapHdfTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SapHdfTbExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPzbhIsNull() {
            addCriterion("pzbh is null");
            return (Criteria) this;
        }

        public Criteria andPzbhIsNotNull() {
            addCriterion("pzbh is not null");
            return (Criteria) this;
        }

        public Criteria andPzbhEqualTo(String value) {
            addCriterion("pzbh =", value, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhNotEqualTo(String value) {
            addCriterion("pzbh <>", value, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhGreaterThan(String value) {
            addCriterion("pzbh >", value, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhGreaterThanOrEqualTo(String value) {
            addCriterion("pzbh >=", value, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhLessThan(String value) {
            addCriterion("pzbh <", value, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhLessThanOrEqualTo(String value) {
            addCriterion("pzbh <=", value, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhLike(String value) {
            addCriterion("pzbh like", value, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhNotLike(String value) {
            addCriterion("pzbh not like", value, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhIn(List<String> values) {
            addCriterion("pzbh in", values, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhNotIn(List<String> values) {
            addCriterion("pzbh not in", values, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhBetween(String value1, String value2) {
            addCriterion("pzbh between", value1, value2, "pzbh");
            return (Criteria) this;
        }

        public Criteria andPzbhNotBetween(String value1, String value2) {
            addCriterion("pzbh not between", value1, value2, "pzbh");
            return (Criteria) this;
        }

        public Criteria andDjbhIsNull() {
            addCriterion("djbh is null");
            return (Criteria) this;
        }

        public Criteria andDjbhIsNotNull() {
            addCriterion("djbh is not null");
            return (Criteria) this;
        }

        public Criteria andDjbhEqualTo(String value) {
            addCriterion("djbh =", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhNotEqualTo(String value) {
            addCriterion("djbh <>", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhGreaterThan(String value) {
            addCriterion("djbh >", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhGreaterThanOrEqualTo(String value) {
            addCriterion("djbh >=", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhLessThan(String value) {
            addCriterion("djbh <", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhLessThanOrEqualTo(String value) {
            addCriterion("djbh <=", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhLike(String value) {
            addCriterion("djbh like", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhNotLike(String value) {
            addCriterion("djbh not like", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhIn(List<String> values) {
            addCriterion("djbh in", values, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhNotIn(List<String> values) {
            addCriterion("djbh not in", values, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhBetween(String value1, String value2) {
            addCriterion("djbh between", value1, value2, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhNotBetween(String value1, String value2) {
            addCriterion("djbh not between", value1, value2, "djbh");
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

        public Criteria andZkrqIsNull() {
            addCriterion("zkrq is null");
            return (Criteria) this;
        }

        public Criteria andZkrqIsNotNull() {
            addCriterion("zkrq is not null");
            return (Criteria) this;
        }

        public Criteria andZkrqEqualTo(String value) {
            addCriterion("zkrq =", value, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqNotEqualTo(String value) {
            addCriterion("zkrq <>", value, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqGreaterThan(String value) {
            addCriterion("zkrq >", value, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqGreaterThanOrEqualTo(String value) {
            addCriterion("zkrq >=", value, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqLessThan(String value) {
            addCriterion("zkrq <", value, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqLessThanOrEqualTo(String value) {
            addCriterion("zkrq <=", value, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqLike(String value) {
            addCriterion("zkrq like", value, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqNotLike(String value) {
            addCriterion("zkrq not like", value, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqIn(List<String> values) {
            addCriterion("zkrq in", values, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqNotIn(List<String> values) {
            addCriterion("zkrq not in", values, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqBetween(String value1, String value2) {
            addCriterion("zkrq between", value1, value2, "zkrq");
            return (Criteria) this;
        }

        public Criteria andZkrqNotBetween(String value1, String value2) {
            addCriterion("zkrq not between", value1, value2, "zkrq");
            return (Criteria) this;
        }

        public Criteria andSkbzIsNull() {
            addCriterion("skbz is null");
            return (Criteria) this;
        }

        public Criteria andSkbzIsNotNull() {
            addCriterion("skbz is not null");
            return (Criteria) this;
        }

        public Criteria andSkbzEqualTo(String value) {
            addCriterion("skbz =", value, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzNotEqualTo(String value) {
            addCriterion("skbz <>", value, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzGreaterThan(String value) {
            addCriterion("skbz >", value, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzGreaterThanOrEqualTo(String value) {
            addCriterion("skbz >=", value, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzLessThan(String value) {
            addCriterion("skbz <", value, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzLessThanOrEqualTo(String value) {
            addCriterion("skbz <=", value, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzLike(String value) {
            addCriterion("skbz like", value, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzNotLike(String value) {
            addCriterion("skbz not like", value, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzIn(List<String> values) {
            addCriterion("skbz in", values, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzNotIn(List<String> values) {
            addCriterion("skbz not in", values, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzBetween(String value1, String value2) {
            addCriterion("skbz between", value1, value2, "skbz");
            return (Criteria) this;
        }

        public Criteria andSkbzNotBetween(String value1, String value2) {
            addCriterion("skbz not between", value1, value2, "skbz");
            return (Criteria) this;
        }

        public Criteria andHdfIsNull() {
            addCriterion("hdf is null");
            return (Criteria) this;
        }

        public Criteria andHdfIsNotNull() {
            addCriterion("hdf is not null");
            return (Criteria) this;
        }

        public Criteria andHdfEqualTo(String value) {
            addCriterion("hdf =", value, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfNotEqualTo(String value) {
            addCriterion("hdf <>", value, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfGreaterThan(String value) {
            addCriterion("hdf >", value, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfGreaterThanOrEqualTo(String value) {
            addCriterion("hdf >=", value, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfLessThan(String value) {
            addCriterion("hdf <", value, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfLessThanOrEqualTo(String value) {
            addCriterion("hdf <=", value, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfLike(String value) {
            addCriterion("hdf like", value, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfNotLike(String value) {
            addCriterion("hdf not like", value, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfIn(List<String> values) {
            addCriterion("hdf in", values, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfNotIn(List<String> values) {
            addCriterion("hdf not in", values, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfBetween(String value1, String value2) {
            addCriterion("hdf between", value1, value2, "hdf");
            return (Criteria) this;
        }

        public Criteria andHdfNotBetween(String value1, String value2) {
            addCriterion("hdf not between", value1, value2, "hdf");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andCjrIsNull() {
            addCriterion("cjr is null");
            return (Criteria) this;
        }

        public Criteria andCjrIsNotNull() {
            addCriterion("cjr is not null");
            return (Criteria) this;
        }

        public Criteria andCjrEqualTo(String value) {
            addCriterion("cjr =", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotEqualTo(String value) {
            addCriterion("cjr <>", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrGreaterThan(String value) {
            addCriterion("cjr >", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrGreaterThanOrEqualTo(String value) {
            addCriterion("cjr >=", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrLessThan(String value) {
            addCriterion("cjr <", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrLessThanOrEqualTo(String value) {
            addCriterion("cjr <=", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrLike(String value) {
            addCriterion("cjr like", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotLike(String value) {
            addCriterion("cjr not like", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrIn(List<String> values) {
            addCriterion("cjr in", values, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotIn(List<String> values) {
            addCriterion("cjr not in", values, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrBetween(String value1, String value2) {
            addCriterion("cjr between", value1, value2, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotBetween(String value1, String value2) {
            addCriterion("cjr not between", value1, value2, "cjr");
            return (Criteria) this;
        }

        public Criteria andJdybmIsNull() {
            addCriterion("jdybm is null");
            return (Criteria) this;
        }

        public Criteria andJdybmIsNotNull() {
            addCriterion("jdybm is not null");
            return (Criteria) this;
        }

        public Criteria andJdybmEqualTo(String value) {
            addCriterion("jdybm =", value, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmNotEqualTo(String value) {
            addCriterion("jdybm <>", value, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmGreaterThan(String value) {
            addCriterion("jdybm >", value, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmGreaterThanOrEqualTo(String value) {
            addCriterion("jdybm >=", value, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmLessThan(String value) {
            addCriterion("jdybm <", value, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmLessThanOrEqualTo(String value) {
            addCriterion("jdybm <=", value, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmLike(String value) {
            addCriterion("jdybm like", value, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmNotLike(String value) {
            addCriterion("jdybm not like", value, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmIn(List<String> values) {
            addCriterion("jdybm in", values, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmNotIn(List<String> values) {
            addCriterion("jdybm not in", values, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmBetween(String value1, String value2) {
            addCriterion("jdybm between", value1, value2, "jdybm");
            return (Criteria) this;
        }

        public Criteria andJdybmNotBetween(String value1, String value2) {
            addCriterion("jdybm not between", value1, value2, "jdybm");
            return (Criteria) this;
        }

        public Criteria andLrzxIsNull() {
            addCriterion("lrzx is null");
            return (Criteria) this;
        }

        public Criteria andLrzxIsNotNull() {
            addCriterion("lrzx is not null");
            return (Criteria) this;
        }

        public Criteria andLrzxEqualTo(String value) {
            addCriterion("lrzx =", value, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxNotEqualTo(String value) {
            addCriterion("lrzx <>", value, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxGreaterThan(String value) {
            addCriterion("lrzx >", value, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxGreaterThanOrEqualTo(String value) {
            addCriterion("lrzx >=", value, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxLessThan(String value) {
            addCriterion("lrzx <", value, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxLessThanOrEqualTo(String value) {
            addCriterion("lrzx <=", value, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxLike(String value) {
            addCriterion("lrzx like", value, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxNotLike(String value) {
            addCriterion("lrzx not like", value, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxIn(List<String> values) {
            addCriterion("lrzx in", values, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxNotIn(List<String> values) {
            addCriterion("lrzx not in", values, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxBetween(String value1, String value2) {
            addCriterion("lrzx between", value1, value2, "lrzx");
            return (Criteria) this;
        }

        public Criteria andLrzxNotBetween(String value1, String value2) {
            addCriterion("lrzx not between", value1, value2, "lrzx");
            return (Criteria) this;
        }

        public Criteria andSklxIsNull() {
            addCriterion("sklx is null");
            return (Criteria) this;
        }

        public Criteria andSklxIsNotNull() {
            addCriterion("sklx is not null");
            return (Criteria) this;
        }

        public Criteria andSklxEqualTo(String value) {
            addCriterion("sklx =", value, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxNotEqualTo(String value) {
            addCriterion("sklx <>", value, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxGreaterThan(String value) {
            addCriterion("sklx >", value, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxGreaterThanOrEqualTo(String value) {
            addCriterion("sklx >=", value, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxLessThan(String value) {
            addCriterion("sklx <", value, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxLessThanOrEqualTo(String value) {
            addCriterion("sklx <=", value, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxLike(String value) {
            addCriterion("sklx like", value, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxNotLike(String value) {
            addCriterion("sklx not like", value, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxIn(List<String> values) {
            addCriterion("sklx in", values, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxNotIn(List<String> values) {
            addCriterion("sklx not in", values, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxBetween(String value1, String value2) {
            addCriterion("sklx between", value1, value2, "sklx");
            return (Criteria) this;
        }

        public Criteria andSklxNotBetween(String value1, String value2) {
            addCriterion("sklx not between", value1, value2, "sklx");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmIsNull() {
            addCriterion("sapjxsbm is null");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmIsNotNull() {
            addCriterion("sapjxsbm is not null");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmEqualTo(String value) {
            addCriterion("sapjxsbm =", value, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmNotEqualTo(String value) {
            addCriterion("sapjxsbm <>", value, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmGreaterThan(String value) {
            addCriterion("sapjxsbm >", value, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmGreaterThanOrEqualTo(String value) {
            addCriterion("sapjxsbm >=", value, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmLessThan(String value) {
            addCriterion("sapjxsbm <", value, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmLessThanOrEqualTo(String value) {
            addCriterion("sapjxsbm <=", value, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmLike(String value) {
            addCriterion("sapjxsbm like", value, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmNotLike(String value) {
            addCriterion("sapjxsbm not like", value, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmIn(List<String> values) {
            addCriterion("sapjxsbm in", values, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmNotIn(List<String> values) {
            addCriterion("sapjxsbm not in", values, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmBetween(String value1, String value2) {
            addCriterion("sapjxsbm between", value1, value2, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSapjxsbmNotBetween(String value1, String value2) {
            addCriterion("sapjxsbm not between", value1, value2, "sapjxsbm");
            return (Criteria) this;
        }

        public Criteria andSklyIsNull() {
            addCriterion("skly is null");
            return (Criteria) this;
        }

        public Criteria andSklyIsNotNull() {
            addCriterion("skly is not null");
            return (Criteria) this;
        }

        public Criteria andSklyEqualTo(String value) {
            addCriterion("skly =", value, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyNotEqualTo(String value) {
            addCriterion("skly <>", value, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyGreaterThan(String value) {
            addCriterion("skly >", value, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyGreaterThanOrEqualTo(String value) {
            addCriterion("skly >=", value, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyLessThan(String value) {
            addCriterion("skly <", value, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyLessThanOrEqualTo(String value) {
            addCriterion("skly <=", value, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyLike(String value) {
            addCriterion("skly like", value, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyNotLike(String value) {
            addCriterion("skly not like", value, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyIn(List<String> values) {
            addCriterion("skly in", values, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyNotIn(List<String> values) {
            addCriterion("skly not in", values, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyBetween(String value1, String value2) {
            addCriterion("skly between", value1, value2, "skly");
            return (Criteria) this;
        }

        public Criteria andSklyNotBetween(String value1, String value2) {
            addCriterion("skly not between", value1, value2, "skly");
            return (Criteria) this;
        }

        public Criteria andSrkmIsNull() {
            addCriterion("srkm is null");
            return (Criteria) this;
        }

        public Criteria andSrkmIsNotNull() {
            addCriterion("srkm is not null");
            return (Criteria) this;
        }

        public Criteria andSrkmEqualTo(String value) {
            addCriterion("srkm =", value, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmNotEqualTo(String value) {
            addCriterion("srkm <>", value, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmGreaterThan(String value) {
            addCriterion("srkm >", value, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmGreaterThanOrEqualTo(String value) {
            addCriterion("srkm >=", value, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmLessThan(String value) {
            addCriterion("srkm <", value, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmLessThanOrEqualTo(String value) {
            addCriterion("srkm <=", value, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmLike(String value) {
            addCriterion("srkm like", value, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmNotLike(String value) {
            addCriterion("srkm not like", value, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmIn(List<String> values) {
            addCriterion("srkm in", values, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmNotIn(List<String> values) {
            addCriterion("srkm not in", values, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmBetween(String value1, String value2) {
            addCriterion("srkm between", value1, value2, "srkm");
            return (Criteria) this;
        }

        public Criteria andSrkmNotBetween(String value1, String value2) {
            addCriterion("srkm not between", value1, value2, "srkm");
            return (Criteria) this;
        }

        public Criteria andXssjeIsNull() {
            addCriterion("xssje is null");
            return (Criteria) this;
        }

        public Criteria andXssjeIsNotNull() {
            addCriterion("xssje is not null");
            return (Criteria) this;
        }

        public Criteria andXssjeEqualTo(String value) {
            addCriterion("xssje =", value, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeNotEqualTo(String value) {
            addCriterion("xssje <>", value, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeGreaterThan(String value) {
            addCriterion("xssje >", value, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeGreaterThanOrEqualTo(String value) {
            addCriterion("xssje >=", value, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeLessThan(String value) {
            addCriterion("xssje <", value, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeLessThanOrEqualTo(String value) {
            addCriterion("xssje <=", value, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeLike(String value) {
            addCriterion("xssje like", value, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeNotLike(String value) {
            addCriterion("xssje not like", value, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeIn(List<String> values) {
            addCriterion("xssje in", values, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeNotIn(List<String> values) {
            addCriterion("xssje not in", values, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeBetween(String value1, String value2) {
            addCriterion("xssje between", value1, value2, "xssje");
            return (Criteria) this;
        }

        public Criteria andXssjeNotBetween(String value1, String value2) {
            addCriterion("xssje not between", value1, value2, "xssje");
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