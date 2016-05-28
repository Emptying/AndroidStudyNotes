package com.empty.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by cws10 on 2016/5/26.
 */
public class ListActivityDemo extends ListActivity {
    String [] str = {"福州","漳州","厦门","泉州"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String>  adapter = new ArrayAdapter<>(
                this,
                R.layout.listitem,
                R.id.tvcity,
                str
        );
        setListAdapter(adapter);
    }
    //ListView Item点击事件
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(ListActivityDemo.this, str[position], Toast.LENGTH_SHORT).show();
    }
}
