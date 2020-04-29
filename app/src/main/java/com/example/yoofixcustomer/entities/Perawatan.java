package com.example.yoofixcustomer.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Perawatan {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String perawatanId;

    @ColumnInfo(name = "text")
    private String text;

    public Perawatan(String perawatanId, String text) {
        this.perawatanId = perawatanId;
        this.text = text;
    }

    @Ignore
    public Perawatan(String text) {
        this.text = text;
    }

    @NonNull
    @Override
    public String toString() {
        return text;
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
