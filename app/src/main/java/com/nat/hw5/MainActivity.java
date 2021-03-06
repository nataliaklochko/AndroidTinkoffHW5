package com.nat.hw5;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NewsFragmentPagerAdapter fragmentPagerAdapter;

    private  NewsPageFragment newsLastFragment;
    private static NewsPageFragment newsFavouritesFragment;

    protected static final String PREF = "settings";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        fragmentPagerAdapter = new NewsFragmentPagerAdapter(getSupportFragmentManager());

        newsLastFragment = NewsPageFragment.newInstance(true, false);
        newsFavouritesFragment = NewsPageFragment.newInstance(false, true);
        fragmentPagerAdapter.addFragment("", newsLastFragment);
        fragmentPagerAdapter.addFragment("", newsFavouritesFragment);

        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_access_time);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_star);

    }
}

