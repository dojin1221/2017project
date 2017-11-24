package com.hb.model.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.model.score.ScoreDto;
import com.hb.util.MyOracle;

public class ScoreDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<ScoreDto> slist;
	ArrayList<ScoreDto> slist2;
	ArrayList<ScoreDto> slist3;
	
	public ArrayList<ScoreDto> scoreView(){
		String sql="select * from score";
		conn=MyOracle.getConnection();
		
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			slist = new ArrayList<ScoreDto>();
			while(rs.next()){
				ScoreDto bean= new ScoreDto();
				bean.setScoreid(rs.getInt("scoreid"));
				bean.setSubject(rs.getString("subject"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setSclass(rs.getInt("sclass"));
				bean.setScore(rs.getInt("score"));
				slist.add(bean);				
			}			
		}catch(Exception e){
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return slist;
	}

	public ArrayList<ScoreDto> scoreView2(){
		String sql="select * from score";
		conn=MyOracle.getConnection();
		try{
			 pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			slist = new ArrayList<ScoreDto>();
			while(rs.next()){
				ScoreDto bean= new ScoreDto();
				bean.setScoreid(rs.getInt("scoreid"));
				bean.setSubject(rs.getString("subject"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setSclass(rs.getInt("sclass"));
				bean.setScore(rs.getInt("score"));
				slist.add(bean);				
			}			
		}catch(Exception e){
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return slist2;
	}
	
	public ArrayList<ScoreDto> update(int score) throws SQLException{
		String sql="update score set score=?";
	try{
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, score);
		pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	return slist3;
	}	
}