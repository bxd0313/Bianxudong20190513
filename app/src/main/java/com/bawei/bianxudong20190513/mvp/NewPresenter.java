package com.bawei.bianxudong20190513.mvp;

import com.bawei.bianxudong20190513.net.CallBack;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/13 9:12
 * @Description：描述信息
 */
public class NewPresenter implements INewContract.INewPresenter {
    private INewContract.INewView view;
    private INewContract.INewModel model;
    @Override
    public void attach(INewContract.INewView view) {
        this.view=view;
        model=new NewModel();

    }

    @Override
    public void detach() {
       if(view!=null){
           view=null;
       }
       if(model!=null){
           model=null;
       }
    }

    @Override
    public void show(String url) {

        model.show(url, new CallBack() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
