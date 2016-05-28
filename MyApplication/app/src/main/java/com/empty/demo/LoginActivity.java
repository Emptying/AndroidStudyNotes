package com.empty.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button insign = (Button) findViewById(R.id.insign);
        Button login = (Button) findViewById(R.id.login);
        //登陆按钮
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        //注册按钮
        insign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,InsignActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });

    }

    public void login(){
        EditText username = (EditText) findViewById(R.id.username);
        EditText userpwd = (EditText) findViewById(R.id.userpwd);
       String name=username.getText().toString();
       String pwd=userpwd.getText().toString();
        if(name.equals("")){
            Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
        }else if(name.equals("")!=true&&pwd.equals("")){
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
        }else if(name.equals("")==false&&pwd.equals("")==false){
           pwd= DbHellper.Md5(pwd);
            if(DbHellper.VerifyUser(name,pwd)!=null){
                //登陆成功
                Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,ShowActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("student",DbHellper.VerifyUser(name,pwd));
                intent.putExtras(bundle);
                startActivity(intent);
                LoginActivity.this.finish();

            }else{
                //登陆失败
                Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
