package com.codeclub.coursestudio;

import android.content.Intent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText ed,ed2,ed3,ed5;
    AutoCompleteTextView hobbies;
    MyCoreDatabase myData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed5=(EditText)findViewById(R.id.editText5);
        hobbies=(AutoCompleteTextView)findViewById(R.id.hobbies);

        myData=new MyCoreDatabase(this);
    }

    public void Login(View view) {
        int edlen=ed.length();
        int ed2len=ed2.length();
        int ed3len=ed3.length();
        int ed5len=ed5.length();
        int hb=hobbies.length();
        //int age=Integer.valueOf(ed2.toString());
       // int dob=Integer.valueOf(ed5.toString());
        if(edlen > 0 && ed2len > 0  && ed3len > 0 && ed5len > 0 && hb > 0){
            //myData.insert(ed.toString(),ed2.toString(),ed3.toString(),hobbies.toString(),ed5.toString());
            Intent in1=new Intent(this,Login.class);
            startActivity(in1);
        }
        else {
            Toast.makeText(this,"Check every input",Toast.LENGTH_SHORT).show();
        }
    }

    public void loadlogin(View view) {
        Intent in2=new Intent(this,Login.class);
        startActivity(in2);
    }
}
