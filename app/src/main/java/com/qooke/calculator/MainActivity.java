package com.qooke.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText editPercent;
    EditText editNumber;
    Button btnCalculator;
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPercent = findViewById(R.id.editPercent);
        editNumber = findViewById(R.id.editNumber);
        btnCalculator = findViewById(R.id.btnCalculator);
        txtResult = findViewById(R.id.txtResult);

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 1. 에디트 텍스트에서 유저가 입력한거 값 가져오기
                String strPercent = editPercent.getText().toString().trim();
                String strNumber = editNumber.getText().toString().trim();

                // 2. 유저가 입력 안했을 경우엔 필수 항목이라고 메세지 띄운다.
                if (strPercent.isEmpty() || strNumber.isEmpty()) {
                    Snackbar.make(btnCalculator, "필수 항목을 모두 입력하세요.", Snackbar.LENGTH_LONG).show();
                    return;
                }

                // 3-1. 문자를 숫자로 바꾼다.
                Double percent = Double.parseDouble(strPercent);
                Double number = Double.parseDouble(strNumber);

                // 3-2. 수식을 계산한다.
                // number * percent / 100
                double result = percent * number / 100;

                // 4. 계산 결과를 화면에 보여준다.y
                txtResult.setText("" + result);

            }
        });
    }
}