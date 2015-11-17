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
import android.widget.Toast;


public class End extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        SharedPreferences sharedPreferences = getSharedPreferences("level", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("levelnow", 14);
        editor.apply();
    }

    public void startOver(View view){
        Intent intent = new Intent(this , Redirect.class);
        intent.putExtra("admincode","10100");
        SharedPreferences sharedPreferences = getSharedPreferences("level", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("1",false);
        editor.putBoolean("2", false);
        editor.putBoolean("3",false);
        editor.putBoolean("4",false);
        editor.putBoolean("5",false);
        editor.putBoolean("6",false);
        editor.putBoolean("7",false);
        editor.putBoolean("8",false);
        editor.putBoolean("9",false);
        editor.putBoolean("10",false);
        editor.putBoolean("11",false);
        editor.putBoolean("12",false);
        editor.putInt("levelnow" , 0);
        editor.putInt("levelcurr", 0);
        editor.apply();
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_end, menu);
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
