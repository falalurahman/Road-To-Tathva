package com.falalu.roadtotathva;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    ImageView road;
    ImageView tathva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ScaleAnimation scaleAnimation1 =
                new ScaleAnimation(0.0f,1.2f,0.0f,1.2f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        final ScaleAnimation scaleAnimation2 =
                new ScaleAnimation(1.2f,0.8f,1.2f,0.8f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        final ScaleAnimation scaleAnimation3 =
                new ScaleAnimation(0.8f,1.0f,0.8f,1.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation1.setDuration(500);
        scaleAnimation2.setDuration(500);
        scaleAnimation3.setDuration(500);
        scaleAnimation3.setInterpolator(new OvershootInterpolator());

        RotateAnimation rotateAnimation =
                new RotateAnimation(0.0f , 720.0f , Animation.RELATIVE_TO_SELF ,0.5f ,Animation.RELATIVE_TO_SELF ,0.5f);
        ScaleAnimation scaleAnimation =
                new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        AlphaAnimation alphaAnimation =
                new AlphaAnimation(0.0f,1.0f);
        final AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(1000);
        animationSet.setInterpolator(new OvershootInterpolator());
        road = (ImageView) findViewById(R.id.road);
        road.setVisibility(View.VISIBLE);
        road.startAnimation(scaleAnimation1);

        tathva = (ImageView) findViewById(R.id.tathva);

        scaleAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                road.startAnimation(scaleAnimation2);
                tathva.setVisibility(View.VISIBLE);
                tathva.startAnimation(animationSet);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                road.startAnimation(scaleAnimation3);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });





        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                ;
                SharedPreferences sharedPreferences = getSharedPreferences("level", Context.MODE_PRIVATE);
                int currlevel = sharedPreferences.getInt("levelcurr", 0);
                if (currlevel == 0) {
                    Intent intent = new Intent(MainActivity.this, Redirect.class);
                    intent.putExtra("admincode", "10100");
                    startActivity(intent);
                    finish();
                } else {
                    int level = 0;
                    level = sharedPreferences.getInt("levelnow", 0);
                    Intent intent = null;
                    switch (level) {
                        case 1:
                            intent = new Intent(MainActivity.this, Question1.class);
                            break;
                        case 2:
                            intent = new Intent(MainActivity.this, Question2.class);
                            break;
                        case 3:
                            intent = new Intent(MainActivity.this, Question3.class);
                            break;
                        case 4:
                            intent = new Intent(MainActivity.this, Question4.class);
                            break;
                        case 5:
                            intent = new Intent(MainActivity.this, Question5.class);
                            break;
                        case 6:
                            intent = new Intent(MainActivity.this, Question6.class);
                            break;
                        case 7:
                            intent = new Intent(MainActivity.this, Question7.class);
                            break;
                        case 8:
                            intent = new Intent(MainActivity.this, Question8.class);
                            break;
                        case 9:
                            intent = new Intent(MainActivity.this, Question9.class);
                            break;
                        case 10:
                            intent = new Intent(MainActivity.this, Question10.class);
                            break;
                        case 11:
                            intent = new Intent(MainActivity.this, Question11.class);
                            break;
                        case 12:
                            intent = new Intent(MainActivity.this, Question12.class);
                            break;
                        case 13:
                            intent = new Intent(MainActivity.this, Question13.class);
                            break;
                        case 14:
                            intent = new Intent(MainActivity.this, End.class);
                            break;
                        default:
                            intent = new Intent(MainActivity.this, Question1.class);
                            break;
                    }
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
