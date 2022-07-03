package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tutorial;
import com.example.demo.helper.CSVHelper;
import com.example.demo.repository.TutorialRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {
  @Autowired
  TutorialRepository repository;
  public void save(MultipartFile file) {
    try {
      List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }
  public List<Tutorial> getAllTutorials() {
    return repository.findAll();
  }
}
