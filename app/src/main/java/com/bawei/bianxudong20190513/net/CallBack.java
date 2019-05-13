package com.bawei.bianxudong20190513.net;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/13 8:57
 * @Description：描述信息
 */
public interface CallBack {
    void onSuccess(String result);
    void onError(String msg);
}
