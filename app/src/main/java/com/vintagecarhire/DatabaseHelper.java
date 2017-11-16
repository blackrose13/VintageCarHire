package com.vintagecarhire;

//the class as a whole helps in the management of the database created using sqlite manager.The cursor
//is responsible for a number of functions in a database one of them is to provide results in a cursor interface
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
///the code below  states the name of the database and its path which is its package in this context

public class DatabaseHelper extends SQLiteOpenHelper {

     private static String DB_Path="/data/data/com.vintagecarhire/";
     private static String DB_Name="Vintage_Cars.sqlite";
     private SQLiteDatabase myDatabase;
     private final Context myContext;
    private Object checkAndCopyDatabase;

    public DatabaseHelper(Context context) {
        super(context, DB_Name, null, 1);
        this.myContext=contex0t;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private boolean checkDatabase(){
        SQLiteDatabase checkDB=null;

        //a number of try and catch blocks are given inorder to avoid certain errors that occur when connection fails
        //the database is opened when check returns a true value showing its exists in the application

        try{
            String myPath=DB_Path+DB_Name;
            checkDB=SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
        }catch (SQLiteException e){
            if(checkDB != null) checkDB.close();
            return  checkDB !=null ? true : false;
        }
        private void copyDatabase() throw IOException{
        InputStream myInput = null;
        try {
            myInput = myContext.getAssets().open(DB_Name);//this line of code points were the database is located
        } catch (IOException e) {
            e.printStackTrace();
        }
        String outFileName = DB_Path +DB_Name;
        try {
            OutputStream myOutput = new FileOutputStream(outFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)))>0
        {
            myOutput.write(buffer,0,length);

        }
        myOutput.flush();
        myOutput.close();
        try {
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openDatabase() throws  SQLiteException{
        String myPath=DB_Path+DB_Name;
        myDatabase=SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
    }
    public void ExeSQLData(String query) throws SQLiteException{
        myDatabase.execSQL(sql);

    }
    public Cursor QueryData(String query) throws SQLiteException{
        return myDatabase.rawQuery(query,null);

    }

    public Object getCheckAndCopyDatabase() {
        return checkAndCopyDatabase;
    }

    public void setCheckAndCopyDatabase(Object checkAndCopyDatabase) {
        this.checkAndCopyDatabase = checkAndCopyDatabase;
    }
    ////the class stills needs lines of code which check if the stated database exists in the asset folder
    //if it doesnt then Sqlite database helper assists one in creation of an open readwrite database
}
