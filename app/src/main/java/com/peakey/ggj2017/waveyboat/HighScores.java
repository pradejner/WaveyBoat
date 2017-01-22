package com.peakey.ggj2017.waveyboat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HighScores extends Activity {

    private Button resetButton;
    private SharedPreferences highScore;
    public static final String HIGH_SCORES = "HighScores";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_scores);

        highScore = getSharedPreferences(HIGH_SCORES, 0);//gethighscores
        //initialize components
        final SharedPreferences.Editor scoreEdit = highScore.edit();
        final TextView textView2=(TextView) findViewById(R.id.textView2);
        final SharedPreferences scorePrefs = getSharedPreferences("High Scores", 0);
        //split strings, loop through them appending a newline char
        String[] savedScores = scorePrefs.getString("highScores", "").split(",");
        StringBuilder buildScore = new StringBuilder("");
        for(String score : savedScores){
            buildScore.append(score+"\n");
        }
        textView2.setText(buildScore.toString());//set the text
        //reset button listener onclick clears sharedpref and resets textview2 text
        resetButton=(Button)findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreEdit.clear();
                scoreEdit.commit();
                textView2.setText("");
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