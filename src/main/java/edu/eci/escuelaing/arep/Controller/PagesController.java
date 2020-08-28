package edu.eci.escuelaing.arep.Controller;

import edu.eci.escuelaing.arep.MySpring.Annotations.RequestMapping;

public class PagesController {

    @RequestMapping("/")
    public static String index(){
        return "Prueba SPRING";
    }


    @RequestMapping("/prueba")
    public static String prueba(){
        return "<button type=\"button\">Click Me!</button>";
    }

}
