package Login;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBManager extends DriverManagerDataSource {
     public DriverManagerDataSource getDataBaseSource(){
       DriverManagerDataSource dataSource= new DriverManagerDataSource();
       dataSource.setUsername("root");
       dataSource.setPassword("");
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://localhost:3306/dbmsschools");
       return dataSource;
   }
}
