package com.fnfn.blog;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 클래스명: <code>BlogApplicationTests</code><br>
 *
 * Test 코드
 * - springboot 2.2.x 와 junit5가 안됨 ㅗ애어ㅐㄴ왜농내오내
 *
 * @author fnfnk
 * @since 2020. 4. 24.
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSqlSession() {
        System.out.println(sqlSession.toString());
    }

}
