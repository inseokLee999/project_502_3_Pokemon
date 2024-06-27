package org.choongang.pokemon.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MemberTest {

    @Test
    @DisplayName("회원 정보 삽입 테스트")
    void insertMemberTest() {
        assertDoesNotThrow(() -> {
            // Faker를 사용하여 무작위 데이터 생성
            Faker faker = new Faker();
            String email = faker.internet().emailAddress();
            String password = faker.internet().password();
            String userName = faker.name().fullName();
            String userType = faker.options().option("USER", "ADMIN");

            final String prodUrl = "jdbc:oracle:thin:@localhost:1521:XE";
            final String prodUsername = "PROJECT3";
            final String prodPassword = "oracle";

            try (Connection conn = DriverManager.getConnection(prodUrl, prodUsername, prodPassword)) {
                String sql = "INSERT INTO MEMBER (USER_NO, EMAIL, PASSWORD, USER_NAME, USER_TYPE, REG_DT, MOD_DT) " +
                        "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, SYSDATE, SYSDATE)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, email);
                    stmt.setString(2, password);
                    stmt.setString(3, userName);
                    stmt.setString(4, userType);

                    int rowsInserted = stmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new member was inserted successfully!");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }
}
