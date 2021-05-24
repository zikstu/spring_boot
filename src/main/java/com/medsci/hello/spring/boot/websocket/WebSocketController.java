package com.medsci.hello.spring.boot.websocket;

import com.medsci.hello.spring.boot.common.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Arnold
 * @date: 2021/5/24 16:43
 */
@RestController
@RequestMapping("/api/socket")
public class WebSocketController {
    //页面请求
    @GetMapping("/index/{userId}")
    public ModelAndView socket(@PathVariable String userId) {
        ModelAndView mav = new ModelAndView("/socket");
        mav.addObject("userId", userId);
        return mav;
    }

    //推送数据接口
    @RequestMapping("/socket/push/{cid}")
    public ResponseBean pushToWeb(@PathVariable String cid, String message) {
        Map<String,Object> result = new HashMap<>();
        try {
            WebSocketServer.sendInfo(message, cid);
            result.put("code", cid);
            result.put("msg", message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseBean.ok(result);
    }
}
