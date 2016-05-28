package com.nickjwpark.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewMessage;
    Button btnSave;
    Button btnDelete;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        sharedPref = this.getSharedPreferences("com.nickjwpark.sharedpreference", Context.MODE_PRIVATE);
        String defaultValue = "Message";
        String message = sharedPref.getString("message", defaultValue);

        textViewMessage.setText(message);

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("message", "Hello World!");
                editor.commit();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.remove("message");
                //다 지우려면 editor.clear(); 을 사용한다
                editor.commit();
            }
        });

    }
}
