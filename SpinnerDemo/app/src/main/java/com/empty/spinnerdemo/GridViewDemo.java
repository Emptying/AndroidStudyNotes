package com.empty.spinnerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * Created by cws10 on 2016/5/27.
 */
public class GridViewDemo extends Activity {
    GridView gridView;
    String [] str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_gridview);
        gridView = (GridView)findViewById(R.id.gridView);
        str = new String[]{"AAA","BBB","CCC","EEE","FFF"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.gridview_item,
                R.id.textView,
                str
        );
        gridView.setAdapter(adapter);

    }
}
