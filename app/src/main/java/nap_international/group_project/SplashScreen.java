package nap_international.group_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nap_international.group_project.LoginScreen.LoginScreen;

public class SplashScreen extends AppCompatActivity {

    public int SPLASH_TIME_OUT = 2500;
    public boolean time = true;
    TextView textview = null;
    TextView textview2 = null;
    RelativeLayout RL = null;
    RelativeLayout RL2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);

        //textview = findViewById(R.id.header);
        textview2 = findViewById(R.id.splashtext);
        //RL = findViewById(R.id.relative1);
        RL2 = findViewById(R.id.relative2);

        //handler.postDelayed(runnable,2000);
//custom text
        Typeface CustomFont2 = Typeface.createFromAsset(getAssets(), "fonts/kaushanRegular.ttf");
        textview2.setTypeface(CustomFont2);

        //Typeface CustomFont = Typeface.createFromAsset(getAssets(), "fonts/kaushanRegular.ttf");
        //textview.setTypeface(CustomFont);
//animation
        Animation animation999 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        textview2.startAnimation(animation999);
        //textview.startAnimation(animation999);

//thread
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //RL.setVisibility(View.VISIBLE);
                //RL2.setVisibility(View.GONE);

                if (time == true) {
                    Intent o = new Intent(SplashScreen.this, LoginScreen.class);
                    startActivity(o);
                    finish();
                    time = false;
                }
            }
        }, SPLASH_TIME_OUT);
    }

    //stopping thread
    public void onBackPressed() {
        time = false;
        finish();
    }
}
