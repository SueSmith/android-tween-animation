package com.example.tweenanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimatedActivity extends AppCompatActivity {
    private ImageView ivRestartAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated);
        //get the sun View

        ivRestartAnimation = (ImageView) findViewById(R.id.ivRestartAnimation);
        if (ivRestartAnimation != null)
            ivRestartAnimation.setVisibility(View.INVISIBLE);
        startAnimation();
        ivRestartAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation clockTurn = AnimationUtils.loadAnimation(AnimatedActivity.this, R.anim.clock_turn);
                ivRestartAnimation.startAnimation(clockTurn);
                startAnimation();
            }
        });


    }

    private void startAnimation() {

        ImageView sun = (ImageView) findViewById(R.id.sun);
        //get the sunrise animation
        Animation sunRise = AnimationUtils.loadAnimation(this, R.anim.sun_rise);

        //apply the animation to the View
        sun.startAnimation(sunRise);


        //get the clock View
        ImageView clock = (ImageView) findViewById(R.id.clock);

        //get the clock turn animation
        Animation clockTurn = AnimationUtils.loadAnimation(this, R.anim.clock_turn);

        //apply the animation to the View
        clock.startAnimation(clockTurn);


        //get the hour hand View
        ImageView hour = (ImageView) findViewById(R.id.hour);

        //get the hour turn animation
        Animation hourTurn = AnimationUtils.loadAnimation(this, R.anim.hour_turn);

        //apply the animation to the View
        hour.startAnimation(hourTurn);
        ivRestartAnimation.setVisibility(View.VISIBLE);

    }
}
