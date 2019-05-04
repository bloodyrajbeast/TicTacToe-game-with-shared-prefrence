package com.gaurav.tomar.tictoc;


public class winner {
    private String gamezones[][] = new String[3][3];
    int horizontal,vertical,diagonalsame,diagonalsum;


    public void setter(int i,int j,String value)
    {
        if(value.equals("0")) value = "zero";
        gamezones[i][j] = value;
    }

    public void clear()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                gamezones[i][j] = null;
            }
        }
        horizontal=0;vertical=0;diagonalsame=0;diagonalsum=0;
    }

    public int decide(int i, int j)
    {
        int count = 0 ;
        String sign;
        horizontal=0;vertical=0;diagonalsame=0;diagonalsum=0;


        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if (i == m) {
                    if (gamezones[m][n] != null) {
                        sign = gamezones[m][n];
                        if(gamezones[i][j] == sign)
                        {
                            horizontal++;
                        }
                    }
                }
                if (j == n) {
                    if (gamezones[m][n] != null) {
                        sign = gamezones[m][n];
                        if(gamezones[i][j] == sign)
                        {
                            vertical++;
                        }
                    }
                }
                if (m == n) {
                    if (gamezones[m][n] != null) {
                        sign = gamezones[m][n];
                        if(gamezones[i][j] == sign)
                        {
                            diagonalsame++;
                        }
                    }
                }
                if (m+n == 2) {
                    if (gamezones[m][n] != null) {
                        sign = gamezones[m][n];
                        if(gamezones[i][j] == sign)
                        {
                            diagonalsum++;
                        }
                    }
                }
            }
        }
        if(horizontal == 3 || vertical == 3 || diagonalsame == 3 || diagonalsum == 3)  count = 3;
        else count = 0 ;
        return count;
    }
}
