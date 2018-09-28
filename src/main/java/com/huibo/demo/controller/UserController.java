/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: UserController
  Author:   xingshuang
  Date:     2018/9/26 21:25
  Description: 
  History:
  <author>          <time>          <version>          <desc>
  作者姓名           修改时间           版本号              描述
 */
package com.huibo.demo.controller;


import com.huibo.demo.common.execution.MapResult;
import com.huibo.demo.model.User;
import com.huibo.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author xingshuang
 * @date 2018/9/26 21:25
 */
@Api(value = "UserController", description = "用户管理")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有用户", notes = "测试", httpMethod = "POST", consumes = "application/xml",response = MapResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "startPageIndex", value = "起始页面索引", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页面大小", dataType = "Integer")
    })
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public MapResult getUser(@RequestParam Integer startPageIndex, @RequestParam Integer pageSize) {
        try {
            return MapResult.success(this.userService.findAllUsersByPage(startPageIndex, pageSize));
        } catch (RuntimeException e) {
            return MapResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "查询所有用户，采用无参方式", notes = "测试", httpMethod = "GET")
    @RequestMapping(value = "/user1", method = RequestMethod.GET)
    public MapResult getUser1() {
        try {
            return MapResult.success(this.userService.findAllUsersByPage(1, 2));
        } catch (RuntimeException e) {
            return MapResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "查询所有用户，采用@PathVariable方式", notes = "测试", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "startPageIndex", value = "起始页面索引", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "pageSize", value = "页面大小", dataType = "Integer")
    })
    @RequestMapping(value = "/user2/{startPageIndex}/{pageSize}", method = RequestMethod.GET)
    public MapResult getUser2(@PathVariable Integer startPageIndex, @PathVariable Integer pageSize) {
        try {
            return MapResult.success(this.userService.findAllUsersByPage(startPageIndex, pageSize));
        } catch (RuntimeException e) {
            return MapResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "查询所有用户，采用@RequestParam方式", notes = "测试", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "startPageIndex", value = "起始页面索引", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页面大小", dataType = "Integer")
    })
    @RequestMapping(value = "/user3", method = RequestMethod.GET)
    public MapResult getUser3(@RequestParam Integer startPageIndex, @RequestParam Integer pageSize) {
        try {
            return MapResult.success(this.userService.findAllUsersByPage(startPageIndex, pageSize));
        } catch (RuntimeException e) {
            return MapResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "查询指定用户，采用@RequestBody方式", notes = "测试", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "user", value = "user对象，id必填", dataType = "User")
    })
    @RequestMapping(value = "/user/get/by/id", method = RequestMethod.POST)
    public MapResult getUserById(@RequestBody User user) {
        try {
            return MapResult.success(this.userService.findUserById(user));
        } catch (RuntimeException e) {
            return MapResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "查询指定用户，采用@RequestBody方式", notes = "测试", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "user", value = "user对象，id必填", dataType = "User")
    })
    @RequestMapping(value = "/user/update/by/id", method = RequestMethod.POST)
    public MapResult updateUserById(@RequestBody User user) {
        try {
            return MapResult.success(this.userService.updateUserById(user));
        } catch (RuntimeException e) {
            return MapResult.error(e.getMessage());
        }
    }
}
