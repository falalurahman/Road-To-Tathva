package com.falalu.roadtotathva;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class Redirect extends ActionBarActivity {

    EditText redirectcode;
    String typecode;
    ArrayList<String> questionleft;
    int currlevel;
    TextView nextlevel;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionleft = new ArrayList<String>();
        setContentView(R.layout.activity_redirect);
        redirectcode = (EditText) findViewById(R.id.redirectcode);
        sharedPreferences = getSharedPreferences("level", Context.MODE_PRIVATE);
        currlevel = sharedPreferences.getInt("levelcurr",0);
        nextlevel = (TextView)findViewById(R.id.nextlevel);
        nextlevel.setText("Next Level: "+Integer.toString(currlevel+1));
        if(currlevel == 3 || currlevel == 2 || currlevel == 1) {
            for (int i = 1; i <= 6; i++) {
                Boolean temp = sharedPreferences.getBoolean(Integer.toString(i), false);
                if (temp == false)
                    questionleft.add(Integer.toString(i));
            }
            Intent intent;
            if (questionleft.size() > 2) {
                Random randomGenerator = new Random();
                int ind = randomGenerator.nextInt(questionleft.size());
                int choosen = Integer.parseInt(questionleft.get(ind));
                switch (choosen) {
                    case 1:
                        intent = new Intent(Redirect.this, Question1.class);
                        break;
                    case 2:
                        intent = new Intent(Redirect.this, Question2.class);
                        break;
                    case 3:
                        intent = new Intent(Redirect.this, Question3.class);
                        break;
                    case 4:
                        intent = new Intent(Redirect.this, Question4.class);
                        break;
                    case 5:
                        intent = new Intent(Redirect.this, Question5.class);
                        break;
                    case 6:
                        intent = new Intent(Redirect.this, Question6.class);
                        break;
                    case 7:
                        intent = new Intent(Redirect.this, Question7.class);
                        break;
                    case 8:
                        intent = new Intent(Redirect.this, Question8.class);
                        break;
                    case 9:
                        intent = new Intent(Redirect.this, Question9.class);
                        break;
                    case 10:
                        intent = new Intent(Redirect.this, Question10.class);
                        break;
                    case 11:
                        intent = new Intent(Redirect.this, Question11.class);
                        break;
                    case 12:
                        intent = new Intent(Redirect.this, Question12.class);
                        break;
                    default:
                        intent = new Intent(Redirect.this, Redirect.class);
                        break;
                }
                currlevel = currlevel + 1;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("levelcurr", currlevel);
                editor.putBoolean(questionleft.get(ind), true);
                editor.apply();
                startActivity(intent);
                finish();
            }
        }else if(currlevel == 4){
            for (int i = 7; i <= 12; i++) {
                Boolean temp = sharedPreferences.getBoolean(Integer.toString(i), false);
                if (temp == false)
                    questionleft.add(Integer.toString(i));
            }
            Intent intent;
            if (questionleft.size() > 1) {
                Random randomGenerator = new Random();
                int ind = randomGenerator.nextInt(questionleft.size());
                int choosen = Integer.parseInt(questionleft.get(ind));
                switch (choosen) {
                    case 1:
                        intent = new Intent(Redirect.this, Question1.class);
                        break;
                    case 2:
                        intent = new Intent(Redirect.this, Question2.class);
                        break;
                    case 3:
                        intent = new Intent(Redirect.this, Question3.class);
                        break;
                    case 4:
                        intent = new Intent(Redirect.this, Question4.class);
                        break;
                    case 5:
                        intent = new Intent(Redirect.this, Question5.class);
                        break;
                    case 6:
                        intent = new Intent(Redirect.this, Question6.class);
                        break;
                    case 7:
                        intent = new Intent(Redirect.this, Question7.class);
                        break;
                    case 8:
                        intent = new Intent(Redirect.this, Question8.class);
                        break;
                    case 9:
                        intent = new Intent(Redirect.this, Question9.class);
                        break;
                    case 10:
                        intent = new Intent(Redirect.this, Question10.class);
                        break;
                    case 11:
                        intent = new Intent(Redirect.this, Question11.class);
                        break;
                    case 12:
                        intent = new Intent(Redirect.this, Question12.class);
                        break;
                    default:
                        intent = new Intent(Redirect.this, Redirect.class);
                        break;
                }
                currlevel = currlevel + 1;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("levelcurr", currlevel);
                editor.putBoolean(questionleft.get(ind), true);
                editor.apply();
                startActivity(intent);
                finish();
            }
        }
    }

    public void nextques(View view){
        String getcode = redirectcode.getText().toString();
        Bundle bundle = getIntent().getExtras();
        String inputcode = bundle.getString("admincode");
        if(getcode.equals(inputcode) && currlevel == 0) {
            for (int i = 1; i <= 6; i++) {
                Boolean temp = sharedPreferences.getBoolean(Integer.toString(i), false);
                if (temp == false)
                    questionleft.add(Integer.toString(i));
            }
            Intent intent;
            if (questionleft.size() > 2) {
                Random randomGenerator = new Random();
                int ind = randomGenerator.nextInt(questionleft.size());
                int choosen = Integer.parseInt(questionleft.get(ind));
                switch (choosen) {
                    case 1:
                        intent = new Intent(Redirect.this, Question1.class);
                        break;
                    case 2:
                        intent = new Intent(Redirect.this, Question2.class);
                        break;
                    case 3:
                        intent = new Intent(Redirect.this, Question3.class);
                        break;
                    case 4:
                        intent = new Intent(Redirect.this, Question4.class);
                        break;
                    case 5:
                        intent = new Intent(Redirect.this, Question5.class);
                        break;
                    case 6:
                        intent = new Intent(Redirect.this, Question6.class);
                        break;
                    case 7:
                        intent = new Intent(Redirect.this, Question7.class);
                        break;
                    case 8:
                        intent = new Intent(Redirect.this, Question8.class);
                        break;
                    case 9:
                        intent = new Intent(Redirect.this, Question9.class);
                        break;
                    case 10:
                        intent = new Intent(Redirect.this, Question10.class);
                        break;
                    case 11:
                        intent = new Intent(Redirect.this, Question11.class);
                        break;
                    case 12:
                        intent = new Intent(Redirect.this, Question12.class);
                        break;
                    default:
                        intent = new Intent(Redirect.this, Redirect.class);
                        break;
                }
                currlevel = currlevel + 1;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("levelcurr", currlevel);
                editor.putBoolean(questionleft.get(ind), true);
                editor.apply();
                startActivity(intent);
                finish();
            }
        }
        else if(getcode.equals(inputcode) && currlevel >= 5 && currlevel <9) {
            for (int i = 7; i <= 12; i++) {
                Boolean temp = sharedPreferences.getBoolean(Integer.toString(i), false);
                if (temp == false)
                    questionleft.add(Integer.toString(i));
            }
            Intent intent;
            if (questionleft.size() > 1) {
                Random randomGenerator = new Random();
                int ind = randomGenerator.nextInt(questionleft.size());
                int choosen = Integer.parseInt(questionleft.get(ind));
                switch (choosen) {
                    case 1:
                        intent = new Intent(Redirect.this, Question1.class);
                        break;
                    case 2:
                        intent = new Intent(Redirect.this, Question2.class);
                        break;
                    case 3:
                        intent = new Intent(Redirect.this, Question3.class);
                        break;
                    case 4:
                        intent = new Intent(Redirect.this, Question4.class);
                        break;
                    case 5:
                        intent = new Intent(Redirect.this, Question5.class);
                        break;
                    case 6:
                        intent = new Intent(Redirect.this, Question6.class);
                        break;
                    case 7:
                        intent = new Intent(Redirect.this, Question7.class);
                        break;
                    case 8:
                        intent = new Intent(Redirect.this, Question8.class);
                        break;
                    case 9:
                        intent = new Intent(Redirect.this, Question9.class);
                        break;
                    case 10:
                        intent = new Intent(Redirect.this, Question10.class);
                        break;
                    case 11:
                        intent = new Intent(Redirect.this, Question11.class);
                        break;
                    case 12:
                        intent = new Intent(Redirect.this, Question12.class);
                        break;
                    default:
                        intent = new Intent(Redirect.this, Redirect.class);
                        break;
                }
                currlevel = currlevel + 1;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("levelcurr", currlevel);
                editor.putBoolean(questionleft.get(ind), true);
                editor.apply();
                startActivity(intent);
                finish();
            }
        }
        else if(currlevel == 9 && getcode.equals(inputcode)){
            Intent intent;
            intent = new Intent(Redirect.this, Question13.class);
            currlevel = currlevel + 1;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("levelcurr", currlevel);
            editor.putBoolean("13",true);
            editor.apply();
            startActivity(intent);
            finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_redirect, menu);
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
