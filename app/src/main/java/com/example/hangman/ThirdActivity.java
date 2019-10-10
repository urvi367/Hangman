package com.example.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends MainActivity {
    int win;
    String l="YOU LOOSE :/",w="YOU WIN! :p";
    TextView q,f;
    ImageView i2;
    Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        win = getIntent().getIntExtra("winnerr",0);
        q = (TextView)findViewById(R.id.q);
        f = (TextView)findViewById(R.id.f);
        i2 = (ImageView)findViewById(R.id.i2);
        button= (Button) findViewById(R.id.button);
        button2= (Button) findViewById(R.id.button2);

        if(win==1)
        {
            f.setText(l);
            i2.setImageResource(R.drawable.go);
        }
        else if(win==2)
        {
            f.setText(w);
        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  //closes third activity only use something else

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z=new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(z);
            }
        });
    }
}
