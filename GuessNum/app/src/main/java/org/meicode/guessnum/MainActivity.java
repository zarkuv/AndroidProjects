package org.meicode.guessnum;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int randomNum;
    private Button guessNum;
    private EditText editText;
    private TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNum = (int) (Math.random() * 10 + 1);
        Toast.makeText(MainActivity.this,
                "Created once" + randomNum, Toast.LENGTH_SHORT).show();

        Button btnNewGame = (Button) findViewById(R.id.btnNewGame);
        Button guessNum = (Button) findViewById(R.id.guessNum);
        editText = findViewById(R.id.editText);
        textView2 = findViewById(R.id.textView2);


        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNum = (int) (Math.random() * 10 + 1);
                Toast.makeText(MainActivity.this,
                        "Please Enter a number " + randomNum, Toast.LENGTH_SHORT).show();
            }
        });

        guessNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guessNum = editText.getText().toString();
                int num = Integer.parseInt(guessNum);
                if(num == randomNum) {
                    textView2.setVisibility(View.VISIBLE);
                    textView2.setTextColor(Color.parseColor("#00FF00"));
                    textView2.setText("Correct");
                }else {
                    textView2.setVisibility(View.VISIBLE);
                    textView2.setTextColor(Color.parseColor("#FF0000"));
                    textView2.setText("Wrong, try again");
                }
            }
        });
    }

}