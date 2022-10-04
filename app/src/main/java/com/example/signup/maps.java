package com.example.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.security.Permission;
import java.util.Map;

public class maps extends AppCompatActivity {

    SupportMapFragment smf;
    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        smf = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
        client = LocationServices.getFusedLocationProviderClient(this);

        Dexter.withContext(getApplicationContext())
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        getmylocation();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();

    }


    public void getmylocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(final Location location) {
                smf.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        LatLng latLng=new LatLng(28.67614202712363, 77.11323744541525);
                        LatLng Ind=new LatLng(28.6759917655773418, 77.11243380362569);
                        LatLng Ind1=new LatLng(28.675910640943098, 77.11317816497306);

                        MarkerOptions markerOptions=new MarkerOptions().position(latLng).title("you are here");
                        MarkerOptions markerOptions1=new MarkerOptions().position(Ind).title("Volunteer 1");
                        MarkerOptions markerOptions2=new MarkerOptions().position(Ind1).title("Volunteer 2");
                        googleMap.addMarker(markerOptions);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,17));
                        googleMap.addMarker(markerOptions1);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Ind,17));
                        googleMap.addMarker(markerOptions2);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Ind1,17));
                    }
                });
            }
        });
    }
}