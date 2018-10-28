package com.ruoyi.web.controller.wx;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.web.core.base.BaseController;
//import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import weixinpay.common.Config;
import weixinpay.model.AccessToken;
import weixinpay.model.Param;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 87734 on 2018/3/19.
 */
@RestController
@Component
@RequestMapping("/weixinpay")
public class CodeController  extends BaseController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/getCode",method = RequestMethod.POST)
    public @ResponseBody
    Object getCode(HttpServletRequest request, @RequestBody Param param){
        System.out.println(param.getPath());
        String url= Config.getAccessTokenUrl();
        System.out.println("url:"+url);
        String s=this.restTemplate.getForObject(url,String.class);
        System.out.println("s:"+s);
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            AccessToken accessToken=objectMapper.readValue(s,AccessToken.class);
            String token = accessToken.getAccess_token();
            String getCodeUrl="https://api.weixin.qq.com/wxa/getwxacode?access_token="+token;
            HttpHeaders headers = new HttpHeaders();
             MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            String par="{\"path\":\""+param.getPath()+"\"}";
            System.out.println("param"+par);
            HttpEntity<String> formEntity = new HttpEntity<String>(par, headers);
            byte[] entity = restTemplate.postForObject(getCodeUrl, formEntity, byte[].class);
            String res= Base64.encodeBase64String(entity);
//            System.out.println(Base64.encodeBase64String(entity));
            return success(res);
        }catch (Exception e){
            e.printStackTrace();
        }

        return s;
    }
}

