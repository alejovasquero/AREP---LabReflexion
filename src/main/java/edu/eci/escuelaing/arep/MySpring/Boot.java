package edu.eci.escuelaing.arep.MySpring;

import edu.eci.escuelaing.arep.MySpring.Annotations.RequestMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Boot {

    private final Map<String, Method> beans = new HashMap<String, Method>();

    public void map(String a) throws Exception {
        int passed = 0, failed = 0;
        for (Method m : Class.forName(a).getMethods()) {
            if (m.isAnnotationPresent(RequestMapping.class)) {
                try {
                    m.invoke(null);
                    String str = m.getAnnotation(RequestMapping.class).value();
                    beans.put(str, m);
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                }
            }
        }
    }


    public String invoke(String path){
        try{
            return beans.get(path).invoke(null).toString();
        } catch (Exception e){
            return "Error :'(";
        }
    }
}
