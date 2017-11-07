package Login;

import Data.AssessData;
import Data.QueData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EvaluateDao {
    public ArrayList<QueData> evaluateAnswersDao(List<QueData> ans){
        Connection conn = null;
        DriverManagerDataSource dataSource;
        DBManager dbManager =new DBManager();
        //CONNECTION WITH MYSQL
        ArrayList<QueData> results = new ArrayList<QueData>();
        dataSource = dbManager.getDataBaseSource();
        try {
            conn = dataSource.getConnection();
            for (QueData a: ans) {
                String sql = "SELECT * FROM QUESTIONS WHERE QUES_ID = ? AND ANSWER = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, a.getQueId());
                ps.setString(2, Integer.toString(a.getAns()[0]));
                ResultSet rs = ps.executeQuery();
                QueData result = new QueData();
                result.setQueId(a.getQueId());
                if(!rs.wasNull()){
                    while(rs.next() ) {
                        result.setCorrect(true);
                    }
                }else{
                    result.setCorrect(false);
                }
                results.add(result);
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return results;
    }
    public List<QueData> getQuestionsDao(EvaluateBean bean){
        String sql ="SELECT * FROM QUESTIONS WHERE COURSE_ID = ? AND CHAPTER_ID = ?";
        Connection conn = null;
        DriverManagerDataSource dataSource;
        DBManager dbManager =new DBManager();
        List<QueData> quesArray = new ArrayList<QueData>();

        //CONNECTION WITH MYSQL
        dataSource = dbManager.getDataBaseSource();
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bean.getCourseId());
            ps.setString(2, bean.getChapterId());
            ResultSet rs = ps.executeQuery();
            while(rs.next() ) {
                QueData data = new QueData();
                data.setQueId(rs.getInt("ques_id"));
                data.setQueType(rs.getString("ques_type"));
                data.setQueContent(rs.getString("ques_content"));
                data.setOptions((rs.getString("options")));
                quesArray.add(data);
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return quesArray;
    }

    public List<AssessData> getAssessmentDao(int userData){
        String sql ="SELECT * FROM ASSESSMENT_DETAILS WHERE COURSE_ID IN (SELECT COURSE_ID FROM COURSE_DETAILS WHERE USER_STD = ?)";
        Connection conn = null;
        DriverManagerDataSource dataSource;
        DBManager dbManager =new DBManager();
        List<AssessData> assessArray = new ArrayList<AssessData>();

        //CONNECTION WITH MYSQL
        dataSource = dbManager.getDataBaseSource();
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userData);
            ResultSet rs = ps.executeQuery();
            while(rs.next() ) {
                AssessData data = new AssessData();
                data.setAssId(rs.getInt("ASSESSMENT_ID"));
                data.setAssName(rs.getString("ASSESSMENT_NAME"));
                data.setAssType(rs.getString("ASSESSMENT_TYPE"));
                data.setAssStatus((rs.getString("ASSESSMENT_STATUS")));
                data.setCreatedBy((rs.getString("CREATED_BY")));
                data.setAssDuration((rs.getInt("ASSESSMENT_DURATION")));
                data.setMarks(rs.getInt("TOTAL_MARKS"));
                data.setChapId(rs.getInt("CHAPTER_ID"));
                data.setCourId(rs.getInt("COURSE_ID"));
                assessArray.add(data);
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return assessArray;
    }
}
