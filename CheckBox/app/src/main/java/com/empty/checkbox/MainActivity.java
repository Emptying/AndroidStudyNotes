package com.empty.checkbox;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox  red,blue,green,bold,italic;
    EditText content;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.my_layout);
        red = (CheckBox) findViewById(R.id.red);
        blue = (CheckBox) findViewById(R.id.blue);
        green = (CheckBox) findViewById(R.id.green);
        btn = (Button) findViewById(R.id.button);
        bold = (CheckBox) findViewById(R.id.chkBold);
        italic = (CheckBox) findViewById(R.id.chkItalic);
        content = (EditText) findViewById(R.id.etContent);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
//                String str1="";
//                String str2="";
                if(red.isChecked()){
                    str+="红色";
                }
                if(blue.isChecked()){
                    str+="蓝色";
                }
                if(green.isChecked()){
                    str+="绿色";
                }
                Toast.makeText(MainActivity.this, "你选择的颜色是"+str, Toast.LENGTH_SHORT).show();
            }
        });
        CheckedChange listener = new CheckedChange();
        bold.setOnCheckedChangeListener(listener);
        italic.setOnCheckedChangeListener(listener);


    }
    class CheckedChange implements CompoundButton.OnCheckedChangeListener{
        int style = 0;

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch(buttonView.getId()){
                case R.id.chkBold:
                    if(isChecked){
                        style+=Typeface.BOLD;
                    }else{
                        style-=Typeface.BOLD;
                    }
                    break;
                case R.id.chkItalic:
                    if(isChecked){
                        style+=Typeface.ITALIC;
                    }else{
                        style-=Typeface.ITALIC;
                    }
                    break;
            }
            content.setTypeface(Typeface.DEFAULT,style);

        }
    }

}
