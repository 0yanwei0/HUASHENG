package com.jxszj.pojo.sap;

public class SapScrkwlTb {
    private String id;

    private String gzrq;

    private String wlzbm;

    private String wlzmc;

    private Integer drrk;

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

    public Integer getDrrk() {
        return drrk;
    }

    public void setDrrk(Integer drrk) {
        this.drrk = drrk;
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

	@Override
	public String toString() {
		return "SapScrkwlTb [id=" + id + ", gzrq=" + gzrq + ", wlzbm=" + wlzbm + ", wlzmc=" + wlzmc + ", drrk=" + drrk
				+ ", dylj=" + dylj + ", dyrj=" + dyrj + "]";
	}
    
}