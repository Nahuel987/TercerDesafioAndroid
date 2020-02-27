package com.example.desafiotres;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaSync;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desafiotres.api.Api;
import com.example.desafiotres.api.RetrofitClient;
import com.example.desafiotres.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView  pregunta,categoria,dificultad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicio las vistas
        iniciarVistas();
        //pregunta.setText("wenaaa");
        //categoria.setText("iiii");
        //dificultad.setText("ooooo");

        //retrofit
        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getQuestion();

        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                pregunta.setText(response.body().getResults().get(0).getQuestion());
                categoria.setText(response.body().getResults().get(0).getQuestion());
            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {

                Log.e("ERRORES",t.toString());
                Toast.makeText(MainActivity.this, "Existe un error", Toast.LENGTH_SHORT).show();
            }

        });
    }//on create

    private void iniciarVistas(){

        pregunta=findViewById(R.id.textViewDos);
        categoria=findViewById(R.id.textViewCuatro);
        dificultad =findViewById(R.id.textViewSeis);
    }

}//class
