package com.example.yoofixcustomer.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Perawatan.class,
        parentColumns = "perawatanId",
        childColumns = "perawatan_id"))
public class Keluhan {

    @PrimaryKey(autoGenerate = true)
    public int keluhanId;

    @ColumnInfo(name = "perawatan_id")
    public int perawatanId;

    @ColumnInfo(name = "text")
    public String text;

    public int getKeluhanId() {
        return keluhanId;
    }

    public void setKeluhanId(int keluhanId) {
        this.keluhanId = keluhanId;
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
