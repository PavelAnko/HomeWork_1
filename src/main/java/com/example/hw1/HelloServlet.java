package com.example.hw1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//
//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Survey results</title>");
//        out.println("</head>");
//        out.println("<body>");
//
//        out.println("<h2>Survey results:</h2>");
//
//        String answer1 = request.getParameter("questionJava");
//        String answer2 = request.getParameter("questionCsharp");
//
//
//        out.println("<p>Ответ на вопрос 1: " + answer1 + "</p>");
//        out.println("<p>Ответ на вопрос 2: " + answer2 + "</p>");
//
//
//        HttpSession session = request.getSession();
//
//
//        Map<String, Integer> statistics = (Map<String, Integer>) session.getAttribute("statistics");
//        if (statistics == null) {
//            statistics = new HashMap<>();
//            session.setAttribute("statistics", statistics);
//        }
//
//
//        updateStatistics(statistics, answer1);
//        updateStatistics(statistics, answer2);
//
//
//        out.println("<h3>Статистика выборов в текущей сессии:</h3>");
//        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
//            out.println("<p>" + entry.getKey() + ": " + entry.getValue() + " раз</p>");
//        }
//
//        out.println("</body>");
//        out.println("</html>");
//    }
//
//
//    private void updateStatistics(Map<String, Integer> statistics, String answer) {
//        statistics.put(answer, statistics.getOrDefault(answer, 0) + 1);
//    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    HttpSession session = request.getSession(true); // Використовуйте true для автоматичного створення сесії, якщо вона не існує

    String javaAnswer = request.getParameter("javaAnswer");  // Отримання параметрів з JSP-сторінки
    String csharpAnswer = request.getParameter("csharpAnswer");

    int javaYes = (session.getAttribute("javaYes") != null) ? (int) session.getAttribute("javaYes") : 0; // Отримання атрибутів з сесії або ініціалізація, якщо вони ще не існують
    int javaNo = (session.getAttribute("javaNo") != null) ? (int) session.getAttribute("javaNo") : 0;
    int csharpYes = (session.getAttribute("csharpYes") != null) ? (int) session.getAttribute("csharpYes") : 0;
    int csharpNo = (session.getAttribute("csharpNo") != null) ? (int) session.getAttribute("csharpNo") : 0;

    if ("Yes".equals(javaAnswer)) {      // Оновлення відповідей
        javaYes++;
    } else if ("No".equals(javaAnswer)) {
        javaNo++;
    }
    if ("Yes".equals(csharpAnswer)) {
        csharpYes++;
    } else if ("No".equals(csharpAnswer)) {
        csharpNo++;
    }

    session.setAttribute("javaYes", javaYes);     // Оновлення атрибутів сесії
    session.setAttribute("javaNo", javaNo);
    session.setAttribute("csharpYes", csharpYes);
    session.setAttribute("csharpNo", csharpNo);

    response.sendRedirect("index.jsp");     // Перенаправлення на JSP-сторінку
}
}