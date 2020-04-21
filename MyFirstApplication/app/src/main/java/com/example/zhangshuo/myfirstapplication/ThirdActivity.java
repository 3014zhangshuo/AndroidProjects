package com.example.zhangshuo.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        final Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("ThirdActivity", data);

        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivityForResult(intent1, RESULT_FIRST_USER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("RequestCode", "value: " + requestCode);

        switch (requestCode) {
            case RESULT_FIRST_USER:
                String returnedData = data.getStringExtra("data_return");
                Log.d("ThirdActivity", returnedData);
                break;
            default:
        }
    }
}
