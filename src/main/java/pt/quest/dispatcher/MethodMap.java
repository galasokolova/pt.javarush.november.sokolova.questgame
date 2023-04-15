package pt.quest.dispatcher;

import java.lang.reflect.Method;
import java.util.Objects;

public class MethodMap {
    private final Object controllerInstance;
    private final MethodType methodType;
    private final Method method;

    public MethodMap(Object controllerInstance, MethodType methodType, Method method) {
        this.controllerInstance = controllerInstance;
        this.methodType = methodType;
        this.method = method;
    }

    public Object getControllerInstance() {
        return controllerInstance;
    }

    public MethodType getMethodType() {
        return methodType;
    }

    public Method getMethod() {
        return method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MethodMap methodMap = (MethodMap) o;
        return Objects.equals(controllerInstance, methodMap.controllerInstance) &&
                methodType == methodMap.methodType &&
                Objects.equals(method, methodMap.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controllerInstance, methodType, method);
    }

    @Override
    public String toString() {
        return "MethodMap{" +
                "controllerInstance=" + controllerInstance +
                ", methodType=" + methodType +
                ", method=" + method +
                '}';
    }
}