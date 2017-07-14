package app.com.walkthrough.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import app.com.walkthrough.R;
import app.com.walkthrough.fragment.Walk1Fragment;
import app.com.walkthrough.fragment.Walk2Fragment;
import app.com.walkthrough.fragment.Walk3Fragment;
import app.com.walkthrough.fragment.Walk4Fragment;
import app.com.walkthrough.fragment.WalkFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final int pages;
    private SparseArray<Fragment> registeredFragments = new SparseArray<>();
    public SectionsPagerAdapter(FragmentManager fm, int pages, Context context) {
        super(fm);
        this.pages = pages;

    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }
    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Walk1Fragment.init("1", "login", R.mipmap.ic_launcher);
            case 1:
                return Walk2Fragment.init("2", "Share this Awesomeness!", R.mipmap.ic_launcher);
            case 2:
                return Walk3Fragment.init("3", "chat", R.mipmap.ic_launcher);
            case 3:
                return Walk4Fragment.init("4", "shimmer", R.mipmap.ic_launcher);
        }
        return null;
    }

    @Override
    public int getCount() {
        return pages;
    }
}