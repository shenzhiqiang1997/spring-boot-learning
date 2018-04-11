package com.shen.learn.web;

import com.shen.learn.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/users")
public class UserController {
    private Map<Long,User> users
            = new ConcurrentHashMap<>();

    @ApiOperation("获取用户列表")
    @GetMapping("/")
    public List<User> getUserList(){
        List<User> u=new ArrayList<>();
        u.addAll(users.values());
        return u;
    }

    @ApiOperation(value = "创建用户",notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户实体user",required = true,dataType = "User")
    @PostMapping("/")
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息",notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long",paramType = "path")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    @ApiOperation(value = "更新用户详细信息",notes = "根据url的id和传入的User对象更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user",value = "用户实体user",required = true,dataType = "User")
    })
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id,@ModelAttribute User user){
        users.put(id,user);
        return "success";
    }

    @ApiOperation(value = "删除用户",notes = "根据url的id来删除指定用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long",paramType = "path")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }
}
