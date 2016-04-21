package br.com.deivisondfs2.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private static final Integer THREE_POINTS = 3;
    private static final Integer TWO_POINTS = 2;
    private static final Integer ONE_POINT = 1;


    private int scoreTeamA;
    public TextView teamAPoints;

    private int scoreTeamB;
    public TextView teamBPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    /*
    Buttons A
     */
    public void addThreePointsTeamA(View view){
        displayTeamA(THREE_POINTS);
    }

    public void addTwoPointsTeamA(View view){
        displayTeamA(TWO_POINTS);
    }

    public void addOnePointTeamA(View view){
        displayTeamA(ONE_POINT);
    }
    /*
    Buttons A Finish
     */

    /*
        Display Team A
     */
    public void displayTeamA(int score) {
        teamAPoints = (TextView) findViewById(R.id.teamAPoints);
        scoreTeamA += score;
        teamAPoints.setText(String.valueOf(scoreTeamA));
    }

    /*
        Display Team B
     */
    public void displayTeamB(int score) {
        teamBPoints = (TextView) findViewById(R.id.teamBPoints);
        scoreTeamB += score;
        teamBPoints.setText(String.valueOf(scoreTeamB));
    }


    /*
    Buttons b
     */
    public void addThreePointsTeamB(View view){
        displayTeamB(THREE_POINTS);
    }

    public void addTwoPointsTeamB(View view){
        displayTeamB(TWO_POINTS);
    }

    public void addOnePointTeamB(View view){
        displayTeamB(ONE_POINT);
    }
    /*
    Buttons B Finish
     */

    /*
    Reset Button
     */
    public void resetTeams(View v){
        scoreTeamA = 0;
        scoreTeamB = 0;

        displayTeamA(scoreTeamA);
        displayTeamB(scoreTeamB);
    }
}
