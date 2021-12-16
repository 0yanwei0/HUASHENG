package com.jxszj.pojo.sap;

public class SapScjhwlTb {
    private String id;

    private String gzrq;

    private String wlzbm;

    private String wlzmc;

    private Integer drjh;

    private Integer dylj;

    private Integer dyrj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGzrq() {
        return gzrq;
    }

    public void setGzrq(String gzrq) {
        this.gzrq = gzrq == null ? null : gzrq.trim();
    }

    public String getWlzbm() {
        return wlzbm;
    }

    public void setWlzbm(String wlzbm) {
        this.wlzbm = wlzbm == null ? null : wlzbm.trim();
    }

    public String getWlzmc() {
        return wlzmc;
    }

    public void setWlzmc(String wlzmc) {
        this.wlzmc = wlzmc == null ? null : wlzmc.trim();
    }

    public Integer getDrjh() {
        return drjh;
    }

    public void setDrjh(Integer drjh) {
        this.drjh = drjh;
    }

    public Integer getDylj() {
        return dylj;
    }

    public void setDylj(Integer dylj) {
        this.dylj = dylj;
    }

    public Integer getDyrj() {
        return dyrj;
    }

    public void setDyrj(Integer dyrj) {
        this.dyrj = dyrj;
    }
}