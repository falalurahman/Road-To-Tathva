package com.falalu.roadtotathva;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Question7 extends ActionBarActivity {

    View popup;
    Button Submit;
    TextView timer;
    TextView timernot;
    EditText answer1;
    int errorno;
    String typecode;
    long errortime;
    int currlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);
        SharedPreferences sharedPreferences = getSharedPreferences("level", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        currlevel = sharedPreferences.getInt("levelcurr",0);
        editor.putInt("levelnow", 7);
        editor.apply();
        errorno = 0;
        errorno = sharedPreferences.getInt("errorno", 0);
        answer1 = (EditText) findViewById(R.id.answer7);
        Submit = (Button) findViewById(R.id.button);
        popup = (RelativeLayout)findViewById(R.id.popup);
        timer = (TextView)findViewById(R.id.timer);
        timernot = (TextView)findViewById(R.id.timernot);
        if(errorno != 0 && errorno % 2== 1) {
            errortime = 0;
            errortime = sharedPreferences.getLong("errortime", 0);
            long timenow = SystemClock.elapsedRealtime();
            if(timenow >= errortime) {
                long duration = timenow - errortime;
                long limit = errorno + 1;
                limit = limit/2;
                limit = limit * 30000;
                duration = limit - duration;
                if (duration >= 0)
                    starttimer(duration);
            }else {
                errortime = sharedPreferences.getLong("errortime", 0);
                timenow = System.currentTimeMillis();
                long duration = timenow - errortime;
                long limit = errorno + 1;
                limit = limit/2;
                limit = limit * 30000;
                duration = limit - duration;
                if (duration >= 0)
                    starttimer(duration);
            }
        }
    }

    public void checkAnswer(View view){
        String answer = answer1.getText().toString().toLowerCase();
        if( answer.equals("ccc")){
            Toast.makeText(this, "Correct Answer!!!",Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences("level", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong("errortime", 0);
            editor.putLong("errortime1", 0);
            editor.putInt("errorno", 0);
            editor.apply();
            ScaleAnimation scaleAnimation =
                    new ScaleAnimation(0.0f,1.0f,0.0f,1.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            AlphaAnimation alphaAnimation =
                    new AlphaAnimation(0.0f,1.0f);
            final AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(1000);
            Submit.setVisibility(View.GONE);
            popup.setVisibility(View.VISIBLE);
            popup.setAnimation(animationSet);
        }
        else if(errorno % 2 == 1){
            Toast.makeText(this, "Wrong Answer!! Try Again",Toast.LENGTH_SHORT).show();
            long limit = errorno + 1;
            limit = limit/2;
            limit = limit * 30000;
            SharedPreferences sharedPreferences = getSharedPreferences("level", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            errorno = errorno +1;
            editor.putLong("errortime", SystemClock.elapsedRealtime());
            editor.putLong("errortime1", System.currentTimeMillis());
            editor.putInt("errorno", errorno);
            editor.apply();
            starttimer(limit);
        }
        else{
            Toast.makeText(this, "Wrong Answer!! Try Again",Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences("level", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            errorno = errorno +1;
            editor.putLong("errortime", SystemClock.elapsedRealtime());
            editor.putLong("errortime1", System.currentTimeMillis());
            editor.putInt("errorno", errorno);
            editor.apply();
        }
    }

    public void starttimer(long limit){
        Submit.setVisibility(View.GONE);
        answer1.setVisibility(View.GONE);
        timer.setVisibility(View.VISIBLE);
        timernot.setVisibility(View.VISIBLE);

        new CountDownTimer(limit,998){
            public void onTick(long millisUntilFinished){
                long min = millisUntilFinished/60000;
                long sec = millisUntilFinished/1000;
                sec = sec - (min * 60);
                if(sec > 9)
                    timer.setText(""+Long.toString(min)+"min "+Long.toString(sec) + "sec");
                else
                    timer.setText(""+Long.toString(min)+"min "+Long.toString(sec) + "sec");
            }
            public void onFinish(){
                Submit.setVisibility(View.VISIBLE);
                answer1.setVisibility(View.VISIBLE);
                timer.setVisibility(View.GONE);
                timernot.setVisibility(View.GONE);
            }
        }.start();
    }

    public  void nextques(View view){
        Intent intent = new Intent(this , Redirect.class);
        if(currlevel + 1 < 10)
            intent.putExtra("admincode","80"+Integer.toString(currlevel+1)+Integer.toString(currlevel)+"0");
        else
            intent.putExtra("admincode", "8" + Integer.toString(currlevel+1) + Integer.toString(currlevel) + "0");
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question7, menu);
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
