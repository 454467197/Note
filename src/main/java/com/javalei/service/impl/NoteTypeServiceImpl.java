package com.javalei.service.impl;

import com.javalei.dao.DetailedMapper;
import com.javalei.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteTypeServiceImpl implements NoteTypeService{

    @Autowired
    private DetailedMapper Detailed;

    @Override
    public List<com.javalei.pojo.Detailed> getDetailedList() {

          return Detailed.selectDetailedList();
    }
}
