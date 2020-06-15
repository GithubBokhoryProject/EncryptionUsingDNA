package com.example.encryptionusingdna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DecryptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);
    }

    public void gotoactivitydecryptiontext(View view) {
        Intent intent=new Intent(DecryptionActivity.this,ActivityDecryptionText.class);
        startActivity(intent);
    }

    public void gotoactivitydecryptionfile(View view) {
        Intent intent=new Intent(DecryptionActivity.this,ActivityDecryptionFile.class);
        startActivity(intent);
    }

    public void gotoactivitydecryptionimage(View view) {
        Intent intent=new Intent(DecryptionActivity.this,ActivityDecryptionImage.class);
        startActivity(intent);
    }

    public void gotoactivitydecryptionvoice(View view) {
        Intent intent=new Intent(DecryptionActivity.this,ActivityDecryptionVoice.class);
        startActivity(intent);
    }
}
