package com.TidyGames.common;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) {

		String originName = originFile.getName();
		
		// 1. 파일업로드시간(년월일시분초 형태) (String currentTime)
		String currentTile = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		// 2. 5자리랜덤값 (int ranNum)
		int ranNum = (int)(Math.random() * 90000 + 10000);
		
		// 3. 원본파일 확장자(String ext)
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTile + ranNum + ext;
		
		return new File(originFile.getParent(), changeName);
		// File객체를 생성과 동시에 리턴
	}

	
	
	
}
