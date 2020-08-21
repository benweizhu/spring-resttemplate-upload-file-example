package me.zeph.spring.uploadfile.springresttemplateuploadfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringResttemplateUploadFileApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringResttemplateUploadFileApplication.class, args);
  }

}
