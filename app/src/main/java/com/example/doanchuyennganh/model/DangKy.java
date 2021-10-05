package com.example.doanchuyennganh.model;

import java.io.Serializable;

public class DangKy implements Serializable {
    private String tentk;
    private String sdt;

    public DangKy(String tentk, String sdt) {
        this.tentk = tentk;
        this.sdt = sdt;
    }

    public DangKy() {

    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
