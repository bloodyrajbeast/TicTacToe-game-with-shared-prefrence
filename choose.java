package com.gaurav.tomar.tictoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choose extends AppCompatActivity {
    Button zero,cross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        zero = findViewById(R.id.zero);
        cross = findViewById(R.id.cross);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zeros = new Intent(choose.this,play.class);
                zeros.putExtra("choose","0");                                  //choice of player 1
                startActivity(zeros);
            }
        });

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cross = new Intent(choose.this,play.class);
                cross.putExtra("choose","1");                       //choice of player 1
                startActivity(cross);
            }
        });
    }
}
