package com.hb.controller.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class ScoreInput {

	public void InputAll(String subject, ArrayList<ScoreAll> alist){

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		conn=MyOracle.getConnection();
			
			try {
				for(int i=0; i<alist.size(); i++){
					sql="insert into score (subject, stuid, score) values (?, ?, ?)";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, subject);
					pstmt.setInt(2, alist.get(i).stuid);
					pstmt.setInt(3, alist.get(i).score);
					int result = pstmt.executeUpdate();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} //method end	
	}