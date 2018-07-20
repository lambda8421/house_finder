package com.mofei.house_finder.entity;

import com.mofei.house_finder.HouseFinderApplicationTests;
import com.mofei.house_finder.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mofei.
 */
public class UserRepositoryTest extends HouseFinderApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        User user = userRepository.findOne(1L);
        Assert.assertEquals("wali", user.getName());
    }
}
