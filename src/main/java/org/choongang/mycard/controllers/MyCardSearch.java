package org.choongang.mycard.controllers;

import lombok.Data;

@Data
public class MyCardSearch {//검색용 데이터
    private int page = 1;
    private int limit = 20;//한페이지당 출력될 레코드 갯수
    private int offset;
    private int endRows;
    private String sopt; //검색 옵션
    private String skey;//검색 키워드
}