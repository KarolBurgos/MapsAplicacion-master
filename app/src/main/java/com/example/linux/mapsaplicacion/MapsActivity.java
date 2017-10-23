package com.example.linux.mapsaplicacion;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.linux.mapsaplicacion.api.DatosApi;
import com.example.linux.mapsaplicacion.models.Inmuebles;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener {

    public static final String EXTRA_LATITUD = "";
    public static final String EXTRA_LONGITUD = "";
    private GoogleMap mMap;
    private Marker markerPais;
    public final static String TAG ="DATOS COLOMBIA";
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        retrofit=new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        obtenerDatos();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        UiSettings uiSettings=mMap.getUiSettings();
        uiSettings.setScrollGesturesEnabled(true);
        uiSettings.setTiltGesturesEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        //brujula
        uiSettings.setCompassEnabled(true);

        //boton mi ubicacion
        uiSettings.setMyLocationButtonEnabled(true);
        //uiSettings.setZoomControlsEnabled(true);
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(1.219586, -77.282971);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Mi casa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        float zoomlevel=17;
       // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoomlevel));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //eetiquetas

        MarkerOptions markerOptions =
                new MarkerOptions()
                        .position(sydney)
                        .title("Casa Karol")
                        .snippet("Primer ministro: Shinzō Abe").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        Marker marker = googleMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoomlevel));

        // Cámara
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //Eventos
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);
        googleMap.setOnInfoWindowClickListener(this);

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

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
