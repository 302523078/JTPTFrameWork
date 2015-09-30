package com.hisense.core.controller;


import com.hisense.core.util.HqlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bcm on 15-9-30.
 */
public abstract class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Logger getLogger() {
        return logger;
    }

    /**
     *  requet 转化为Hqlsql
     * @param request
     * @return
     */
    public  HqlFilter makeHqlFilter(HttpServletRequest request){
        HqlFilter hqlFilter = new HqlFilter(request);
        return hqlFilter;
    };





}
