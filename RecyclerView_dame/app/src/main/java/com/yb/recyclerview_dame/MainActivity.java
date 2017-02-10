package com.yb.recyclerview_dame;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.yb.recyclerview_dame.adapter.SimpleAdapterto;
import com.yb.recyclerview_dame.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recycleView;


    private List<String> mDate;

    private SimpleAdapterto mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initDate();


        initview();


        mAdapter = new SimpleAdapterto(this, mDate);
        recycleView.setAdapter(mAdapter);

        //设置recycleview布局管理
//        LinearLayoutManager linear = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

//        recycleView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL));

        recycleView.setLayoutManager(new LinearLayoutManager(this));

        //设置动画效果
        recycleView.setItemAnimator(new DefaultItemAnimator());



        //设置recycyleview分隔线


//        recycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));





        mAdapter.setonitemclick(new SimpleAdapterto.OnItemClickListener() {
            @Override
            public void onitemclick(View view, int position) {
                Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onitemlongclick(View view, int position) {
                Toast.makeText(MainActivity.this,"长按",Toast.LENGTH_SHORT).show();
            }
        });






    }

    private void initDate() {


        mDate = new ArrayList<String>();


        for (int i = 'A'; i <= 'z'; i++) {

            mDate.add("" + (char) i);

        }
    }


    private void initview() {


        recycleView = (RecyclerView) findViewById(R.id.recycleView);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        switch (id) {
            case R.id.action_listview:
                recycleView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_gridview:
                recycleView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.action_gor_gridview:
                recycleView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_staggered:
                recycleView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL));
                break;

            case R.id.action_jia:
                mAdapter.addDate(1);
                break;

            case R.id.action_shan:
             mAdapter.deleteDeat(1);
                break;



        }
//        recycleView.setAdapter(mLoadMoreWrapper);

        return super.onOptionsItemSelected(item);
    }








}
