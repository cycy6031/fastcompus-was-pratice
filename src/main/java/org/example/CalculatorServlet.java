package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import org.example.calculate.Calculator;
import org.example.calculate.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/calculate")
public class CalculatorServlet implements Servlet{

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException{
        log.info("init");
        this.servletConfig = servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException{
        log.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }

    @Override
    public ServletConfig getServletConfig(){
        return this.servletConfig;
    }

    @Override
    public String getServletInfo(){
        return null;
    }

    @Override
    public void destroy() {

    }
}
