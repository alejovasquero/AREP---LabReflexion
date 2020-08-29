package edu.eci.escuelaing.arep.Controller;

import edu.eci.escuelaing.arep.Handlers.HTMLHandler;
import edu.eci.escuelaing.arep.HttpServer.HeadersCollection;
import edu.eci.escuelaing.arep.MySpring.Annotations.RequestMapping;

public class PagesController {

    @RequestMapping("/")
    public static String index(){
        return HeadersCollection.HTML_HEADERS +"Prueba SPRING <p><a href=\"/prueba\">Prueba</a></p>"+
                "<p><a href=\"/complex\">Pagina mejorada</a></p>";
    }


    @RequestMapping("/prueba")
    public static String prueba(){
        return HeadersCollection.HTML_HEADERS +"<button type=\"button\">Click Me!</button>";
    }

    @RequestMapping("/complex")
    public static String complex(){
        HTMLHandler handler = new HTMLHandler("src/main/webapp/data.html");
        return HeadersCollection.HTML_HEADERS + handler.getData();
    }

    @RequestMapping("/css/style.css")
    public static String style(){
        HTMLHandler handler = new HTMLHandler("src/main/webapp/css/style.css");
        return HeadersCollection.CSS_HEADERS + handler.getData();
    }
}
