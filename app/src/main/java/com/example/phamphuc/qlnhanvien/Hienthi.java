package com.example.phamphuc.qlnhanvien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
public class Hienthi extends AppCompatActivity {
    ArrayList<NhanVien> data;
    ListView lv;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthi);
        Intent intent= getIntent();
        NhanVien nv = (NhanVien) intent.getSerializableExtra("nhanvien");
        init();
        Database db = new Database(this);
        data = db.pull();
        adapter = new MyAdapter(this,R.layout.lv,data);
        lv.setAdapter(adapter);
    }
    private void init(){
        lv=(ListView) findViewById(R.id.lv);
    }

}
