package com.example.gpa_santda_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText edit1, edit2, edit3, edit4, edit5;
    TextView txt1;
    ConstraintLayout c1;
    int y=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1=(ConstraintLayout)findViewById(R.id.con1);

        edit1=(EditText)findViewById(R.id.editText1);
        edit2=(EditText)findViewById(R.id.editText2);
        edit3=(EditText)findViewById(R.id.editText3);
        edit4=(EditText)findViewById(R.id.editText4);
        edit5=(EditText)findViewById(R.id.editText5);

        txt1=(TextView)findViewById(R.id.textView8);

        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(v->{

                if(y%2>0) {
                    edit1.setText("");
                    edit2.setText("");
                    edit3.setText("");
                    edit4.setText("");
                    edit5.setText("");
                    btn1.setText("Compute GPA");
                    txt1.setText("");
                    edit5.clearFocus();
                    c1.setBackgroundColor(getResources().getColor(R.color.colorDefault));
                    y++;
                    return;
                }
                else{
                if(edit1.getText().toString().isEmpty()|| edit2.getText().toString().isEmpty() || edit3.getText().toString().isEmpty() || edit4.getText().toString().isEmpty() || edit5.getText().toString().isEmpty() )
                    Toast.makeText(MainActivity.this, "Please fill in every grade", Toast.LENGTH_SHORT).show();
                     else {
                     Double x;
                     x = (Double.parseDouble(edit1.getText().toString()) + Double.parseDouble(edit2.getText().toString()) + Double.parseDouble(edit3.getText().toString()) + Double.parseDouble(edit4.getText().toString()) + Double.parseDouble(edit5.getText().toString())) / 5;
                     txt1.setText("Your Calculated GPA is: " + String.valueOf(x));
                     if(x<60)
                        c1.setBackgroundColor(getResources().getColor(R.color.colorBelow60));
                         else
                             if(x>=60 && x<=79)
                            c1.setBackgroundColor(getResources().getColor(R.color.colorBetween6179));
                         else
                            c1.setBackgroundColor(getResources().getColor(R.color.colorAbove80));

                         btn1.setText("Clear");
                         y++;
                    }
                }
        });



    }
}
