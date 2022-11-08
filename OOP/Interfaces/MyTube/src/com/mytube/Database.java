package com.mytube;

public class Database implements VideoDatabase {
    @Override
    public void store(Video video){
        var database = new SqlVideoDatabase();
        database.store(video);
    }
}
