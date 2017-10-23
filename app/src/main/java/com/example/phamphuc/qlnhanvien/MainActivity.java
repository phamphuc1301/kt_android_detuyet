package com.example.phamphuc.qlnhanvien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name,dateofbirth,job;
    RadioButton time1,time2,time3;
    Button add,rewrite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setTen(name.getText().toString());
                nhanVien.setNgaysinh(dateofbirth.getText().toString());
                nhanVien.setPhongban(job.getText().toString());
                int thamnien=-1;
                String thoigianct="";
                if (time1.isChecked()){
                    thamnien=0;
                    thoigianct=time1.getText().toString();
                }
                if (time2.isChecked()){
                    thamnien=1;
                    thoigianct=time2.getText().toString();
                }
                if (time3.isChecked()){
                    thamnien=2;
                    thoigianct=time3.getText().toString();
                }
                nhanVien.setThamnien(thamnien);
                nhanVien.setThoigianct(thoigianct);
                Database db = new Database(MainActivity.this);
                validate vl = new validate();
                ArrayList<NhanVien> data = db.pull();
                Log.d("xxx",data.get(0).getTen().toString());
                if (vl.validate(nhanVien,data)){
                    Intent i = new Intent(MainActivity.this,Hienthi.class);
                    i.putExtra("nhanvien",nhanVien);
                    db.push(nhanVien);

                    startActivity(i);}
                else Toast.makeText(MainActivity.this, "du lieu khongchisnh xac", Toast.LENGTH_SHORT).show();
            }
        });
        rewrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                dateofbirth.setText("");
                job.setText("");
                time1.setChecked(false);
                time2.setChecked(false);
                time3.setChecked(false);
            }
        });
    }

    private void init(){
        name = (EditText) findViewById(R.id.name);
        dateofbirth= (EditText) findViewById(R.id.dateofbirth);
        job= (EditText) findViewById(R.id.job);
        time1= (RadioButton) findViewById(R.id.time1);
        time2= (RadioButton) findViewById(R.id.time2);
        time3= (RadioButton) findViewById(R.id.time3);
        add= (Button) findViewById(R.id.add);
        rewrite= (Button) findViewById(R.id.rewrite);
    }
}