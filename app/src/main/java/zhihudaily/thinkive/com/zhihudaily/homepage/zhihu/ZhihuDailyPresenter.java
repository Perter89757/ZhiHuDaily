package zhihudaily.thinkive.com.zhihudaily.homepage.zhihu;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.homepage.zhihu
 *  @文件名:   ZhihuDailyPresenter
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/10 0010 23:12
 *  @描述：    TODO
 */

import android.util.Log;

import com.squareup.okhttp.Request;

import zhihudaily.thinkive.com.zhihudaily.BaseModle;
import zhihudaily.thinkive.com.zhihudaily.CallBack;
import zhihudaily.thinkive.com.zhihudaily.bean.ZhihuDailyNews;
import zhihudaily.thinkive.com.zhihudaily.util.Api;
import zhihudaily.thinkive.com.zhihudaily.util.DateFormatter;

public class ZhihuDailyPresenter implements ZhihuDailyContract.ZhihuDailyPresenter {
    private ZhihuDailyContract.ZhihuDailyView view;
    private final BaseModle request;
    private DateFormatter formatter = new DateFormatter();
    public ZhihuDailyPresenter(ZhihuDailyContract.ZhihuDailyView view) {
        this.view = view;
        this.view.setPresenter(this);
        request = new BaseModle();
    }

    @Override
    public void loadData(long date) {
        view.showLoading();
        Log.d("ZhihuDailyFragment","loadData");
        String url = Api.ZHIHU_HISTORY+formatter.ZhihuDailyDateFormat(date);
        request.zhiHuLoadData(url, new CallBack<ZhihuDailyNews>() {
            @Override
            public void onError(Request request, Exception e) {
                view.loadError();
                view.hideLoading();
            }

            @Override
            public void onSuccess(ZhihuDailyNews bean) {
                view.loadSccuess(bean);
                view.hideLoading();
            }

        });
    }

    @Override
    public void loadMore(long date) {
        view.showLoading();
        Log.d("ZhihuDailyFragment","loadMore");
        String url = Api.ZHIHU_HISTORY+formatter.ZhihuDailyDateFormat(date);
        request.zhihuLoadMore(url, new CallBack<ZhihuDailyNews>() {
            @Override
            public void onError(Request request, Exception e) {
                view.loadError();
                view.hideLoading();
            }

            @Override
            public void onSuccess(ZhihuDailyNews bean) {
                view.loadSccuess(bean);
                view.hideLoading();
            }
        });
    }
}
