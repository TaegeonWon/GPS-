package com.wtg.googlemaptest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectLocal1 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_local1);

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
                    Intent site1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bamdokkaebi.org/"));
                    startActivity(site1);
                    break;
                case R.id.list2:
                    Intent site2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.chf.or.kr/cont/view/fest/month/menu/210?thisPage=1&idx=108793&searchCategory1=600&searchCategory2=&searchField=all&searchDate=202209&weekSel=undefined&searchText="));
                    startActivity(site2);
                    break;
                case R.id.list3:
                    Intent site3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jarasumjazz.com/"));
                    startActivity(site3);
                    break;
                case R.id.list4:
                    Intent site4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.koreanfolk.co.kr/event/event_now.asp"));
                    startActivity(site4);
                    break;
                case R.id.list5:
                    Intent site5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sscampus.kr/"));
                    startActivity(site5);
                    break;
                case R.id.list6:
                    Intent site6 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafeshow.com/kor/event/festival9.asp"));
                    startActivity(site6);
                    break;
                case R.id.list7:
                    Intent site7 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cultureseoul.co.kr/"));
                    startActivity(site7);
                    break;
                case R.id.event01:
                    Intent event01 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://kq-event.com/front/rumor_event.do"));
                    startActivity(event01);
                    break;
                case R.id.event02:
                    Intent event02 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ito.or.kr/main/bbs/bbsMsgDetail.do?msg_seq=635&bcd=notice"));
                    startActivity(event02);
                    break;
            }
        }
    };
}
