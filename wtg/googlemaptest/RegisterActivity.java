package com.wtg.googlemaptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_name, et_age;
    private Button btn_register;

    @Override //액티비티 시작 시 처음으로 실행
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        // 아이디, 기타 값 찾기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        
        // 회원가입 버튼 기능
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 입력한 값을 getText로 가져옴
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                int userAge = Integer.parseInt(et_age.getText().toString());

                //서버에 전송할 시 활용하는 Json을 운반,파싱하는 기능
                Response.Listener<String> responseListener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);
                            // register.php 에 있는 response의 키 값을 가져와서 true/false를 비교
                            boolean success = jsonObject.getBoolean("success");
                            if(success) // 회원가입 성공 시(success = true)
                            {
                                Toast.makeText(getApplicationContext(),"회원가입이 완료되었습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }
                            else  // 회원가입 실패 시(success = false)
                            {
                                Toast.makeText(getApplicationContext(),"회원가입에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }

                    }
                };
                // class RegisterRequest에 있는 생성자에 넣을 값(userID 등)을 설정
                RegisterRequest registerRequest = new RegisterRequest(userID, userPass, userName, userAge, responseListener);
                //  Volley를 사용해서 서버에 요청
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);




            }
        });



    }
}