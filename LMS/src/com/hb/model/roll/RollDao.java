package com.hb.model.roll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.model.score.ScoreDto;
import com.hb.util.MyOracle;


public class RollDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<RollDto> rlist;
	public ArrayList<RollDto> rollView(){
		String sql="select * from roll";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rlist = new ArrayList<RollDto>();
			while(rs.next()){
				RollDto bean= new RollDto();
				bean.setRollid(rs.getInt("rollid"));
				bean.setCalldate(rs.getDate("calldate"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setSclass(rs.getInt("sclass"));
				bean.setStatus(rs.getString("status"));
				rlist.add(bean);				
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
		return rlist;
	}
	

	public ArrayList<RollDto> edit(String status, int rollid) throws SQLException{
		String sql="update roll set STATUS=? where ROLLID=?";
		conn=MyOracle.getConnection();
	try{
	
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, status);
		pstmt.setInt(2, rollid);
		pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	return rlist;
	}	
	
	public ArrayList<RollDto> selectOne(int idx){
		 		System.out.println(idx);
		 		ArrayList<RollDto> rlist = new ArrayList<RollDto>();
		 		conn=MyOracle.getConnection();
		 		try{
		 			String sql="select * from roll where rollid=?";
		 			pstmt=conn.prepareStatement(sql);
		 			pstmt.setInt(1, idx);
		 			rs=pstmt.executeQuery();
		 			
		 			if(rs.next()){
		 				RollDto bean = new RollDto();
		 				bean.setRollid(rs.getInt("rollid"));
						bean.setCalldate(rs.getDate("calldate"));
						bean.setStuid(rs.getInt("stuid"));
						bean.setStuname(rs.getString("stuname"));
						bean.setSclass(rs.getInt("sclass"));
						bean.setStatus(rs.getString("status"));
						rlist.add(bean);				
		 			}
		 			System.out.println(rlist.size());
		 			if(rs!=null)rs.close();
		 			if(pstmt!=null)pstmt.close();
		 			
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
		 		return rlist;
	 	} 
		public ArrayList<RollDto> selectAll(){
 		ArrayList<RollDto> rlist = new ArrayList<RollDto>();
 		conn=MyOracle.getConnection();
 		try{
 			String sql="select * from (select * from score order by id desc) where rownum <11";
 			pstmt=conn.prepareStatement(sql);
 			rs=pstmt.executeQuery();
 			
 			while(rs.next()){
 				RollDto bean = new RollDto();
 				bean.setRollid(rs.getInt("rollid"));
				bean.setCalldate(rs.getDate("calldate"));
				bean.setStuid(rs.getInt("stuid"));
				bean.setStuname(rs.getString("stuname"));
				bean.setSclass(rs.getInt("sclass"));
				bean.setStatus(rs.getString("status"));
				rlist.add(bean);				

 			}
 			
 			if(rs!=null)rs.close();
 			if(pstmt!=null)pstmt.close();
 			
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
 		return rlist;
 	}
	
}
