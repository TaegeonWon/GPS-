package com.wtg.googlemaptest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectLocal2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_local2);

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
                    Intent site1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mdfestival.com/"));
                    startActivity(site1);
                    break;
                case R.id.list2:
                    Intent site2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.happyhanwoofestival.com/"));
                    startActivity(site2);
                    break;
                case R.id.list3:
                    Intent site3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ddcwj.com/"));
                    startActivity(site3);
                    break;
                case R.id.list4:
                    Intent site4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ccsool.co.kr/"));
                    startActivity(site4);
                    break;
                case R.id.list5:
                    Intent site5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hsg.go.kr/tour/00001386/00001390.web"));
                    startActivity(site5);
                    break;
                case R.id.list6:
                    Intent site6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coffeefestival.net/"));
                    startActivity(site6);
                    break;
                case R.id.list7:
                    Intent site7 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cruisestory.co.kr/"));
                    startActivity(site7);
                    break;
                case R.id.event01:
                    Intent event01 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://event.impacsys.me/home/kwdevent"));
                    startActivity(event01);
                    break;
                case R.id.event02:
                    Intent event02 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/gogw1234/221812737076"));
                    startActivity(event02);
                    break;
            }
        }
    };
}