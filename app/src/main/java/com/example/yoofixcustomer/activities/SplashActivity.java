package com.example.yoofixcustomer.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.databases.AppExecutors;
import com.example.yoofixcustomer.databases.PerawatanDatabase;
import com.example.yoofixcustomer.entities.Perawatan;
import com.example.yoofixcustomer.utils.Preferences;

import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private TextView textView;
    private PerawatanDatabase perawatanDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textView = findViewById(R.id.text_view);

        if (!Preferences.getDbInitiated(this)) {
            createDatabase();
            return;
        }

        updateUI("");


    }

    private void createDatabase() {
        perawatanDatabase = PerawatanDatabase.getInstance(this);

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                perawatanDatabase.clearAllTables();
                perawatanDatabase.perawatanDao().insertPerawatan(new Perawatan("Cuci AC"));

                List<Perawatan> perawatans = perawatanDatabase.perawatanDao().getAll();
                String s = "";
                for (Perawatan perawatan : perawatans) {
                    s += perawatan.toString() + " ";
                }
                Preferences.setDbInitiated(SplashActivity.this, true);
                updateUI(s);
            }
        });

    }

    private void updateUI(final String text) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                textView.setText(text);
            }
        });
    }
}
