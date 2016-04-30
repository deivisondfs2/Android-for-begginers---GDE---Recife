package br.com.deivisondfs2.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.deivisondfs2.android.domain.Team;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    public Team teamVictory;

    public
    @Bind(R.id.nameTeamVictory)
    TextView nameTeam;

    public
    @Bind(R.id.totalTeamThreePoins)
    TextView totalThreePoints;
    public
    @Bind(R.id.totalTeamTwoPoins)
    TextView totalTeamTwoPoins;
    public
    @Bind(R.id.totalTeamOnePoins)
    TextView totalTeamOnePoins;

    public
    @Bind(R.id.valueTotal)
    TextView totalGenerel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        teamVictory = getIntent().getExtras().getParcelable("team");

        nameTeam.setText(teamVictory.getName());
        totalThreePoints.setText(String.valueOf(teamVictory.getTotalThreePoints()));
        totalTeamTwoPoins.setText(String.valueOf(teamVictory.getTotalTwoPoints()));
        totalTeamOnePoins.setText(String.valueOf(teamVictory.getTotalOnePoints()));

        totalGenerel.setText(String.valueOf(teamVictory.getPoints()));

    }
}
