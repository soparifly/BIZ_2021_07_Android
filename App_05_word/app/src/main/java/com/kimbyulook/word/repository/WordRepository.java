package com.kimbyulook.word.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.kimbyulook.word.dao.WordDao;
import com.kimbyulook.word.model.WordDTO;

import java.util.List;

/**
 * WordDao와 WordDTO를 사용하여
 * DataBase 핸들링을 하는 중간 Service클래
 */
public class WordRepository<ListData> {


    protected WordDao wordDao;
    protected LiveData<List<WordDTO>> wordList;

    /**
     * Application Context를 매개변수로 갖는 생성자 필요
     * @param application
     */
    public WordRepository(Application application){

    }

    /**
     * wordList를 단순히 return 만 하고있는데
     * wordList 데이터를 가져오는 코드는 어디있을까
     *
     * 외부에서 repository.selectAll() method를 호출하면
     * 자동으로 Dao 를 거쳐서 DB에 select를 수행하고
     * 그결과를 return 한다
     *
     *
      * @return
     */
    public LiveData<List<WordDTO>> selectAll(){
        return wordList;
    }
    public void insert(WordDTO wordDTO){
        wordDao.insert(wordDTO);
    }

    public void deleteAll(){
        wordDao.deleteAll();
    }
}
