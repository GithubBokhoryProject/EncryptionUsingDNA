package com.example.encryptionusingdna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EncryptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);
    }

    public void gotoactivityencryptiontext(View view) {
        Intent intent=new Intent(EncryptionActivity.this,ActivityEncryptionText.class);
        startActivity(intent);
    }

    public void gotoactivityencryptionfile(View view) {
        Intent intent=new Intent(EncryptionActivity.this,ActivityEncryptionFile.class);
        startActivity(intent);
    }

}
