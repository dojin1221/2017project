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

@WebServlet(value="/rolldetail.do")
public class RollDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idx= Integer.parseInt(req.getParameter("idx"));
		
		RollDao dao = new RollDao();
		ArrayList<RollDto> rlist = dao.selectOne(idx);
		req.setAttribute("list", rlist);
		req.getRequestDispatcher("rolldetail.jsp").forward(req, resp);
	
	}
}
