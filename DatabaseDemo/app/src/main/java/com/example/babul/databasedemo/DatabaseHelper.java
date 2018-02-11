package com.example.babul.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Babul on 2/9/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";
    private static final int VERSION_NUMBER = 7;
    private static final String TABLE_NAME = "students_details";
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String GENDER = "gender";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+AGE+" INTEGER, "+GENDER+" VARCHAR(15))";
    private Context context;
    private static final String UPGRADE_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    private static final String SELECT_ALL = "SELECT * FROM "+TABLE_NAME;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context.getApplicationContext(),"onCreate is called",Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Toast.makeText(context.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context.getApplicationContext(),"onUpgrade is called",Toast.LENGTH_SHORT).show();
            db.execSQL(UPGRADE_TABLE);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    public long insertInfo(String name, String age, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(AGE, age);
        contentValues.put(GENDER,gender);

        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        return rowId;
    }

    public Cursor displayAll(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
    }
}
