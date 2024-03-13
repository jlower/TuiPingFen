package com.xiaozhaovip.demo.controller.login;


import com.xiaozhaovip.demo.controller.BaseController;
import com.xiaozhaovip.demo.controller.util.UserUtils;
import com.xiaozhaovip.demo.intf.entity.User;
import com.xiaozhaovip.demo.intf.user.DO.ResponseDO;
import com.xiaozhaovip.demo.intf.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/u")
public class LoginController extends BaseController {

    @Resource
    private UserService userService;

    //hello
    @GetMapping("/login")
    public String show(Model model , HttpServletRequest request, HttpSession session) throws Exception {
        // 1 判断有没有登录
        int userId = UserUtils.dealUser(DOMAIN, request, session);

        String callback = request.getParameter("callback");

        // 2 跳转到url
        if(userId != 0){
            return "redirect:" + callback;
        }
        model.addAttribute("callback",callback);
        return "login";

    }

    @PostMapping("/login/verify")
    @ResponseBody
    public ResponseDO verify(String userName, String password, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println("username =:" + userName + " , password=:" + password);

        if(userName == null || userName.equals("")){
            return new ResponseDO(false, "用户名不正确", null);
        }

        if(password == null || password.equals("")){
            return new ResponseDO(false, "密码不正确", null);
        }

        User user = null;//userService.loadByName(userName);

        if(user == null){
            return new ResponseDO(false, "用户名不正确", null);
        }

        try {
//            if(MD5Signature.verify(password, user.getPassword(), KeyConstant.MD5_KEY)){
//                String token = user.getId() +  "_" + MD5Signature.sign("" + user.getId(), KeyConstant.MD5_KEY);
//                CookieUtil.addCookie("token", token, DOMAIN, response);
//                session.setAttribute("s_user_id" , user.getId());
//                return new ResponseDO(true, SUCCESS, null);
//            }
//            //
        }catch (Exception e){
            e.printStackTrace();
        }


        return new ResponseDO(false, "用户名不正确", null);
    }

    public static void main(String[] args) throws Exception {
       // System.out.println(MD5Signature.sign("123321", KeyConstant.MD5_KEY));
    }


}
