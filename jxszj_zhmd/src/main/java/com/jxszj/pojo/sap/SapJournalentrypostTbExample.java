package com.jxszj.pojo.sap;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SapJournalentrypostTbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SapJournalentrypostTbExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andZzIsNull() {
            addCriterion("zz is null");
            return (Criteria) this;
        }

        public Criteria andZzIsNotNull() {
            addCriterion("zz is not null");
            return (Criteria) this;
        }

        public Criteria andZzEqualTo(String value) {
            addCriterion("zz =", value, "zz");
            return (Criteria) this;
        }

        public Criteria andZzNotEqualTo(String value) {
            addCriterion("zz <>", value, "zz");
            return (Criteria) this;
        }

        public Criteria andZzGreaterThan(String value) {
            addCriterion("zz >", value, "zz");
            return (Criteria) this;
        }

        public Criteria andZzGreaterThanOrEqualTo(String value) {
            addCriterion("zz >=", value, "zz");
            return (Criteria) this;
        }

        public Criteria andZzLessThan(String value) {
            addCriterion("zz <", value, "zz");
            return (Criteria) this;
        }

        public Criteria andZzLessThanOrEqualTo(String value) {
            addCriterion("zz <=", value, "zz");
            return (Criteria) this;
        }

        public Criteria andZzLike(String value) {
            addCriterion("zz like", value, "zz");
            return (Criteria) this;
        }

        public Criteria andZzNotLike(String value) {
            addCriterion("zz not like", value, "zz");
            return (Criteria) this;
        }

        public Criteria andZzIn(List<String> values) {
            addCriterion("zz in", values, "zz");
            return (Criteria) this;
        }

        public Criteria andZzNotIn(List<String> values) {
            addCriterion("zz not in", values, "zz");
            return (Criteria) this;
        }

        public Criteria andZzBetween(String value1, String value2) {
            addCriterion("zz between", value1, value2, "zz");
            return (Criteria) this;
        }

        public Criteria andZzNotBetween(String value1, String value2) {
            addCriterion("zz not between", value1, value2, "zz");
            return (Criteria) this;
        }

        public Criteria andJfjzmIsNull() {
            addCriterion("jfjzm is null");
            return (Criteria) this;
        }

        public Criteria andJfjzmIsNotNull() {
            addCriterion("jfjzm is not null");
            return (Criteria) this;
        }

        public Criteria andJfjzmEqualTo(String value) {
            addCriterion("jfjzm =", value, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmNotEqualTo(String value) {
            addCriterion("jfjzm <>", value, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmGreaterThan(String value) {
            addCriterion("jfjzm >", value, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmGreaterThanOrEqualTo(String value) {
            addCriterion("jfjzm >=", value, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmLessThan(String value) {
            addCriterion("jfjzm <", value, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmLessThanOrEqualTo(String value) {
            addCriterion("jfjzm <=", value, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmLike(String value) {
            addCriterion("jfjzm like", value, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmNotLike(String value) {
            addCriterion("jfjzm not like", value, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmIn(List<String> values) {
            addCriterion("jfjzm in", values, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmNotIn(List<String> values) {
            addCriterion("jfjzm not in", values, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmBetween(String value1, String value2) {
            addCriterion("jfjzm between", value1, value2, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andJfjzmNotBetween(String value1, String value2) {
            addCriterion("jfjzm not between", value1, value2, "jfjzm");
            return (Criteria) this;
        }

        public Criteria andKmIsNull() {
            addCriterion("km is null");
            return (Criteria) this;
        }

        public Criteria andKmIsNotNull() {
            addCriterion("km is not null");
            return (Criteria) this;
        }

        public Criteria andKmEqualTo(String value) {
            addCriterion("km =", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmNotEqualTo(String value) {
            addCriterion("km <>", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmGreaterThan(String value) {
            addCriterion("km >", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmGreaterThanOrEqualTo(String value) {
            addCriterion("km >=", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmLessThan(String value) {
            addCriterion("km <", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmLessThanOrEqualTo(String value) {
            addCriterion("km <=", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmLike(String value) {
            addCriterion("km like", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmNotLike(String value) {
            addCriterion("km not like", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmIn(List<String> values) {
            addCriterion("km in", values, "km");
            return (Criteria) this;
        }

        public Criteria andKmNotIn(List<String> values) {
            addCriterion("km not in", values, "km");
            return (Criteria) this;
        }

        public Criteria andKmBetween(String value1, String value2) {
            addCriterion("km between", value1, value2, "km");
            return (Criteria) this;
        }

        public Criteria andKmNotBetween(String value1, String value2) {
            addCriterion("km not between", value1, value2, "km");
            return (Criteria) this;
        }

        public Criteria andJfjeIsNull() {
            addCriterion("jfje is null");
            return (Criteria) this;
        }

        public Criteria andJfjeIsNotNull() {
            addCriterion("jfje is not null");
            return (Criteria) this;
        }

        public Criteria andJfjeEqualTo(String value) {
            addCriterion("jfje =", value, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeNotEqualTo(String value) {
            addCriterion("jfje <>", value, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeGreaterThan(String value) {
            addCriterion("jfje >", value, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeGreaterThanOrEqualTo(String value) {
            addCriterion("jfje >=", value, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeLessThan(String value) {
            addCriterion("jfje <", value, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeLessThanOrEqualTo(String value) {
            addCriterion("jfje <=", value, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeLike(String value) {
            addCriterion("jfje like", value, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeNotLike(String value) {
            addCriterion("jfje not like", value, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeIn(List<String> values) {
            addCriterion("jfje in", values, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeNotIn(List<String> values) {
            addCriterion("jfje not in", values, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeBetween(String value1, String value2) {
            addCriterion("jfje between", value1, value2, "jfje");
            return (Criteria) this;
        }

        public Criteria andJfjeNotBetween(String value1, String value2) {
            addCriterion("jfje not between", value1, value2, "jfje");
            return (Criteria) this;
        }

        public Criteria andCbzxIsNull() {
            addCriterion("cbzx is null");
            return (Criteria) this;
        }

        public Criteria andCbzxIsNotNull() {
            addCriterion("cbzx is not null");
            return (Criteria) this;
        }

        public Criteria andCbzxEqualTo(String value) {
            addCriterion("cbzx =", value, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxNotEqualTo(String value) {
            addCriterion("cbzx <>", value, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxGreaterThan(String value) {
            addCriterion("cbzx >", value, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxGreaterThanOrEqualTo(String value) {
            addCriterion("cbzx >=", value, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxLessThan(String value) {
            addCriterion("cbzx <", value, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxLessThanOrEqualTo(String value) {
            addCriterion("cbzx <=", value, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxLike(String value) {
            addCriterion("cbzx like", value, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxNotLike(String value) {
            addCriterion("cbzx not like", value, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxIn(List<String> values) {
            addCriterion("cbzx in", values, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxNotIn(List<String> values) {
            addCriterion("cbzx not in", values, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxBetween(String value1, String value2) {
            addCriterion("cbzx between", value1, value2, "cbzx");
            return (Criteria) this;
        }

        public Criteria andCbzxNotBetween(String value1, String value2) {
            addCriterion("cbzx not between", value1, value2, "cbzx");
            return (Criteria) this;
        }

        public Criteria andDfjzmIsNull() {
            addCriterion("dfjzm is null");
            return (Criteria) this;
        }

        public Criteria andDfjzmIsNotNull() {
            addCriterion("dfjzm is not null");
            return (Criteria) this;
        }

        public Criteria andDfjzmEqualTo(String value) {
            addCriterion("dfjzm =", value, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmNotEqualTo(String value) {
            addCriterion("dfjzm <>", value, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmGreaterThan(String value) {
            addCriterion("dfjzm >", value, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmGreaterThanOrEqualTo(String value) {
            addCriterion("dfjzm >=", value, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmLessThan(String value) {
            addCriterion("dfjzm <", value, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmLessThanOrEqualTo(String value) {
            addCriterion("dfjzm <=", value, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmLike(String value) {
            addCriterion("dfjzm like", value, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmNotLike(String value) {
            addCriterion("dfjzm not like", value, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmIn(List<String> values) {
            addCriterion("dfjzm in", values, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmNotIn(List<String> values) {
            addCriterion("dfjzm not in", values, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmBetween(String value1, String value2) {
            addCriterion("dfjzm between", value1, value2, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andDfjzmNotBetween(String value1, String value2) {
            addCriterion("dfjzm not between", value1, value2, "dfjzm");
            return (Criteria) this;
        }

        public Criteria andGysIsNull() {
            addCriterion("gys is null");
            return (Criteria) this;
        }

        public Criteria andGysIsNotNull() {
            addCriterion("gys is not null");
            return (Criteria) this;
        }

        public Criteria andGysEqualTo(String value) {
            addCriterion("gys =", value, "gys");
            return (Criteria) this;
        }

        public Criteria andGysNotEqualTo(String value) {
            addCriterion("gys <>", value, "gys");
            return (Criteria) this;
        }

        public Criteria andGysGreaterThan(String value) {
            addCriterion("gys >", value, "gys");
            return (Criteria) this;
        }

        public Criteria andGysGreaterThanOrEqualTo(String value) {
            addCriterion("gys >=", value, "gys");
            return (Criteria) this;
        }

        public Criteria andGysLessThan(String value) {
            addCriterion("gys <", value, "gys");
            return (Criteria) this;
        }

        public Criteria andGysLessThanOrEqualTo(String value) {
            addCriterion("gys <=", value, "gys");
            return (Criteria) this;
        }

        public Criteria andGysLike(String value) {
            addCriterion("gys like", value, "gys");
            return (Criteria) this;
        }

        public Criteria andGysNotLike(String value) {
            addCriterion("gys not like", value, "gys");
            return (Criteria) this;
        }

        public Criteria andGysIn(List<String> values) {
            addCriterion("gys in", values, "gys");
            return (Criteria) this;
        }

        public Criteria andGysNotIn(List<String> values) {
            addCriterion("gys not in", values, "gys");
            return (Criteria) this;
        }

        public Criteria andGysBetween(String value1, String value2) {
            addCriterion("gys between", value1, value2, "gys");
            return (Criteria) this;
        }

        public Criteria andGysNotBetween(String value1, String value2) {
            addCriterion("gys not between", value1, value2, "gys");
            return (Criteria) this;
        }

        public Criteria andZzbsIsNull() {
            addCriterion("zzbs is null");
            return (Criteria) this;
        }

        public Criteria andZzbsIsNotNull() {
            addCriterion("zzbs is not null");
            return (Criteria) this;
        }

        public Criteria andZzbsEqualTo(String value) {
            addCriterion("zzbs =", value, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsNotEqualTo(String value) {
            addCriterion("zzbs <>", value, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsGreaterThan(String value) {
            addCriterion("zzbs >", value, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsGreaterThanOrEqualTo(String value) {
            addCriterion("zzbs >=", value, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsLessThan(String value) {
            addCriterion("zzbs <", value, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsLessThanOrEqualTo(String value) {
            addCriterion("zzbs <=", value, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsLike(String value) {
            addCriterion("zzbs like", value, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsNotLike(String value) {
            addCriterion("zzbs not like", value, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsIn(List<String> values) {
            addCriterion("zzbs in", values, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsNotIn(List<String> values) {
            addCriterion("zzbs not in", values, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsBetween(String value1, String value2) {
            addCriterion("zzbs between", value1, value2, "zzbs");
            return (Criteria) this;
        }

        public Criteria andZzbsNotBetween(String value1, String value2) {
            addCriterion("zzbs not between", value1, value2, "zzbs");
            return (Criteria) this;
        }

        public Criteria andDfjeIsNull() {
            addCriterion("dfje is null");
            return (Criteria) this;
        }

        public Criteria andDfjeIsNotNull() {
            addCriterion("dfje is not null");
            return (Criteria) this;
        }

        public Criteria andDfjeEqualTo(String value) {
            addCriterion("dfje =", value, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeNotEqualTo(String value) {
            addCriterion("dfje <>", value, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeGreaterThan(String value) {
            addCriterion("dfje >", value, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeGreaterThanOrEqualTo(String value) {
            addCriterion("dfje >=", value, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeLessThan(String value) {
            addCriterion("dfje <", value, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeLessThanOrEqualTo(String value) {
            addCriterion("dfje <=", value, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeLike(String value) {
            addCriterion("dfje like", value, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeNotLike(String value) {
            addCriterion("dfje not like", value, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeIn(List<String> values) {
            addCriterion("dfje in", values, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeNotIn(List<String> values) {
            addCriterion("dfje not in", values, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeBetween(String value1, String value2) {
            addCriterion("dfje between", value1, value2, "dfje");
            return (Criteria) this;
        }

        public Criteria andDfjeNotBetween(String value1, String value2) {
            addCriterion("dfje not between", value1, value2, "dfje");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
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

        public Criteria andPzrqIsNull() {
            addCriterion("pzrq is null");
            return (Criteria) this;
        }

        public Criteria andPzrqIsNotNull() {
            addCriterion("pzrq is not null");
            return (Criteria) this;
        }

        public Criteria andPzrqEqualTo(String value) {
            addCriterion("pzrq =", value, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqNotEqualTo(String value) {
            addCriterion("pzrq <>", value, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqGreaterThan(String value) {
            addCriterion("pzrq >", value, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqGreaterThanOrEqualTo(String value) {
            addCriterion("pzrq >=", value, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqLessThan(String value) {
            addCriterion("pzrq <", value, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqLessThanOrEqualTo(String value) {
            addCriterion("pzrq <=", value, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqLike(String value) {
            addCriterion("pzrq like", value, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqNotLike(String value) {
            addCriterion("pzrq not like", value, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqIn(List<String> values) {
            addCriterion("pzrq in", values, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqNotIn(List<String> values) {
            addCriterion("pzrq not in", values, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqBetween(String value1, String value2) {
            addCriterion("pzrq between", value1, value2, "pzrq");
            return (Criteria) this;
        }

        public Criteria andPzrqNotBetween(String value1, String value2) {
            addCriterion("pzrq not between", value1, value2, "pzrq");
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

        public Criteria andHtextIsNull() {
            addCriterion("htext is null");
            return (Criteria) this;
        }

        public Criteria andHtextIsNotNull() {
            addCriterion("htext is not null");
            return (Criteria) this;
        }

        public Criteria andHtextEqualTo(String value) {
            addCriterion("htext =", value, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextNotEqualTo(String value) {
            addCriterion("htext <>", value, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextGreaterThan(String value) {
            addCriterion("htext >", value, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextGreaterThanOrEqualTo(String value) {
            addCriterion("htext >=", value, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextLessThan(String value) {
            addCriterion("htext <", value, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextLessThanOrEqualTo(String value) {
            addCriterion("htext <=", value, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextLike(String value) {
            addCriterion("htext like", value, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextNotLike(String value) {
            addCriterion("htext not like", value, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextIn(List<String> values) {
            addCriterion("htext in", values, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextNotIn(List<String> values) {
            addCriterion("htext not in", values, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextBetween(String value1, String value2) {
            addCriterion("htext between", value1, value2, "htext");
            return (Criteria) this;
        }

        public Criteria andHtextNotBetween(String value1, String value2) {
            addCriterion("htext not between", value1, value2, "htext");
            return (Criteria) this;
        }

        public Criteria andTextIsNull() {
            addCriterion("text is null");
            return (Criteria) this;
        }

        public Criteria andTextIsNotNull() {
            addCriterion("text is not null");
            return (Criteria) this;
        }

        public Criteria andTextEqualTo(String value) {
            addCriterion("text =", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotEqualTo(String value) {
            addCriterion("text <>", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThan(String value) {
            addCriterion("text >", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThanOrEqualTo(String value) {
            addCriterion("text >=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThan(String value) {
            addCriterion("text <", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThanOrEqualTo(String value) {
            addCriterion("text <=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLike(String value) {
            addCriterion("text like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotLike(String value) {
            addCriterion("text not like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextIn(List<String> values) {
            addCriterion("text in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotIn(List<String> values) {
            addCriterion("text not in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextBetween(String value1, String value2) {
            addCriterion("text between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotBetween(String value1, String value2) {
            addCriterion("text not between", value1, value2, "text");
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