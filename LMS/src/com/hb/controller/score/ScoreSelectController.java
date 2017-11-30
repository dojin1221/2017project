package com.hb.controller.score;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.score.ScoreDao;
import com.hb.model.score.ScoreDto;

@WebServlet(value="/scoreselect.do")
public class ScoreSelectController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	ScoreDao dao = new ScoreDao();
	ArrayList<ScoreDto> slist = dao.classView();
	req.setAttribute("list", slist);
	req.getRequestDispatcher("scoreselect.jsp").forward(req, resp);
}
}
