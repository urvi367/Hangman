package com.example.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends MainActivity {

    TextView t1,t2,t3;
    EditText e1;
    Button b;
    char[] disp=new char[100];
    char[] h={'H','A','N','G','M','A','N'};
    int x=0,counter,winner=0,win;
    String m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        t3 = (TextView)findViewById(R.id.t3);
        b = (Button) findViewById(R.id.b);
        e1 = (EditText) findViewById(R.id.e1);

        display_h();

        m = getIntent().getStringExtra("movie");
        for(int i=0;i<m.length();i++ )
        {
            if(m.charAt(i)!='a' && m.charAt(i)!='e' && m.charAt(i)!='i' && m.charAt(i)!='o' && m.charAt(i)!='u' && m.charAt(i)!=' ' ) {
                disp[i]='-';
            }
            else
            {
                disp[i]=m.charAt(i);
            }
        }
        String newmov=String.valueOf(disp);
        t2.setText(newmov);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter=0;
                    win=1;

                    String in = e1.getText().toString().toLowerCase();
                    if (in.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "Guess!", Toast.LENGTH_SHORT).show();
                    }
                    else if (in.length()>1) {
                        Toast.makeText(getApplicationContext(), "One alphabet at once!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        for (int j = 0; j < m.length(); j++)
                        {
                            if (in.charAt(0) == m.charAt(j) && disp[j]=='-')
                            {
                                disp[j] = m.charAt(j);
                                counter = 1;
                            }
                        }

                        if (counter == 1) {
                            String newmov = String.valueOf(disp);
                            t2.setText(newmov);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Wrong guess!", Toast.LENGTH_SHORT).show();
                            for (int k = 0; k < 7; k++) {
                                if (h[k] !='*')
                                { h[k]='*';
                                  x++;
                                  break;
                                }
                            }
                            display_h();
                        }

                        checkwin();

                        if(x<7 && win==1)
                        {
                           winner=2;
                            //Toast.makeText(getApplicationContext(), "YOU WIN!", Toast.LENGTH_LONG).show();
                        }
                        if(x==7 && win==0)
                        {
                           winner=1;
                            //Toast.makeText(getApplicationContext(), "YOU LOOSE!", Toast.LENGTH_LONG).show();
                        }


                       if(winner==1 || winner==2)
                        {
                            Intent z=new Intent(SecondActivity.this,ThirdActivity.class);
                            z.putExtra("winnerr",winner);
                            startActivity(z);
                            finish();
                        }
                    }
                }
            });
        }

        void display_h()
        {
            String um=String.valueOf(h);
            t3.setText(um);
        }

        void checkwin()
        {
            for(int i=0;i<m.length();i++)
            {
                if(disp[i]=='-')
                    win=0;
            }
        }
}