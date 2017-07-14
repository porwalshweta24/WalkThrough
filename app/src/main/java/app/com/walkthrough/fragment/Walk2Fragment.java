package app.com.walkthrough.fragment;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import app.com.walkthrough.R;
import app.com.walkthrough.SplashActivity;
import app.com.walkthrough.Walkthrough;

/**
 * Created by Lenovo on 7/13/2017.
 */

public class Walk2Fragment extends Fragment {
    private String title;
    LinearLayout ll_connect;
    TextView text_connect;
    public Walk2Fragment() {
    }

    public static Walk2Fragment init(String title, String text, int image) {
        Walk2Fragment fragment = new Walk2Fragment();
        Bundle args = new Bundle();
        args.putInt("imageId", image);
        args.putString("TitleText", title);
        args.putString("MessageText", text);
        fragment.setArguments(args);
        return fragment;
    }

    public static Walk2Fragment newInstance() {
        Walk2Fragment fragment = new Walk2Fragment();
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
        v = inflater.inflate(R.layout.walk2_fragment, container, false);
        ll_connect=(LinearLayout)v.findViewById(R.id.ll_connect);
        text_connect=(TextView) v.findViewById(R.id.text_connect);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    void init()
    {
        try{
            text_connect.setText(getString(R.string.connect));
            text_connect.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.add),null,null,null);
            ObjectAnimator colorFade = ObjectAnimator.ofObject(ll_connect, "backgroundColor", new ArgbEvaluator(), Color.argb(255,51,181,229), 0xffffff);
            colorFade.setDuration(1000);
            colorFade.start();
            Handler mHandler = new Handler();
            mHandler.postDelayed(new Runnable(){
                @Override
                public void run(){
                    ll_connect.setBackground(getResources().getDrawable(R.color.white));
                    text_connect.setText(getString(R.string.connected));
                    text_connect.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ticked),null,null,null);
                }
            }, 1000 );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void walkChange()
    {
        init();
    }

}
