package com.bawei.bianxudong20190513.net;

import android.os.AsyncTask;

import com.google.common.io.CharStreams;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/13 8:58
 * @Description：描述信息
 */
public class HttpUtil {
    private static final HttpUtil ourInstance = new HttpUtil();

    public static HttpUtil getInstance() {
        return ourInstance;
    }

    private HttpUtil() {

    }

    public  void doHttpGet(String url, final CallBack callBack){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url1=new URL(strings[0]);
                    HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    if(connection.getResponseCode()==200){
                     return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                callBack.onSuccess(s);
            }
        }.execute(url);
    }
}
