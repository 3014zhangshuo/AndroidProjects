package com.example.zhangshuo.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    private ImageView imageView;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button alert_dialog_button = (Button) findViewById(R.id.alert_dialog_button);
        Button progress_dialog_button = (Button) findViewById(R.id.progress_dialog_button);
        Button change_image_src_button = (Button) findViewById(R.id.change_image_src_button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
        alert_dialog_button.setOnClickListener(this);
        progress_dialog_button.setOnClickListener(this);
        change_image_src_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
    //            if (progressBar.getVisibility() == View.GONE) {
    //                progressBar.setVisibility(View.VISIBLE);
    //            } else {
    //                progressBar.setVisibility(View.GONE);
    //            }
                int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setProgress(progress);
                break;
            case R.id.change_image_src_button:
                imageView = (ImageView) findViewById(R.id.image_view);
                Log.d("Drawable", "ID: " + imageView.getId());

                Integer imageTag = (Integer) imageView.getTag();
                imageTag = imageTag == null ? 0 : imageTag
                if (imageTag == R.drawable.img_1) {
                    imageView.setImageResource(R.drawable.img_2);
                } else {
                    imageView.setImageResource(R.drawable.img_1);
                }
                break;
            case R.id.alert_dialog_button:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something improtant");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            case R.id.progress_dialog_button:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
            default:
                break;
        }
    }
}
