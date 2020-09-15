package com.medsci.hello.spring.boot.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.medsci.hello.spring.boot.common.ExceptionEnum;
import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.domain.User;
import com.medsci.hello.spring.boot.domain.Users;
import com.medsci.hello.spring.boot.mapper.UserMapper;
import com.medsci.hello.spring.boot.mapper.UsersMapper;
import com.medsci.hello.spring.boot.service.AuthService;
import com.medsci.hello.spring.boot.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Senior
 * @date: 2020/4/16 19:34
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AuthService authService;

//    @MyAnnotation(name="ceshi")
    @PostMapping("/list")
    @ResponseBody
    public ResponseBean userList(){
        List<User> user = userService.selectUser();

        return ResponseBean.ok(user);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseBean findById(@PathVariable(required = true, name = "id") Integer id){
        User byId = userService.findById(id);

        return ResponseBean.ok(byId);
    }

    @PostMapping("/selectByNameOrSex")
    @ResponseBody
    public ResponseBean selectByNameOrSex(@RequestBody User user){
        List<User> by = userService.selectByNameOrSex(user);

        return ResponseBean.ok(by);
    }

    @PostMapping("/selectAll")
    @ResponseBody
    public ResponseBean selectAll(){
        List<User> selectAll = userMapper.selectAll();

        return ResponseBean.ok(selectAll);
    }

    @PostMapping("/insert")
    @ResponseBody
    public ResponseBean insert(@RequestBody User user){
        int insert = userMapper.insert(user);

        return ResponseBean.ok(insert);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseBean update(@RequestBody User userData){
        User user = userMapper.selectByPrimaryKey(userData.getId());

        int i = userMapper.updateByPrimaryKeySelective(userData);

        if (i == 1){
            return ResponseBean.ok(user);
        }

        return ResponseBean.error(ExceptionEnum.USER_UPDATE_FAIL);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResponseBean delete(@PathVariable(required = true, name = "id") Integer id){
        int i = userMapper.deleteByPrimaryKey(id);

        if (i == 1){
            return ResponseBean.ok("操作成功");
        }

        return ResponseBean.error(ExceptionEnum.USER_DELETE_FAIL);
    }

    @GetMapping("/result")
    @ResponseBody
    public ResponseBean result(@RequestParam(value = "type") String type){
        ResponseBean responseBean = new ResponseBean();
        System.out.println("type =============== " + type);
        try {
            if (type.equals("a")){
                responseBean.setReturnCode(200);
                responseBean.setReturnMsg("Success");
                return responseBean;
            }
            responseBean.setReturnCode(422);
            responseBean.setReturnMsg("参数异常");
            return responseBean;
        }catch (Exception e){
            e.printStackTrace();
            responseBean.setReturnCode(500);
            responseBean.setReturnMsg("请求出现异常");
            return responseBean;
        }
    }

    @PostMapping("/auth/login")
    @ApiOperation(value = "登录")
    @ApiOperationSupport(author = "学长")
    public ResponseBean login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception{
        try {
            final String token = authService.login(username, password);

            Map<String, String> tokenMap = new HashMap<>();

            tokenMap.put("token", token);
            tokenMap.put("tokenHead", tokenHead);

            return ResponseBean.ok(tokenMap);
        }catch (Exception e){
            return ResponseBean.error(e.getMessage());
        }
    }

    @PostMapping("/auth/register")
    @ApiOperation(value = "注册")
    @ApiOperationSupport(author = "学长")
    public ResponseBean register(@RequestParam("username") String username, @RequestParam("password") String password){
        try {
            Integer i = authService.register(username, password);

            return ResponseBean.ok(i);
        }catch (Exception e){
            return ResponseBean.error(e.getMessage());
        }
    }

    @GetMapping("/auth/findUsersByName")
    @ApiOperation(value = "获取后台用户")
    @ApiOperationSupport(author = "学长")
    public ResponseBean findUsersByName(@RequestParam("username") String username){
        Users byUserName = usersMapper.findByUserName(username);
        return ResponseBean.ok(byUserName);
    }
}
