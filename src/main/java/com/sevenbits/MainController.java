package com.sevenbits;

import com.sevenbits.service.booking.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class MainController {
    private Map<String, Boolean> conditions;
    private Map<String, String> fields;
    private Map<String, String[]> parameters;

    private BookingService bookingService;

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/protected",method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        parameters = request.getParameterMap();
        bookingService.doWork(parameters, request.getParameter("rad"), request.getParameter("our"));

        fields = bookingService.getFields();
        conditions = bookingService.getConditions();

        request.getSession().setAttribute("field", fields);
        request.getSession().setAttribute("condition", conditions);

        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }
}

