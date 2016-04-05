package com.boottest;

import com.obj.User;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by asreal on 2016-03-31.
 */
@EnableSwagger2
@RestController
@RequestMapping(value = "/user")
@Api("测试swagger")
public class BootTestController {

    //    @RequestMapping(value = "/show", method = RequestMethod.POST)
    //    // 这里指定RequestMethod，如果不指定Swagger会把所有RequestMethod都输出，在实际应用中，具体指定请求类型也使接口更为严谨。
    //    @ApiOperation(value = "测试接口", notes = "测试接口详细描述")
    //    @ResponseBody
    //    public String show(@ApiParam(required = true, name = "name", value = "姓名") @RequestParam(name = "name") String stuName) {
    //        return "success";
    //    }

    @ApiOperation(value = "获取用户信息", notes = "请输入相关的参数")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "username", dataType = "String", required = true, value = "用户的姓名"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码") })
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@RequestHeader("username") String username,
                          @RequestParam("password") String password) {
        return username + password;
    }

    @ApiOperation(value = "获取用户", notes = "请输入相关的参数")
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @RequestMapping(value = "/getUserObj", method = RequestMethod.POST)
    @ResponseBody
    public User getUserObj(@RequestBody User user) {
        return user;
    }
}
