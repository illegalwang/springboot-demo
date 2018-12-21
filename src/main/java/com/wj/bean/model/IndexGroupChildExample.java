package com.wj.bean.model;

import java.util.ArrayList;
import java.util.List;

public class IndexGroupChildExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndexGroupChildExample() {
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

        public Criteria andWebIdIsNull() {
            addCriterion("WEB_ID is null");
            return (Criteria) this;
        }

        public Criteria andWebIdIsNotNull() {
            addCriterion("WEB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWebIdEqualTo(Integer value) {
            addCriterion("WEB_ID =", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotEqualTo(Integer value) {
            addCriterion("WEB_ID <>", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdGreaterThan(Integer value) {
            addCriterion("WEB_ID >", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEB_ID >=", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdLessThan(Integer value) {
            addCriterion("WEB_ID <", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdLessThanOrEqualTo(Integer value) {
            addCriterion("WEB_ID <=", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdIn(List<Integer> values) {
            addCriterion("WEB_ID in", values, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotIn(List<Integer> values) {
            addCriterion("WEB_ID not in", values, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdBetween(Integer value1, Integer value2) {
            addCriterion("WEB_ID between", value1, value2, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WEB_ID not between", value1, value2, "webId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andWebUrlIsNull() {
            addCriterion("WEB_URL is null");
            return (Criteria) this;
        }

        public Criteria andWebUrlIsNotNull() {
            addCriterion("WEB_URL is not null");
            return (Criteria) this;
        }

        public Criteria andWebUrlEqualTo(String value) {
            addCriterion("WEB_URL =", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotEqualTo(String value) {
            addCriterion("WEB_URL <>", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlGreaterThan(String value) {
            addCriterion("WEB_URL >", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_URL >=", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLessThan(String value) {
            addCriterion("WEB_URL <", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLessThanOrEqualTo(String value) {
            addCriterion("WEB_URL <=", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLike(String value) {
            addCriterion("WEB_URL like", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotLike(String value) {
            addCriterion("WEB_URL not like", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlIn(List<String> values) {
            addCriterion("WEB_URL in", values, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotIn(List<String> values) {
            addCriterion("WEB_URL not in", values, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlBetween(String value1, String value2) {
            addCriterion("WEB_URL between", value1, value2, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotBetween(String value1, String value2) {
            addCriterion("WEB_URL not between", value1, value2, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebNameIsNull() {
            addCriterion("WEB_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWebNameIsNotNull() {
            addCriterion("WEB_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWebNameEqualTo(String value) {
            addCriterion("WEB_NAME =", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotEqualTo(String value) {
            addCriterion("WEB_NAME <>", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameGreaterThan(String value) {
            addCriterion("WEB_NAME >", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_NAME >=", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLessThan(String value) {
            addCriterion("WEB_NAME <", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLessThanOrEqualTo(String value) {
            addCriterion("WEB_NAME <=", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLike(String value) {
            addCriterion("WEB_NAME like", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotLike(String value) {
            addCriterion("WEB_NAME not like", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameIn(List<String> values) {
            addCriterion("WEB_NAME in", values, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotIn(List<String> values) {
            addCriterion("WEB_NAME not in", values, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameBetween(String value1, String value2) {
            addCriterion("WEB_NAME between", value1, value2, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotBetween(String value1, String value2) {
            addCriterion("WEB_NAME not between", value1, value2, "webName");
            return (Criteria) this;
        }

        public Criteria andWebIconIsNull() {
            addCriterion("WEB_ICON is null");
            return (Criteria) this;
        }

        public Criteria andWebIconIsNotNull() {
            addCriterion("WEB_ICON is not null");
            return (Criteria) this;
        }

        public Criteria andWebIconEqualTo(String value) {
            addCriterion("WEB_ICON =", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconNotEqualTo(String value) {
            addCriterion("WEB_ICON <>", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconGreaterThan(String value) {
            addCriterion("WEB_ICON >", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_ICON >=", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconLessThan(String value) {
            addCriterion("WEB_ICON <", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconLessThanOrEqualTo(String value) {
            addCriterion("WEB_ICON <=", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconLike(String value) {
            addCriterion("WEB_ICON like", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconNotLike(String value) {
            addCriterion("WEB_ICON not like", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconIn(List<String> values) {
            addCriterion("WEB_ICON in", values, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconNotIn(List<String> values) {
            addCriterion("WEB_ICON not in", values, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconBetween(String value1, String value2) {
            addCriterion("WEB_ICON between", value1, value2, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconNotBetween(String value1, String value2) {
            addCriterion("WEB_ICON not between", value1, value2, "webIcon");
            return (Criteria) this;
        }

        public Criteria andIfDesIsNull() {
            addCriterion("IF_DES is null");
            return (Criteria) this;
        }

        public Criteria andIfDesIsNotNull() {
            addCriterion("IF_DES is not null");
            return (Criteria) this;
        }

        public Criteria andIfDesEqualTo(Integer value) {
            addCriterion("IF_DES =", value, "ifDes");
            return (Criteria) this;
        }

        public Criteria andIfDesNotEqualTo(Integer value) {
            addCriterion("IF_DES <>", value, "ifDes");
            return (Criteria) this;
        }

        public Criteria andIfDesGreaterThan(Integer value) {
            addCriterion("IF_DES >", value, "ifDes");
            return (Criteria) this;
        }

        public Criteria andIfDesGreaterThanOrEqualTo(Integer value) {
            addCriterion("IF_DES >=", value, "ifDes");
            return (Criteria) this;
        }

        public Criteria andIfDesLessThan(Integer value) {
            addCriterion("IF_DES <", value, "ifDes");
            return (Criteria) this;
        }

        public Criteria andIfDesLessThanOrEqualTo(Integer value) {
            addCriterion("IF_DES <=", value, "ifDes");
            return (Criteria) this;
        }

        public Criteria andIfDesIn(List<Integer> values) {
            addCriterion("IF_DES in", values, "ifDes");
            return (Criteria) this;
        }

        public Criteria andIfDesNotIn(List<Integer> values) {
            addCriterion("IF_DES not in", values, "ifDes");
            return (Criteria) this;
        }

        public Criteria andIfDesBetween(Integer value1, Integer value2) {
            addCriterion("IF_DES between", value1, value2, "ifDes");
            return (Criteria) this;
        }

        public Criteria andIfDesNotBetween(Integer value1, Integer value2) {
            addCriterion("IF_DES not between", value1, value2, "ifDes");
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