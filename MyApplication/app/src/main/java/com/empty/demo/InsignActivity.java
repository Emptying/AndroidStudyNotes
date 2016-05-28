package com.empty.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insign);
        Button save = (Button) findViewById(R.id.save);
        //注册按钮
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InSign();
            }
        });

    }

    public void InSign() {
        String name = ((EditText) findViewById(R.id.name)).getText().toString();
        String pwd1 = ((EditText) findViewById(R.id.pwd1)).getText().toString();
        String pwd2 = ((EditText) findViewById(R.id.pwd2)).getText().toString();
        String msg;

        if (name.isEmpty()) {
            msg = "请填写用户名";
        } else if (pwd1.isEmpty()) {
            msg = "请填写密码";
        } else if (pwd2.isEmpty()) {
            msg = "请再次填写密码";
        } else if (!pwd1.equals(pwd2)) {
            msg = "两次输入密码不一致请重新输入";
        } else  {//准备注册
            String pwd = DbHellper.Md5(pwd1);
            if (DbHellper.Add(new Student(name, pwd)) == true) {
                msg = "添加成功";
                startActivity(new Intent(InsignActivity.this, LoginActivity.class));
                InsignActivity.this.finish();
            } else {
                msg ="用户已经存在";
            }
        }
        if(!msg.isEmpty()){
            Toast.makeText(InsignActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
