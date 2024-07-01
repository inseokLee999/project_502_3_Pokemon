//package org.choongang.game.services;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import lombok.RequiredArgsConstructor;
//import org.choongang.global.config.annotations.Controller;
//import org.choongang.global.config.annotations.RequestMapping;
//import org.choongang.global.config.containers.BeanContainer;
//import org.choongang.member.MemberUtil;
//import org.choongang.member.entities.GetRandPokemon;
//import org.choongang.member.entities.Member;
//import org.choongang.pokemon.entities.PokemonDetail;
//import org.choongang.pokemon.mappers.PokemonMapper;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import jakarta.inject.Inject;
//import jakarta.inject.Singleton;
//import org.choongang.pokemon.services.PokemonInfoService;
//
//
//@Controller
//@Singleton
//@RequestMapping("/game")
////@RequiredArgsConstructor
//public class GameService {



//
//    private final SqlSessionFactory sqlSessionFactory;
//
//    @Inject
//    public GameService(SqlSessionFactory sqlSessionFactory) {
//
//        private final PokemonInfoService infoService;
//        private final MemberUtil memberUtil;
//        private final HttpServletRequest request;
//        this.sqlSessionFactory = sqlSessionFactory;
//
//        private HttpSession session = BeanContainer.getInstance().getBean(HttpSession.class);
//
//    public int calculatePower(int seq) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            PokemonMapper mapper = session.getMapper(PokemonMapper.class);
//            PokemonDetail pokemonDetail = mapper.get(seq);
//
//            if (PokemonDetail != null) {
//                return PokemonDetail.getWeight() * PokemonDetail.getHeight() * pokemonDetail.getBaseExperience();
//            } else {
//                throw new RuntimeException("No Pokemon details found for the given user and sequence.");
//            }
//        }
//    }
//
//    public int getRandPokemon() {
//        commonProcess();
//        Member member = (Member) session.getAttribute("member");
//        PokemonDetail data = infoService.getRandom().orElse(null);
//        GetRandPokemon getRandPokemon = new GetRandPokemon();
//        getRandPokemon.setSeq(data.getSeq());
//        getRandPokemon.setUserNo(member.getUserNo());
//        return  RandomPokemon= getPokemon(getRandPokemon);
//    }
//
//    public void startGame(long userNo, long myPokemonSeq) {
//        PokemonDetail userPokemon = getUserPokemon(userNo,myPokemonSeq);
//        PokemonDetail computerPokemon = getRandomPokemon();
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
//    private Member getUserPokemon(long userNo, long myPokemonSeq) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            PokemonMapper mapper = session.getMapper(PokemonMapper.class);
//          //  int seq = member.getMyPokemonSeq pokemonmapper.get(seq);
//            return mapper.get(myPokemonSeq);
//        }
//    }
//
//    private int calculatePower(PokemonDetail pokemon) {
//        return pokemon.getWeight() * pokemon.getHeight() * pokemon.getBaseExperience();
//    }
//}