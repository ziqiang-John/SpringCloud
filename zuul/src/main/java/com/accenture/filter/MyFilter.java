package com.accenture.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType(){
        return "pre";
    }
    @Override
    public int filterOrder(){
        return 0;
    }
    @Override
    public boolean shouldFilter(){
        return true;
    }
    @Override
    public Object run(){
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        logger.info("%s >>> %s", httpServletRequest.getMethod(), httpServletRequest.getRequestURL().toString());
        Object accessToken = httpServletRequest.getParameter("token");
        if(accessToken == null){
            logger.warn("token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try{
                requestContext.getResponse().getWriter().write("token is empty");
            }
            catch(Exception e){

            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
