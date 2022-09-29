package com.wtg.googlemaptest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    WebView webView2;
    LinearLayout frame1, frame2, frame3, frame4, frame5;
    LinearLayout btnSpring, btnSummer, btnFall, btnWinter;
    Button btnGo;
    TextView tv_receive;
    TextView tv_receive2;
    double latitude;
    double longitude;
    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_main);





// 로그인 시 입력한 id 값 뿌려주기
        // 홈화면에 뿌려주기
        tv_receive = (TextView)findViewById(R.id.txtUser);
        // 마이페이지에 뿌려주기
        tv_receive2 = (TextView)findViewById(R.id.txtName);
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        tv_receive.setText(userID);
        tv_receive2.setText(userID);

    // 마이페이지 확장 리스트뷰 부분    
        ExpandableListView elv = (ExpandableListView) findViewById(R.id.ExpandablelistView);
        final ArrayList<Position> position = getData();

        Adapter adapter1 = new Adapter(this, position);
        elv.setAdapter(adapter1);

        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), position.get(groupPosition).players.get(childPosition), Toast.LENGTH_LONG).show();
                return false;
            }
        });

        //  지도
        String keyWord = "관광명소";
        webView2 = (WebView) findViewById(R.id.webview2);
        webView2.setWebViewClient(new SearchActivity.MyWebClient());
        WebSettings set = webView2.getSettings();
        set.setJavaScriptEnabled(true);
        set.setBuiltInZoomControls(true);
        String urlAddr = "https://www.google.co.kr/maps/search/%EA%B4%80%EA%B4%91%EB%AA%85%EC%86%8C/data=!3m1!4b1?hl=ko" +keyWord+"/@"+latitude+","+longitude+",17z/data=!3m1!4b1?hl=ko";
        webView2.loadUrl(urlAddr);


        Log.d("지도화면:","검색키워드:"+ keyWord + "/ 위경도:"+ latitude+"/"+longitude);


        // 메인 뷰페이저
        mPager = findViewById(R.id.viewpager);
        //Adapter
        pagerAdapter = new MyAdapter(this, num_page);
        mPager.setAdapter(pagerAdapter);

        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        mPager.setCurrentItem(1000); //시작 지점
        mPager.setOffscreenPageLimit(4); //최대 이미지 수

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

            }
        });

        frame1 = (LinearLayout) findViewById(R.id.frame1_Home);
        frame2 = (LinearLayout) findViewById(R.id.frame2_Search);
        frame3 = (LinearLayout) findViewById(R.id.frame3_Gps);
        frame4 = (LinearLayout) findViewById(R.id.frame4_Member);
        frame5 = (LinearLayout) findViewById(R.id.frame5_Non);

        findViewById(R.id.btnHome).setOnClickListener(mClick);
        findViewById(R.id.btnSearch).setOnClickListener(mClick);
        findViewById(R.id.btnGps).setOnClickListener(mClick);
        findViewById(R.id.btnMypage).setOnClickListener(mClick);
        findViewById(R.id.btnGo).setOnClickListener(mClick);

        findViewById(R.id.local_1).setOnClickListener(mClick);
        findViewById(R.id.local_2).setOnClickListener(mClick);
        findViewById(R.id.local_3).setOnClickListener(mClick);
        findViewById(R.id.local_4).setOnClickListener(mClick);
        findViewById(R.id.local_5).setOnClickListener(mClick);
        findViewById(R.id.local_6).setOnClickListener(mClick);

        findViewById(R.id.btnSpring).setOnClickListener(mClick);
        findViewById(R.id.btnSummer).setOnClickListener(mClick);
        findViewById(R.id.btnFall).setOnClickListener(mClick);
        findViewById(R.id.btnWinter).setOnClickListener(mClick);


    }

    /** 하단바 (이동) **/
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
//            frame1.setVisibility(View.VISIBLE);
//            frame2.setVisibility(View.INVISIBLE);
//            frame3.setVisibility(View.INVISIBLE);
//            frame4.setVisibility(View.INVISIBLE);
//            frame5.setVisibility(View.INVISIBLE);

            switch(v.getId())
            {
                case R.id.btnHome:
                    frame1.setVisibility(View.VISIBLE);
                    frame2.setVisibility(View.INVISIBLE);
                    frame3.setVisibility(View.INVISIBLE);
                    frame4.setVisibility(View.INVISIBLE);
                    frame5.setVisibility(View.INVISIBLE);
                    break;
                case R.id.btnSearch:
                    frame2.setVisibility(View.VISIBLE);
                    frame1.setVisibility(View.INVISIBLE);
                    frame3.setVisibility(View.INVISIBLE);
                    frame4.setVisibility(View.INVISIBLE);
                    frame5.setVisibility(View.INVISIBLE);
                    break;
                    // 관광명소
                case R.id.btnGps:
                    frame3.setVisibility(View.VISIBLE);
                    frame1.setVisibility(View.INVISIBLE);
                    frame2.setVisibility(View.INVISIBLE);
                    frame4.setVisibility(View.INVISIBLE);
                    frame5.setVisibility(View.INVISIBLE);
                    break;
                case R.id.btnMypage:
                    frame4.setVisibility(View.VISIBLE);
                    frame1.setVisibility(View.INVISIBLE);
                    frame2.setVisibility(View.INVISIBLE);
                    frame3.setVisibility(View.INVISIBLE);
                    frame5.setVisibility(View.INVISIBLE);
                    break;

                case R.id.btnGo:
                    Intent activity_search = new Intent(MainActivity.this, Search1.class);
                    startActivity(activity_search);
                    break;

                case R.id.local_1:
                    Intent local1 = new Intent(MainActivity.this, ProjectLocal1.class);
                    startActivity(local1);
                    break;

                case R.id.local_2:
                    Intent local2 = new Intent(MainActivity.this, ProjectLocal2.class);
                    startActivity(local2);
                    break;

                case R.id.local_3:
                    Intent local3 = new Intent(MainActivity.this, ProjectLocal3.class);
                    startActivity(local3);
                    break;

                case R.id.local_4:
                    Intent local4 = new Intent(MainActivity.this, ProjectLocal4.class);
                    startActivity(local4);
                    break;

                case R.id.local_5:
                    Intent local5 = new Intent(MainActivity.this, ProjectLocal5.class);
                    startActivity(local5);
                    break;

                case R.id.local_6:
                    Intent local6 = new Intent(MainActivity.this, ProjectLocal6.class);
                    startActivity(local6);
                    break;

                case R.id.btnSpring:
                    Intent spring = new Intent(MainActivity.this, ProjectSpring.class);
                    startActivity(spring);
                    break;

                case R.id.btnSummer:
                    Intent summer = new Intent(MainActivity.this, ProjectSummer.class);
                    startActivity(summer);
                    break;

                case R.id.btnFall:
                    Intent fall = new Intent(MainActivity.this, ProjectFall.class);
                    startActivity(fall);
                    break;

                case R.id.btnWinter:
                    Intent winter = new Intent(MainActivity.this, ProjectWinter.class);
                    startActivity(winter);
                    break;
            }

        }
    };

    private ArrayList<Position> getData() {

        Position p1 = new Position("개발자 정보");
        p1.players.add("원태건");
        p1.players.add("최예슬");
        p1.players.add("방준원");
        p1.players.add("정미진");

        Position p2 = new Position("고객센터");
        p2.players.add("010-1234-5678");


        Position p3 = new Position("공지사항");
        p3.players.add("DW아카데미");
        p3.players.add("팀프로젝트");

        Position p4 = new Position("FAQ(자주 묻는 질문)");
        p4.players.add("Q. 애인있어요 ?");
        p4.players.add("A. 네 있습니다.");


        ArrayList<Position> allposition = new ArrayList<>();
        allposition.add(p1);
        allposition.add(p2);
        allposition.add(p3);
        allposition.add(p4);

        return allposition;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
// 메뉴를 부풀립니다. 그러면 수행 표시줄에 항목이 추가됩니다.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
// 수행 표시줄 항목 클릭을 처리합니다. 수행 표시줄은
// 홈/업 버튼 클릭을 자동으로 처리합니다. 너무 깁니다.
// AndroidManifest.xml에서 부모 활동을 지정하는 것처럼.
        int id = item.getItemId();

// noinspection SimplifiableIfStatement
// 검사 없음 Simplified If 문
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

}


