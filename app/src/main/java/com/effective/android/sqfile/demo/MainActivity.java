package com.effective.android.sqfile.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.effective.android.sqfile.SQFile;
import com.effective.android.sqfile.param.DeleteParameter;
import com.effective.android.sqfile.param.InsertParameter;
import com.effective.android.sqfile.param.QueryParameter;
import com.effective.android.sqfile.scope.Scopes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", Scopes.internalFiles().realPath());
        Log.d("MainActivity", Scopes.internalFiles("/dir1/dir2").realPath());

        Log.d("MainActivity", Scopes.internalCache().realPath());
        Log.d("MainActivity", Scopes.internalCache("/dir1/dir2/").realPath());

        Log.d("MainActivity", Scopes.externalFiles().realPath());
        Log.d("MainActivity", Scopes.externalFiles("dir1/dir2").realPath());
        Log.d("MainActivity", Scopes.externalFiles(Environment.DIRECTORY_MUSIC).realPath());
        Log.d("MainActivity", Scopes.externalFiles(Environment.DIRECTORY_PODCASTS).realPath());
        Log.d("MainActivity", Scopes.externalFiles(Environment.DIRECTORY_RINGTONES).realPath());
        Log.d("MainActivity", Scopes.externalFiles(Environment.DIRECTORY_ALARMS).realPath());
        Log.d("MainActivity", Scopes.externalFiles(Environment.DIRECTORY_NOTIFICATIONS).realPath());
        Log.d("MainActivity", Scopes.externalFiles(Environment.DIRECTORY_PICTURES).realPath());
        Log.d("MainActivity", Scopes.externalFiles(Environment.DIRECTORY_MOVIES).realPath());

        Log.d("MainActivity", Scopes.externalCache().realPath());
        Log.d("MainActivity", Scopes.externalCache("dir1/dir2").realPath());


        SQFile.insert(Scopes.internalFiles())
                .param(new InsertParameter(""))
                .execute();

        SQFile.delete(Scopes.externalCache())
                .param(new DeleteParameter(""))
                .execute();

        SQFile.query(Scopes.externalCache())
                .param(new QueryParameter(""))
                .execute();

    }
}
