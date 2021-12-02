package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton$InspectionCompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv5;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tv5 = findViewById(R.id.textView3);
        btn = findViewById(R.id.button2);
        btn.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras(); // она может быть null
        if(bundle != null) {
            tv5.setText(bundle.getString("ccc"));
        }else{
            tv5.setText("hi");
        }




    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}