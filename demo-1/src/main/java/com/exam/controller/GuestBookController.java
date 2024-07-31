package com.exam.controller;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.guestBook.GuestBookServiceImpl;
import com.example.guestBook.GuestBookVO;

@RequestMapping("/guestBook")
@Controller
public class GuestBookController {
	
	GuestBookController(){
		System.out.println("GuestBookController 생성");
	}
	
	@Autowired
	GuestBookServiceImpl service;
	
	
	@GetMapping("/insert")
	public String insert(GuestBookVO vo, Model model) {
		System.out.println("insert");
			String [] firstName = {"최","박","석","김","황","오","이","장","정","조","한"};
			String [] LastName = {"하니","두리","지효","지솔","대익","지희","민준","승현","민기","민영"};
			
			int [] age = {11,12,13,14,15,16,17,18};
			String [] memo = {"안녕하세요","감사합니다","잘부탁드려요","너무좋아요","미안합니다","부탁드립니다",
					"응원합니다","고마워요","제가요?","지금요?","왜요?"};
		
			Random random = new Random();
			for(int i=1 ; i<125 ; i++) {
				int firstArr = random.nextInt(11);
				int LastArr= random.nextInt(10);
				int ageArr = random.nextInt(8);
				int memoArr = random.nextInt(11);
			
				vo.setName(firstName[firstArr]+LastName[LastArr]);
				vo.setAge(age[ageArr]);
				vo.setMemo(memo[memoArr]);
				
				service.insert(vo);
			}
			
		return "redirect:/guestBook/list";    	
	}

	@GetMapping("/list")
	public String getGuestBookList(GuestBookVO vo, Model model) {
		System.out.println("getGuestBookList");
		int start=0;
		int pageSize = 10;
		int pageListSize = 10;
		int totalCount = service.totalCount(vo);
		
		if(vo.getStart() == 0) {
			start = 1;
		} else {
			start = vo.getStart();
		}
		
		int end = start + pageSize - 1 ;
		int totalPage = (int) (Math.ceil((double)totalCount/pageSize));
		int currentPage = (start / pageSize) +1;
		int lastPage  = ( totalPage - 1 ) * pageSize + 1;
		int listStartPage = (currentPage - 1) / pageListSize * pageListSize + 1;
		int listEndPage = listStartPage + pageListSize - 1 ;
 
		// 1. 페이지사이즈
		model.addAttribute("pageSize", pageSize);
		// 2. 페이지 list 사이즈
		model.addAttribute("pageListSize", pageListSize);
		// 3. 전체 레코드 수
		model.addAttribute("totalCount", totalCount);
		// 4. 총페이지
		model.addAttribute("totalPage", totalPage);
		// 5. 현재 레코드
		model.addAttribute("start", start);
		// 6. 현재 페이지
		model.addAttribute("currentPage", currentPage);
		// 7. 하단 가로 시작
		model.addAttribute("listStartPage", listStartPage);
		// 8. 하단 가로 끝
		model.addAttribute("listEndPage", listEndPage);
		// 9. 마지막 페이지
		model.addAttribute("lastPage", lastPage);
				
		vo.setStart(start);
		vo.setEnd(end);
		
		model.addAttribute("ch1", vo.getCh1());
		model.addAttribute("ch2", vo.getCh2());
		
		model.addAttribute("li", service.list(vo)) ;
		return "guestBook/list.html";    	
	}
	
	
	
	
}
