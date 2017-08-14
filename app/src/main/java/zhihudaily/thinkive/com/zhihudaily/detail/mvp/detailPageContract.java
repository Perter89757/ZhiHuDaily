package zhihudaily.thinkive.com.zhihudaily.detail.mvp;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.detail.mvp
 *  @文件名:   detailPageContract
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/14 0014 22:33
 *  @描述：    TODO
 */

import android.widget.ImageView;

import zhihudaily.thinkive.com.zhihudaily.BasePresenter;
import zhihudaily.thinkive.com.zhihudaily.BaseView;

public interface detailPageContract {
    interface detailPageView extends BaseView{

    }

    interface detailPagePresenter extends BasePresenter{
       void showImageView(ImageView view, String url);
    }
}
