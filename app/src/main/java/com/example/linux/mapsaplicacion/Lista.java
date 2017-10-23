package com.example.linux.mapsaplicacion;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.linux.mapsaplicacion.api.DatosApi;
import com.example.linux.mapsaplicacion.models.Inmuebles;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Lista extends AppCompatActivity {

    public final static String TAG ="DATOS COLOMBIA";
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        retrofit=new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        obtenerDatos();
    }

    public void obtenerDatos(){

        DatosApi service=retrofit.create(DatosApi.class);
        Call<List<Inmuebles>> municipioCall=service.obtenerListaInmuebles();

        municipioCall.enqueue(new Callback<List<Inmuebles>>() {
            @Override
            public void onResponse(Call<List<Inmuebles>> call, Response<List<Inmuebles>> response) {

                if(response.isSuccessful()){
                    List lista=response.body();
                    for(int i=0;i<lista.size();i++){
                        Inmuebles m=(Inmuebles) lista.get(i);
                        Log.i(TAG,"Codigo: "+m.getCodigo()+" Ciudad: "+m.getCiudad());

                    }
                }
                else {
                    Log.e(TAG,"onResponse"+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Inmuebles>> call, Throwable t) {

                Log.e(TAG,"onFailure"+t.getMessage());
            }
        });
    }
}
