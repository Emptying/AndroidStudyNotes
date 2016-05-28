package com.empty.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Emptying on 2016/5/26.
 */
public class ExampleDemo extends Activity {
    private String [] str;
    ListView lv;
    TextView tvShow;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        str = getResources().getStringArray(R.array.fruit);
        lv = (ListView)findViewById(R.id.listView2);
        tvShow = (TextView)findViewById(R.id.tvShow);

        adapter = new ArrayAdapter<>(this,R.layout.example_item,R.id.textView2,str);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tmp = str[position];
                tvShow.setText(tmp);
            }
        });


    }
}
