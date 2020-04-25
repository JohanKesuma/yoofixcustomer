package com.example.yoofixcustomer.daos;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.yoofixcustomer.entities.Keluhan;

import java.util.List;

@Dao
public interface KeluhanDao {
    @Query("SELECT * FROM keluhan")
    List<Keluhan> getAll();

    @Query("SELECT * FROM keluhan WHERE perawatan_id = :perawatanId")
    List<Keluhan> getByPerawatanId(int perawatanId);
}
