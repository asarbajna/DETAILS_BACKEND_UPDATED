package com.example.demo.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileDB;
import com.example.demo.repository.FileDBRepository;
import org.springframework.util.StringUtils;

@Service
public class FileStorageTableService {
	@Autowired
	  private FileDBRepository fileDBRepository;
	  public FileDB store(MultipartFile file) throws IOException {
		  FileDB fileUid;  
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
	    fileUid=fileDBRepository.save(FileDB);
	    return fileUid;
	    
	    
	  }
	  public FileDB getFile(String id) {
	    return fileDBRepository.findById(id).get();
	  }
	  
	  public Stream<FileDB> getAllFiles() {
	    return fileDBRepository.findAll().stream();
	  }
}
