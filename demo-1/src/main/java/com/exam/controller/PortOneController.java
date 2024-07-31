package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.project.PortVO;
import com.example.project.ProjectService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PortOneController {

	PortOneController(){
		System.out.println("===> PortOneController 생성자");
	}
	
	@Autowired
	private ProjectService  mPServ;
	
	@GetMapping("/Port/PortOneStart")
	String PortOneStart( Model model ,  PortVO vo ) {
		System.out.println("===> PortOneStart 매핑확인 ");
		
		 vo.setGname("영원헬스클럽");
		 vo.setGymnum(90001);
		 model.addAttribute("gym", vo);
		 
		 vo.setMmail("kk0063@naver.com");
		 vo.setMname("영심이");
		 vo.setMphone("010-1234-6133");
		 vo.setMembernum("90001");
		 
		 model.addAttribute("member", vo);
		
		return "/PortOne/index";
	}
	

    @PostMapping("/insertMPay")
    @ResponseBody
    public String insertMPay(@RequestBody PortVO mpay, HttpSession session, RedirectAttributes rttr){
    	  System.out.println("===> Controller insertMPay()");
        
        // 리턴값으로 view = "payment?mpaynum=" + mpay.getMpaynum();
        // 즉 저장하고 결제 완료 페이지로 넘어 간다. 
        String view = mPServ.insertMPay(mpay, session, rttr);  
        return view;
    }

    @GetMapping("/payment")
    public String paymentContents(String mpaynum, HttpSession session, Model model){
    	  System.out.println("===> Controller paymentContents()");
    	  // 테이터 베이스에 결제 정보를 저장 후  주문정보와 헬스장 정보를 리턴한다. 
        model.addAttribute("mv", mPServ.paymentContents(mpaynum, session));
        return "PortOne/getBoard.html";
    }
        
        
}
