package com.hb.controller.score;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.score.ScoreDao;
import com.hb.model.score.ScoreDto;
@WebServlet("/edit.do")
public class Edit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ScoreDao dao = new ScoreDao();
		ArrayList<ScoreDto> dto;
		try {
			dto = (ArrayList<ScoreDto>)dao.update(Integer.parseInt(req.getParameter("score")));
			req.setAttribute("bean", dto);
			req.getRequestDispatcher("score.do").forward(req, resp);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
