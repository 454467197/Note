package com.javalei.dao;

import com.javalei.pojo.Detailed;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface DetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Detailed record);

    int insertSelective(Detailed record);

    Detailed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Detailed record);

    int updateByPrimaryKey(Detailed record);

    List<Detailed> selectDetailedList();
}