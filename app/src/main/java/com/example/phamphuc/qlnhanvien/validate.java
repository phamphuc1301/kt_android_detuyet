package com.example.phamphuc.qlnhanvien;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by phamphuc on 24/10/2017.
 */

public class validate {
    String name,ngaysinh,phongban,thoigianct;
    int thamnien;
    NhanVien nv;
    String so = "0123456789";
    public Boolean validate(NhanVien nhanVien, ArrayList<NhanVien> nv){
        init(nhanVien);
        if(nullpoint()&&type()&&loop(nv)){
            return true;
        }
        return false;
    }
    public void init(NhanVien nv){
         name = nv.getTen().toString();
        Log.d("eman",name);
         ngaysinh = nv.getNgaysinh().toString();
         phongban = nv.getPhongban().toString();
         thoigianct = nv.getThoigianct();
         thamnien = nv.getThamnien();
    }
    public Boolean nullpoint(){
        if (name==""||ngaysinh==""||phongban==""||thoigianct==""){
            return false;
        }
        return true;
    }
    public Boolean type(){
        char[] a;
        a= name.toCharArray();
        String b[];
        b=new String[a.length];
        for (int i = 0; i <a.length ; i++) {
            b[i]=String.valueOf(a[i]);
            if(so.contains(b[i])){
                return false;
            }
        }
        return true;
    }
    public Boolean loop(ArrayList<NhanVien> nv){
        for (int i = 0; i <nv.size() ; i++) {
            NhanVien current = nv.get(i);
            if (name.equals(current.getTen().toString())&&ngaysinh.equals(current.getNgaysinh().toString())&&phongban.equals(current.getPhongban().toString())&&thoigianct.equals(current.getThoigianct().toString())){
                return false;
            }
        }
        return true;
    }
}
