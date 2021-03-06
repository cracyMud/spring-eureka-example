package service.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}

@RestController
class ServiceInstanceRestController {

    @RequestMapping("/vapi/{apiName}")
    public ResponseEntity<Map<String, Object>> vapi(@PathVariable String apiName) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("message", "sucess");
        map.put("data", apiName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Map<String, Object>>(map, headers, HttpStatus.OK);
    }
    @RequestMapping("/vapi/apiName/{ok}/{okone}/{apiName}")
    public ResponseEntity<Map<String, Object>> vapiTwo(@PathVariable("ok") String apiName,
                                                       @PathVariable("okone") String apiNameOne) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("message", "sucess");
        map.put("data", apiName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Map<String, Object>>(map, headers, HttpStatus.OK);
    }

    @RequestMapping("/vapi/apiName/")
    public ResponseEntity<Map<String, Object>> vapiTwoThree() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("message", "sucess");
        map.put("data", "datadata");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Map<String, Object>>(map, headers, HttpStatus.OK);
    }
}