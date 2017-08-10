package zhihudaily.thinkive.com.zhihudaily.homepage.zhihu;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.homepage.zhihu
 *  @文件名:   ZhihuDailyPresenter
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/10 0010 23:12
 *  @描述：    TODO
 */

public class ZhihuDailyPresenter implements ZhihuDailyContract.ZhihuDailyPresenter {
    private ZhihuDailyContract.ZhihuDailyView view;
    public ZhihuDailyPresenter(ZhihuDailyContract.ZhihuDailyView view) {
        this.view = view;
    }

    @Override
    public void loadData() {

    }
}
