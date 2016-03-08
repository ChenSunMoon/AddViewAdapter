package com.zhaoss.addviewadapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Zhaoss on 2016/3/7.
 */
public class MyAdapter extends BaseRecyclerViewAdapter {

    private Activity activity;

    public MyAdapter(Activity activity, List list) {
        super(list);
        this.activity = activity;
    }

    @Override
    public void onBindBodyViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        MyViewHolder vh = (MyViewHolder) viewHolder;
        vh.textView.setText((String) list.get(position));
        vh.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "我是内容体", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder setBodyViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(View.inflate(activity, R.layout.item_adapter, null));
    }

    @Override
    public RecyclerView.ViewHolder setHeadViewHolder(ViewGroup viewGroup, View headView) {
        //返回的ViewHolder传入的必须是headView
        return new MyViewHolder(headView);
    }

    @Override
    public RecyclerView.ViewHolder setFootViewHolder(ViewGroup viewGroup, View footView) {
        //返回的ViewHolder传入的必须是footView
        return new MyViewHolder(footView);
    }

    @Override
    public void onBindHeadViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        MyViewHolder vh = (MyViewHolder) viewHolder;
        vh.textView.setText("我是头头头头头头头头");
        vh.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "我是头头头头头头头头", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBindFootViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        MyViewHolder vh = (MyViewHolder) viewHolder;
        vh.textView.setText("我是脚脚脚脚脚脚脚脚");
        vh.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "我是脚脚脚脚脚脚脚脚", Toast.LENGTH_LONG).show();
            }
        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
