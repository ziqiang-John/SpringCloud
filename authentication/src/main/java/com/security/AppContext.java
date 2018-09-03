package com.security;


import org.springframework.context.ApplicationContext;

public class AppContext {
    public static ApplicationContext ctx=null;
    public static Object getObject(String string){
        return ctx.getBean(string);
    }

}