package sk.upjs.ics.errorhandling;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tomas on 16.12.2017.
 */
public class ErrorBase {

    protected static ModelAndView createModelView(String error, int status, String message) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("404");

        mav.addObject("error", error);
        mav.addObject("status", status);
        mav.addObject("message", message);

        return mav;
    }
}
