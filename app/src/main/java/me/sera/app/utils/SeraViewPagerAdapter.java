package me.sera.app.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import me.sera.app.ui.fragments.*;


public class SeraViewPagerAdapter extends FragmentStateAdapter {

    public final static String[] titles = {"Chat", "People", "History"};

    public SeraViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ChatFragment();
            case 1:
                return new PeopleFragment();
            case 2:
                return new HistoryFragment();

        }

        return null;
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
