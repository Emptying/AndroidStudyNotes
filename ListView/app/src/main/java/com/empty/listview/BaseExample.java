package com.empty.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cws10 on 2016/5/27.
 */
public class BaseExample extends Activity {
    ArrayList<Books> list;
    ListView lvShowBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_example_activity);
        list = new ArrayList<>();
        fill();
        lvShowBook = (ListView)findViewById(R.id.lvShowBook);
        lvShowBook.setAdapter(new BaseAdapters());
    }
    public void fill(){
        list.add(new Books("疯狂java讲义","李刚",108.0));
        list.add(new Books("疯狂Android讲义","李刚",98.0));
        list.add(new Books("疯狂XML讲义","李刚",79.0));
    }

    class BaseAdapters extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
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
            View view;

            //1.利用convertView提升效率
            view = convertView;
            //持有者
            //2.利用持有者方式提升效率
            Holders holders=null;
            if(view==null){
                LayoutInflater inflater=getLayoutInflater();
                view= inflater.inflate(R.layout.base_example_item,parent,false);
                //新建持有者
                holders = new Holders(view);
                //把view缓存到持有者
                view.setTag(holders);
            }else{
                holders= (Holders) view.getTag();
            }
            TextView BookName= holders.getBookName();
            TextView Author = holders.getAuthor();
            TextView Price = holders.getPrice();

            Books book=list.get(position);
            BookName.setText(book.getBookName());
            Author.setText(book.getAuthor());
            Price.setText(String.valueOf(book.getPrice()));
            return view;
        }
    }
    //持有者
    private class Holders{
        TextView BookName;
        TextView Author;
        TextView Price;
        View view;
        public Holders(View view){
            this.view = view;
        }
        public TextView getBookName(){
            if(BookName==null){
                BookName= (TextView) view.findViewById(R.id.tvBookName);
            }
            return BookName;
        }
        public TextView getAuthor(){
            if(Author==null){
                Author= (TextView) view.findViewById(R.id.tvAuthor);
            }
            return Author;
        }
        public TextView getPrice(){
            if(Price==null){
                Price= (TextView) view.findViewById(R.id.tvPrice);
            }
            return Price;
        }

    }
}

