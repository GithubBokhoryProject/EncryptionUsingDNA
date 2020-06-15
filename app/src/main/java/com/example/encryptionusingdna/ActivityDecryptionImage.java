package com.example.encryptionusingdna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ActivityDecryptionImage extends AppCompatActivity {
    EditText Edit_sequenceDNA_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption_image);
        Edit_sequenceDNA_image=findViewById(R.id.sequenceDNA_image_id);
    }
    //Read file.txt and disblay in Edit text
/////////////////////لقرأه ملف وعرضه في Edit text
    public void btn_choise_file(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            ///read file
            Uri PathHolder = data.getData();
            FileInputStream fileInputStream = null;
            StringBuilder text = new StringBuilder();
            try {
                InputStream inputStream = getContentResolver().openInputStream(PathHolder);
                BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
                String mLine;
                while ((mLine = r.readLine()) != null) {
                    text.append(mLine);
                    text.append('\n');
                }
                Edit_sequenceDNA_image.setText(text);
            } catch (FileNotFoundException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            ////end read file
        }
    }
}
