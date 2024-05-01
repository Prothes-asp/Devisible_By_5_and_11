package com.prothesbrand.divisiblebyfiveandeleven;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edText;
    private Button btn;
    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES,WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edText);
        btn = findViewById(R.id.btn);
        tvDisplay = findViewById(R.id.tvDisplay);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String getStr = edText.getText().toString();
               if (getStr.length() > 0 ){
                   long num = Long.parseLong(getStr);
                   if (num%5==0 && num%11==0){
                       tvDisplay.setText(""+"This number is"+"\n Divisible By Both");
                   }else if(num%5==0){
                       tvDisplay.setText(""+"This number is"+"\n Divisible By only 5");
                   }else if(num%11==0){
                       tvDisplay.setText(""+"This number is"+"\n Divisible By only 11");
                   }else{
                       tvDisplay.setText(""+"This number Cannot"+"\n Divisible By 5 and 11");
                   }
               }else{
                   edText.setError("Empty");
                   Toast.makeText(MainActivity.this, "Field is Empty", Toast.LENGTH_SHORT).show();
                   tvDisplay.setText(null);
               }
            }
        });

    }
}