package com.lzg.cloudshop.service;

import com.lzg.cloudshop.bean.SystemUser;
import com.lzg.cloudshop.jpa.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Component
public class SystemUserService {

    @Autowired
    SystemUserRepository systemUserRepository;

    //系统用户登录
    public SystemUserRepository login(String userName, String password) {
        return null;
    }

    /**
     * 查询所有系统用户列表
     *
     * @return
     */
    public List<SystemUser> getList() {
        return systemUserRepository.findAll();
    }

    /**
     * 新增系统用户
     *
     * @return
     */
    public SystemUser add(SystemUser user) {
        user.setBlack(false);
        return systemUserRepository.save(user);
    }

    /**
     * 根据Id查询
     *
     * @param userId
     * @return
     */
    public SystemUser findById(Integer userId) {
        return systemUserRepository.findById(userId).get();
    }

    public List<SystemUser> findByPhoneNum(String phoneNum) {
        return systemUserRepository.findByPhoneNum(phoneNum);
    }

    public SystemUser update(SystemUser user) {
        return systemUserRepository.save(user);
    }

    public void delete(Integer userId) {
        systemUserRepository.deleteById(userId);
    }

    @Transactional
    public void addTow() {
        SystemUser userA = new SystemUser();
        userA.setUserName("addUserA");
        userA.setPassword("addUserAPwd");
        userA.setPhoneNum("18966665555");
        userA.setBlack(false);
        systemUserRepository.save(userA);

        SystemUser userB = new SystemUser();
        userB.setUserName("addUserA");
        userB.setPassword("addUserAPwd");
        userB.setPhoneNum("1896666555511111111");
        userB.setBlack(false);
        systemUserRepository.save(userB);

    }
}
