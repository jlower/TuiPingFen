package com.xiaozhaovip.demo.controller.util;

import com.xiaozhaovip.demo.intf.entity.security.MD5Signature;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtils {

    public static int dealUser(String domain, HttpServletRequest request, HttpSession session) throws Exception {
        String userIdStr = CookieUtil.getCookieValue(request, domain, "token");
        if(!StringUtils.isEmpty(userIdStr)){
            String[] users = userIdStr.split("_");
            if(users.length ==2){
                if(MD5Signature.verify(users[0], users[1], "1234")){
                    System.out.println("already logined in");
                    return NumberUtils.toInt(users[0]);
                }
            }
        }else{
           return NumberUtils.toInt((String) session.getAttribute("s_user_id"));
        }

        return 0;
    }



}
