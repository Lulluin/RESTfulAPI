package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
	private  ProjectDao  dao ;
	
	ProjectServiceImpl(){
		  System.out.println("===> ProjectServiceImpl 생성자");
	}


	@Override
	public String insertMPay(PortVO mpay, HttpSession session, RedirectAttributes rttr) {
		
	    System.out.println("insertMPay()");
	    String view = null;
	    String msg = null;

	    try {	    	
	    	dao.insertMPay(mpay);
	        view = "/payment?mpaynum=" + mpay.getMpaynum();
	        System.out.println(view);
	    } catch (Exception e){
	        e.printStackTrace();
	    }
	    return view;
	}

	@Override
	public ModelAndView paymentContents( String mpaynum, HttpSession session) {
		 
		 ModelAndView  mv = new ModelAndView();

		  //주문정보 가져오기
		  PortVO mpay = dao.selectPayment(mpaynum);
		  mv.addObject("mpay", mpay);
		  int gymnum = mpay.getGymnum();            // 헬스장 고유번호 
		  int tgoodsint = mpay.getTgoodsint();      // 주문번호 

		  //헬스장 정보 가져오기
		  PortVO gym = dao.selectGym(gymnum);
		  mv.addObject("gym", gym);
		  //view 설정
		  mv.setViewName("payment");

		  return mv;
	}

}
