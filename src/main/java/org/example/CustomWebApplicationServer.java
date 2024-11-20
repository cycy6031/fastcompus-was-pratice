package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class CustomWebApplicationServer {

    private final int port;

    private static final Logger logger = Logger.getLogger(CustomWebApplicationServer.class.getName());

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(port)){
            logger.info("Custom Web Application Server started on port " + port);

            Socket clientSocket;
            logger.info("Custom Web Application Server waiting for client");

            while((clientSocket = serverSocket.accept()) != null){
                logger.info("Custom Web Application Server client Connected");

                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    String line;
                    while((line = br.readLine()) != ""){
                        System.out.println(line);
                    }
                }
            }

        }
    }

}
