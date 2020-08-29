package edu.eci.escuelaing.arep;

import static org.junit.Assert.*;

import edu.eci.escuelaing.arep.MySpring.Annotations.RequestMapping;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;

/**
 * Unit test for simple App.
 */
public class AnnotationsTest {

    @Test
    public void testAnnotationsNumbers(){
        int passed = 0, failed = 0;
        for (Method m : AnnonationsMap.class.getMethods()) {
            System.out.println(m.getName());
            if (m.isAnnotationPresent(RequestMapping.class)) {
                try {
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                }
            } else {
                failed++;
            }
        }

        assertEquals(passed, 3);
        assertEquals(failed, 3+9);
        assertEquals(passed, passed);
    }
}
