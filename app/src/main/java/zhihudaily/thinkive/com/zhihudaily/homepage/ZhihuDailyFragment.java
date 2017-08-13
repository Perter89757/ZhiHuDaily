package zhihudaily.thinkive.com.zhihudaily.homepage;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.homepage
 *  @文件名:   ZhihuDailyFragment
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/8 0008 22:36
 *  @描述：    TODO
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

import zhihudaily.thinkive.com.zhihudaily.R;
import zhihudaily.thinkive.com.zhihudaily.adapter.ZhihuDailyNewsAdapter;
import zhihudaily.thinkive.com.zhihudaily.bean.ZhihuDailyNews;
import zhihudaily.thinkive.com.zhihudaily.homepage.zhihu.ZhihuDailyContract;
import zhihudaily.thinkive.com.zhihudaily.homepage.zhihu.ZhihuDailyPresenter;

public class ZhihuDailyFragment extends Fragment implements ZhihuDailyContract.ZhihuDailyView<ZhihuDailyNews>, SwipeRefreshLayout.OnRefreshListener {

    private ZhihuDailyPresenter dailyPresenter;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refresh;
    private ZhihuDailyNewsAdapter zhihuDailyNewsAdapter;

    private int mYear = Calendar.getInstance().get(Calendar.YEAR);
    private int mMonth = Calendar.getInstance().get(Calendar.MONTH);
    private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);


    public static ZhihuDailyFragment newInstance() {
        return new ZhihuDailyFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        zhihuDailyNewsAdapter = new ZhihuDailyNewsAdapter(getContext());
        recyclerView.addOnScrollListener(new scrollListenter());

        refresh = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        refresh.setRefreshing(true);
        dailyPresenter.loadData(Calendar.getInstance().getTimeInMillis());
        refresh.setOnRefreshListener(this);
        return view;
    }

    class scrollListenter extends RecyclerView.OnScrollListener {
        boolean isSlidingToLast = false;
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            //不在滚动中
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                //是否到底最低部,最后item是否可见,并且是继续向下拉
                // 获取最后一个完全显示的item position
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                int totalItemCount = manager.getItemCount();
                // 判断是否滚动到底部并且是向下滑动
                if (lastVisibleItem == (totalItemCount - 1) && isSlidingToLast) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(mYear,mMonth,--mDay);
                    //加载更多
                    dailyPresenter.loadMore(calendar.getTimeInMillis());
                    //
                }
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            //往下拉的判断
            isSlidingToLast = dy > 0;
            //SwipeRefreshLayout和RecyclerView一起使用的时候,下拉冲突
            int topRowVerticalPosition = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
            refresh.setEnabled(topRowVerticalPosition >= 0);
        }
    }

    @Override
    public void showLoading() {
        Log.d("ZhihuDailyFragment", "加载中");
    }

    @Override
    public void hideLoading() {
        refresh.setRefreshing(false);
        Log.d("ZhihuDailyFragment", "隐藏加载中");
    }

    @Override
    public void loadError() {

    }

    @Override
    public void loadSccuess(Object o) {
        ZhihuDailyNews bean = (ZhihuDailyNews) o;
        zhihuDailyNewsAdapter.setData(bean);
        recyclerView.setAdapter(zhihuDailyNewsAdapter);
        Log.d("ZhihuDailyFragment", "加载完成,数据大小:"+bean.getStories().size());
    }

    @Override
    public void setPresenter(ZhihuDailyPresenter presenter) {
        dailyPresenter = presenter;
    }

    @Override
    public ZhihuDailyPresenter getPersenter() {
        return dailyPresenter;
    }

    @Override
    public void onRefresh() {
        //刷新
        dailyPresenter.loadData(Calendar.getInstance().getTimeInMillis());
    }
}
