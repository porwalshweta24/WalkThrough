package app.com.walkthrough.fragment;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import app.com.walkthrough.R;
import app.com.walkthrough.adapter.MyBounceInterpolator;

/**
 * Created by Lenovo on 7/13/2017.
 */

public class Walk3Fragment extends Fragment {
    private String title;
    TextView text_thanks, text_catch3;
    LinearLayout ll_judy, ll_anim;
    ImageView image_good_job1;

    public Walk3Fragment() {
    }

    public static Walk3Fragment init(String title, String text, int image) {
        Walk3Fragment fragment = new Walk3Fragment();
        Bundle args = new Bundle();
        args.putInt("imageId", image);
        args.putString("TitleText", title);
        args.putString("MessageText", text);
        fragment.setArguments(args);
        return fragment;
    }

    public static Walk3Fragment newInstance() {
        Walk3Fragment fragment = new Walk3Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("TitleText");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v;
        v = inflater.inflate(R.layout.walk3_fragment, container, false);
        text_thanks = (TextView) v.findViewById(R.id.text_thanks2);
        text_catch3 = (TextView) v.findViewById(R.id.text_catch3);
        ll_judy = (LinearLayout) v.findViewById(R.id.ll_judy);
        ll_anim = (LinearLayout) v.findViewById(R.id.ll_anim);
        image_good_job1 = (ImageView) v.findViewById(R.id.image_good_job1);
        return v;
    }

    public void walkChange() {
        init(0);
    }

    void init(final int carry) {
        try {

            final Animation animBounce = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce_in);
            MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
            animBounce.setInterpolator(interpolator);

            final int delay = 500;
            Handler mHandler = new Handler();
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (carry) {
                        case 0:
                            ll_judy.startAnimation(animBounce);init(1);
                            break;
                        case 1:
                            image_good_job1.startAnimation(animBounce);init(2);
                            break;
                        case 2:
                            text_thanks.startAnimation(animBounce);init(3);
                            break;
                        case 3:
                            text_catch3.startAnimation(animBounce);
                            break;
                    }
                }

            }, delay );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
