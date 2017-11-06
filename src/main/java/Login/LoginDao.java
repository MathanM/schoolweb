package Login;

import Data.CourseData;
import Data.UserData;
import org.ahocorasick.trie.Token;
import org.ahocorasick.trie.Trie;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import Data.ChapData;


public class LoginDao {
    public UserData userLoginDao(LoginBean user){
        String sql ="SELECT * FROM USER_LOGIN_DETAILS WHERE USER_NAME = ? AND USER_PASSWORD = ?";
        Connection conn = null;
        DriverManagerDataSource dataSource;
        DBManager dbManager =new DBManager();
        UserData data = new UserData();

        //CONNECTION WITH MYSQL
        dataSource = dbManager.getDataBaseSource();
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassWord());
            ResultSet rs = ps.executeQuery();
            while(rs.next() ) {
                data.setUsername(rs.getString("user_name"));
                data.setEmail(rs.getString("user_email"));
                data.setMobile(rs.getString("user_mobile"));
                data.setAddress(rs.getString("user_address"));
                data.setPermission(rs.getString("user_permission"));
                data.setStd(rs.getInt("user_std"));
                data.setName(rs.getString("name"));
                data.setSessionEstablished(true);
            }
            ps.close();
            data.setCourses(getCourseDao(data.getStd()));
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
        return data;
    }
    public boolean forgotPasswordDao(LoginBean user){
        String sql ="UPDATE USER_LOGIN_DETAILS SET USER_PASSWORD = 'password123' WHERE USER_NAME = ? AND USER_EMAIL = ?";
        Connection conn = null;
        DriverManagerDataSource dataSource;
        DBManager dbManager =new DBManager();
        boolean data = false;
        //CONNECTION WITH MYSQL
        dataSource = dbManager.getDataBaseSource();
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            int flag = ps.executeUpdate();
            ps.close();
            if(flag == 1){
                data = true;
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
        return data;
    }

    public boolean updateUserDetailsDao(LoginBean user){
        String sql ="UPDATE USER_LOGIN_DETAILS SET USER_EMAIL = ?,USER_MOBILE = ?, USER_ADDRESS = ? WHERE USER_NAME = ?";
        Connection conn = null;
        DriverManagerDataSource dataSource;
        DBManager dbManager =new DBManager();
        boolean data = false;
        //CONNECTION WITH MYSQL
        dataSource = dbManager.getDataBaseSource();
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getMobile());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getUserName());
            int flag = ps.executeUpdate();
            ps.close();
            if(flag == 1){
                data = true;
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
        return data;
    }

    public ArrayList<ChapData> getChaptersDao(int courseId){
        String sql ="SELECT * FROM CHAPTERS_DETAILS WHERE COURSE_ID = ?";
        Connection conn = null;
        DriverManagerDataSource dataSource;
        DBManager dbManager =new DBManager();
        //CONNECTION WITH MYSQL
        dataSource = dbManager.getDataBaseSource();
        ArrayList<ChapData> results = new ArrayList<ChapData>();
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs  = ps.executeQuery();
            while(rs.next()) {
                ChapData data = new ChapData();
                data.setChapName(rs.getString("chapter_name"));
                data.setChapId(rs.getInt("chapter_id"));
                data.setWpId(rs.getInt("wp_id"));
                results.add(data);
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
        return results;
    }

    public ArrayList<CourseData> getCourseDao(int userStd){
        String sql ="SELECT * FROM COURSE_DETAILS WHERE USER_STD = ?";
        Connection conn = null;
        DriverManagerDataSource dataSource;
        DBManager dbManager =new DBManager();
        //CONNECTION WITH MYSQL
        dataSource = dbManager.getDataBaseSource();
        ArrayList<CourseData> results = new ArrayList<CourseData>();
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userStd);
            ResultSet rs  = ps.executeQuery();
            while(rs.next()) {
                CourseData data = new CourseData();
                data.setCourName(rs.getString("course_name"));
                data.setCourId(rs.getInt("course_id"));
                results.add(data);
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
        return results;
    }

    public String ansMatching(String ans){
        String output="";
        Trie trie = Trie.builder().ignoreOverlaps().onlyWholeWords().ignoreCase()
                .addKeyword("Johann Dobreiner")
                .addKeyword("1800’s")
                .addKeyword("physical and chemical properties")
                .build();
        Collection<Token> tokens = trie.tokenize(ans);
        for (Token token : tokens) {
            if (token.isMatch()) {
                output = output.concat(token.getFragment()) + " ";
            }
        }
        return output;
    }
}
