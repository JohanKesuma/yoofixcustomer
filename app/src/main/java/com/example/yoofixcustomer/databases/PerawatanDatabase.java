package com.example.yoofixcustomer.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.yoofixcustomer.daos.KeluhanDao;
import com.example.yoofixcustomer.daos.PerawatanDao;
import com.example.yoofixcustomer.entities.Keluhan;
import com.example.yoofixcustomer.entities.Perawatan;

@Database(entities = {Perawatan.class, Keluhan.class}, version = 1)
public abstract class PerawatanDatabase extends RoomDatabase {
    private static final String DB_NAME = "perawatan_db";
    private static PerawatanDatabase instance;

    public static synchronized PerawatanDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), PerawatanDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract PerawatanDao perawatanDao();

    public abstract KeluhanDao keluhanDao();
}
