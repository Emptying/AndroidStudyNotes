package com.empty.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cws10 on 2016/5/26.
 */
public class SimpleAdapterDemo extends Activity{
    ArrayList<Map<String,String >> list;
    Map<String,String>  map;
    ListView lv;
    Button btn;
    EditText edtName,edtAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_activity);
        lv = (ListView)findViewById(R.id.listView4);
        list = new ArrayList<>();
        btn = (Button)findViewById(R.id.button);
        edtName = (EditText)findViewById(R.id.edtName);
        edtAge = (EditText)findViewById(R.id.edtAge);
        fill();
        final SimpleAdapter adapter = new SimpleAdapter(
                this,  //context
                list,  //数据源
                R.layout.simple_item, //要显示的项
                new String[]{"name","age"},     //要显示相应的key
                new int[]{R.id.tvName,R.id.tvAge}       //要显示的位置
        );
        lv.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String age = edtAge.getText().toString();
                if(!name.isEmpty()&&!age.isEmpty()){
                    map = new HashMap<>();
                    map.put("name",name);
                    map.put("age",age+"岁");
                    list.add(map);

                    //适配器更新
                    adapter.notifyDataSetChanged();
                }

            }
        });

    }



    public void fill(){
        map = new HashMap<>();
        map.put("name","张三");
        map.put("age","18岁");
        list.add(map);

        map = new HashMap<>();
        map.put("name","李四");
        map.put("age","20岁");
        list.add(map);
    }
}
