package priv.shen.learn.web;

import priv.shen.learn.dao.UserRepository;
import priv.shen.learn.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @ApiOperation("获取用户列表")
    @GetMapping("/")
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    @ApiOperation(value = "创建用户",notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户实体user",required = true,dataType = "User")
    @PostMapping("/")
    public String postUser(@ModelAttribute User user){
        userRepository.save(user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息",notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long",paramType = "path")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @ApiOperation(value = "更新用户详细信息",notes = "根据url的id和传入的User对象更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user",value = "用户实体user",required = true,dataType = "User")
    })
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id,@ModelAttribute User user){
        userRepository.save(user);
        return "success";
    }

    @ApiOperation(value = "删除用户",notes = "根据url的id来删除指定用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long",paramType = "path")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return "success";
    }
}
