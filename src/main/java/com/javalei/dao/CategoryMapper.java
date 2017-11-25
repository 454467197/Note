package com.javalei.dao;

import com.javalei.pojo.Category;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}