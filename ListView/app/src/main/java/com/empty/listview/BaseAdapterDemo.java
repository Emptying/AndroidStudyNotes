package com.empty.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cws10 on 2016/5/26.
 */
public class BaseAdapterDemo extends Activity {
    String [] str;
    ArrayList<String> array;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        lv = (ListView)findViewById(R.id.listView3);
        str = getResources().getStringArray(R.array.fruit);
        array = new ArrayList<>();
        for(int i = 0;i<str.length;i++){
            array.add(str[i]);
        }
        lv.setAdapter(new BaseAdapters());
    }
    //最主要的方法第一个和第四个
    class BaseAdapters extends BaseAdapter{

        //返回个数
        @Override
        public int getCount() {
            return array.size();
        }

        //返回item
        @Override
        public Object getItem(int position) {
            return array.get(position);
        }

        //返回ItemId
        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
/*            TextView tv = new TextView(BaseAdapterDemo.this);
            tv.setText(array.get(position));*/
            View view;
            LayoutInflater inflater= getLayoutInflater();
            view=inflater.inflate(R.layout.base_item,parent,false);
            TextView  tv = (TextView) view.findViewById(R.id.textView3);
//            ImageView iv = (ImageView) view.findViewById(R.id.imageView);
            tv.setText(array.get(position));

            return view;
        }
    }
}
