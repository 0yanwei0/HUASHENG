package com.jxszj.pojo.sap;

public class SapJdrbTb {
    private String id;

    private String wlz;

    private String wlzmc;

    private Integer dylj;

    private Integer dyrj;

    private String rq;

    private Integer drjd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWlz() {
        return wlz;
    }

    public void setWlz(String wlz) {
        this.wlz = wlz == null ? null : wlz.trim();
    }

    public String getWlzmc() {
        return wlzmc;
    }

    public void setWlzmc(String wlzmc) {
        this.wlzmc = wlzmc == null ? null : wlzmc.trim();
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

    public String getRq() {
        return rq;
    }

    public void setRq(String rq) {
        this.rq = rq == null ? null : rq.trim();
    }

    public Integer getDrjd() {
        return drjd;
    }

    public void setDrjd(Integer drjd) {
        this.drjd = drjd;
    }
}