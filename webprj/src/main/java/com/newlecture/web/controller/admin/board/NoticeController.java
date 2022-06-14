package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

// 동일명의 클래스가 있기 때문에 컨트롤러에 명명해 줘야 된다.
@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController { // <bean name="adminNoticeController" class="com.newlecture.web.controller.admin.board.NoticeController" />

	@Autowired
	private ServletContext ctx;
	
	@RequestMapping("list")
	public String list() {

		return "";
	}

	@RequestMapping("reg")
	@ResponseBody
	public String reg(String title, String content, MultipartFile file, String category, String[] foods, String food, HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		long size = file.getSize();
		System.out.printf("파일명:%s, 파일크기:%d\n", fileName, size);
		
//		----------------------------------- 파일 저장 Start ----------------------------------- 
		// 홈 디렉터리는 webapp임
//		ServletContext ctx = request.getServletContext();
		String webPath = "/static/upload";
		String realPath = ctx.getRealPath(webPath);
		System.out.printf("realPath : %s\n", realPath);
		
		// 파일 경로 존재 체크
		File savePath = new File(realPath);
		if(!savePath.exists()) {
			// mkdirs : 그 사이에 있는 경로가 하나만 없는게 아니라 중간에 없는 것이 있으면 그것까지 다 만들어준다.
			// 더 확실하게 하기 위해서는 mkdir보다는 mkdirs를 사용하자.
			savePath.mkdirs();
		}
		
		// 윈도우가 아닐경우 \\가 아닌 /가 사용될 수도 있기에 File.separator 사용
		// File.separator : 현재 시스템에 맞는 구분자를 넣어줌
		realPath += File.separator + fileName;
		File saveFile = new File(realPath);
		
		// transferTo : 파일 데이터를 지정한 file로 저장
		file.transferTo(saveFile);
		
//		----------------------------------- 파일 저장 End -----------------------------------
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
