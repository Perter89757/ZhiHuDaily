package zhihudaily.thinkive.com.zhihudaily.bookmarks;

/*
 *  @项目名：  ZhiHuDaily 
 *  @包名：    zhihudaily.thinkive.com.zhihudaily.bookmarks
 *  @文件名:   BookmarksFragment
 *  @创建者:   HuangYanHui
 *  @创建时间:  2017/8/10 0010 22:05
 *  @描述：    TODO
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zhihudaily.thinkive.com.zhihudaily.R;

public class BookmarksFragment extends Fragment {
    public static BookmarksFragment newInstance() {
        return new BookmarksFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }
}
