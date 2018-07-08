package com.mofei.house_finder.service;

import com.mofei.house_finder.entity.User;
import org.springframework.stereotype.Service;


public interface IUserService {
    User findUserByName(String userName);
}
