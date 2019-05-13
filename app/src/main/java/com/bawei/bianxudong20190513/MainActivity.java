package com.bawei.bianxudong20190513;

import android.widget.ListView;

import com.bawei.bianxudong20190513.adapter.ShowAdapter;
import com.bawei.bianxudong20190513.base.BaseActivity;
import com.bawei.bianxudong20190513.bean.ShowBean;
import com.bawei.bianxudong20190513.mvp.INewContract;
import com.bawei.bianxudong20190513.mvp.NewPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements INewContract.INewView {
     private ListView listView;
     private List<ShowBean.Items> list=new ArrayList<>();
    private INewContract.INewPresenter presenter;
    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initControl() {
     listView=findViewById(R.id.listView);
    }

    @Override
    public void initData() {
       presenter=new NewPresenter();
       presenter.attach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void showList(String result) {
        presenter.show("https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt");

        Gson gson=new Gson();
        ShowBean showBean = gson.fromJson(result, ShowBean.class);
        list.addAll(showBean.items);
        listView.setAdapter(new ShowAdapter(list,MainActivity.this));
    }
}
