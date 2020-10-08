package com.ddd.justeatit.domain;
import com.ddd.justeatit.domain.users.Users;
import com.ddd.justeatit.domain.users.UsersRepository;
import org.aspectj.lang.annotation.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UsersRepositoryTest {
    @Autowired
    UsersRepository usersRepository;

    @After("")
    public void cleanup() {
        usersRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        usersRepository.save(Users.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Users> usersList = usersRepository.findAll();

        //then
        Users posts = usersList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }
}
