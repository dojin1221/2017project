package com.hb.controller.roll;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.roll.RollDao;

@WebServlet(value="/redit.do")
public class EditController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		RollDao dao = new RollDao();
		String status=req.getParameter("status").trim();
		int rollid=Integer.parseInt(req.getParameter("rollid").trim());
		System.out.println(status);
		System.out.println(rollid);
				try {
					dao.edit(status,rollid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		System.out.println("tqtqtqtqtq");
		resp.sendRedirect("rollindex.do");
	}
}