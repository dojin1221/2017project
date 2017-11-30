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

@WebServlet(value="/rolledit.do")
public class RollEditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RollDao dao = new RollDao();
		ArrayList<RollDto> rlist = dao.rollView();
		req.setAttribute("list", rlist);
		req.getRequestDispatcher("rolledit.jsp").forward(req, resp);
		
	}
}
