package com.example.doanchuyennganh.model;

import java.io.Serializable;

public class Account implements Serializable {
    private String Sdt;

    public Account(String sdt) {
        Sdt = sdt;
    }

    public Account() {

    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }
}
