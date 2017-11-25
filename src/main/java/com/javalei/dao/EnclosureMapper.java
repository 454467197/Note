package com.javalei.dao;

import com.javalei.pojo.Enclosure;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface EnclosureMapper {
    int deleteByPrimaryKey(Integer eid);

    int insert(Enclosure record);

    int insertSelective(Enclosure record);

    Enclosure selectByPrimaryKey(Integer eid);

    int updateByPrimaryKeySelective(Enclosure record);

    int updateByPrimaryKey(Enclosure record);
}