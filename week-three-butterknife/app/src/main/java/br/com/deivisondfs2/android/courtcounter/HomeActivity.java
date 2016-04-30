package br.com.deivisondfs2.android.courtcounter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.deivisondfs2.android.domain.Team;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {


    public
    @Bind(R.id.teamA)
    TextView teamAname;

    private int scoreTeamA;
    public
    @Bind(R.id.teamAPoints)
    TextView teamAPoints;

    public
    @Bind(R.id.teamB)
    TextView teamBname;


    private int scoreTeamB;
    public
    @Bind(R.id.teamBPoints)
    TextView teamBPoints;

    private Team teamA = new Team(1, "Team 1", 0);
    private Team teamB = new Team(2, "Team 2", 0);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        teamAname.setText(teamA.getName());
        teamBname.setText(teamB.getName());

    }

    /*
    Buttons A
     */
    @OnClick(R.id.threePointsTeamA)
    public void addThreePointsTeamA(View view) {
        displayTeamA(Team.THREE_POINTS);
    }

    @OnClick(R.id.twoPointsTeamA)
    public void addTwoPointsTeamA(View view) {
        displayTeamA(Team.TWO_POINTS);
    }

    @OnClick(R.id.onePointTeamA)
    public void addOnePointTeamA(View view) {
        displayTeamA(Team.ONE_POINT);
    }
    /*
    Buttons A Finish
     */

    /*
        Display Team A
     */
    public void displayTeamA(int score) {
        teamA.addPoints(score);
        teamAPoints.setText(String.valueOf(teamA.getPoints()));
    }

    /*
        Display Team B
     */
    public void displayTeamB(int score) {
        teamB.addPoints(score);
        teamBPoints.setText(String.valueOf(teamB.getPoints()));
    }


    /*
    Buttons b
     */
    @OnClick(R.id.threePointsTeamB)
    public void addThreePointsTeamB(View view) {
        displayTeamB(Team.THREE_POINTS);
    }

    @OnClick(R.id.twoPointsTeamB)
    public void addTwoPointsTeamB(View view) {
        displayTeamB(Team.TWO_POINTS);
    }

    @OnClick(R.id.onePointTeamB)
    public void addOnePointTeamB(View view) {
        displayTeamB(Team.ONE_POINT);
    }
    /*
    Buttons B Finish
     */

    /*
    Reset Button
     */
    @OnClick(R.id.resetGame)
    public void resetTeams(View v) {
        teamA = new Team(1, "Team 1", 0);
        teamB = new Team(2, "Team 2", 0);

        displayTeamA(teamA.getPoints());
        displayTeamB(teamB.getPoints());
        Toast.makeText(HomeActivity.this, "New Game!!!", Toast.LENGTH_SHORT).show();
    }

    /*
    Result button
     */
    @OnClick(R.id.resultGame)
    public void resultGame(View v) {
        try {
            Intent intent = new Intent(this, ResultActivity.class);
            if (teamA.getPoints() >= teamB.getPoints()) {
                intent.putExtra("team", teamA);
            } else {
                intent.putExtra("team", teamB);
            }

            if (teamA.getPoints() == 0 && teamB.getPoints() == 0){
                throw new RuntimeException();
            }

            startActivity(intent);

        } catch (RuntimeException e) {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Ops!")
                    .setMessage("Points should not be zero :( ")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create();
            alertDialog.show();
        }
    }


}
