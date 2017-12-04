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
		
		//기본 flow
		//1.doPost를 호출한 form 으로 부터는 stuid "값"을 이름으로쓰는 status value 목록확보
		//2. 1번목록을 map(학번, score)에 담거
		//3. form 에 사용된 출석부 목록과 같은 arraylist를 새로만들어
		//4. 3번 arraylist의 score 값을 2번 map을 이용해서 채운다

		// 파라미터 이름가져오기 -- 전부 학번 목록이지만 단 한개만 분반이름(hidden input)
		Enumeration<String> paramNames = req.getParameterNames();
		
		// 대상 맵
		Map paramMap = new HashMap<String, String>();
		
		// 맵 저장 -- (학번, 점수)
		while(paramNames.hasMoreElements()) {
			String name	= paramNames.nextElement().toString();
			String value = req.getParameter(name);
			paramMap.put(name, value);
		}
		
		//이전 form에 있던 리스트와 같지만 status가 없는 리스트를 다시 생성
		ScoreDao dao = new ScoreDao();
		String regclass= (String) paramMap.get("sclass");
		int sclass = Integer.parseInt(regclass);
		//sclass는 이전 form에서 이름이 학번이 아닌 유일한 인자
		ArrayList<ScoreDto> newlist = dao.classView2(sclass);
		
		for(int i=0; i<newlist.size(); i++){
			int tempIdx = newlist.get(i).getStuid();
			int score =  (int) paramMap.get(tempIdx+"");
			newlist.get(i).setScore(score);
		}
		System.out.println(newlist.get(9).getScore());
		
		
		//status값이 추가된 arraylist를 dao로 보낸다.
		dao.add(newlist);

		
		resp.sendRedirect("score.jsp");
		
	}
}
