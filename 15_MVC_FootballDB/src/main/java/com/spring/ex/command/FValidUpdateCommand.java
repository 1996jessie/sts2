package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FValidUpdateCommand implements FCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		FDto fdto = (FDto)map.get("fdto");
		FDao fdao = FDao.getInstance();
		fdao.update(fdto);

	}
	
}


