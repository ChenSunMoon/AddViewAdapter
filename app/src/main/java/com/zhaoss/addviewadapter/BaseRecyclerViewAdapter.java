package com.zhaoss.addviewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhaoss on 2016/2/18.
 * 可以add头部和add尾部的RecyclerView适配器
 */
public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter {

    /** 尾部View的总数 */
    private int footViewCount;
    /** 头部View的总数 */
    private int headViewCount;
    public List list;
    /** 头部View的list */
    public List<View> footViewList;
    /** 尾部View的list */
    public List<View> headViewList;
    private final int TYPE_BODY = 101;
    private final int TYPE_HEAD = 102;
    private final int TYPE_FOOT = 103;
    /** 在绑定时当前尾部View的id */
    public int currentFootViewId;
    /** 在绑定时当前头部View的id  */
    public int currentHeadViewId;

    public BaseRecyclerViewAdapter(List list){
        this.list = list;
        footViewList = new ArrayList();
        headViewList = new ArrayList();
    }

    @Override
    public int getItemViewType(int position) {
        if(footViewCount>0 && position>list.size()-1+headViewCount){
            return TYPE_FOOT;
        }else if(headViewCount>0 && position<headViewCount){
            return TYPE_HEAD;
        }
        return TYPE_BODY;
    }

    /** 设置尾部的ViewHolder
     * @param viewGroup
     */
    public RecyclerView.ViewHolder setFootViewHolder(ViewGroup viewGroup, View footView){
        return null;
    }

    /** 设置头部的ViewHolder
     * @param viewGroup
     */
    public RecyclerView.ViewHolder setHeadViewHolder(ViewGroup viewGroup, View headView){
        return null;
    }

    public abstract void onBindBodyViewHolder(RecyclerView.ViewHolder viewHolder, int position);

    /**
     * 绑定脚View时调用的ViewHolder
     */
    public void onBindFootViewHolder(RecyclerView.ViewHolder viewHolder, int position){}

    /**
     * 绑定头View时调用的ViewHolder
     */
    public void onBindHeadViewHolder(RecyclerView.ViewHolder viewHolder, int position){}

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case TYPE_FOOT:
                onBindFootViewHolder(viewHolder, i);
                break;
            case TYPE_HEAD:
                onBindHeadViewHolder(viewHolder, i);
                break;
            case TYPE_BODY:
                onBindBodyViewHolder(viewHolder, i-currentHeadViewId);
                break;
        }
    }

    /** 设置内容体的ViewHolder
     * @param viewGroup
     */
    public abstract RecyclerView.ViewHolder setBodyViewHolder(ViewGroup viewGroup);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if(i == TYPE_FOOT){
            return setFootViewHolder(viewGroup, footViewList.get(currentFootViewId++));
        }else if(i == TYPE_HEAD){
            return setHeadViewHolder(viewGroup, headViewList.get(currentHeadViewId++));
        }else{
            return setBodyViewHolder(viewGroup);
        }
    }

    /**
     * 添加尾部View
     */
    public void addFootView(View view){
        footViewList.add(view);
        footViewCount++;
    }

    /**
     * 添加头部View
     */
    public void addHeadView(View view){
        headViewList.add(view);
        headViewCount++;
    }

    @Override
    public int getItemCount() {
        return list.size()+headViewCount+footViewCount;
    }
}
