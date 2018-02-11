package com.example.babul.gridview;

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

class CustomAdapter extends BaseAdapter{
    Context context;
    String[] countryNames;
    int[] flags;
    LayoutInflater inflater;

    public CustomAdapter(Context context, String[] countryNames, int[] flags) {
        this.context = context;
        this.countryNames = countryNames;
        this.flags = flags;
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

        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_simple,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageviewId);
        TextView textView = convertView.findViewById(R.id.textviewId);

        imageView.setImageResource(flags[position]);
        textView.setText(countryNames[position]);

        return convertView;
    }
}
