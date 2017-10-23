package com.example.phamphuc.qlnhanvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by phamphuc on 24/10/2017.
 */

public class Database extends SQLiteOpenHelper {
    SQLiteDatabase db;
    //database info
    static String DATABASE_NAME ="QL NHAN VIEN";
    static String TABLE_NAME ="NHAN_VIEN";
    static  int DATABASE_VER =1;

    //Table info

    static String NAME ="Ten";
    static String ID ="ID";
    static String NGAYSINH ="NGAY_SINH";
    static String PHONGBAN ="PHONG_BAN";
    static String THAMNIEN ="THAM_NIEN";
    static String THOIGIANCT ="THOI_GIAN_CT";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE NHAN_VIEN( ID INTEGER PRIMARY KEY AUTOINCREMENT, TEN TEXT,NGAY_SINH TEXT,PHONG_BAN TEXT,THOI_GIAN_CT TEXT,THAM_NIEN INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql ="DELETE TABLE IF EXITST "+TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }
    public long push(NhanVien nv){
        db=getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(NAME,nv.getTen().toString());
        content.put(NGAYSINH,nv.getNgaysinh().toString());
        content.put(PHONGBAN,nv.getPhongban().toString());
        content.put(THAMNIEN,nv.getThamnien());
        content.put(THOIGIANCT,nv.getThoigianct().toString());
        long kt = db.insert(TABLE_NAME,null,content);
        return kt;
    }
    public ArrayList<NhanVien> pull(){
        db = getReadableDatabase();
        ArrayList<NhanVien> data = new ArrayList<>();
        String sql= "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            NhanVien nv = new NhanVien();
            nv.setTen(cursor.getString(1));
            nv.setNgaysinh(cursor.getString(2));
            nv.setPhongban(cursor.getString(3));
            nv.setThoigianct(cursor.getString(4));
            nv.setThamnien(cursor.getInt(5));
            data.add(nv);
        }
        return data;
    }

}
