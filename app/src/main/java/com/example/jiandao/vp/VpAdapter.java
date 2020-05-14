package com.example.jiandao.vp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.jiandao.home.view.fragment.ColumnBean;

import java.util.ArrayList;
import java.util.List;

public class VpAdapter extends FragmentPagerAdapter {
    private List<VpFragment> fragments;

    public VpAdapter(@NonNull FragmentManager fm, List<VpFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


}
