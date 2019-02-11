package com.example.springcloudapi.Service;

import com.baidu.aip.ocr.AipOcr;
import com.example.springcloudapi.Tools.DateTools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ApiService {

    @Autowired
    private DateTools dateTools;

    //设置APPID/AK/SK
    private static final String APP_ID = "11540842";
    private static final String API_KEY = "aaDIvgPK6Ptb0itaS2mlUnOC";
    private static final String SECRET_KEY = "iVoaZjKu69c11WIsQWKzj2bdiTy7i0Db";

    public Map test() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "crawler");
        return map;
    }

    public Map baidu(MultipartFile image) throws IOException {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        JSONObject res = client.basicGeneral(image.getBytes(), options);
        Map<String, String> map = new HashMap<String, String>();

        /**
         * 百度传回的JSON格式
         * {
         "log_id": 2471272194,
         "words_result_num": 2,
         "words_result":
         [
            {"words": " TSINGTAO"},
            {"words": "青島睥酒"}
         ]
         }
         */

        JSONArray jsonArray = res.getJSONArray("words_result");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < jsonArray.length(); ++i){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            stringBuilder.append(jsonObject.get("words"));
        }
        map.put("words", stringBuilder.toString());
        return map;
    }

//    public String getPythonCrawler() {
//        return restFulTools.restfulGet("http://106.12.19.58:5678/crawler/news_baidu", String.class);
//    }
//
//    public String getPythonCrawlerJson(String filename) {
//        return restFulTools.restfulGet("http://106.12.19.58:5678/crawler/read_json?filename="
//                + filename, String.class);
//    }
}
