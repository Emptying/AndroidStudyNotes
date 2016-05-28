package com.empty.timo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OverActivity extends AppCompatActivity {


    Button btnOk;
    EditText  etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);
        btnOk = (Button) findViewById(R.id.btnOk);
        etName = (EditText) findViewById(R.id.etName);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toString 转换字符串
                //trim 忽略前后空格
                //isEmpty 判断是不是空
                if(etName.getText().toString().trim().isEmpty()){
                    Toast.makeText(OverActivity.this, "请输入玩家姓名", Toast.LENGTH_SHORT).show();
                    return;
                }
                finish();
            }
        });

    }
}
