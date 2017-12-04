package com.hb.controller.score;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.roll.RollDao;
import com.hb.model.roll.RollDto;
import com.hb.model.score.ScoreDao;
import com.hb.model.score.ScoreDto;
@WebServlet(value="/sadd.do")
public class ScoreAddController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//�⺻ flow
		//1.doPost�� ȣ���� form ���� ���ʹ� stuid "��"�� �̸����ξ��� status value ���Ȯ��
		//2. 1������� map(�й�, score)�� ���
		//3. form �� ���� �⼮�� ��ϰ� ���� arraylist�� ���θ����
		//4. 3�� arraylist�� score ���� 2�� map�� �̿��ؼ� ä���

		// �Ķ���� �̸��������� -- ���� �й� ��������� �� �Ѱ��� �й��̸�(hidden input)
		Enumeration<String> paramNames = req.getParameterNames();
		
		// ��� ��
		Map paramMap = new HashMap<String, String>();
		
		// �� ���� -- (�й�, ����)
		while(paramNames.hasMoreElements()) {
			String name	= paramNames.nextElement().toString();
			String value = req.getParameter(name);
			paramMap.put(name, value);
		}
		
		//���� form�� �ִ� ����Ʈ�� ������ status�� ���� ����Ʈ�� �ٽ� ����
		ScoreDao dao = new ScoreDao();
		String regclass= (String) paramMap.get("sclass");
		int sclass = Integer.parseInt(regclass);
		//sclass�� ���� form���� �̸��� �й��� �ƴ� ������ ����
		ArrayList<ScoreDto> newlist = dao.classView2(sclass);
		
		for(int i=0; i<newlist.size(); i++){
			int tempIdx = newlist.get(i).getStuid();
			int score =  (int) paramMap.get(tempIdx+"");
			newlist.get(i).setScore(score);
		}
		System.out.println(newlist.get(9).getScore());
		
		
		//status���� �߰��� arraylist�� dao�� ������.
		dao.add(newlist);

		
		resp.sendRedirect("score.jsp");
		
	}
}
