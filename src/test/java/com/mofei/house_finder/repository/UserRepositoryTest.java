package com.mofei.house_finder.repository;

import com.mofei.house_finder.HouseFinderApplicationTests;
import com.mofei.house_finder.entity.User;
import com.mofei.house_finder.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends HouseFinderApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne(){
        User user = userRepository.findOne(2L);
        Assert.assertEquals("admin",user.getName());
    }
}
