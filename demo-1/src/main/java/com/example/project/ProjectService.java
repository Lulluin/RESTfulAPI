package com.example.project;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

public interface ProjectService {
	
	String insertMPay(PortVO mpay, HttpSession session, RedirectAttributes rttr);
	
	ModelAndView paymentContents( String mpaynum, HttpSession session);
	
}
