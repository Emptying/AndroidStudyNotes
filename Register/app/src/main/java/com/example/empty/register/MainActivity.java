package com.example.empty.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button regbtn;
    EditText edpwd,edusr;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        regbtn=(Button)findViewById(R.id.regbtn);
        edpwd=(EditText)findViewById(R.id.edpwd);
        edusr=(EditText)findViewById(R.id.edusr);
        result=(TextView)findViewById(R.id.tvResult);
        //

        regbtn.setEnabled(false);
        //添加编辑框文本改变监听事件
        edusr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //改变时
                if(edusr.length()!=0){
                    regbtn.setEnabled(true);
                }else {
                    regbtn.setEnabled(false);
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //改变前
            }

            @Override
            public void afterTextChanged(Editable s) {
                //改变后
            }
        });


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("用户名是:"+edusr.getText()+"密码是:"+edpwd.getText());

            }
        });


    }
}
