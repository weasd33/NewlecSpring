package com.newlecture.web.controller.admin.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

// 동일명의 클래스가 있기 때문에 컨트롤러에 명명해 줘야 된다.
@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController { // <bean name="adminNoticeController" class="com.newlecture.web.controller.admin.board.NoticeController" />

	@RequestMapping("list")
	public String list() {

		return "";
	}

	@RequestMapping("reg")
	@ResponseBody
	public String reg(String title, String content, MultipartFile file, String category, String[] foods, String food) {
		String fileName = file.getOriginalFilename();
		long size = file.getSize();
		System.out.printf("파일명:%s, 파일크기:%d\n", fileName, size);
		
		System.out.println(category);
		for(String f : foods)
			System.out.println(f);
		return String.format("title:%s<br>content:%s<br>category:%s<br>", title, content, category);
	}

	@RequestMapping("edit")
	public String edit() {

		return "";
	}

	@RequestMapping("del")
	public String del() {

		return "";
	}
}
