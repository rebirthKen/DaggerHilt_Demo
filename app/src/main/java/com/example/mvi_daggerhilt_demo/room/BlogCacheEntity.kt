package com.example.mvi_daggerhilt_demo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blogs")
data class BlogCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "title")
    var title: String,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "body")
    var body: String,


    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "image")
    var image: String,


    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "category")
    var category: String) {



}