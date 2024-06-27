package org.choongang.game.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;

import java.util.Random;

//1~260사이 랜덤숫자 생성해서 seq에 넣기
public class RandomMon {


    public static int generate() {

        int min = 1;
        int max = 260;

        // Random 객체 생성
        Random random = new Random();

        // min부터 max까지 범위의 랜덤 숫자 생성
        int randomNum = random.nextInt(max - min + 1) + min;

        return randomNum;
    }
}

