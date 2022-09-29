package com.wtg.googlemaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapBasic extends AppCompatActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button btn_gps;
    private Button btn_search;
    private Button btn_search2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapbasic);
        //fragment 사용
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_gps = findViewById(R.id.btn_gps);
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapBasic.this, GpsAuto.class);
                startActivity(intent);
            }
        });
        btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity_search = new Intent(MapBasic.this, Search1.class);
                startActivity(activity_search);
            }
        });
        btn_search2 = findViewById(R.id.btn_search2);
        btn_search2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity_search2 = new Intent(MapBasic.this, SearchActivity.class);
                startActivity(activity_search2);
            }
        });


    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;
        
        //서울 위도 경ㄹ도
        LatLng SEOUL = new LatLng(37.56, 126.97);

        //마커 옵션(마커 클릭 시 설명)
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");
        mMap.addMarker(markerOptions);
        //카메라를 줌 위치로 이동시킴 + 줌 범위 : 숫자가 작을수록 멀리 보여줌
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 10));

    }

}