//package org.choongang.game.services;
//
//import org.choongang.mycard.entities.MyCardDetail;
//import org.choongang.mycard.mappers.MyCardMapper;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import jakarta.inject.Inject;
//import jakarta.inject.Singleton;
//
//@Singleton
//public class GameService {
//
//    private final SqlSessionFactory sqlSessionFactory;
//
//    @Inject
//    public GameService(SqlSessionFactory sqlSessionFactory) {
//        this.sqlSessionFactory = sqlSessionFactory;
//    }
//
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
//    public MyCardDetail getRandomPokemon() {
//        int randomSeq = (int) (Math.random() * 260) + 1;
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            MyCardMapper mapper = session.getMapper(MyCardMapper.class);
//            return mapper.getRandomPokemon(randomSeq);
//        }
//    }
//
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
//    private MyCardDetail getUserPokemon(int userNo, int seq) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            MyCardMapper mapper = session.getMapper(MyCardMapper.class);
//            return mapper.get(userNo, seq);
//        }
//    }
//
//    private int calculatePower(MyCardDetail pokemon) {
//        return pokemon.getWeight() * pokemon.getHeight() * pokemon.getBaseExperience();
//    }
//}