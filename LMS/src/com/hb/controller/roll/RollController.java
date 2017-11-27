package com.hb.controller.roll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.index.IndexDao;
import com.hb.model.index.IndexDto;
import com.hb.model.roll.RollDao;
import com.hb.model.roll.RollDto;
@WebServlet(value="/rollmgr.do")
public class RollController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RollDao dao= new RollDao();
		ArrayList<RollDto> rlist= dao.rollView();
		
		req.setAttribute("rlist", rlist);
		req.getRequestDispatcher("roll.jsp").forward(req, resp);	
	}
}
