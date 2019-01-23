package com.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootJpaApplicationTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void Test() {
        redisTemplate.opsForValue().set("usrname", "test");
    }


    /*@Autowired
    private UserRepository userRepository;
    @Test
    public void contextLoads(){
        System.out.println(userRepository.findAll().toString());
    }
    @Before
    public void add(){
        userRepository.save(new User("英雄","lol"));
    }
    @After
    public void update(){
        //ifPresent 如果存在值，则使用值调用指定的使用者，否则不执行任何操作。
        userRepository.findById(1L).ifPresent(user -> {
            user.setName("熊猫");
            userRepository.save(user);
            System.out.println(user.toString());
        });
    }
    //删除
    @After
    public void del(){
        userRepository.findById(2L).ifPresent(user -> userRepository.delete(user));
    }*/
    @Test
    public void CsetListRedis() {
        List<String> trap = new ArrayList<>();
        trap.add("zs");
        trap.add("zwj");
        trap.add("xyjy");
        //循环向userlist左添加值
        trap.forEach(value -> redisTemplate.opsForList().leftPush("userlist", value));
        //向userlist右添加值
        redisTemplate.opsForList().rightPush("userlist", "rightValue");
        log.info("userlist->{}", redisTemplate.opsForList().range("userlist", 0, 10));
        //循环向userlist左添加值
        trap.forEach(value -> redisTemplate.opsForSet().add("userset", value));
        log.info("userlist->{}", redisTemplate.opsForSet().members("userlist"));

    }

    @Test
    public void DlistRedisRemove() {
        redisTemplate.opsForList().remove("userlist", 0, "zwj");
    }


}















