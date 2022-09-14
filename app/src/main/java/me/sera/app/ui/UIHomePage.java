package me.sera.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

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

        ImageView settings = findViewById(R.id.settings);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        tabLayout = findViewById(R.id.home_tab);
        viewPager2 = findViewById(R.id.view_pager);
        seraViewPagerAdapter = new SeraViewPagerAdapter(this);
        viewPager2.setAdapter(seraViewPagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> tab.setText(SeraViewPagerAdapter.titles[position]))).attach();


    }

}