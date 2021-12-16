package com.jxszj.pojo;

public class Jxspm {
	private String id;
	
    private String jxsbm;   //经销商编码

    private Integer dj;    //店均
    
    private Double total;  //收款总数
    
    private String mdbm;   //门店编码
    
    private String mdmc;   //门店名称
    
    private Double jf;   //积分
    
    private String dz;   //店长

	public String getJxsbm() {
		return jxsbm;
	}

	public void setJxsbm(String jxsbm) {
		this.jxsbm = jxsbm;
	}

	public Integer getDj() {
		return dj;
	}

	public void setDj(Integer dj) {
		this.dj = dj;
	}

	public String getMdbm() {
		return mdbm;
	}

	public void setMdbm(String mdbm) {
		this.mdbm = mdbm;
	}

	public String getMdmc() {
		return mdmc;
	}

	public void setMdmc(String mdmc) {
		this.mdmc = mdmc;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Double getJf() {
		return jf;
	}

	public void setJf(Double jf) {
		this.jf = jf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	@Override
	public String toString() {
		return "Jxspm [id=" + id + ", jxsbm=" + jxsbm + ", dj=" + dj + ", total=" + total + ", mdbm=" + mdbm + ", mdmc=" + mdmc
				+ ", jf=" + jf + ", dz=" + dz + "]";
	}

}