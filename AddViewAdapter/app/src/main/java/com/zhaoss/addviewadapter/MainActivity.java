package com.zhaoss.addviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] datas = {"中文", "英语", "韩语", "日语", "法语", "德语", "俄语", "西班牙", "阿拉伯"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = new ArrayList<>();
        for (String str : datas){
            list.add(str);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //你的适配器要继承BaseRecyclerViewAdapter
        MyAdapter myAdapter = new MyAdapter(this, list);

        myAdapter.addHeadView(View.inflate(this, R.layout.item_adapter, null));//如果使用了addHeadView方法,必须要重写BaseRecyclerViewAdapter的setHeadViewHolder方法
        myAdapter.addHeadView(View.inflate(this, R.layout.item_adapter, null));
        myAdapter.addFootView(View.inflate(this, R.layout.item_adapter, null));//如果使用了addFootView方法,必须要重写BaseRecyclerViewAdapter的setFootViewHolder方法

        recyclerView.setAdapter(myAdapter);
    }
}
