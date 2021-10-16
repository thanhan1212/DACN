package com.example.doanchuyennganh.model;

import java.io.Serializable;
public class Account implements Serializable {
    private String Sdt;
    private int Quyen;
    private String LoaiTK;

    public Account(String sdt, int quyen, String loaiTK) {
        Sdt = sdt;
        Quyen = quyen;
        LoaiTK = loaiTK;
    }

    public Account() {

    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public int getQuyen() {
        return Quyen;
    }

    public void setQuyen(int quyen) {
        Quyen = quyen;
    }

    public String getLoaiTK() {
        return LoaiTK;
    }

    public void setLoaiTK(String loaiTK) {
        LoaiTK = loaiTK;
    }
}
