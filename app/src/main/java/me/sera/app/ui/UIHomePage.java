package me.sera.app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import me.sera.app.R;
import me.sera.app.utils.SeraViewPagerAdapter;

public class UIHomePage extends AppCompatActivity {

    public TabLayout tabLayout;
    public ViewPager2 viewPager2;
    public SeraViewPagerAdapter seraViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_home_page);

        tabLayout = findViewById(R.id.home_tab);
        viewPager2 = findViewById(R.id.view_pager);
        seraViewPagerAdapter = new SeraViewPagerAdapter(this);
        viewPager2.setAdapter(seraViewPagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2,((tab, position) -> tab.setText(seraViewPagerAdapter.titles[position]))).attach();


    }

}