package me.zeph.spring.fileupload.fileupload;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileController {

  @CrossOrigin(origins = "*")
  @PostMapping(value = "/upload")
  public String uploadCSV(@RequestParam(value = "file") MultipartFile file) {
    return file.getOriginalFilename();
  }

}