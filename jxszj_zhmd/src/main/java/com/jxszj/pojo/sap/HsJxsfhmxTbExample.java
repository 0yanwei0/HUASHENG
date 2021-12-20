package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.List;

public class HsJxsfhmxTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HsJxsfhmxTbExample() {
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

        public Criteria andCpzmsIsNull() {
            addCriterion("cpzms is null");
            return (Criteria) this;
        }

        public Criteria andCpzmsIsNotNull() {
            addCriterion("cpzms is not null");
            return (Criteria) this;
        }

        public Criteria andCpzmsEqualTo(String value) {
            addCriterion("cpzms =", value, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsNotEqualTo(String value) {
            addCriterion("cpzms <>", value, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsGreaterThan(String value) {
            addCriterion("cpzms >", value, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsGreaterThanOrEqualTo(String value) {
            addCriterion("cpzms >=", value, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsLessThan(String value) {
            addCriterion("cpzms <", value, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsLessThanOrEqualTo(String value) {
            addCriterion("cpzms <=", value, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsLike(String value) {
            addCriterion("cpzms like", value, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsNotLike(String value) {
            addCriterion("cpzms not like", value, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsIn(List<String> values) {
            addCriterion("cpzms in", values, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsNotIn(List<String> values) {
            addCriterion("cpzms not in", values, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsBetween(String value1, String value2) {
            addCriterion("cpzms between", value1, value2, "cpzms");
            return (Criteria) this;
        }

        public Criteria andCpzmsNotBetween(String value1, String value2) {
            addCriterion("cpzms not between", value1, value2, "cpzms");
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