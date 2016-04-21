package br.com.deivisondfs2.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    private static final Integer THREE_POINTS = 3;
    private static final Integer TWO_POINTS = 2;
    private static final Integer ONE_POINT = 1;


    private int scoreTeamA;
    public
    @Bind(R.id.teamAPoints)
    TextView teamAPoints;

    private int scoreTeamB;
    public
    @Bind(R.id.teamBPoints)
    TextView teamBPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    /*
    Buttons A
     */
    @OnClick(R.id.threePointsTeamA)
    public void addThreePointsTeamA(View view) {
        displayTeamA(THREE_POINTS);
    }

    @OnClick(R.id.twoPointsTeamA)
    public void addTwoPointsTeamA(View view) {
        displayTeamA(TWO_POINTS);
    }

    @OnClick(R.id.onePointTeamA)
    public void addOnePointTeamA(View view) {
        displayTeamA(ONE_POINT);
    }
    /*
    Buttons A Finish
     */

    /*
        Display Team A
     */
    public void displayTeamA(int score) {
        scoreTeamA += score;
        teamAPoints.setText(String.valueOf(scoreTeamA));
    }

    /*
        Display Team B
     */
    public void displayTeamB(int score) {
        scoreTeamB += score;
        teamBPoints.setText(String.valueOf(scoreTeamB));
    }


    /*
    Buttons b
     */
    @OnClick(R.id.threePointsTeamB)
    public void addThreePointsTeamB(View view) {
        displayTeamB(THREE_POINTS);
    }

    @OnClick(R.id.twoPointsTeamB)
    public void addTwoPointsTeamB(View view) {
        displayTeamB(TWO_POINTS);
    }

    @OnClick(R.id.onePointTeamB)
    public void addOnePointTeamB(View view) {
        displayTeamB(ONE_POINT);
    }
    /*
    Buttons B Finish
     */

    /*
    Reset Button
     */
    @OnClick(R.id.resetGame)
    public void resetTeams(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;

        displayTeamA(scoreTeamA);
        displayTeamB(scoreTeamB);
        Toast.makeText(HomeActivity.this, "New Game!!!", Toast.LENGTH_SHORT).show();
    }
}
