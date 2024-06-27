package org.choongang.mycard.mapper;

import org.choongang.mycard.controllers.MyCardSearch;
import org.choongang.mycard.entities.MyCardDetail;
import java.util.List;

public interface MyCardMapper {
    int register(MyCardDetail params);
    MyCardDetail get(long seq);
    List<MyCardDetail> getList(MyCardSearch search);
}
