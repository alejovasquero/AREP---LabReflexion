package edu.eci.escuelaing.arep.HttpServer;



import edu.eci.escuelaing.arep.MySpring.Boot;
import edu.eci.escuelaing.arep.WebFram.WebFramework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

import static edu.eci.escuelaing.arep.WebFram.WebFramework.*;

public class HttpServer {
    private static boolean runnning = false;
    private static int port = 35000;
    private static Boot boot = null;

    public static void setBoot(Boot b){
        boot=b;
    }

    public static void start() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+ port +".");
            System.exit(1);
            }
        Socket clientSocket = null;
        runnning = true;
        while(runnning) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            processClient(clientSocket);
        }
        serverSocket.close();
    }


    private static void processClient(Socket s){
        try {
            makeResponse(s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e){

        }
    }
    public static void makeResponse(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        String[] argu = null;
        HashMap<String, String[]> a = new HashMap<String, String[]>();
        System.out.println("Leyendo mensaje...");
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje: " + inputLine);
            argu = inputLine.split("\\s+");
            a.put(argu[0], argu);
            if (!in.ready()) {
                break;
            }
        }
        if(a.containsKey("Accept:")){
            findResponse(clientSocket, a);
        }
        in.close();
        clientSocket.close();
    }

    public static void findResponse(Socket clientSocket, HashMap<String, String[]> request) throws IOException, NoSuchElementException {

        String outputLine = null;
        System.out.println(Arrays.toString(request.entrySet().toArray()));
        System.out.println(request.get("Accept:"));
        String type = request.get("Accept:")[1];
        System.out.println("HELLO: "+type);
        if(type.contains("text/html") || type.contains("text/css")){
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            outputLine = boot.invoke(request.get("GET")[1]);
            out.writeBytes(HeadersCollection.HTML_HEADERS);
            out.writeBytes(outputLine);
            out.close();
        } else {
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            File file = new File("src/main/webapp/images/prueba.png");
            int numOfBytes = (int) file.length();

            FileInputStream inFile  = new FileInputStream ("src/main/webapp/images/prueba.png");

            byte[] fileInBytes = new byte[numOfBytes];
            inFile.read(fileInBytes);
            out.writeBytes(JPG_HEADERS);
            out.write(fileInBytes,0, numOfBytes);
            out.close();
            inFile.close();
        }
        System.out.println(outputLine);

    }


    public static void setPort(int p){
        port = p;
    }


    public static int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
