package org.choongang.admin.controllers;

import lombok.Data;

@Data
public class MemberSearch {
    private int page = 1;
    private int limit = 10;//한페이지당 출력될 레코드 갯수
    private int offset;
    private int endRows;
    private String email;
    private String userName;
    private String userType;
    private String sopt; //검색 옵션
    private String skey;//검색 키워드
}
