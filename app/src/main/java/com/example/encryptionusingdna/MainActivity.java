package com.example.encryptionusingdna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /////////option menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //////////////////////////

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_aboutus:
                Intent intentaboutus=new Intent(MainActivity.this,ActivityAboutUs.class);
                startActivity(intentaboutus);
                break;
            case R.id.item_teamwork:
                Intent intentteamwork=new Intent(MainActivity.this,ActivityTeamWork.class);
                startActivity(intentteamwork);
                break;
            case R.id.item_images:
                Intent intentimages=new Intent(MainActivity.this,ActivityImages.class);
                startActivity(intentimages);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    ////////////////////////

    ////////////////////////////
    public void gotoencryptionactivity(View view) {
        Intent intent=new Intent(MainActivity.this,EncryptionActivity.class);
        startActivity(intent);
    }
    ///////////////////////////
    public void gotodecryptionactivity(View view) {
        Intent intent=new Intent(MainActivity.this,DecryptionActivity.class);
        startActivity(intent);
    }
    ///////////////////////////
}
