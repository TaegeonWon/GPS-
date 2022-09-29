package com.wtg.googlemaptest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectLocal4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_local4);

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
                    Intent site1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://festival.phcf.or.kr/fireWorks/subMain.do"));
                    startActivity(site1);
                    break;
                case R.id.list2:
                    Intent site2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ginsengexpo.org/yjexpo/main.do"));
                    startActivity(site2);
                    break;
                case R.id.list3:
                    Intent site3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.busanrockfestival.com/"));
                    startActivity(site3);
                    break;
                case R.id.list4:
                    Intent site4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gyeongju.go.kr/sillafestival/index.do"));
                    startActivity(site4);
                    break;
                case R.id.list5:
                    Intent site5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bfo.or.kr/main/index.asp"));
                    startActivity(site5);
                    break;
                case R.id.list6:
                    Intent site6 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.chimacfestival.com/"));
                    startActivity(site6);
                    break;
                case R.id.list7:
                    Intent site7 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bicf.kr/"));
                    startActivity(site7);
                    break;
                case R.id.event01:
                    Intent event01 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://daeguchallenge.com/"));
                    startActivity(event01);
                    break;
                case R.id.event02:
                    Intent event02 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://korean.visitkorea.or.kr/detail/event_detail.do?cotid=191929c0-ce67-491a-9822-410d41bff714"));
                    startActivity(event02);
                    break;
            }
        }
    };
}