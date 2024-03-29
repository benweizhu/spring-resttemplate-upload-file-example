package me.zeph.spring.uploadfile.springresttemplateuploadfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UploadClient uploadClient;

  @CrossOrigin(origins = "*")
  @PostMapping(value = "/upload")
  public String uploadCSV(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "date") String date) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);

    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    body.add("file", file.getResource());
    body.add("date", date);
    HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

    String serverUrl = "http://localhost:9091/upload";

    ResponseEntity<String> response = restTemplate
        .postForEntity(serverUrl, requestEntity, String.class);
    return response.getBody();
  }

  @CrossOrigin(origins = "*")
  @PostMapping(value = "/uploadFile")
  public String uploadFile(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "date") String date) {
    return uploadClient.uploadCoupons(file, date);
  }

}