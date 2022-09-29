package com.wtg.googlemaptest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectLocal5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_local5);

        findViewById(R.id.list1).setOnClickListener(mClick);
        findViewById(R.id.list2).setOnClickListener(mClick);
        findViewById(R.id.list3).setOnClickListener(mClick);
        findViewById(R.id.list4).setOnClickListener(mClick);
        findViewById(R.id.list5).setOnClickListener(mClick);
        findViewById(R.id.list6).setOnClickListener(mClick);
        findViewById(R.id.list7).setOnClickListener(mClick);
        findViewById(R.id.event01).setOnClickListener(mClick);
        findViewById(R.id.event02).setOnClickListener(mClick);
    }
    View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.list1:
                    Intent site1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.firefly.or.kr/index2.sgk"));
                    startActivity(site1);
                    break;
                case R.id.list2:
                    Intent site2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jinnamje.com/"));
                    startActivity(site2);
                    break;
                case R.id.list3:
                    Intent site3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/culture__art/?form=MY01SV&OCID=MY01SV"));
                    startActivity(site3);
                    break;
                case R.id.list4:
                    Intent site4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imsilfestival.com/"));
                    startActivity(site4);
                    break;
                case R.id.list5:
                    Intent site5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jangfestival.co.kr/ver2/"));
                    startActivity(site5);
                    break;
                case R.id.list6:
                    Intent site6 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.chunhyang.org/"));
                    startActivity(site6);
                    break;
                case R.id.list7:
                    Intent site7 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gochang.go.kr/tour/index.gochang?menuCd=DOM_000000403005001000"));
                    startActivity(site7);
                    break;
                case R.id.event01:
                    Intent event01 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://korean.visitkorea.or.kr/detail/event_detail.do?cotid=f9d4762c-d232-41c8-82a3-6e71c4c837a9"));
                    startActivity(event01);
                    break;
                case R.id.event02:
                    Intent event02 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://korean.visitkorea.or.kr/detail/rem_detail.do?cotid=d7d364ab-0c9e-4e1d-a4bd-f574ba1baac3&contype=12000"));
                    startActivity(event02);
                    break;
            }
        }
    };
}