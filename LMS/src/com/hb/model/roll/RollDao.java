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
		public ArrayList<RollDto> classView() {
			conn=MyOracle.getConnection();
			ArrayList<RollDto> list=null;
	 		try{
	 			String sql="select sclass from roll group by sclass having count(sclass)>0";
	 			pstmt=conn.prepareStatement(sql);
	 			rs=pstmt.executeQuery();
	 			list = new ArrayList<RollDto>();
	 			while(rs.next()){
	 
	 				RollDto bean = new RollDto();	 				
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
		public ArrayList<RollDto> classView2(int idx) {
			conn=MyOracle.getConnection();
			ArrayList<RollDto> list=null;
	 		try{
//	 			String sql="select distinct stuid,stuname,sclass from roll where sclass=?";
	 			String sql="select * from stu where regclass=?";
	 			pstmt=conn.prepareStatement(sql);
	 			pstmt.setInt(1, idx);
	 			
	 			rs=pstmt.executeQuery();
	 			
	 			list = new ArrayList<RollDto>();
	 			while(rs.next()){
	 				RollDto bean = new RollDto();	 				
	 				
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
		public void add(ArrayList<RollDto> stulist) {
			System.out.println("add¾È :"+ stulist.size());
			conn=MyOracle.getConnection();
			//ArrayList<RollDto> list=null;
			
			int cnt = stulist.size()-1;
			String sql="insert into roll(calldate, stuid, status,stuname)";
			for(int i=0; i<stulist.size()-1; i++){
				sql +=" select sysdate,"+stulist.get(i).getStuid()+","+"'"+stulist.get(i).getStatus()+"'"+","+"'"+stulist.get(i).getStuname()+"' from DUAL UNION ALL";							
	
			}
				sql+=" select sysdate,"+stulist.get(cnt).getStuid()+","+"'"+stulist.get(cnt).getStatus()+"'"+","+"'"+stulist.get(cnt).getStuname()+"' from DUAL";			

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
