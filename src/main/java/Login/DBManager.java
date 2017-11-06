package Login;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBManager extends DriverManagerDataSource {
     public DriverManagerDataSource getDataBaseSource(){
       DriverManagerDataSource dataSource= new DriverManagerDataSource();
       dataSource.setUsername("wwwaspii_schools");
       dataSource.setPassword("maddy302390");
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://145.239.227.138:3306/wwwaspii_neetschools");
       return dataSource;
   }
}
