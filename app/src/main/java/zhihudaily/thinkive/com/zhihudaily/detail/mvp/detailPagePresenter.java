package zhihudaily.thinkive.com.zhihudaily.detail.mvp;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.detail.mvp
 *  @文件名:   detailPagePresenter
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/14 0014 22:44
 *  @描述：    TODO
 */

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import zhihudaily.thinkive.com.zhihudaily.R;

public class detailPagePresenter implements detailPageContract.detailPagePresenter {
    private Context mContext;

    public detailPagePresenter(Context context) {
        mContext = context;
    }

    @Override
    public void showImageView(ImageView view, String url) {
        if (url == null) {
            view.setImageResource(R.drawable.placeholder);
            return;
        }
        Glide.with(mContext)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(view);
    }
}
