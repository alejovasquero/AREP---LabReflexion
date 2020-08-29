package edu.eci.escuelaing.arep;

import edu.eci.escuelaing.arep.Controller.PagesController;
import edu.eci.escuelaing.arep.HttpServer.HttpServer;
import edu.eci.escuelaing.arep.MySpring.Boot;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        Boot bo = null;
        try {
            bo = new Boot();
            bo.map(args[0]);
            System.out.println(bo.invoke("/"));
            HttpServer.setBoot(bo);
            HttpServer.setPort(HttpServer.getPort());
            HttpServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static
}
