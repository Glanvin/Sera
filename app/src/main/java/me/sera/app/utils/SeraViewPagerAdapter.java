package me.sera.app.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import me.sera.app.ui.fragments.Chat;
import me.sera.app.ui.fragments.History;
import me.sera.app.ui.fragments.People;

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
                return new Chat();
            case 1:
                return new People();
            case 2:
                return new History();

        }

        return new Chat();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
