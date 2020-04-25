package com.example.yoofixcustomer.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Perawatan {

    @PrimaryKey(autoGenerate = true)
    private int perawatanId;

    @ColumnInfo(name = "text")
    private String text;

    public Perawatan(int perawatanId, String text) {
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

    public int getPerawatanId() {
        return perawatanId;
    }

    public void setPerawatanId(int perawatanId) {
        this.perawatanId = perawatanId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
