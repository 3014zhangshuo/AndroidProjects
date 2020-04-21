package com.example.zhangshuo.myfirstapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello zhangshuo");
                setResult(RESULT_FIRST_USER, intent);
                finish();
            }
        });

        Button buttonPassData = (Button) findViewById(R.id.button_pass_data);
        buttonPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Hello ThirdActivity";
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello zhangshuo");
        setResult(RESULT_FIRST_USER, intent);
        finish();
    }
}
