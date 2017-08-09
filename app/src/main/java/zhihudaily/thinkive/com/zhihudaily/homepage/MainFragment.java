package zhihudaily.thinkive.com.zhihudaily.homepage;
/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.homepage
 *  @文件名:   MainFragment
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/8 0008 22:07
 *  @描述：    TODO
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zhihudaily.thinkive.com.zhihudaily.R;
import zhihudaily.thinkive.com.zhihudaily.adapter.MainPagerAdapter;

public class MainFragment extends Fragment {
    private TabLayout tabLayout;
    private ZhihuDailyFragment zhihuDailyFragment;
    private GuokrFragment guokrFragment;
    private DoubanMomentFragment doubanMomentFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        Context context = getContext();
        // TODO: 2017/8/9 0009 fragment 怎么传入adapter中
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getChildFragmentManager(), context, zhihuDailyFragment,guokrFragment, doubanMomentFragment);
        viewPager.setAdapter(mainPagerAdapter);
    }
}
