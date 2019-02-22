package com.lzg.cloudshop.controller;

import com.lzg.cloudshop.bean.SystemUser;
import com.lzg.cloudshop.jpa.SystemUserRepository;
import com.lzg.cloudshop.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/systemUser")
public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;

    @GetMapping(value = "/getList")
    public Map<String, Object> getList() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<SystemUser> list = systemUserService.getList();
        List userList = list.stream().map(u -> u.getUserName()).collect(Collectors.toList());
        resultMap.put("status", true);
        resultMap.put("userList", userList);
        return resultMap;
    }

    @PostMapping(value = "/add")
    public Boolean addSystemUser(@RequestParam String userName, @RequestParam String password,
                                 @RequestParam(required = false) String phoneNum) {
        SystemUser user = new SystemUser();
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhoneNum(phoneNum);
        systemUserService.add(user);
        return true;
    }

    @GetMapping(value = "/findById/{id}")
    public SystemUser findById(@PathVariable Integer id) {
        return systemUserService.findById(id);
    }


    @GetMapping(value = "/findByPhoneNum/{phoneNum}")
    public Map<String, Object> findByPhoneNum(@PathVariable String phoneNum) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<SystemUser> list = systemUserService.findByPhoneNum(phoneNum);
        List userList = list.stream().map(u -> u.getUserName()).collect(Collectors.toList());
        resultMap.put("status", true);
        resultMap.put("userList", userList);
        return resultMap;
    }


    @PutMapping(value = "/update")
    public void update(@RequestParam Integer userId, @RequestParam String userName,
                       @RequestParam String password, @RequestParam String phoneNum,
                       @RequestParam(required = false) Boolean isBlank) {
        SystemUser user = systemUserService.findById(userId);
        user.setId(userId);
        user.setPhoneNum(phoneNum);
        user.setUserName(userName);
        user.setPassword(password);
        if (isBlank != null) {
            System.out.println("isBlank != null");
            user.setBlack(isBlank);
        }else{
            System.out.println("isBlank is null");
        }
        systemUserService.update(user);
    }

    @DeleteMapping(value = "/delete/{userId}")
    public void delete(@PathVariable Integer userId) {
        systemUserService.delete(userId);
    }

    @PostMapping(value = "/addTow")
    public void addTow(){
        systemUserService.addTow();
    }
}
