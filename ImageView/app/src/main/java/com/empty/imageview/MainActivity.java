package com.empty.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView show;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.my_layout);
        show = (ImageView) findViewById(R.id.show);
      final int [] image = new int[]{R.drawable.timo,R.drawable.gir,R.drawable.back,R.drawable.gir2};
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            int count=0;
            @Override
            public void onClick(View v) {
                if(count==image.length){
                    count=0;
                }else{
                    show.setImageResource(image[count++]);
                }

            }
        });

//        show.setImageResource(R.drawable.timo)
//
// ;
    }
}
