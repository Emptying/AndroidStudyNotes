package com.empty.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String [] str = new String[]{"福州","漳州","厦门","泉州"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.listView);
        //adapter 适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, //上下文
                R.layout.listitem,//每一项的布局
                R.id.tvcity,//显示数据控件id
                str         //数据源
        );
        lv.setAdapter(adapter);
        //ListView Item点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, str[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
