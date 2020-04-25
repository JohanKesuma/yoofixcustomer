package com.example.yoofixcustomer.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.yoofixcustomer.entities.Perawatan;

import java.util.List;

@Dao
public interface PerawatanDao {
    @Query("SELECT * FROM perawatan")
    List<Perawatan> getAll();

    @Query("SELECT * FROM perawatan WHERE perawatanId = :id")
    Perawatan getById(int id);

    @Insert
    void insertPerawatan(Perawatan perawatan);
}
