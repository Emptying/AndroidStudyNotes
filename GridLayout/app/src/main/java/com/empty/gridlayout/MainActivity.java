package com.empty.gridlayout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edt;
    LinearLayout layout;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        btn = (Button)findViewById(R.id.button);
        edt = (EditText)findViewById(R.id.editText);
        layout = (LinearLayout)findViewById(R.id.layout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到需要添加控件的个数
                int count = Integer.parseInt(edt.getText().toString());
                for(int i = 0;i<count;i++){
                    //解析得到layout对象
                    LayoutInflater inflater=getLayoutInflater();
                    view=inflater.inflate(R.layout.setting,null);
                    //通过得到的对象获取资源
                    TextView tvcount= (TextView) view.findViewById(R.id.textView);
                    tvcount.setText(String.valueOf(i));
                    layout.addView(view);

                }
            }
        });
    }
}
