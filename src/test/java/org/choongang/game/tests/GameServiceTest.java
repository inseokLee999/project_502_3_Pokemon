
//package org.choongang.game.tests;
//
//import org.choongang.game.services.GameService;
//import org.choongang.mycard.entities.MyCardDetail;
//import org.choongang.mycard.mappers.MyCardMapper;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class GameServiceTest {
//
//    @Mock
//    private SqlSessionFactory sqlSessionFactory;
//
//    @Mock
//    private SqlSession sqlSession;
//
//    @Mock
//    private MyCardMapper myCardMapper;
//
//    @InjectMocks
//    private GameService gameService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        when(sqlSessionFactory.openSession()).thenReturn(sqlSession);
//        when(sqlSession.getMapper(MyCardMapper.class)).thenReturn(myCardMapper);
//    }
//
//    @Test
//    public void testCalculateUserPower() {
//        int userNo = 1;
//        int seq = 100;
//
//        MyCardDetail myCardDetail = MyCardDetail.builder()
//                .seq(seq)
//                .weight(10)
//                .height(20)
//                .baseExperience(30)
//                .build();
//
//        when(myCardMapper.get(userNo, seq)).thenReturn(myCardDetail);
//
//        int expectedPower = 10 * 20 * 30;
//        int actualPower = gameService.calculateUserPower(userNo, seq);
//
//        assertEquals(expectedPower, actualPower);
//
//        verify(sqlSessionFactory, times(1)).openSession();
//        verify(sqlSession, times(1)).getMapper(MyCardMapper.class);
//        verify(myCardMapper, times(1)).get(userNo, seq);
//    }
//
//    @Test
//    public void testStartGame() {
//        int userNo = 1;
//        int userSeq = 100;
//
//        MyCardDetail userPokemon = MyCardDetail.builder()
//                .seq(userSeq)
//                .weight(10)
//                .height(20)
//                .baseExperience(30)
//                .build();
//
//        MyCardDetail computerPokemon = MyCardDetail.builder()
//                .seq(200)
//                .weight(15)
//                .height(25)
//                .baseExperience(35)
//                .build();
//
//        when(myCardMapper.get(userNo, userSeq)).thenReturn(userPokemon);
//        when(myCardMapper.getRandomPokemon(anyInt())).thenReturn(computerPokemon);
//
//        gameService.startGame(userNo, userSeq);
//
//        // 추가적인 검증은 System.out을 캡쳐하여 결과를 검증하는 방식으로 수행할 수 있습니다.
//    }
//}
