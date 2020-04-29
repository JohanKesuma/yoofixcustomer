package com.example.yoofixcustomer.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yoofixcustomer.MainActivity;
import com.example.yoofixcustomer.R;
import com.example.yoofixcustomer.databases.AppExecutors;
import com.example.yoofixcustomer.databases.PerawatanDatabase;
import com.example.yoofixcustomer.entities.Keluhan;
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

        updateUI();


    }

    /**
     * Instalasi Database
     * hanya satu kali ketika aplikasi diinstall
     */
    private void createDatabase() {
        perawatanDatabase = PerawatanDatabase.getInstance(this);

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                perawatanDatabase.clearAllTables();

                // isi tabel perawatan
                perawatanDatabase.perawatanDao().insertPerawatan(new Perawatan("AC1", "Perawatan AC"));
                perawatanDatabase.perawatanDao().insertPerawatan(new Perawatan("AC2", "Instalasi AC"));

                // isi tabel keluhan
                perawatanDatabase.keluhanDao().insertKeluhan(new Keluhan("KAC1", "AC1", "Cuci AC"));
                perawatanDatabase.keluhanDao().insertKeluhan(new Keluhan("KAC2", "AC1", "AC Bocor"));
                perawatanDatabase.keluhanDao().insertKeluhan(new Keluhan("KAC3", "AC1", "AC Mati"));
                List<Perawatan> perawatans = perawatanDatabase.perawatanDao().getAll();

                Preferences.setDbInitiated(SplashActivity.this, true);
                updateUI();
            }
        });

    }

    private void updateUI() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
