package ru.samsung.itschool.mdev.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{
    private Button btv;
    private TextView tv5,tv2,tv3,tv4;

    public int startCap, timeCap, everyCap, procentCap, resultCap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btv = findViewById(R.id.button);
        btv.setOnClickListener(this);

        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        final SeekBar seekBar2 = (SeekBar)findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(this);
        final SeekBar seekBar3 = (SeekBar)findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(this);
        final SeekBar seekBar4 = (SeekBar)findViewById(R.id.seekBar4);
        seekBar4.setOnSeekBarChangeListener(this);

        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);
    }



    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
            resultCap = startCap;
            for(int i = 0; i<timeCap; i++){
                resultCap += everyCap*12;
                resultCap += resultCap*procentCap;
            }
            String resultCap1 = Integer.toString(resultCap);

            intent.putExtra("ccc",resultCap1);
            //startActivity(intent); // его вызывают, когда мы не ждем данные обратно
            //startActivityForResult(intent,);
            startActivity(intent);
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.getId()==R.id.seekBar) {
            int temp;
            StringBuilder temp2 = new StringBuilder("Сумма при открытии счета: ");
            temp = Integer.parseInt((String.valueOf(seekBar.getProgress())));
            if (progress ==0) temp= 1;
            temp2.append(temp*12000);
            temp2.append(" рублей");
            tv2.setText(temp2);

        } else if(seekBar.getId()==R.id.seekBar2) {
            int temp;
            StringBuilder temp2 = new StringBuilder("На срок: ");
            temp = Integer.parseInt((String.valueOf(seekBar.getProgress())));
            if (progress == 0) temp = 1;
            temp2.append(temp);
            if (temp == 1){
                temp2.append(" год");
            }
            else if (temp <5){
                temp2.append(" года");
            }
            else temp2.append(" лет");
            tv3.setText(temp2);

        } else if(seekBar.getId()==R.id.seekBar3) {
            int temp;
            StringBuilder temp2 = new StringBuilder("Ежемесячное пополнение: ");
            temp = Integer.parseInt((String.valueOf(seekBar.getProgress())));
            if (progress ==0) temp= 1;
            temp2.append(temp*3000);
            temp2.append(" рублей");
            tv4.setText(temp2);


        } else if(seekBar.getId()==R.id.seekBar4) {
            int temp;
            StringBuilder temp2 = new StringBuilder("Ставка в год: ");
            temp = Integer.parseInt((String.valueOf(seekBar.getProgress())));
            if (progress ==0) temp= 1;
            temp2.append(temp);
            temp2.append("%");
            tv5.setText(temp2);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() == R.id.seekBar) {
            int temp = Integer.parseInt((String.valueOf(seekBar.getProgress())));
            if (temp == 0) temp = 1;
            startCap = temp * 12000;
        } else if (seekBar.getId() == R.id.seekBar2) {
            int temp = Integer.parseInt((String.valueOf(seekBar.getProgress())));
            if (temp == 0) temp = 1;
            timeCap = temp;
        } else if(seekBar.getId()==R.id.seekBar3) {
            int temp = Integer.parseInt((String.valueOf(seekBar.getProgress())));
            if (temp == 0) temp = 1;
            everyCap = temp;
        } else if(seekBar.getId()==R.id.seekBar4) {
            int temp = Integer.parseInt((String.valueOf(seekBar.getProgress())));
            if (temp == 0) temp = 1;
            procentCap = temp;
        }
    }
}