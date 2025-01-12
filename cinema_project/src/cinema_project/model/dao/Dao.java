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
	public int createTimetable(TimeTable tm , Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO timetable(m_title, t_name, time_start, time_end) "
					+"VALUES ('?', '?', '?', DATE_ADD(STR_TO_DATE(?, '%Y-%m-%d %T'), INTERVAL ? minute))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tm.getmTitle());
			pstmt.setString(2, tm.gettName());
			pstmt.setString(3, tm.getTimeStart());
			pstmt.setString(4, tm.getTimeStart());
			pstmt.setString(5, tm.getTimeEnd());
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		}
	
	public List<ViewTimeTable> editTimeTable(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ViewTimeTable> list = new ArrayList<ViewTimeTable>();
		try {
			String sql = "SELECT m.m_no ,m.m_title , m.m_runtime ,t.t_name "                   
					+"FROM movie m "
					+"JOIN theater t "
					+"ON m.m_no = t.t_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			ViewTimeTable tm = new ViewTimeTable();
			tm.setmNo(rs.getInt("m_no"));
			tm.setmTitle(rs.getString("m_title"));
			tm.setmRuntime(rs.getInt("m_runtime"));
			tm.settName(rs.getString("t_name"));
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
}
