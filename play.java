package com.gaurav.tomar.tictoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class play extends AppCompatActivity {
    private String symbol,choice;
    private int playerchance,see,player1won,player2won,result = 0;
    String gamezones[][] = new String[3][3];
    Button number1,number2,number3,number4,number5,number6,number7,number8,number9;
    TextView player1,player2,winp1,winp2,finale;
    ImageView question;
    Button exit,restart;
    winner win = new winner();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        choice = getIntent().getStringExtra("choose");
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        winp1 = findViewById(R.id.winp1);
        winp2 = findViewById(R.id.winp2);
        exit = findViewById(R.id.end);
        restart = findViewById(R.id.replay);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);
        number5 = findViewById(R.id.number5);
        number6 = findViewById(R.id.number6);
        number7 = findViewById(R.id.number7);
        number8 = findViewById(R.id.number8);
        number9 = findViewById(R.id.number9);
        finale = findViewById(R.id.finale);                 //find resources...
        question = findViewById(R.id.question);


        if(choice.equals("1"))
        {
            player1.setText("Player 1: Cross");
            player2.setText("Player 2: Zero");
        }
        else if(choice.equals("0"))
        {
            player1.setText("Player 1: Zero");
            player2.setText("Player 2: Cross");
            playerchance++;
        }                                                       //player choices


        winp1.setText("Win : "+"0");
        winp2.setText("Win : "+"0");

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent end = new Intent(play.this,MainActivity.class);

                //Toast.makeText(play.this,"player1won"+String.valueOf(player1won),Toast.LENGTH_SHORT).show();
                if(player1won >= player2won)  end.putExtra("topwinner",String.valueOf(player1won));
                else end.putExtra("topwinner",String.valueOf(player2won));
                startActivity(end);
            }
        });                               //end Game

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {             //restart click listners

                number1.setText("");
                number2.setText("");
                number3.setText("");
                number4.setText("");
                number5.setText("");
                number6.setText("");
                number7.setText("");
                number8.setText("");
                number9.setText("");          //button set null
                question.setVisibility(View.GONE);
                result =0;

                winp1.setText("Win : "+String.valueOf(player1won));
                winp2.setText("Win : "+String.valueOf(player2won));
                finale.setVisibility(View.INVISIBLE);
                win.clear();

                if(choice.equals("1"))
                {
                    player1.setText("Player 1: Cross");
                    player2.setText("Player 2: Zero");
                    playerchance = 0;
                }
                else if(choice.equals("0"))
                {
                    player1.setText("Player 1: Zero");
                    player2.setText("Player 2: Cross");
                    playerchance = 1;
                }

            }
        });                              //restart Game

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result != 2) {
                    if (playerchance % 2 == 0) symbol = "X";
                    else if (playerchance % 2 == 1) symbol = "0";
                    win.setter(0, 0, symbol);
                    number1.setText(symbol);
                    gamezones[0][0] = symbol;
                    see = win.decide(0, 0);


                    if (see == 3) {
                        result = 2;
                        question.setVisibility(View.VISIBLE);
                        if (choice.equals("1") && symbol.equals("X")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player1won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("1") && symbol.equals("0")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            player2won++;
                        } else if (choice.equals("0") && symbol.equals("X")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player2won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("0") && symbol.equals("0")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            player1won++;
                        }
                    }
                    playerchance++;
                }
            }
        });

        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result != 2) {
                    if (playerchance % 2 == 0) symbol = "X";
                    else if (playerchance % 2 == 1) symbol = "0";
                    win.setter(0, 1, symbol);
                    see = win.decide(0, 1);
                    gamezones[0][1] = symbol;
                    if (see == 3) {
                        result = 2;
                        question.setVisibility(View.VISIBLE);

                        if (choice.equals("1") && symbol.equals("X")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player1won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("1") && symbol.equals("0")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            player2won++;
                        } else if (choice.equals("0") && symbol.equals("X")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player2won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("0") && symbol.equals("0")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            player1won++;
                        }
                    }

                    number2.setText(symbol);
                    playerchance++;
                }
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result != 2) {
                    if (playerchance % 2 == 0) symbol = "X";
                    else if (playerchance % 2 == 1) symbol = "0";
                    win.setter(0, 2, symbol);
                    see = win.decide(0, 2);
                    gamezones[0][2] = symbol;
                    if (see == 3) {
                        result = 2;
                        question.setVisibility(View.VISIBLE);

                        if (choice.equals("1") && symbol.equals("X")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player1won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("1") && symbol.equals("0")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            player2won++;
                        } else if (choice.equals("0") && symbol.equals("X")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player2won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("0") && symbol.equals("0")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            player1won++;
                        }
                    }

                    number3.setText(symbol);
                    playerchance++;
                }
            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result != 2) {
                    if (playerchance % 2 == 0) symbol = "X";
                    else if (playerchance % 2 == 1) symbol = "0";
                    win.setter(1, 0, symbol);
                    see = win.decide(1, 0);
                    gamezones[1][0] = symbol;
                    if (see == 3) {
                        result = 2;
                        question.setVisibility(View.VISIBLE);

                        if (choice.equals("1") && symbol.equals("X")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player1won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("1") && symbol.equals("0")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            player2won++;
                        } else if (choice.equals("0") && symbol.equals("X")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player2won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("0") && symbol.equals("0")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            player1won++;
                        }
                    }

                    number4.setText(symbol);
                    playerchance++;
                }
            }
        });

        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result != 2) {
                    if (playerchance % 2 == 0) symbol = "X";
                    else if (playerchance % 2 == 1) symbol = "0";
                    win.setter(1, 1, symbol);
                    gamezones[1][1] = symbol;
                    see = win.decide(1, 1);
                    if (see == 3) {
                        result = 2;
                        question.setVisibility(View.VISIBLE);

                        if (choice.equals("1") && symbol.equals("X")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player1won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("1") && symbol.equals("0")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            player2won++;
                        } else if (choice.equals("0") && symbol.equals("X")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player2won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("0") && symbol.equals("0")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            player1won++;
                        }
                    }

                    number5.setText(symbol);
                    playerchance++;
                }
            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result != 2) {
                    if (playerchance % 2 == 0) symbol = "X";
                    else if (playerchance % 2 == 1) symbol = "0";
                    win.setter(1, 2, symbol);
                    see = win.decide(1, 2);
                    gamezones[1][2] = symbol;
                    if (see == 3) {
                        result = 2;
                        question.setVisibility(View.VISIBLE);

                        if (choice.equals("1") && symbol.equals("X")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player1won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("1") && symbol.equals("0")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            player2won++;
                        } else if (choice.equals("0") && symbol.equals("X")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player2won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("0") && symbol.equals("0")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            player1won++;
                        }
                    }

                    number6.setText(symbol);
                    playerchance++;
                }
            }
        });

        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result != 2) {
                    if (playerchance % 2 == 0) symbol = "X";
                    else if (playerchance % 2 == 1) symbol = "0";
                    win.setter(2, 0, symbol);
                    see = win.decide(2, 0);
                    gamezones[2][0] = symbol;
                    if (see == 3) {
                        result = 2;
                        question.setVisibility(View.VISIBLE);

                        if (choice.equals("1") && symbol.equals("X")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player1won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("1") && symbol.equals("0")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            player2won++;
                        } else if (choice.equals("0") && symbol.equals("X")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player2won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("0") && symbol.equals("0")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            player1won++;
                        }
                    }

                    number7.setText(symbol);
                    playerchance++;
                }
            }
        });

        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result != 2)
                {
                if(playerchance %2 == 0) symbol = "X";
                else if(playerchance %2 == 1) symbol = "0";
                win.setter(2,1,symbol);
                see = win.decide(2,1);
                gamezones[2][1] = symbol;
                if (see == 3) {
                    result = 2;
                    question.setVisibility(View.VISIBLE);

                    if(choice.equals("1") && symbol.equals("X")) {

                        finale.setText("Winner Player 1");
                        finale.setVisibility(View.VISIBLE);
                        ////player1won = Integer.parseInt(wins1) + 1;
                        player1won++;
                        ////player2won = Integer.parseInt(wins2);
                    }
                    else if(choice.equals("1") && symbol.equals("0"))
                    {

                        finale.setText("Winner Player 2");
                        finale.setVisibility(View.VISIBLE);
                        player2won++;
                    }
                    else if(choice.equals("0") && symbol.equals("X")) {

                        finale.setText("Winner Player 2");
                        finale.setVisibility(View.VISIBLE);
                        ////player1won = Integer.parseInt(wins1) + 1;
                        player2won++;
                        ////player2won = Integer.parseInt(wins2);
                    }
                    else if(choice.equals("0") && symbol.equals("0"))
                    {

                        finale.setText("Winner Player 1");
                        finale.setVisibility(View.VISIBLE);
                        player1won++;
                    }
                }
                
                number8.setText(symbol);
                playerchance++;
               }
            }
        });

        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result != 2) {
                    if (playerchance % 2 == 0) symbol = "X";
                    else if (playerchance % 2 == 1) symbol = "0";
                    win.setter(2, 2, symbol);
                    gamezones[2][2] = symbol;
                    see = win.decide(2, 2);
                    if (see == 3) {
                        result = 2;
                        question.setVisibility(View.VISIBLE);

                        if (choice.equals("1") && symbol.equals("X")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player1won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("1") && symbol.equals("0")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            player2won++;
                        } else if (choice.equals("0") && symbol.equals("X")) {

                            finale.setText("Winner Player 2");
                            finale.setVisibility(View.VISIBLE);
                            ////player1won = Integer.parseInt(wins1) + 1;
                            player2won++;
                            ////player2won = Integer.parseInt(wins2);
                        } else if (choice.equals("0") && symbol.equals("0")) {

                            finale.setText("Winner Player 1");
                            finale.setVisibility(View.VISIBLE);
                            player1won++;
                        }
                    }

                    number9.setText(symbol);
                    playerchance++;
                }
            }
        });                                                   //number click listners

    }

}
