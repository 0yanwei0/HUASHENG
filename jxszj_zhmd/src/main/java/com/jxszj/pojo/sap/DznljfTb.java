package com.jxszj.pojo.sap;

public class DznljfTb {
    private Integer zrs;

    private Double zjf;

    private Double rjjf;

    private String ny;

    private String pp;

    public Integer getZrs() {
        return zrs;
    }

    public void setZrs(Integer zrs) {
        this.zrs = zrs;
    }

    public Double getZjf() {
        return zjf;
    }

    public void setZjf(Double zjf) {
        this.zjf = zjf;
    }

    public Double getRjjf() {
        return rjjf;
    }

    public void setRjjf(Double rjjf) {
        this.rjjf = rjjf;
    }

    public String getNy() {
        return ny;
    }

    public void setNy(String ny) {
        this.ny = ny == null ? null : ny.trim();
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp == null ? null : pp.trim();
    }
}