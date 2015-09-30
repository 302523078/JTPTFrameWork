package com.hisense.jtpt.service.impl;

import com.hisense.core.service.impl.BaseServiceImpl;
import com.hisense.jtpt.entity.SysUser;
import com.hisense.jtpt.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by bcm on 15-9-30.
 */
@Service
public class SysUserServiceImpl  extends BaseServiceImpl<SysUser> implements SysUserService {



    public String  buildQuery(Map<String, Object> params, boolean isQuery){
        StringBuffer hql = new StringBuffer();
        if(isQuery){
            hql.append("select t from SysUser t");
        }else{
            hql.append("select count(t) from SysUser t");
        }
        hql.append(" where 1=1 ");
        for(String key:params.keySet()){
            hql.append(" and  t." + key +" = :" + key);
        }

        return hql.toString();
    }
}
