package com.codeclub.coursestudio;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Login extends AppCompatActivity {
    MyCoreDatabase myData;
    EditText ed1, ed2;
    String name;
    String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1 = (EditText) findViewById(R.id.editText6);
        ed2 = (EditText) findViewById(R.id.editText7);
        name = ed1.getText().toString();
        age = ed2.getText().toString();
        myData = new MyCoreDatabase(this);
    }

    public void Welcome(View view) {
       /*boolean login= myData.getAll(name,age);
       if(login){

        */
       if(age.length() >0 && name.length() > 0){
           Intent i2 = new Intent(this, Welcome.class);
           i2.putExtra("Name", name);
           i2.putExtra("Age", age);
           startActivity(i2);
           Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

       }
    }

}
