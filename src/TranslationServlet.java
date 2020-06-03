import com.sun.org.apache.xml.internal.serialize.EncodingInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslationServlet", urlPatterns = "/translate")
public class TranslationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String search = request.getParameter("txtSearch");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search);
        if (result != null) {
            writer.println("Word: " + search);
            writer.println("Result: " + result);
        } else {
            writer.println("Not found");
        }

        writer.println(request.getMethod());
        writer.println("<br>");
        writer.println(request.getPathInfo());
        writer.println("<br>");
        writer.println(request.getRemoteUser());
        writer.println("<br>");
        writer.println(request.getRequestURL());
        writer.println("<br>");
        writer.println(request.getRequestURI());
        writer.println("<br>");

    }
//    ################################################
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
//    ################################################

//    @Override
//    protected long getLastModified(HttpServletRequest req) {
//        GregorianCalendar cal = new GregorianCalendar();        // current time
//        cal.set(Calendar.HOUR, 0);                              // set to midnight
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        return cal.getTimeInMillis();
//    }
}