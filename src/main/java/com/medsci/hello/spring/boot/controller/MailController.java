package com.medsci.hello.spring.boot.controller;

import com.medsci.hello.spring.boot.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


/**
 * @description:
 * @author: 学长
 * @date: 2020/6/2 18:57
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private IMailService iMailService;

    @GetMapping("/send")
    public boolean send(
            @RequestParam(value = "to") String to,
            @RequestParam(value = "subject") String subject,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "url") String url
    ) {
        Context context = new Context();

        context.setVariable("content", content);
        context.setVariable("url", url);

        String s = templateEngine.process("index", context);

        iMailService.sendHtmlMail(to,subject,s);

        return true;
    }
}
