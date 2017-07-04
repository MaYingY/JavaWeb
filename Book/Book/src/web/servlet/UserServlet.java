package web.servlet;

import cn.itcast.servlet.BaseServlet;
import domain.User;
import exception.RegistException;
import org.apache.commons.beanutils.BeanUtils;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zzp on 2017/4/10.
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    private UserServiceImp serviceImp = new UserServiceImp();

    public String activecode(HttpServletRequest request, HttpServletResponse response){
        String activeCode = request.getParameter("activecode");
        serviceImp.activeUser(activeCode);
    }

    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //验证码操作
        String checkcode = request.getParameter("checkcode");
        String _checkcode = (String) request.getSession().getAttribute("session_vcode");
        request.getSession().removeAttribute("session_vcode");
        System.out.println(checkcode+"   "+_checkcode);
        if(_checkcode == null || !_checkcode.equalsIgnoreCase(checkcode)){
            request.setAttribute("regist.message", "验证码不正确");
            return "/regist.jsp";
        }

        //得到请求参数， 封装到javaBean中
        User user = new User();
        BeanUtils.populate(user, request.getParameterMap());
        //进行服务器端数据校验
        Map<String, String> map = user.validateRegist();
        if(map.size() > 0){
            request.setAttribute("map", map);
            return "/regist.jsp";
        }
        //手动封装一个激活码
        user.setActivecode(UUID.randomUUID().toString());
        try {
            serviceImp.regist(user);
            response.getWriter().write("注册成功，激活后请<a href='"+request.getContextPath()+"/index.jsp'>登录</a>");
        } catch (RegistException e) {
            request.setAttribute("regist.message", e.getMessage());
            return "/regist.jsp";
        }
        return null;
    }

}
