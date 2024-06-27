
//package org.choongang.game.services;
//
//import lombok.Data;
//import org.choongang.global.config.annotations.RestController;
//import org.choongang.global.config.annotations.Service;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.choongang.mycard.entities.MyCardDetail;
//import jakarta.inject.Inject;
//import org.choongang.mycard.mappers.MyCardMapper;
//
//@Data
//@Service
//@RestController
//public class GameService {

//    private final SqlSessionFactory sqlSessionFactory;
//
//    @Inject
//    public GameService(SqlSessionFactory sqlSessionFactory) {
//        this.sqlSessionFactory = sqlSessionFactory;
//    }
//
//    // 유저의 포켓몬 파워 계산
//    public int calculateUserPower(int userNo, int seq) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            MyCardMapper mapper = session.getMapper(MyCardMapper.class);
//            MyCardDetail myCardDetail = mapper.get(userNo, seq);
//
//            if (myCardDetail != null) {
//                return myCardDetail.getWeight() * myCardDetail.getHeight() * myCardDetail.getBaseExperience();
//            } else {
//                throw new RuntimeException("No Pokemon details found for the given user and sequence.");
//            }
//        }
//    }
//
//    // 랜덤한 포켓몬을 가져오는 메소드 (예시로 작성)
//    public MyCardDetail getRandomPokemon() {
//        int randomSeq = (int) (Math.random() * 260) + 1;
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            MyCardMapper mapper = session.getMapper(MyCardMapper.class);
//            return mapper.getRandomPokemon(randomSeq);
//        }
//    }
//
//    // 컴퓨터의 포켓몬 파워 계산
//    public int calculateComputerPower(int userNo, int seq) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            MyCardMapper mapper = session.getMapper(MyCardMapper.class);
//            MyCardDetail myCardDetail = mapper.get(userNo, seq);
//
//            if (myCardDetail != null) {
//                return myCardDetail.getWeight() * myCardDetail.getHeight() * myCardDetail.getBaseExperience();
//            } else {
//                throw new RuntimeException("No Pokemon details found for the given user and sequence.");
//            }
//        }
//    }
//
//    // 게임 진행
//    public void startGame(int userNo, int userSeq) {
//        MyCardDetail userPokemon = getUserPokemon(userNo, userSeq);
//        MyCardDetail computerPokemon = getRandomPokemon();
//
//        int userPower = calculatePower(userPokemon);
//        int computerPower = calculatePower(computerPokemon);
//
//        System.out.println("User's Pokemon: " + userPokemon);
//        System.out.println("Computer's Pokemon: " + computerPokemon);
//
//        if (userPower > computerPower) {
//            System.out.println("User wins!");
//        } else if (userPower < computerPower) {
//            System.out.println("Computer wins!");
//        } else {
//            System.out.println("It's a tie!");
//        }
//    }
//
//    // 유저의 포켓몬 정보 가져오기
//    private MyCardDetail getUserPokemon(int userNo, int seq) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            MyCardMapper mapper = session.getMapper(MyCardMapper.class);
//            return mapper.get(userNo, seq);
//        }
//    }
//
//    // 포켓몬 파워 계산
//    private int calculatePower(MyCardDetail pokemon) {
//        return pokemon.getWeight() * pokemon.getHeight() * pokemon.getBaseExperience();
//    }
//}
