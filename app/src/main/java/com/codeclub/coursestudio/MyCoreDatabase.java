package com.codeclub.coursestudio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MyCoreDatabase extends SQLiteOpenHelper {

    static final private  String DB_NAME="CourseStudio";
    static final private  String DB_TABLE="Users";
    static final private  int DB_VER=1;
    Context ctx;
    SQLiteDatabase mydb;

    public MyCoreDatabase(Context ct){
        super(ct,DB_NAME,null,DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
                db.execSQL("create table "+DB_TABLE+"(Name text,Age text,Gender text,Hobbies text, dob text)");
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+DB_TABLE);
    }
    public void insert(String name,String age,String gender,String hobbies,String dob){
        mydb=getWritableDatabase();
        mydb.execSQL("insert into "+DB_TABLE+" values ('"+name+"','"+age+",'"+gender+"','"+hobbies+"','"+dob+"') ");
        Toast.makeText(ctx,"Sign uP Succeful",Toast.LENGTH_SHORT).show();
    }
    public boolean getAll(String name,String age){
        mydb=getReadableDatabase();
        Cursor cr=mydb.rawQuery("select * from "+DB_TABLE,null);
        StringBuilder str=new StringBuilder();
        while (cr.moveToNext()){
            String na=cr.getString(1);
            String ag=cr.getString(2);
            if(na==name && age==ag) {
                return true;
            }
        }
        return false;

    }
}
