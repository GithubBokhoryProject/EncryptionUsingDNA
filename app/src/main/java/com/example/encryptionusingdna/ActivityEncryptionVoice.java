package com.example.encryptionusingdna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ActivityEncryptionVoice extends AppCompatActivity {
    EditText edit_Result_DNA,FileName;
    public static final int WRIYE_EX_REQ_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption_voice);
        edit_Result_DNA=findViewById(R.id.Result_DNA_id);
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
        ////////////////////////////////////
    }
/////////////////////////
    public void btn_Save_File(View view) {
        String Data=edit_Result_DNA.getText().toString().trim();
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
                    fos.write(edit_Result_DNA.getText().toString().getBytes());
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
    //////////////////////////////////////
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
    ///////////////////////////
}
