package com.wtg.googlemaptest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_intro);

        //이벤트 핸들러를 통해서 몇초후의 동작을 시킴...
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent intent = new Intent (ProjectIntro.this, LoginActivity.class);
                startActivity(intent); //인트로 실행 후 바로 MainActivity로 넘어감.
                finish();
            }
        },3000); //3초 후 인트로 실행

    }

}
