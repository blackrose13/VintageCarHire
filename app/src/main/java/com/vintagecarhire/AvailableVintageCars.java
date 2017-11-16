package com.vintagecarhire;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


public class AvailableVintageCars extends AppCompatActivity {
    ListView listView;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_vintage_cars);

        dbHelper=new DatabaseHelper(this);

        try {
            dbHelper.getCheckAndCopyDatabase();
            dbHelper.openDatabase();
        }catch (SQLiteException e){

        }
try {
    Cursor cursor=dbHelper.QueryData("select*from Vintage_Cars");
    if (cursor !=null){
        if (cursor.moveToFirst())
            do {
                Item item= new Item();
                item.setId(cursor.getInt(0));
                item.setVintagename(cursor.getString(1));
                item.getEngine(cursor.getInt(2));

            }
    }
}

        }
}
