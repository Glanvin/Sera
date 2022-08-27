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

    private final int itemcount = 3;

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
            case 3:
                return new History();
            default:
                return new Chat();
        }
    }

    @Override
    public int getItemCount() {
        return itemcount;
    }
}
