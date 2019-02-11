package com.example.springcloudapi.Controller;

import com.example.springcloudapi.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ApiService crawlerService;

    /**
     * 测试用.
     * @return 字符串.
     */
    @RequestMapping("/test")
    @ResponseBody
    public Map test() {
        return crawlerService.test();
    }

    /**
     * 调用百度接口实现图片转文字
     * @return 转换好的文字.
     */
    @RequestMapping("/baidu/images2word")
    @ResponseBody
    public Map translation(MultipartFile image) throws IOException {
        return crawlerService.baidu(image);
    }

}
