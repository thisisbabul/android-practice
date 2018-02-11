package com.example.babul.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    List<String> headerList;
    HashMap<String, List<String>> childList;
    private CustomAdapter adapter;
    private int lastExpandPostion = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preparedListData();
        adapter = new CustomAdapter(this, headerList, childList);
        expandableListView = findViewById(R.id.expandableListViewId);
        expandableListView.setAdapter(adapter);


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandPostion != -1 && lastExpandPostion != groupPosition){
                    expandableListView.collapseGroup(lastExpandPostion);
                }
                lastExpandPostion = groupPosition;
            }
        });
    }

    private void preparedListData() {
        String[] countryNames = getResources().getStringArray(R.array.countryNames);
        String[] countryDes = getResources().getStringArray(R.array.countryDescription);

        headerList = new ArrayList<>();
        childList = new HashMap<>();

        for (int i = 0; i<countryNames.length; i++){
            headerList.add(countryNames[i]);
            List<String> cList = new ArrayList<>();
            cList.add(countryDes[i]);
            childList.put(headerList.get(i), cList);
        }

    }

}
