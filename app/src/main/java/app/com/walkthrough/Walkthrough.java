package app.com.walkthrough;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import app.com.walkthrough.adapter.SectionsPagerAdapter;
import app.com.walkthrough.fragment.Walk2Fragment;
import app.com.walkthrough.fragment.Walk3Fragment;
import app.com.walkthrough.fragment.Walk4Fragment;

public class Walkthrough extends AppCompatActivity {

    private LinearLayout main_content;
    private LinearLayout controls_layout;
    private TabLayout tabLayout;
    private ViewPager mViewPager;
    private final int NUMBER_OF_PAGES = 4;
    Button SKIP_BUTTON, Sign_BUTTON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);
        main_content = (LinearLayout) findViewById(R.id.main_content);
        SKIP_BUTTON = (Button) findViewById(R.id.SKIP_BUTTON);
        Sign_BUTTON = (Button) findViewById(R.id.Sign_BUTTON);
        Sign_BUTTON.setOnClickListener(signOnViewClickListner);
        SKIP_BUTTON.setOnClickListener(joinOnViewClickListner);

    }

    View.OnClickListener signOnViewClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Walkthrough.this, LoginActivity.class));
            finish();
        }
    };
    View.OnClickListener joinOnViewClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Walkthrough.this, MainActivity.class));
            finish();
        }
    };

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        final SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),
                NUMBER_OF_PAGES, Walkthrough.this);
        mViewPager = (ViewPager) findViewById(R.id.container);
        controls_layout = (LinearLayout) findViewById(R.id.controls_layout);

        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(R.drawable.circle_selector);
            (((LinearLayout) tabLayout.getChildAt(0)).getChildAt(i)).setPadding(0, 0, 0, 0);
        }

        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        int position = tab.getPosition();
                        Fragment fragment = mSectionsPagerAdapter.getRegisteredFragment(position);
                        super.onTabSelected(tab);
                        switch (position) {
                            case 0:
                                SKIP_BUTTON.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                                SKIP_BUTTON.setTextColor(getResources().getColor(R.color.white));
                                Sign_BUTTON.setTextColor(getResources().getColor(R.color.colorAccent));
                                Sign_BUTTON.setBackgroundColor(getResources().getColor(R.color.gray));
                                controls_layout.setBackgroundColor(getResources().getColor(R.color.gray));
                                main_content.setBackgroundColor(getResources().getColor(R.color.gray));
                                break;
                            case 1:
                                ((Walk2Fragment) fragment).walkChange();
                                setColors();
                                break;
                            case 2:
                                ((Walk3Fragment) fragment).walkChange();
                                setColors();
                                break;
                            case 3:
                                ((Walk4Fragment) fragment).walkChange();
                                setColors();
                                break;
                        }
                    }
                });
    }

    void setColors() {
        SKIP_BUTTON.setBackground(getResources().getDrawable(R.drawable.button_bg));
        SKIP_BUTTON.setTextColor(getResources().getColor(R.color.white));
        Sign_BUTTON.setTextColor(getResources().getColor(R.color.white));
        Sign_BUTTON.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        controls_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        main_content.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

}
