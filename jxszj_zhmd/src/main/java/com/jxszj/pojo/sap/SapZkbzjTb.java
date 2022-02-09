package com.jxszj.pojo.sap;

import java.util.Date;

public class SapZkbzjTb {
    private Integer id;

    private String pzbm;

    private String zz;

    private String km;

    private String je;

    private Date date;

    private String status;

    private String msg;

    private String cjr;

    private String pzrq;

    private String gzrq;

    private String htext;

    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPzbm() {
        return pzbm;
    }

    public void setPzbm(String pzbm) {
        this.pzbm = pzbm == null ? null : pzbm.trim();
    }

    public String getZz() {
        return zz;
    }

    public void setZz(String zz) {
        this.zz = zz == null ? null : zz.trim();
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km == null ? null : km.trim();
    }

    public String getJe() {
        return je;
    }

    public void setJe(String je) {
        this.je = je == null ? null : je.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr == null ? null : cjr.trim();
    }

    public String getPzrq() {
        return pzrq;
    }

    public void setPzrq(String pzrq) {
        this.pzrq = pzrq == null ? null : pzrq.trim();
    }

    public String getGzrq() {
        return gzrq;
    }

    public void setGzrq(String gzrq) {
        this.gzrq = gzrq == null ? null : gzrq.trim();
    }

    public String getHtext() {
        return htext;
    }

    public void setHtext(String htext) {
        this.htext = htext == null ? null : htext.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}