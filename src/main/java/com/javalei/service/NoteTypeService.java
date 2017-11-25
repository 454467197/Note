package com.javalei.service;

import com.javalei.pojo.Detailed;
import org.springframework.stereotype.Service;

import java.util.List;



public interface NoteTypeService {

    List<Detailed> getDetailedList();
}
