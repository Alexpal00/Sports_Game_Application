package com.example.ergasia;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Sport")
public class SportPin {

    @PrimaryKey @NonNull
    @ColumnInfo(name="id_sport")
    private int id;

    @ColumnInfo(name="name_sport") @NonNull
    private String name;

    @ColumnInfo(name="kind")@NonNull
    private String kind_sport;


    @ColumnInfo(name="ply")@NonNull
    private String ply_sport;

    public String getKind_sport() {
        return kind_sport;
    }

    public String getPly_sport() {
        return ply_sport;
    }

    public void setPly_sport(String ply_sport) {
        this.ply_sport = ply_sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKind_sport(String kind_sport) {
        this.kind_sport = kind_sport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
