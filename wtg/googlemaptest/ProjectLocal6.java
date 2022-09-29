package com.wtg.googlemaptest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectLocal6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_local6);

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
                    Intent site1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hotpinkdolphins.org/"));
                    startActivity(site1);
                    break;
                case R.id.list2:
                    Intent site2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://korean.visitkorea.or.kr/detail/fes_detail.do?cotid=b1c1d64e-82f3-46ff-88bc-99429a74cdf0&big_category=A02&mid_category=A0207&big_area=39"));
                    startActivity(site2);
                    break;
                case R.id.list3:
                    Intent site3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tamnafestival.kr/"));
                    startActivity(site3);
                    break;
                case R.id.list4:
                    Intent site4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jejuolle.org/office/kor/board/board_view.asp?page=1&search_idx=8134"));
                    startActivity(site4);
                    break;
                case R.id.list5:
                    Intent site5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://korean.visitkorea.or.kr/detail/fes_detail.do?cotid=3651e917-13fa-4616-bc70-75039a30ba22&big_category=A02&mid_category=A0207&big_area=39"));
                    startActivity(site5);
                    break;
                case R.id.list6:
                    Intent site6 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hueree.com/index.php"));
                    startActivity(site6);
                    break;
                case R.id.list7:
                    Intent site7 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jejuyouthday2022.modoo.at/"));
                    startActivity(site7);
                    break;
                case R.id.event01:
                    Intent event01 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://korean.visitkorea.or.kr/detail/event_detail.do?cotid=10d5390c-4edc-469a-be81-bab0f462b7fa"));
                    startActivity(event01);
                    break;
                case R.id.event02:
                    Intent event02 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://korean.visitkorea.or.kr/detail/event_detail.do?cotid=dac83e2f-99b9-4e33-ac6e-81e0fed8775d"));
                    startActivity(event02);
                    break;
            }
        }
    };
}