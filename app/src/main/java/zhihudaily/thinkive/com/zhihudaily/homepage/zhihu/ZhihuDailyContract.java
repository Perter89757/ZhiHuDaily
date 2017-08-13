package zhihudaily.thinkive.com.zhihudaily.homepage.zhihu;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.homepage.zhihu
 *  @文件名:   ZhihuDailyContract
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/10 0010 23:01
 *  @描述：    TODO
 */

import zhihudaily.thinkive.com.zhihudaily.BasePresenter;
import zhihudaily.thinkive.com.zhihudaily.BaseView;

public interface ZhihuDailyContract {
    interface ZhihuDailyView<ZhihuDailyNews> extends BaseView {
        void setPresenter(zhihudaily.thinkive.com.zhihudaily.homepage.zhihu.ZhihuDailyPresenter presenter);
        zhihudaily.thinkive.com.zhihudaily.homepage.zhihu.ZhihuDailyPresenter getPersenter();
    }

    interface ZhihuDailyPresenter extends BasePresenter {

    }

}
