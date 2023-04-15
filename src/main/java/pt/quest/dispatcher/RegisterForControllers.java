package pt.quest.dispatcher;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterForControllers {

    public Map<String, MethodMap> register(Object... controllerInstances) {

        Map<String, MethodMap> urlToMethodMap = new HashMap<>();

        for (Object controllerInstance : controllerInstances) {
            Class<?> clazz = controllerInstance.getClass();
            Method[] methods = clazz.getMethods();
            System.out.println("Check methods");

            for (Method method : methods) {
                System.out.println("method name: " + method.getName() + "");
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                    String url = annotation.url();
                    MethodType httpMethod = annotation.method();
                    System.out.println("url in map: " + url);
                    urlToMethodMap.put(url, new MethodMap(controllerInstance, httpMethod, method));
                }
            }
        }

        return urlToMethodMap;
    }

}