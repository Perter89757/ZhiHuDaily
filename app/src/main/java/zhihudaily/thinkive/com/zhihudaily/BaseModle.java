package zhihudaily.thinkive.com.zhihudaily;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily
 *  @文件名:   BaseModle
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/10 0010 23:22
 *  @描述：    TODO
 */

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import zhihudaily.thinkive.com.zhihudaily.bean.ZhihuDailyNews;

public class BaseModle {
    //请求网络
    public void zhiHuLoadData(String url, final CallBack callBack) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                callBack.onError(request, e);
            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ZhihuDailyNews zhihuDailyNews = gson.fromJson(response, ZhihuDailyNews.class);
                callBack.onSuccess(zhihuDailyNews);
            }
        });
    }

    public void zhihuLoadMore(String url,final  CallBack callBack){
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                callBack.onError(request, e);
            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ZhihuDailyNews zhihuDailyNews = gson.fromJson(response, ZhihuDailyNews.class);
                callBack.onSuccess(zhihuDailyNews);
            }
        });
    }

}
