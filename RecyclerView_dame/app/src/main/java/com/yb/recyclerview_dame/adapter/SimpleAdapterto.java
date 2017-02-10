package com.yb.recyclerview_dame.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.yb.recyclerview_dame.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 亮 on 2016/12/27.
 */
public class SimpleAdapterto extends RecyclerView.Adapter<MyViewHoleder> {


    private LayoutInflater minflater;

    private Context context;

    private List<String> mDate;


    private List<Integer> mHeights;


    public interface OnItemClickListener {

        void onitemclick(View view, int position);

        void onitemlongclick(View view, int position);

    }
    private OnItemClickListener monItemClickListener;

    public void setonitemclick(OnItemClickListener listener) {

        this.monItemClickListener = listener;
    }


    public SimpleAdapterto(Context context, List<String> mDate) {

        this.context = context;
        this.mDate = mDate;

        minflater = LayoutInflater.from(context);

        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < mDate.size(); i++) {

            mHeights.add((int) (100 + Math.random() * 300));
        }
    }


    @Override
    public int getItemCount() {
        return mDate.size();
    }


    //创建ViewHolder
    @Override
    public MyViewHoleder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = minflater.inflate(R.layout.item_recycler, parent, false);

        MyViewHoleder viewHoleder = new MyViewHoleder(view);
        return viewHoleder;
    }


    //绑定ViewHilder数据
    @Override
    public void onBindViewHolder(final MyViewHoleder holder, final int position) {


        //赋值随机高度
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.itemView.setLayoutParams(lp);


        holder.textView.setText(mDate.get(position));


        if (monItemClickListener != null) {


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //获取屏幕上的位置
                    int lood = holder.getAdapterPosition();
                    monItemClickListener.onitemclick(holder.itemView, lood);


                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //获取屏幕上的位置
                    int lood = holder.getAdapterPosition();
                    monItemClickListener.onitemlongclick(holder.itemView, lood);

                    return true;
                }
            });


        }
    }


    //添加item
    public void addDate(int pos) {


        mDate.add(pos, "添加一个");
//        notifyDataSetChanged();
        notifyItemInserted(pos);
    }


    //删除item
    public void deleteDeat(int pos) {
        mDate.remove(pos);
        notifyItemRemoved(pos);
    }


}
