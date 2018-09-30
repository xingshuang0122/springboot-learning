/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: MyFilter
  Author:   ShuangPC
  Date:     2018/9/29 17:15
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/29 17:15
 */
@Component
public class MyFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("{} >>> {}", request.getMethod(), request.getRequestURL());
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            logger.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.info("ok");
        }
        return null;
    }
}
