package com.example.pandu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.pandu.model.persist.entity.SystemUser;
import com.example.pandu.model.persist.vo.systemuser.SystemUserLoginInfoVo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Mr_zh
* @description 针对表【system_user(系统用户表)】的数据库操作Mapper
* @createDate 2025-06-25 09:18:46
* @Entity com.example.demo.model.entity.SystemUser
*/
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    SystemUserLoginInfoVo selectLoginInfo(String phone);



}




