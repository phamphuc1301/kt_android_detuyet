package com.example.phamphuc.qlnhanvien;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phamphuc on 24/10/2017.
 */

public class MyAdapter extends ArrayAdapter {
    Activity activity;
    int myresource;
    ArrayList<NhanVien> myobject;
    public MyAdapter(@NonNull Activity activity, @LayoutRes int resource, @NonNull ArrayList<NhanVien> objects) {
        super(activity, resource, objects);
        this.activity =activity;
        this.myobject=objects;
        this.myresource= resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View v= layoutInflater.inflate(myresource,null);
        TextView ten1= v.findViewById(R.id.ten1);
        TextView ngaysinh1= v.findViewById(R.id.ngaysinh1);
        TextView phongban1= v.findViewById(R.id.phongban1);
        TextView thoigianct1= v.findViewById(R.id.thoigianct1);
        NhanVien data = myobject.get(position);
        ten1.setText(data.getTen().toString());
        ngaysinh1.setText(data.getNgaysinh().toString());
        phongban1.setText(data.getPhongban().toString());
        thoigianct1.setText(data.getThoigianct().toString());
        return v;
    }
}
