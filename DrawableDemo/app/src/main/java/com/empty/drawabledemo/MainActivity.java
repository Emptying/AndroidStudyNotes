package com.empty.drawabledemo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

//    ImageView image;
//    Button btn;
    ImageView image2;
    Button btnPrev,btnNext;
    int [] res;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
//        image = (ImageView)findViewById(R.id.imageView);
//        btn = (Button)findViewById(R.id.button);
//        final Drawable drawable = getResources().getDrawable(R.drawable.timo2);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                image.setImageDrawable(drawable);
//            }
//        });
        res = new int[]{R.drawable.backup,R.drawable.gir,R.drawable.gir2,R.drawable.timo1,R.drawable.timo2};
        image2 = (ImageView)findViewById(R.id.imageView2);
        btnNext = (Button)findViewById(R.id.btnNext);
        btnPrev = (Button)findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(new OnClickListener());
        btnNext.setOnClickListener(new OnClickListener());
    }
    private class OnClickListener implements  View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(count==res.length){
                count=0;

            }
            switch (v.getId()){
                case R.id.btnNext:
                    if(count<=res.length){
                        image2.setImageResource(res[count++]);
                    }
                    break;
                case R.id.btnPrev:
                    if(count>0){
                        image2.setImageResource(res[count++]);
                    }
                    break;
            }
        }
    }
}
