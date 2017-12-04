package com.hb.controller.score;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.roll.RollDao;
import com.hb.model.roll.RollDto;
import com.hb.model.score.ScoreDao;
import com.hb.model.score.ScoreDto;
@WebServlet(value="/score.do")
public class ScoreViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String root=req.getParameter("root");
		if(root.equals("add")){
			
		}else if(root.equals("edit")){
			
		}else if(root.equals("check")){
			
		}else if(root.equals("addview")){
			ScoreDao dao = new ScoreDao();
			ArrayList<ScoreDto> slist = dao.classView();
			req.setAttribute("list", slist);
		}else if(root.equals("addview2")){	
			int idx= Integer.parseInt(req.getParameter("idx"));
			ScoreDao dao = new ScoreDao();
			ArrayList<ScoreDto> slist = dao.classView2(idx);
			System.out.println(slist.size());
			req.setAttribute("list", slist);
		}else if(root.equals("editview")){
			
		}else if(root.equals("checkview")){
			
		}
		
		req.getRequestDispatcher("roll"+root+".jsp").forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	
	}
}
