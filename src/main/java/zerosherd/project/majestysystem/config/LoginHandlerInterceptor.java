package zerosherd.project.majestysystem.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("currentUser");
        if (loginUser == null) {
            request.setAttribute("msg", "请先登陆！");
            request.getRequestDispatcher("index").forward(request, response);
            return false;
        } else {
            return true;
        }
    }

}
