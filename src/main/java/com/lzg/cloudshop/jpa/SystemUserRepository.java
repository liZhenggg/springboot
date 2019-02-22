package com.lzg.cloudshop.jpa;

import com.lzg.cloudshop.bean.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {

    List<SystemUser> findByPhoneNum(String phoneNum);
}
