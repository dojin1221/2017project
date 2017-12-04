package com.hb.controller.roll;

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


@WebServlet("/roll.do")
public class RollViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String root=req.getParameter("root");
		
		if(root.equals("addd")){
			int stuid= Integer.parseInt(req.getParameter("stuid"));
			String stuname = req.getParameter("stuname");
			int sclass= Integer.parseInt(req.getParameter("sclass"));
			String status = req.getParameter("status");
			RollDao dao = new RollDao();
			//ArrayList<RollDto> rlist = dao.add(stuid, stuname,sclass ,status);
			//req.setAttribute("list", rlist);
		}else if(root.equals("edit")){
			RollDao dao = new RollDao();
			ArrayList<RollDto> rlist = dao.rollView();
			req.setAttribute("list", rlist);
			req.getRequestDispatcher("rolledit.jsp").forward(req, resp);
		}else if(root.equals("check")){
			
		}else if(root.equals("addview")){
			RollDao dao = new RollDao();
			ArrayList<RollDto> rlist = dao.classView();
			req.setAttribute("list", rlist);
		}else if(root.equals("addview2")){	
			int idx= Integer.parseInt(req.getParameter("idx"));
			RollDao dao = new RollDao();
			ArrayList<RollDto> rlist = dao.classView2(idx);
			System.out.println(rlist.size());
			req.setAttribute("list", rlist);
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
