package com.gaurav.tomar.tictoc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView win;
    Button start;
    private String winner;
    private SharedPreferences preferences;
    private String prefname = "tictocdetails";
    private int details_pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        win = findViewById(R.id.winp1);
        start = findViewById(R.id.start);


        winner = getIntent().getStringExtra("topwinner");
        if(winner == null )
        {
            winner = "0";
            win.setText("WINS : " +winner);
        }
        else win.setText("WINS : " +winner);

        preferences = getSharedPreferences(prefname,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        details_pref = preferences.getInt("winnerstotal",0);

        win.setText("WINS : " +details_pref);
//                editor.putInt("winnerstotal", 0);
//                editor.commit();

        //Toast.makeText(this, winner, Toast.LENGTH_SHORT).show();


        if(Integer.parseInt(winner) > details_pref) {
            editor.putInt("winnerstotal",Integer.parseInt(winner));
            editor.commit();
            details_pref = preferences.getInt("winnerstotal",0);
            win.setText("WINS : " +details_pref);

        }

        //Toast.makeText(this, "details_prefname"+preferences.getInt("winnerstotal",100), Toast.LENGTH_SHORT).show();


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,choose.class);
                startActivity(intent);
            }
        });
    }
}
