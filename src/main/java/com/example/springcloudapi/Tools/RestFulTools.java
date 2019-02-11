//package com.example.springcloudcrawler.Tools;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//
//@Component
//public class RestFulTools {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public <T> T restfulGet(String url, Class<T> tClass){
//           return restTemplate.getForObject(url, tClass);
//    }
//
//    public <T> T restfulPost(String url, Class<T> tClass,
//                                  MultiValueMap<String, Object> requestEntity){
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(requestEntity, headers);
//        return restTemplate.postForObject(url, entity, tClass);
//    }
//}
