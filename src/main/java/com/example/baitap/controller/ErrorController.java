//package com.example.baitap.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class ErrorController {
//    @RequestMapping(value = "errors", method = RequestMethod.GET)
//    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
//
//        ModelAndView errorPage = new ModelAndView("error/404");
//        String errorMsg = "";
//        int httpErrorCode = getErrorCode(httpRequest);
//
//        switch (httpErrorCode) {
//            case 400: {
//                errorMsg = "Http Error Code: 400. Bad Request";
//                ModelAndView page400 = new ModelAndView("error/400");
//                return page400;
//            }
//            case 401: {
//                errorMsg = "Http Error Code: 401. Unauthorized";
//                ModelAndView page401 = new ModelAndView("error/401");
//                return page401;
//            }
//            case 404: {
//                errorMsg = "Http Error Code: 404. Resource not found";
//                ModelAndView page404 = new ModelAndView("error/404");
//                return page404;
//            }
//            case 405: {
//                errorMsg = "Http Error Code: 405. Method Not Allowed";
//                ModelAndView page405 = new ModelAndView("error/405");
//                return page405;
//            }
//            case 500: {
//                errorMsg = "Http Error Code: 500. Internal Server Error";
//                ModelAndView page500 = new ModelAndView("error/500");
//                return page500;
//            }
//        }
//        errorPage.addObject("errorMsg", errorMsg);
//        return errorPage;
//    }
//
//    @RequestMapping(value = "errors", method = RequestMethod.POST)
//    public ModelAndView renderErrorPageMethod(HttpServletRequest httpRequest) {
//
//        ModelAndView errorPage = new ModelAndView("error/404");
//        String errorMsg = "";
//        int httpErrorCode = getErrorCode(httpRequest);
//
//        switch (httpErrorCode) {
//            case 400: {
//                errorMsg = "Http Error Code: 400. Bad Request";
//                break;
//            }
//            case 401: {
//                errorMsg = "Http Error Code: 401. Unauthorized";
//                break;
//            }
//            case 404: {
//                errorMsg = "Http Error Code: 404. Resource not found";
//                break;
//            }
//            case 405: {
//                errorMsg = "Http Error Code: 405. Method Not Allowed";
//                break;
//            }
//            case 409: {
//                errorMsg = "Http Error Code: 409. Data Conflict";
//                break;
//            }
//            case 500: {
//                errorMsg = "Http Error Code: 500. Internal Server Error";
//                break;
//            }
//        }
//        errorPage.addObject("errorMsg", errorMsg);
//        return errorPage;
//    }
//
//    @RequestMapping(value = "500Error", method = RequestMethod.GET)
//    public void throwRuntimeException() {
//        throw new NullPointerException("Throwing a null pointer exception");
//    }
//
//    private int getErrorCode(HttpServletRequest httpRequest) {
//        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
//    }
//}
