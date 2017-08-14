package zhihudaily.thinkive.com.zhihudaily.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.ImageView;

import zhihudaily.thinkive.com.zhihudaily.R;
import zhihudaily.thinkive.com.zhihudaily.detail.mvp.detailPagePresenter;

public class DetailActivity extends AppCompatActivity {

    private SwipeRefreshLayout refreshLayout;
    private WebView webView;
    private ImageView imageView;
    private detailPagePresenter presenter;
    private String coverUrl;
    private Toolbar toolbar;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        presenter = new detailPagePresenter(this);
        initData();
        initView();

    }

    private void initView() {
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        webView = (WebView) findViewById(R.id.web_view);
        imageView = (ImageView) findViewById(R.id.image_view);
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        presenter.showImageView(imageView, coverUrl);
        toolbar.setTitle(title);

    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String type = intent.getStringExtra("type");
            String id = intent.getStringExtra("id");
            title = intent.getStringExtra("title");
            coverUrl = intent.getStringExtra("coverUrl");
        }
    }
}
