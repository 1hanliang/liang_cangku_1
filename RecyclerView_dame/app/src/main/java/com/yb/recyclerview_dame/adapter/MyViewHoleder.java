package com.yb.recyclerview_dame.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yb.recyclerview_dame.R;

/**
 * Created by 亮 on 2016/12/27.
 */

public class MyViewHoleder extends RecyclerView.ViewHolder{

    TextView textView;


    public MyViewHoleder(View itemView) {
        super(itemView);


        textView= (TextView) itemView.findViewById(R.id.textView);
    }
}
