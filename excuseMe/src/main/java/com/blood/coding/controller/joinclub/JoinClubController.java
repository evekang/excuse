package com.blood.coding.controller.joinclub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blood.coding.dto.joinClub.JoinClubVO;
import com.blood.coding.service.joinclub.JoinClubService;

@Controller
public class JoinClubController {
	
	@Autowired
	private JoinClubService joinClubService;
	
	
	
	//클럽에 가입한 멤버인지 확인할때
	//멤버가 클럽에 가입할때
	//매핑 예) http://localhost/coding/joinclub?mem_id=ro@a.a&club_no=c14
	@RequestMapping("joinclub")
	public ResponseEntity<Boolean> joinClub(JoinClubVO joinVO) throws Exception {
		boolean bool = joinClubService.registClub(joinVO);
		
		ResponseEntity<Boolean> entity = new ResponseEntity<Boolean>(bool,HttpStatus.OK);
		
		return entity;
	}
	
	//클럽에 가입한 멤버인지 확인할때
	//멤버가 틀럽에 탈퇴할때
	//매핑 예) http://localhost/coding/exitclub?mem_id=ro@a.a&club_no=c10
	@RequestMapping("exitclub")
	public ResponseEntity<Boolean> exitClub(JoinClubVO joinVO) throws Exception {
		boolean bool = joinClubService.removeClub(joinVO);
		
		ResponseEntity<Boolean> entity = new ResponseEntity<Boolean>(bool,HttpStatus.OK);
		
		return entity;
	}
	
	
	
}
