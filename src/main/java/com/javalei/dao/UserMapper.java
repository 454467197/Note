package com.javalei.dao;

import com.javalei.pojo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}