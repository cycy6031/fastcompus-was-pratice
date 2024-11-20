package org.example;

import java.io.IOException;

// get /calculate?operand1=11&operator=*&operand2=22
public class Main {

    public static void main(String[] args) throws IOException {

        new CustomWebApplicationServer(8081).start();
    }
}