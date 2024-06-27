//package org.choongang.pokemon.tests;
//
//import com.github.javafaker.Faker;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//
//public class MemberTest {
//
//    private static SqlSessionFactory sqlSessionFactory;
//
//    static {
//        String resource = "mybatis-config.xml"; // MyBatis 설정 파일 경로
//        InputStream inputStream;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "dev"); // 개발 환경 사용
//            // sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "prod"); // 프로덕션 환경 사용
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static SqlSessionFactory getSqlSessionFactory() {
//        return sqlSessionFactory;
//    }
//
//    @BeforeAll
//    static void setupDatabase() {
//        try (Connection conn = DriverManager.getConnection(prodUrl, prodUsername, prodPassword);
//             Statement stmt = conn.createStatement()) {
//            // 시퀀스 생성 쿼리
//            String createSequenceSql = "CREATE SEQUENCE SEQ_MEMBER START WITH 1 INCREMENT BY 1 NOCACHE";
//            stmt.execute(createSequenceSql);
//            System.out.println("Sequence created successfully.");
//        } catch (SQLException e) {
//            // 시퀀스가 이미 존재하는 경우 예외를 무시합니다.
//            if (!e.getMessage().contains("ORA-00955")) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test
//    @DisplayName("회원 정보 삽입 테스트")
//    void insertMemberTest() {
//        assertDoesNotThrow(() -> {
//            // Faker를 사용하여 무작위 데이터 생성
//            Faker faker = new Faker();
//            String email = faker.internet().emailAddress();
//            String password = faker.internet().password();
//            String userName = faker.name().fullName();
//            String userType = faker.options().option("USER", "ADMIN");
//
//            try (Connection conn = DriverManager.getConnection(prodUrl, prodUsername, prodPassword)) {
//                String sql = "INSERT INTO MEMBER (USER_NO, EMAIL, PASSWORD, USER_NAME, USER_TYPE, REG_DT, MOD_DT) " +
//                        "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, SYSDATE, SYSDATE)";
//                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//                    stmt.setString(1, email);
//                    stmt.setString(2, password);
//                    stmt.setString(3, userName);
//                    stmt.setString(4, userType);
//
//                    int rowsInserted = stmt.executeUpdate();
//                    if (rowsInserted > 0) {
//                        System.out.println("A new member was inserted successfully!");
//                    }
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });
//
//    }
//}