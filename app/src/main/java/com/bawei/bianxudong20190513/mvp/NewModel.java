package com.bawei.bianxudong20190513.mvp;

import com.bawei.bianxudong20190513.net.CallBack;
import com.bawei.bianxudong20190513.net.HttpUtil;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/13 9:11
 * @Description：描述信息
 */
public class NewModel implements INewContract.INewModel {
    private HttpUtil httpUtil;
    /*public static HttpUtil{
        httpUtil=HttpUtil.getInstance();
    }*/
    @Override
    public void show(String url, CallBack callBack) {
       String path="https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt";
       httpUtil.doHttpGet(path,callBack);
    }
}
