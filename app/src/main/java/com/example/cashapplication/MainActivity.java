package com.example.cashapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            deleteCache(getCacheDir());

            android.os.Process.killProcess(android.os.Process.myPid());
        });
    }



    public boolean deleteCache(File dir){
        try{
            if(dir != null && dir.isDirectory()){
                String[] children = dir.list();
                for (String child : children) {
                    boolean isSuccess = deleteCache(new File(dir, child));
                    if (!isSuccess) {
                        return false;
                    }
                }
            }
            else{
                Log.d("asdf", "텅");
            }
        }catch (Exception e){
            Log.w("asdf", "deleteCache Error!", e);
        }
        return dir.delete();
    }
}