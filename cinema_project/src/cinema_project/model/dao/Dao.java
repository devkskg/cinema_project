package cinema_project.model.dao;
import static cinema_project.common.TimeTableTemPlate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cinema_project.model.vo.TimeTable;
import cinema_project.model.vo.ViewTimeTable;

public class Dao {
	
	public List<TimeTable> viewTimeTable(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TimeTable> list = new ArrayList<TimeTable>();
		try {
			String sql = "SELECT * FROM timetable ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			TimeTable tm = new TimeTable();
			tm.setTimeNo(rs.getInt("time_no"));
			tm.setmTitle(rs.getString("m_title"));
			tm.settName(rs.getString("t_name"));
			tm.setTimeStart(rs.getString("time_start"));
			tm.setTimeEnd(rs.getString("time_end"));
			list.add(tm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int deleteTimeTable(int delete , Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "DELETE FROM timetable WHERE time_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, delete);
			result = pstmt.executeUpdate();		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
