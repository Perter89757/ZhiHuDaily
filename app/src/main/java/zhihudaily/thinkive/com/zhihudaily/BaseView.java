package zhihudaily.thinkive.com.zhihudaily;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily
 *  @文件名:   BaseView
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/10 0010 23:04
 *  @描述：    TODO
 */

public interface BaseView {
    void showLoading();

    void hideLoading();

    void loadError();

    void loadSccuess();
}
