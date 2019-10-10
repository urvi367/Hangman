package com.example.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TextView textView5, textView7;
    EditText textView8;
    Button button2;
    String mov;
    ImageView imageView;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            textView5 = (TextView)findViewById(R.id.textView5);
            textView7 = (TextView)findViewById(R.id.textView7);
            textView8 = (EditText)findViewById(R.id.textView8);
            button2 = (Button)findViewById(R.id.button2);
            imageView = (ImageView)findViewById(R.id.imageView);

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mov=textView8.getText().toString().toLowerCase();

                    if(mov.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "Enter a movie!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Player 2's turn!", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this,SecondActivity.class);
                        i.putExtra("movie",mov);
                        startActivity(i);
                        finish();
                    }
                }
            });
        }
}
