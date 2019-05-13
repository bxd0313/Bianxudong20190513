package com.bawei.bianxudong20190513.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bianxudong20190513.R;
import com.bawei.bianxudong20190513.bean.ShowBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/13 9:27
 * @Description：描述信息
 */
public class ShowAdapter extends BaseAdapter {
     private List<ShowBean.Items> list;
     private Context context;

    public ShowAdapter(List<ShowBean.Items> list, Context context) {
        this.list = list;
        this.context = context;
    }

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
        switch(getItemViewType(position)){
            case 0:
                ViewHolder1 holder1;
                if(convertView==null){
                    convertView=View.inflate(context, R.layout.one,null);
                    holder1=new ViewHolder1();
                    holder1.imageView=convertView.findViewById(R.id.imageView);
                    holder1.textView=convertView.findViewById(R.id.textView);
                    convertView.setTag(holder1);
                }else{
                    holder1= (ViewHolder1) convertView.getTag();
                }
                holder1.textView.setText(list.get(position).title);
                Glide.with(context).load(list.get(position).image).into(holder1.imageView);
                break;
            case 1:
                ViewHolder2 holder2;
                if(convertView==null){
                    convertView=View.inflate(context, R.layout.two,null);
                    holder2=new ViewHolder2();
                    holder2.textView2=convertView.findViewById(R.id.textView2);
                    convertView.setTag(holder2);
                }else{
                    holder2= (ViewHolder2) convertView.getTag();
                }
                holder2.textView2.setText(list.get(position).title);
                break;
            case 2:
                ViewHolder3 holder3;
                if(convertView==null){
                    convertView=View.inflate(context, R.layout.three,null);
                    holder3=new ViewHolder3();
                    holder3.textView3=convertView.findViewById(R.id.textView3);
                    holder3.imageView3=convertView.findViewById(R.id.imageView3);
                    holder3.imageView4=convertView.findViewById(R.id.imageView4);
                    convertView.setTag(holder3);
                }else{
                    holder3= (ViewHolder3) convertView.getTag();
                }
                holder3.textView3.setText(list.get(position).title);
                Glide.with(context).load(list.get(position).image).into(holder3.imageView3);
                Glide.with(context).load(list.get(position).image).into(holder3.imageView4);
                break;

        }
        return convertView;
    }
class ViewHolder1{
        ImageView imageView;
        TextView textView;
}
    class ViewHolder2{
        TextView textView2;
    }
    class ViewHolder3{
        ImageView imageView3,imageView4;
        TextView textView3;
    }
    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }
}
