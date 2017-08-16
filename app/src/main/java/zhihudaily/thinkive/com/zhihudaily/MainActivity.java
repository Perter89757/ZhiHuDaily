package zhihudaily.thinkive.com.zhihudaily;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import zhihudaily.thinkive.com.zhihudaily.about.AboutActivity;
import zhihudaily.thinkive.com.zhihudaily.homepage.MainFragment;
import zhihudaily.thinkive.com.zhihudaily.service.DownLoadService;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private MainFragment mainFragment;
    private DownLoadService.downBinder mservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //判断是否有系统保存的Fragment
        //判断Fragement是否add到activity中
        //没有add,就把fragment
        //显示隐藏Fragment


        if (savedInstanceState == null) {
            mainFragment = MainFragment.newInstance();
        } else {
            mainFragment = (MainFragment) getSupportFragmentManager().
                    getFragment(savedInstanceState, "MainFragment");
        }

        if (!mainFragment.isAdded()) {
            getSupportFragmentManager()
                    .beginTransaction().
                    add(R.id.layout_fragment, mainFragment, "MainFragment")
                    .commit();
        }
        showMainFragment();
    }

    private void initViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        //侧边导航栏点击监听
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override//侧边导航栏点击监听
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //关闭侧边栏
        drawer.closeDrawer(GravityCompat.START);
        //获得itemID
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            showMainFragment();
        } else if (id == R.id.nav_bookmarks) {
            showBookmarksFragment();
        } else if (id == R.id.nav_change_theme) {
            //改变主题
        } else if (id == R.id.nav_settings) {
            //startActivity(new Intent(this,SettingsPreferenceActivity.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(this,AboutActivity.class));
        }
        return true;
    }

    private void showBookmarksFragment() {

    }

    private void showMainFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(mainFragment);
        // fragmentTransaction.hide()
        fragmentTransaction.commit();
        toolbar.setTitle(getResources().getString(R.string.app_name));
    }

}
