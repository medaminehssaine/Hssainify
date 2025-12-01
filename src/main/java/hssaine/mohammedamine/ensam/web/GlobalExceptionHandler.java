package hssaine.mohammedamine.ensam.web;

import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest req, Exception ex, Model model) {
        model.addAttribute("exception", ex);
        model.addAttribute("url", req.getRequestURL());
        return "error";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Trim incoming String parameters; empty -> null
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        // Allow empty numeric fields to be treated as null instead of failing conversion
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));
    }
}
