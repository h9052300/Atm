package com.example.admin.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    boolean logon = false;
    public static final int FUNC_LOGIN = 1; //新增一個類別層級常數FUNC_LOGIN，代表登入功能


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon) { //如果未登入，則開啟"登入Activity"
            Intent intent = new Intent(this, LoginActivity.class);
            //startActivity(intent);
            startActivityForResult(intent, FUNC_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FUNC_LOGIN) {
            String uid = data.getStringExtra("LOGIN_USERID");
            String pw = data.getStringExtra("LOGIN_PASSWD");
            Log.d("RESULT", uid + "/" + pw);
        } else {
            finish();
        }
    }
}
