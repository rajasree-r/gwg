
package com.example.android.courtcounter;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);

        new CountDownTimer(15*60*1000+3, 1000) {

            public void onTick(long millisUntilFinished) {
                long durationSeconds = millisUntilFinished / 1000;
                String formattedScore = String.format("%02d : %02d", (durationSeconds % 3600) / 60, (durationSeconds % 60));

                TextView scoreView = findViewById(R.id.score);
                scoreView.setText(formattedScore);
               // mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
               // mTextField.setText("done!");
            }
        }.start();
    }

    /** testing @Override
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
    end testing */

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA +1 ;
        displayForTeamA( scoreTeamA );
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA +2 ;
        displayForTeamA( scoreTeamA );
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA +3;
        displayForTeamA( scoreTeamA );

    }

    public void addOneForTeamB (View V) {

        scoreTeamB = scoreTeamB + 1;
        displayForTeamB( scoreTeamB);

    }

    public void addTwoForTeamB (View V) {

        scoreTeamB = scoreTeamB + 2;
        displayForTeamB( scoreTeamB);

    }

    public void addThreeForTeamB (View V) {

        scoreTeamB = scoreTeamB + 3;
        displayForTeamB( scoreTeamB);

    }

    public void resetScore(View V){

        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA( scoreTeamA );
        displayForTeamB( scoreTeamB );

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}