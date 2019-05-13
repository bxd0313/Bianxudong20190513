package com.bawei.bianxudong20190513.mvp;

import com.bawei.bianxudong20190513.net.CallBack;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/13 9:06
 * @Description：
 *
 * 契约接口
 */
public interface INewContract {
    public interface INewView{
        void showList(String result);
    }
    public interface INewModel{
        void show(String url, CallBack callBack);
    }
    public interface INewPresenter{
        void attach(INewView view);
        void detach();
        void show(String url);
    }
}
