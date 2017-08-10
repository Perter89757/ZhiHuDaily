package zhihudaily.thinkive.com.zhihudaily.homepage.zhihu;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.homepage.zhihu
 *  @文件名:   ZhihuDailyPresenter
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/10 0010 23:12
 *  @描述：    TODO
 */

import zhihudaily.thinkive.com.zhihudaily.CallBack;

public class ZhihuDailyPresenter implements ZhihuDailyContract.ZhihuDailyPresenter {
    private ZhihuDailyContract.ZhihuDailyView view;
    private final ZhihuDailyContract.ZhihuDailyModle modle;

    public ZhihuDailyPresenter(ZhihuDailyContract.ZhihuDailyView view) {
        this.view = view;
        modle = new ZhihuDailyContract.ZhihuDailyModle();
    }

    @Override
    public void loadData() {
        view.showLoading();
        modle.load(new CallBack() {
            @Override
            public void onError() {
                view.loadError();
            }

            @Override
            public void onSuccess() {
                view.loadSccuess();
            }
        });
        view.hideLoading();

    }
}
