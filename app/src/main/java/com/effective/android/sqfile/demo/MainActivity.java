package com.effective.android.sqfile.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.effective.android.sqfile.SQFile;
import com.effective.android.sqfile.anno.ConflictStrategy;
import com.effective.android.sqfile.bean.InsertParameter;
import com.effective.android.sqfile.bean.SQResult;
import com.effective.android.sqfile.interfaces.Callback;
import com.effective.android.sqfile.scope.AppScope;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", AppScope.INTERNAL_FILES.path());
        Log.d("MainActivity", AppScope.INTERNAL_CACHE.path());
        Log.d("MainActivity", AppScope.EXTERNAL_FILES.path());
        Log.d("MainActivity", AppScope.EXTERNAL_MUSIC.path());
        Log.d("MainActivity", AppScope.EXTERNAL_PODCASTS.path());
        Log.d("MainActivity", AppScope.EXTERNAL_RINGTONES.path());
        Log.d("MainActivity", AppScope.EXTERNAL_ALARMS.path());
        Log.d("MainActivity", AppScope.EXTERNAL_NOTIFICATIONS.path());
        Log.d("MainActivity", AppScope.EXTERNAL_PICTURES.path());
        Log.d("MainActivity", AppScope.EXTERNAL_MOVIES.path());
        Log.d("MainActivity", AppScope.EXTERNAL_CACHE.path());

        SQFile.create(AppScope.INTERNAL_FILES)
                .insert(new InsertParameter(""))
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(SQFile sqFile, IOException e) {

                    }

                    @Override
                    public void onResponse(SQFile sqFile, SQResult response) throws IOException {

                    }
                });
    }
}
