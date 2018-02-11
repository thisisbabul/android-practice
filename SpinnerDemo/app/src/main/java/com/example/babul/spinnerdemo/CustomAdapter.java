package com.example.babul.spinnerdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Babul on 2/3/2018.
 */

class CustomAdapter extends BaseAdapter{
    Context context;
    int[] flags;
    String[] countryNames;
    String[] populations;
    LayoutInflater inflater;
    ImageView imageViewFlags;
    TextView textViewCountryNames, textViewPopulations;

    public CustomAdapter(Context context, int[] flags, String[] countryNames, String[] populations) {
        this.context = context;
        this.flags = flags;
        this.countryNames = countryNames;
        this.populations = populations;
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
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.simple_activity,parent, false);
        }

        imageViewFlags = convertView.findViewById(R.id.imageViewId);
        imageViewFlags.setImageResource(flags[position]);

        textViewCountryNames = convertView.findViewById(R.id.textviewCountryNamesId);
        textViewCountryNames.setText(countryNames[position]);
        textViewPopulations = convertView.findViewById(R.id.textViewPopulationId);
        textViewPopulations.setText(populations[position]);

        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
