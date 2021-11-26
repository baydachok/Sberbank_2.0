package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn3;
    private EditText ed3;
    public static final int INFOACTIVITY_CODE = 300; // некий код, который идентифицирует активность

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tv = findViewById(R.id.textView);
        btn3 = findViewById(R.id.button3);
        ed3 = findViewById(R.id.editText3);

        Bundle bundle = getIntent().getExtras(); // она может быть null
        if(bundle != null) {
            tv.setText(bundle.getString("ccc"));
        }

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ppp",ed3.getText().toString());
                setResult(INFOACTIVITY_CODE,intent); // возвращаем код активности и намерение
                finish(); // завершаем работу тек. активности
            }
        });

    }
}