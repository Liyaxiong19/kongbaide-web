package com.kongbaide.web.controller;

import com.kongbaide.web.redis.RedisService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaxiong.li on 2019/10/8.
 */
@RestController
public class GameController {

    @Resource
    private RedisService redisService;

    @RequestMapping(value = "/game/check/{code}/{diskId}", method = RequestMethod.GET)
    public String setKey(@PathVariable("code") String code, @PathVariable("diskId") String diskId) {
        List<String> codeList = Arrays.asList("xiangbudao", "lyx201901");
        if (!codeList.contains(code)) {
            return "fail";
        }

        String redisKey = "code_" + code;
        String redisDiskId = redisService.get(redisKey, String.class);
        if (StringUtils.isEmpty(redisDiskId)) {
            redisService.set(redisKey, diskId);
            return "success";
        }

        if (redisDiskId.equals(diskId)) {
            return "success";
        } else {
            return "fail";
        }
    }
}
