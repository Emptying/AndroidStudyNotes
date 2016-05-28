package com.empty.aswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch st;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.my_layout);
        st = (Switch) findViewById(R.id.switch1);
        layout = (LinearLayout) findViewById(R.id.layout);
        st.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    layout.setOrientation(LinearLayout.HORIZONTAL);
                }else{
                    layout.setOrientation(LinearLayout.VERTICAL);
                }

            }
        });
    }
}
