package zhihudaily.thinkive.com.zhihudaily.homepage.zhihu;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.homepage.zhihu
 *  @文件名:   ZhihuDailyPresenter
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/10 0010 23:12
 *  @描述：    TODO
 */

import com.squareup.okhttp.Request;

import zhihudaily.thinkive.com.zhihudaily.BaseModle;
import zhihudaily.thinkive.com.zhihudaily.CallBack;
import zhihudaily.thinkive.com.zhihudaily.bean.ZhihuDailyNews;

public class ZhihuDailyPresenter implements ZhihuDailyContract.ZhihuDailyPresenter {
    private ZhihuDailyContract.ZhihuDailyView view;
    private final BaseModle request;

    public ZhihuDailyPresenter(ZhihuDailyContract.ZhihuDailyView view) {
        this.view = view;
        request = new BaseModle();
    }

    @Override
    public void loadData() {
        view.showLoading();
       request.zhiHuLoadData("", new CallBack<ZhihuDailyNews>() {
            @Override
            public void onError(Request request, Exception e) {
                view.loadError();
            }

           @Override
           public void onSuccess(ZhihuDailyNews bean) {
               view.loadSccuess();
           }

        });
        view.hideLoading();

    }
}
