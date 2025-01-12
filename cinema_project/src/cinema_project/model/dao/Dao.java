package cinema_project.model.dao;
import static cinema_project.common.TimeTableTemPlate.close;
import java.sql.Connection;
import java.sql.PreparedStatement;

import cinema_project.model.vo.TimeTable;

public class Dao {
	public int createTimetable(TimeTable tm , Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO timetable(m_title, t_name, time_start, time_end) "
					+"VALUES ('?', '?관', '?', DATE_ADD(STR_TO_DATE(time_start, '%Y-%m-%d %T'), INTERVAL ? minute))";
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
}
