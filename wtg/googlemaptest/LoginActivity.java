package com.wtg.googlemaptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText et_id, et_pass;
    private Button btn_login, btn_nologin;
    private TextView btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        btn_nologin = findViewById(R.id.btn_nologin);
        btn_register = findViewById(R.id.btn_register);



        // 회원가입 버튼 이벤트
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_nologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력할 아이디,비번 값 받아오기
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();



                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) 
                    {
                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);
                            // login.php 에 있는 response의 키 값을 가져와서 true/false를 비교 (register.php쓰는것과 동일함)
                            boolean success = jsonObject.getBoolean("success");
                            if(success) // 로그인 성공 시(success = true)
                            {

                                String userID = jsonObject.getString("userID");
                                // Login.php에는 'userPassword'라고 되어있음
                                String userPass = jsonObject.getString("userPassword");
                                Toast.makeText(getApplicationContext(),"로그인 되었습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                // 액티비티 넘어갈 때 입력한 id,ps값 같이 가져가려고 저장해놓음
                                intent.putExtra("userID",userID);
                                intent.putExtra("userPass",userPass);
                                startActivity(intent);
                            }
                            else  // 로그인 실패 시(success = false)
                            {
                                Toast.makeText(getApplicationContext(),"로그인에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }

                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);



            }
        });

    }
}