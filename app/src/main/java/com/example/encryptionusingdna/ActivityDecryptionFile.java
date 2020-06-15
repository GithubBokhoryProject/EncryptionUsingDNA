package com.example.encryptionusingdna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ActivityDecryptionFile extends AppCompatActivity {
        EditText Edit_sequenceDNA_File;
    EditText edit_Result_text,FileName;
    public static final int WRIYE_EX_REQ_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption_file);
        Edit_sequenceDNA_File=findViewById(R.id.sequenceDNA_File_id);
        edit_Result_text=findViewById(R.id.Result_DNA_id);
        FileName=findViewById(R.id.Filename_id);

        //هل الصلاحيه تم الحصول عليها ام لا
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            // الصلاحيه لم يتم الحصول عليها
            String [] permission={Manifest.permission.WRITE_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this,permission,WRIYE_EX_REQ_CODE);
        }
        else{
            //الصلاحيه تم الحصول عليها

        }
        ///////////////////
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
                Edit_sequenceDNA_File.setText(text);
            } catch (FileNotFoundException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            ////end read file
}
 }
////////////////////////////////////start button Save
    public void btn_Save_File(View view) {
        String Data=edit_Result_text.getText().toString().trim();
        String name=FileName.getText().toString().trim();
        if(name.isEmpty() || Data.isEmpty() ){
            Toast.makeText(this, "Enter File Name And Sequence DNA", Toast.LENGTH_SHORT).show();
        }
        else {
            if (isExternalstoragewritable()) {
                try {
                    File ex_st = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    File f = new File(ex_st, FileName.getText().toString() + ".txt");
                    FileOutputStream fos = new FileOutputStream(f);
                    fos.write(edit_Result_text.getText().toString().getBytes());
                    fos.close();
                    Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(this, "Cannot Write To External storage", Toast.LENGTH_SHORT).show();
            }
        }
    }
    ///////////////////////////////end button Save
    /////////////////////////
    public boolean isExternalstoragewritable(){
        String state= Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }
///////////////////////////////


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case WRIYE_EX_REQ_CODE:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "تم الحصول على الصلاحيه", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }
////////////////////////////////////
    public void btn_Decryption_file(View view) {
        String key="0123456789ABCDEF";
        String Resultdna=DNA.split_dna(Edit_sequenceDNA_File.getText().toString().trim());
        String End_Result_is_binary=DNA.convert_from_DNA_to_binary(Resultdna.trim());
        String Result_Binary=Converter.binaryToText(End_Result_is_binary.trim());
        String Result_Decryption=XXTEA.Decrypt(Result_Binary,key);
        edit_Result_text.setText(Result_Decryption);
    }
    ///////////////////////////
}
