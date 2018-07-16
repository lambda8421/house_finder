package com.mofei.house_finder.repository;

import com.mofei.house_finder.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupportAddressRepository extends CrudRepository<SupportAddress, Long>
{
    List<SupportAddress> findAllByLevel(String level);

}
