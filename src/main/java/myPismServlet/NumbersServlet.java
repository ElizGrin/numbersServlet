package myPismServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class NumbersServlet extends HttpServlet{

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.setContentType("charset=UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();

        ArrayList<Double> list_of_nums = new ArrayList<>();

        int temp = 0;
        double n = 0;
        boolean i;
        int count = 0;

        try{
        String num = httpServletRequest.getParameter("numbers");

        String[] numbers = num.split(" ");

        for (String number : numbers) {
            n = Double.parseDouble(number);
            temp = (int) n;
            if (number.compareTo(Integer.toString(temp)) == 0) {
                count++;
            }
            list_of_nums.add(n);
            }

            int lsize = list_of_nums.size();

            writer.println("<p><center>Quantity of numbers: " + lsize + "</center></p>");
            writer.println("<p><center>The number of integers: " + count + "</center></p>");
            writer.println("<p><center>The number of doubles: " + (lsize - count) + "</center></p>");
            writer.println("<p><center>The first number: " + list_of_nums.get(0) + "</center></p>");
            writer.println("<p><center>The last number: " + list_of_nums.get(lsize - 1) + "</center></p>");
    }
        catch(NumberFormatException e1){
            writer.println("<br><h2><center>Wrong input! Try again "+
                    "<a href='https://localhost:8888/numbersServlet'></a></center></h2>");
        }
        writer.close();
    }
}

