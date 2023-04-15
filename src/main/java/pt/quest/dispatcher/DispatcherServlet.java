package pt.quest.dispatcher;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static pt.quest.context.GameContext.URL_TO_METHODMAP;

@WebServlet(value = "/dispatcher/*")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String httpMethod = req.getMethod();
        String uri = req.getRequestURI();

        String url = uri.replace(req.getContextPath(), "").replace(req.getServletPath(), "");
        System.out.println("url: " + url);


        MethodMap methodMap = URL_TO_METHODMAP.get(url);

        Method method = methodMap.getMethod();
        Object controller = methodMap.getControllerInstance();
        MethodType methodType = methodMap.getMethodType();

        if (httpMethod.equalsIgnoreCase(methodType.name())) {
            try {
                method.invoke(controller, req, resp);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}