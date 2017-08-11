package zhihudaily.thinkive.com.zhihudaily;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily
 *  @文件名:   CallBack
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/10 0010 23:26
 *  @描述：    TODO
 */

import com.squareup.okhttp.Request;

public interface CallBack<T> {
    void onError(Request request,Exception e);

    void onSuccess(T t);
}
