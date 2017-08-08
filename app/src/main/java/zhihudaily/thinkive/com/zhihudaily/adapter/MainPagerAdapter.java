package zhihudaily.thinkive.com.zhihudaily.adapter;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.adapter
 *  @文件名:   MainPagerAdapter
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/8 0008 22:24
 *  @描述：    ViewPage的adapter
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import zhihudaily.thinkive.com.zhihudaily.R;
import zhihudaily.thinkive.com.zhihudaily.homepage.DoubanMomentFragment;
import zhihudaily.thinkive.com.zhihudaily.homepage.GuokrFragment;
import zhihudaily.thinkive.com.zhihudaily.homepage.ZhihuDailyFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final ZhihuDailyFragment zhihuDailyFragment;
    private final GuokrFragment guokrFragment;
    private final DoubanMomentFragment doubanMomentFragment;
    private final String[] titles;

    public MainPagerAdapter(FragmentManager fm, Context context, ZhihuDailyFragment zhihuDailyFragment, GuokrFragment guokrFragment, DoubanMomentFragment doubanMomentFragment) {
        super(fm);
        titles = new String[]{
                context.getResources().getString(R.string.zhihu_daily),
                context.getResources().getString(R.string.guokr_handpick),
                context.getResources().getString(R.string.douban_moment)
        };

        this.zhihuDailyFragment = zhihuDailyFragment;
        this.guokrFragment = guokrFragment;
        this.doubanMomentFragment = doubanMomentFragment;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            //果壳
            return guokrFragment;
        } else if (position == 2) {
            //豆瓣
            return doubanMomentFragment;
        }
            //知乎
        return zhihuDailyFragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
