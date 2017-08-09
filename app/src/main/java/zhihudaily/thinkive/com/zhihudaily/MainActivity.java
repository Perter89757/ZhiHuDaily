package zhihudaily.thinkive.com.zhihudaily;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import zhihudaily.thinkive.com.zhihudaily.homepage.MainFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //
        MainFragment mainFragment =new MainFragment();
        //把MainFragment替换xml空白de FramLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout_fragment, mainFragment, "MainFragment")
                .commit();
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
        }else if (id == R.id.nav_settings) {
            //startActivity(new Intent(this,SettingsPreferenceActivity.class));
        } else if (id == R.id.nav_about) {
            //startActivity(new Intent(this,AboutPreferenceActivity.class));
        }
        return true;
    }

    private void showBookmarksFragment() {

    }

    private void showMainFragment() {

    }
}
