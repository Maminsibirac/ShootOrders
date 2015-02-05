package com.sevenbits;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sevenbits.service.booking.BookingService;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class MainController {

    private BookingService bookingService;

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping(value = "/protected", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        bookingService.doWork(parameters, request.getParameter("rad"), request.getParameter("our"));

        Map<String, Boolean> conditions = bookingService.getConditions();

        //request.getSession().setAttribute("field", fields);
        //request.getSession().setAttribute("condition", conditions);

        //request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
        return conditions;
    }
}

