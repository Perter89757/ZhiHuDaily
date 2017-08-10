package zhihudaily.thinkive.com.zhihudaily.homepage.zhihu;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.homepage.zhihu
 *  @文件名:   ZhihuDailyContract
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/10 0010 23:01
 *  @描述：    TODO
 */

import zhihudaily.thinkive.com.zhihudaily.BaseModle;
import zhihudaily.thinkive.com.zhihudaily.BasePresenter;
import zhihudaily.thinkive.com.zhihudaily.BaseView;
import zhihudaily.thinkive.com.zhihudaily.CallBack;

public interface ZhihuDailyContract {
    interface ZhihuDailyView extends BaseView {

    }

    interface ZhihuDailyPresenter extends BasePresenter {

    }

    class ZhihuDailyModle implements BaseModle {

        @Override
        public void load(CallBack callBack) {

        }
    }


}
