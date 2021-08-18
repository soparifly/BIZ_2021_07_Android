package com.kimbyulook.word.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(tableName = "tbl_word")
public class WordDTO {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="word")
    private String word;


    @ColumnInfo(name="korea")
    private String korea;
}
