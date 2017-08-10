package zhihudaily.thinkive.com.zhihudaily.homepage;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.homepage
 *  @文件名:   DoubanMomentFragment
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/8 0008 22:38
 *  @描述：    TODO
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zhihudaily.thinkive.com.zhihudaily.R;

public class DoubanMomentFragment extends Fragment {

    private TextView markTv;

    public static DoubanMomentFragment newInstance() {
        return new DoubanMomentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        markTv = (TextView) view.findViewById(R.id.markTV);
        markTv.setText("douban");
        return view;
    }
}
