package me.zeph.spring.uploadfile.springresttemplateuploadfile;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "upload", url = "http://localhost:9091")
public interface UploadClient {
  @PostMapping(value = "upload", consumes = "multipart/form-data")
  String uploadCoupons(@RequestPart("file") MultipartFile file, @RequestPart("date") String date);
}
