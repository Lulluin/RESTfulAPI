package com.example.guestBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookServiceImpl implements GuestBookService{
	
	@Autowired
	private GuestBookDao  dao;


	@Override
	public void insert(GuestBookVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<GuestBookVO> list(GuestBookVO vo) {
        if (vo.getCh2() != null) {
			if ( !vo.getCh2().substring(0).equals("'")) {
				String ch2 = '%' + vo.getCh2() + '%';
				vo.setCh2(ch2);	
			}else {
				String ch2 = vo.getCh2() ;
				vo.setCh2(ch2);	
			}
        }
		return dao.list(vo);
	}

	@Override
	public int totalCount(GuestBookVO vo) {
				
		return dao.totalCount(vo);
	}

}
