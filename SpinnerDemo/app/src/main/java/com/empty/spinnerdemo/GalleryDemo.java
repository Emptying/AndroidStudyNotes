package com.empty.spinnerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.zip.Inflater;

/**
 * Created by cws10 on 2016/5/27.
 */
public class GalleryDemo extends Activity{
    Gallery gallery;
    int [] res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        gallery = (Gallery)findViewById(R.id.gallery);
        res = new int []{R.drawable.timo1,R.drawable.timo2,R.drawable.timo3};
        gallery.setAdapter(new Adapter());

    }

    private class Adapter  extends BaseAdapter{

        @Override
        public int getCount() {
            return res.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            Holders  holders;
            if(view==null){
                LayoutInflater inflater=getLayoutInflater();
                view=inflater.inflate(R.layout.gallery_item,parent,false);
                holders = new Holders(view);
                view.setTag(holders);
            }else {
                holders = (Holders) view.getTag();
            }

            ImageView imageView = holders.getImageView();
            imageView.setImageResource(res[position]);
            return view;
        }
    }

    private class Holders{
        ImageView imageView;
        View view;
        public Holders(View view){
            this.view = view;
        }
        public ImageView getImageView(){
            if(imageView==null){
                imageView = (ImageView) view.findViewById(R.id.imageView);
            }
            return imageView;
        }
    }

}
