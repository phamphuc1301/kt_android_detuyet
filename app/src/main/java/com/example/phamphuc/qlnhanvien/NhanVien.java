package com.example.phamphuc.qlnhanvien;

import java.io.Serializable;

/**
 * Created by phamphuc on 24/10/2017.
 */

public class NhanVien implements Serializable{
    int thamnien;
    String ten,ngaysinh,phongban,thoigianct;

    public NhanVien() {
    }

    public int getThamnien() {
        return thamnien;
    }

    public void setThamnien(int thamnien) {
        this.thamnien = thamnien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }

    public String getThoigianct() {
        return thoigianct;
    }

    public void setThoigianct(String thoigianct) {
        this.thoigianct = thoigianct;
    }
}
