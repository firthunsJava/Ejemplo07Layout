package com.firthuns.ejemplo07layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnGirarPantalla;
    private Button btnLogin;
private  int veces=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGirarPantalla = findViewById(R.id.btnGirarPantalla);
        btnLogin = findViewById(R.id.button);

        btnGirarPantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
veces+=1;
                // RequestOrientation -> Land / Portrait -> get / set
                if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }else{
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        });

        Log.d("ESTADOS", "01-onCreate - " + veces);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ESTADOS", "02-onStart- " + veces);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ESTADOS", "03-onResume- " + veces);
        btnLogin.setText(String.valueOf(veces));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ESTADOS", "04-onPause- " + veces);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ESTADOS", "05-onStop- " + veces);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ESTADOS", "06-ondestroy- " + veces);
    }

// dos metodos, uno para guardar la actividad que no quieres perder
    // y las otra recuperar los datos que no quieres perder

    /**
     *  Automaticamente , antes de la actividad se destruya.
     * @param outState -> Bundle donde guardo la informaci??n  es el que se env??a a onRestore....
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("VECES", veces);
    }

    /**
     * Si se ha guardado algo , se ejecuta este m??tdo para recatar la informaci??n
     * @param savedInstanceState -> Contiene los datos guardados en el m??todo ONsAVEiNSTANTEsTATE
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        veces = savedInstanceState.getInt("VECES");
        Log.d("ESTADOS", "-----onRestoreInstanceState");
    }



}