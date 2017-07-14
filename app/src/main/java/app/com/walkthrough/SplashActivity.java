package app.com.walkthrough;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by Lenovo on 7/13/2017.
 */

public class SplashActivity extends AppCompatActivity {
    ImageView image_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        image_icon=(ImageView) findViewById(R.id.image_icon);
        final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        image_icon.startAnimation(animationFadeIn);
        final Animation animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        Random random = new Random();
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable(){
            @Override
            public void run(){
                image_icon.startAnimation(animationFadeOut);
                startActivity(new Intent(SplashActivity.this,Walkthrough.class));
                finish();
            }
        }, 1000 + random.nextInt(2000));

    }

}
