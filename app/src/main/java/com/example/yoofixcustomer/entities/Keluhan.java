package com.example.yoofixcustomer.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Perawatan.class,
        parentColumns = "perawatanId",
        childColumns = "perawatan_id"))
public class Keluhan {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    public String keluhanId;

    @ColumnInfo(name = "perawatan_id")
    public String perawatanId;

    @ColumnInfo(name = "text")
    public String text;

    public Keluhan(String keluhanId, String perawatanId, String text) {
        this.keluhanId = keluhanId;
        this.perawatanId = perawatanId;
        this.text = text;
    }

    public String getKeluhanId() {
        return keluhanId;
    }

    public void setKeluhanId(String keluhanId) {
        this.keluhanId = keluhanId;
    }

    public String getPerawatanId() {
        return perawatanId;
    }

    public void setPerawatanId(String perawatanId) {
        this.perawatanId = perawatanId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
