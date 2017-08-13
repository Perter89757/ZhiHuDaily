package zhihudaily.thinkive.com.zhihudaily.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import zhihudaily.thinkive.com.zhihudaily.R;
import zhihudaily.thinkive.com.zhihudaily.bean.ZhihuDailyNews;

/**
 * author: huang_yanhui
 * data:2017/8/13
 * time:14:22
 * emaill:huangyh@thinkive.com
 * description:
 */

public class ZhihuDailyNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ZhihuDailyNews zhihuDailyNews = new ZhihuDailyNews();
    private int FootView = 1;


    public ZhihuDailyNewsAdapter(Context context) {
        mContext = context;
    }

    public void setData(ZhihuDailyNews zhihuDailyNewsBean) {
        zhihuDailyNews = zhihuDailyNewsBean;
    }

    public ZhihuDailyNews getData() {
        return zhihuDailyNews;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FootView) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.list_footer, parent, false);
            FootViewHolder footViewHolder = new FootViewHolder(view);
            return footViewHolder;
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.home_list_item_layout, parent, false);
            zhihuViewHodler zhihuViewHodler = new zhihuViewHodler(view);
            return zhihuViewHodler;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof zhihuViewHodler) {
            ArrayList<ZhihuDailyNews.Question> list = zhihuDailyNews.getStories();
            if (list != null) {
                ((zhihuViewHodler) holder).title.setText(list.get(position).getTitle());
                Glide.with(mContext)
                        .load(list.get(position).getImages().get(0))
                        .placeholder(R.drawable.placeholder)
                        .error(R.drawable.placeholder)
                        .into(((zhihuViewHodler) (holder)).itemImage);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == zhihuDailyNews.getStories().size()) {
            return FootView;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return zhihuDailyNews.getStories().size() + 1;
    }

    class zhihuViewHodler extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView itemImage;

        public zhihuViewHodler(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            title = (TextView) itemView.findViewById(R.id.textViewTitle);
            itemImage = (ImageView) itemView.findViewById(R.id.imageViewCover);
        }
    }

    class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }


}
