package com.mofei.house_finder.repository;

import com.mofei.house_finder.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,Long>{
    User findByName(String userName);

}
