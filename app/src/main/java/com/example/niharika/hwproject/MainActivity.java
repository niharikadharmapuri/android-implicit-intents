package com.example.niharika.hwproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn= (Button)findViewById(R.id.buttonid);
        //implement the Java interface View.OnClickListener using an anonymous class

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // opening Activity2 using explicit intent
                Intent intent= new Intent(getApplicationContext(), Activity2.class);
                startActivity(intent);

            }
        });


    }

}
