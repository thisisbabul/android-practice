package com.example.babul.countrynames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Babul on 2/1/2018.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] flags;
    String countryNames[];
    LayoutInflater inflater;

    public CustomAdapter(Context context, int[] flags, String countryNames[]) {
        this.context = context;
        this.flags = flags;
        this.countryNames = countryNames;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.simple_activity,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.flagId);
        TextView countryName = convertView.findViewById(R.id.countryNameId);

        imageView.setImageResource(flags[position]);
        countryName.setText(countryNames[position]);
        return convertView;
    }
}
