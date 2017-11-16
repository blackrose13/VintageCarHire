package com.vintagecarhire;

//this class is responsible for the connection of the items within the database as shown below
//it interacts with the Item.java clsss as its items get methods are obtained from that class
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter {
    private Activity activity;
    int id;
    ArrayList<Item> items;

    public Adapter(Activity context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        this.activity=context;
        this.id=resource;
        this.items=objects;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(id, null);

        }
        Item item=items.get(position);
        TextView id=(TextView)convertView.findViewById(R.id.id);
        TextView vintagename=(TextView)convertView.findViewById(R.id.vintagename);
        TextView engine=(TextView)convertView.findViewById(R.id.engine);
        TextView numberOfSeats=(TextView)convertView.findViewById(R.id.numberOfSeats);
        TextView convertable=(TextView)convertView.findViewById(R.id.convertable);
        TextView numberOfDoors=(TextView)convertView.findViewById(R.id.numberOfDoors);
        TextView yearOfManufacturer=(TextView)convertView.findViewById(R.id.yearOfManufacturer);
        TextView price=(TextView)convertView.findViewById(R.id.price);
        TextView color=(TextView)convertView.findViewById(R.id.color);

        id.setText(item.getId());
        vintagename.setText(item.getVintagename());
        engine.setText(item.getEngine());
        numberOfSeats.setText(item.getNumberOfSeats());
        convertable.setText(item.getConvertable());
        numberOfDoors.setText(item.getNumberOfDoors());
        yearOfManufacturer.setText(item.getYearOfManufacturer());
        price.setText(item.getPrice());
        color.setText(item.getColor());

        return convertView;
    }
}
