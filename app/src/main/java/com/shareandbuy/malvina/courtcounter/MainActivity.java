package com.shareandbuy.malvina.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int rebel_ships_amount = 0;
    int empire_ships_amount = 0;
    int starFighterAttack = 0;
    int lukeAttack = 0;
    int milFalconAttact = 0;
    int tieFighterAttack = 0;
    int darthVaderAttack = 0;
    TextView empireScore;
    TextView rebelScore;
    LinearLayout rebelFullLayout;
    LinearLayout empireFullLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.empire_ships_amount = Integer.parseInt(getString(R.string.empire_total_ships));
        this.rebel_ships_amount = Integer.parseInt(getString(R.string.rebel_total_ships));
        this.starFighterAttack = Integer.parseInt(getString(R.string.starfighter_damage));
        this.lukeAttack = Integer.parseInt(getString(R.string.luke_starfighter_damage));
        this.milFalconAttact = Integer.parseInt(getString(R.string.millennium_falcon_damage));
        this.tieFighterAttack = Integer.parseInt(getString(R.string.tie_fighter_damage));
        this.darthVaderAttack = Integer.parseInt(getString(R.string.darth_vader_tie_fighter_damage));

        this.empireScore = findViewById(R.id.empire_total_ships);
        this.empireFullLayout = (LinearLayout) this.empireScore.getParent();
        this.rebelScore = findViewById(R.id.rebels_total_ships);
        this.rebelFullLayout = (LinearLayout) this.rebelScore.getParent();

        this.empireScore.setText(String.valueOf(this.empire_ships_amount));
        this.rebelScore.setText(String.valueOf(this.rebel_ships_amount));
    }

    public void attack(View view){
        switch (view.getId()) {
            case R.id.starfighter_attack:
                this.empire_ships_amount = this.empire_ships_amount - this.starFighterAttack;
                this.empireScore.setText(String.valueOf(this.empire_ships_amount));
                setAttackedSection(this.empireScore.getId());
                break;
            case R.id.luke_attack:
                this.empire_ships_amount = this.empire_ships_amount - this.lukeAttack;
                this.empireScore.setText(String.valueOf(this.empire_ships_amount));
                setAttackedSection(this.empireScore.getId());
                break;
            case R.id.mel_falcon_attack:
                this.empire_ships_amount = this.empire_ships_amount - this.milFalconAttact;
                this.empireScore.setText(String.valueOf(this.empire_ships_amount));
                setAttackedSection(this.empireScore.getId());
                break;
            case R.id.tie_fighter:
                this.rebel_ships_amount = this.rebel_ships_amount - this.tieFighterAttack;
                this.rebelScore.setText(String.valueOf(this.rebel_ships_amount));
                setAttackedSection(this.rebelScore.getId());
                break;
            case R.id.dart_vader:
                this.rebel_ships_amount = this.rebel_ships_amount - this.darthVaderAttack;
                this.rebelScore.setText(String.valueOf(this.rebel_ships_amount));
                setAttackedSection(this.rebelScore.getId());
                break;
        }
    }

    void setAttackedSection(int layoutId){
        if(layoutId == rebelScore.getId()){
            rebelScore.setTextColor(getResources().getColor(R.color.attacked_text));
            rebelFullLayout.setBackgroundColor(getResources().getColor(R.color.attacked_layout));
            empireScore.setTextColor(getResources().getColor(R.color.title_text));
            empireFullLayout.setBackgroundColor(getResources().getColor(R.color.score_container));
            return;
        }
        if(layoutId == empireScore.getId()){
            empireScore.setTextColor(getResources().getColor(R.color.attacked_text));
            empireFullLayout.setBackgroundColor(getResources().getColor(R.color.attacked_layout));
            rebelScore.setTextColor(getResources().getColor(R.color.title_text));
            rebelFullLayout.setBackgroundColor(getResources().getColor(R.color.score_container));
        }
    }
}
