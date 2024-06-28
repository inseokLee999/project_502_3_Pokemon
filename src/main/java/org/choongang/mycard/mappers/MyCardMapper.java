package org.choongang.mycard.mappers;

import org.apache.ibatis.annotations.Param;
import org.choongang.mycard.controllers.MyCardSearch;
import org.choongang.mycard.entities.MyCardDetail;
import java.util.List;

public interface MyCardMapper {
    int register(MyCardDetail params);
    MyCardDetail get(long seq);
    List<MyCardDetail> getList(MyCardSearch search);


//    @Select("SELECT WEIGHT, HEIGHT, BASE_EXPERIENCE FROM USER_POKEMON_VIEW WHERE USER_NO = #{userNo} AND POKEMON_SEQ = #{seq}")
//    MyCardDetail get(@Param("userNo") int userNo, @Param("seq") int seq);
//
//    @Select("SELECT SEQ, WEIGHT, HEIGHT, BASE_EXPERIENCE FROM POKEMON WHERE SEQ = #{seq}")
//    MyCardDetail getRandomPokemon(@Param("seq") int seq);

    MyCardDetail get(@Param("userNo") int userNo, @Param("seq") int seq);
    MyCardDetail getRandomPokemon(@Param("seq") int seq);
}
