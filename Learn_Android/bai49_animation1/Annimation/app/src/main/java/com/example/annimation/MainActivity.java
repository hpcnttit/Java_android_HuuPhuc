package com.example.annimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btnXoayControl, btnXoayManHinh, btnXoay3s, btnHieuUngListView;

    Animation animation=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnXoayControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation= AnimationUtils.loadAnimation(MainActivity.this, R.anim.xoaycontrol);
                btnXoayControl.startAnimation(animation);
            }
        });

        btnXoayManHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layoutManHinh= findViewById(R.id.layoutManHinh);
                animation= AnimationUtils.loadAnimation(MainActivity.this, R.anim.xoaymanhinh);
                layoutManHinh.startAnimation(animation);
            }
        });

        btnXoay3s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation= AnimationUtils.loadAnimation(MainActivity.this, R.anim.xoaynguoc3s);
                btnXoay3s.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }

    private void addControls() {
        btnXoayControl= this.<Button>findViewById(R.id.btnXoayControl);
        btnHieuUngListView= this.<Button>findViewById(R.id.btnHieuUngListView);
        btnXoay3s= this.<Button>findViewById(R.id.btnXoay3s);
        btnXoayManHinh= this.<Button>findViewById(R.id.btnXoayManHinh);



    }
}
