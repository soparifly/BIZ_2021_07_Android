package com.kimbyulook.word.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.kimbyulook.word.model.WordDTO;

/**
 * RoomDatabase를 상속받아 DB Connection , Session을 만드는 클래스
 * 이클래스는 반드시 abstract 키워드를 추가하여
 * 추상클래스로 선언을 해야한다
 *
 * 일부는 직접 코드를 구현하는 method를 포함하고
 * 일부는 interface처럼 코드가 구현되지 않은 method 를 함께
 * 포함하는 클래스다
 *
 * entities의 항목의 내용
 *만약 db table이 없으면 WordDTO 클래스를 참조하여 table을 만들어라
 * 혹시 사용과정에서 table에 변경사항이 발생할 수 있다
 *여기서는 table에 변경이 이루어지면 WordDTO 클래스에 컬럼들을 변경하는 작업을 수행한다
 * 그리고, version  Number를 현재 값보다 큰값으로 변경한다
 * 변경된 version Number를 기준으로 새롭게 table을 재구성한다.
 *
 */
@Database(entities = {WordDTO.class},version = 1)
public abstract class DBConfig extends RoomDatabase {


}
