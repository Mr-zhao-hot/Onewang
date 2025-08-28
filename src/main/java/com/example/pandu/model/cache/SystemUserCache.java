package com.example.pandu.model.cache;


import com.example.pandu.model.persist.po.systemuserpo.SystemUserLoginPo;
import com.example.pandu.model.persist.vo.systemuser.SystemUserVo;

public interface SystemUserCache {
    void setLoginPermissionInfo(String token, SystemUserLoginPo systemUserLoginPo);

    SystemUserVo selectLoginInfo();


    void setLoginInfo(SystemUserVo loginInfo);
}
