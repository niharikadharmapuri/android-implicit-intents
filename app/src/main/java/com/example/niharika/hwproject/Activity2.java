package com.example.niharika.hwproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.name;

public class Activity2 extends AppCompatActivity {
    public static final int PICK_CONTACT = 1;
    Button btn;
    TextView txtview;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btn = (Button) findViewById(R.id.button);
        txtview = (TextView) findViewById(R.id.textView);
        edittext = (EditText) findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                // to open contacts application

                String enteredFullName = edittext.getText().toString();
                String INTENT_KEY_FINISH_ACTIVITY_ON_SAVE_COMPLETED = "finishActivityOnSaveCompleted";

                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                intent.putExtra(INTENT_KEY_FINISH_ACTIVITY_ON_SAVE_COMPLETED, true);

                //checking if the the name is not entered
                if (enteredFullName != null && !enteredFullName.isEmpty()) {
                    // checking if the name entered is malformed
                    String[] array = enteredFullName.trim().split(" ");
                    if (array.length <= 2) {

                        intent.putExtra(ContactsContract.Intents.Insert.NAME, enteredFullName);
                        startActivityForResult(intent, PICK_CONTACT);

                    } else {
                        txtview.setText("(Error: MalFormed name)");
                    }
                } else {
                    txtview.setText("Name field can't be empty");
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_CONTACT) {
            if (resultCode == RESULT_OK) {
                // displaying success message
                txtview.setText("Contact saved SUCCESSFULLY!.");
            } else if( resultCode == RESULT_CANCELED) {
                // display error message
                txtview.setText("Contact not saved.");
            }
        }
    }
}



