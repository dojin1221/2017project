package com.hb.model.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.model.hrmgr.HrmgrDto;
import com.hb.model.roll.RollDto;
import com.hb.model.score.ScoreDto;
import com.hb.util.MyOracle;

public class ScoreDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<ScoreDto> slist;

	
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


	public ArrayList<ScoreDto> edit(int score, int scoreid) throws SQLException{
		String sql="update score set score=? where scoreid=?";
		conn=MyOracle.getConnection();
	try{
	
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, score);
		pstmt.setInt(2, scoreid);
		pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	return slist;
	}	
	
	public ArrayList<ScoreDto> selectOne(int idx){
		 		System.out.println(idx);
		 		ArrayList<ScoreDto> slist = new ArrayList<ScoreDto>();
		 		conn=MyOracle.getConnection();
		 		try{
		 			String sql="select * from score where scoreid=?";
		 			pstmt=conn.prepareStatement(sql);
		 			pstmt.setInt(1, idx);
		 			rs=pstmt.executeQuery();
		 			
		 			if(rs.next()){
		 				ScoreDto bean = new ScoreDto();
		 				bean.setScoreid(rs.getInt("scoreid"));
		 				bean.setSubject(rs.getString("subject"));
		 				bean.setStuid(rs.getInt("stuid"));
		 				bean.setStuname(rs.getString("stuname"));
		 				bean.setSclass(rs.getInt("sclass"));
		 				bean.setScore(rs.getInt("score"));
		 				slist.add(bean);
		 			}
		 			System.out.println(slist.size());
 			
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
		public ArrayList<ScoreDto> selectAll(){
 		ArrayList<ScoreDto> slist = new ArrayList<ScoreDto>();
 		conn=MyOracle.getConnection();
 		try{
 			String sql="select * from (select * from score order by id desc) where rownum <11";
 			pstmt=conn.prepareStatement(sql);
 			rs=pstmt.executeQuery();
 			
 			while(rs.next()){
 				ScoreDto bean = new ScoreDto();
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
		public ArrayList<ScoreDto> AddView() {
			conn=MyOracle.getConnection();
	 		try{
	 			String sql="select * from (select * from score order by id desc) where rownum <11";
	 			pstmt=conn.prepareStatement(sql);
	 			rs=pstmt.executeQuery();
	 			
	 			while(rs.next()){
	 				ScoreDto bean = new ScoreDto();
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
		
		
		public ArrayList<ScoreDto> insertView() {
			conn=MyOracle.getConnection();
			ArrayList<ScoreDto> list=null;
	 		try{
	 			String sql="select sclass from score group by sclass having count(sclass)>0";
	 			pstmt=conn.prepareStatement(sql);
	 			rs=pstmt.executeQuery();
	 			list = new ArrayList<ScoreDto>();
	 			while(rs.next()){
	 
	 				ScoreDto bean = new ScoreDto();	 				
	 				bean.setSclass(rs.getInt("sclass"));	 				
	 				list.add(bean);		
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
			return list;
		}
		public ArrayList<ScoreDto> classView() {
			conn=MyOracle.getConnection();
			ArrayList<ScoreDto> list=null;
	 		try{
	 			String sql="select sclass from roll group by sclass having count(sclass)>0";
	 			pstmt=conn.prepareStatement(sql);
	 			rs=pstmt.executeQuery();
	 			list = new ArrayList<ScoreDto>();
	 			while(rs.next()){
	 				ScoreDto bean = new ScoreDto();	 				
	 				bean.setSclass(rs.getInt("sclass"));	 				
	 				list.add(bean);		
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
			return list;
		}
		public ArrayList<ScoreDto> classView2(int idx) {
			conn=MyOracle.getConnection();
			ArrayList<ScoreDto> list=null;
	 		try{
//	 			String sql="select distinct stuid,stuname,sclass from roll where sclass=?";
	 			String sql="select * from stu where regclass=?";
	 			pstmt=conn.prepareStatement(sql);
	 			pstmt.setInt(1, idx);
	 			
	 			rs=pstmt.executeQuery();
	 			
	 			list = new ArrayList<ScoreDto>();
	 			while(rs.next()){
	 				ScoreDto bean = new ScoreDto();	 				
	 				
					bean.setStuid(rs.getInt("sid"));
					bean.setStuname(rs.getString("sname"));
					bean.setSclass(rs.getInt("regclass"));
	 				list.add(bean);		
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
			return list;
		}
		public void add(ArrayList<ScoreDto> stulist) {
			System.out.println("add¾È :"+ stulist.size());
			conn=MyOracle.getConnection();
			//ArrayList<RollDto> list=null;
			
			int cnt = stulist.size()-1;
			String sql="insert into roll(subject, stuid,stuname, sclass, score)";
			for(int i=0; i<stulist.size()-1; i++){
				sql +=" select"+ stulist.get(i).getStuid()+","+stulist.get(i).getSclass()+","+stulist.get(i).getScore()+","+"'"+stulist.get(i).getStuname()+"'"+","+"'"+stulist.get(i).getSubject()+"' from DUAL UNION ALL";							
	
			}
				sql+=" select"+ stulist.get(cnt).getStuid()+","+stulist.get(cnt).getSclass()+","+stulist.get(cnt).getScore()+","+"'"+stulist.get(cnt).getStuname()+"'"+","+"'"+stulist.get(cnt).getSubject()+"' from DUAL";			

	 		try{
	 			pstmt=conn.prepareStatement(sql);
	 			pstmt.executeQuery();
	 			
	 			//list = new ArrayList<RollDto>();
	 			
	 		}catch(Exception e){
	 		}finally{
	 			try {
	 				if(pstmt!=null)pstmt.close();
	 				if(conn!=null)conn.close();
	 			} catch (SQLException e) {
	 				e.printStackTrace();
	 			}
	 		}
			//return list;
		}
		
}