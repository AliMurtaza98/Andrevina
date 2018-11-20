package com.example.tnb_20.joc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int contador=1;
    public String name_text = "";
    public static Player jugador = new Player();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        final int numrandom = random.nextInt(100);
        System.out.println(numrandom);
        final Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String string = String.valueOf(editText.getText());
                int num = Integer.parseInt(string);
                if(num < numrandom){
                    contador++;
                    Context context = getApplicationContext();
                    CharSequence texto = "No. Pon uno mas grande !";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, texto, duration);
                    toast.show();

                }

                else if(num > numrandom){
                    contador++;
                    Context context = getApplicationContext();
                    CharSequence texto = "No. Pon uno mas pequeño !";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, texto, duration);
                    toast.show();
                }

                else if(num == numrandom){
                    Context context = getApplicationContext();
                    CharSequence texto = "Felicidades. Es correcto !\nIntentos: "+contador;
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, texto, duration);
                    toast.show();
                    Dialog();
                }
            }
        });
    }

    public void Dialog() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                openDialog();
            }
        }, 2000);
    }
        public void openDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Your Name");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                name_text = input.getText().toString();
                Intent intent = new Intent(getApplicationContext(),FameActivity.class);
                Bundle bundle = new Bundle();

                intent.putExtra("name", name_text);
                intent.putExtra("intentos",contador);
                startActivity(intent);

            }
        });
        builder.show();
    }


}