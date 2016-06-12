
package com.ikmr.banbara23.iriomote_navi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

public class TopActivity extends DrawerActivity {

    private MaterialViewPager mViewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        setTitle("");

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                // switch (position % 4) {
                // case 0:
                // return RecyclerViewFragment.newInstance();
                // case 1:
                // return RecyclerViewFragment.newInstance();
                // case 2:
                // return WebViewFragment.newInstance();
                // default:
                // return RecyclerViewFragment.newInstance();

                // }
                return ScrollFragment.newInstance();
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "観る";
                    case 1:
                        return "遊ぶ";
                    case 2:
                        return "食べる";
                    case 3:
                        return "泊まる";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        // 観る
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.blue,
                                ResourcesCompat.getDrawable(getResources(),
                                        R.drawable.miru, null));
                    case 1:
                        // 遊ぶ
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.green,
                                ResourcesCompat.getDrawable(getResources(),
                                        R.drawable.iriomote_pinai_03, null));
                    case 2:
                        // 食べる
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.red,
                                ResourcesCompat.getDrawable(getResources(),
                                        R.drawable.taberu, null));
                    case 3:
                        // 泊まる
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.purple,
                                ResourcesCompat.getDrawable(getResources(),
                                        R.drawable.hotel, null));
                }

                // execute others actions if needed (ex : modify your header
                // logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
