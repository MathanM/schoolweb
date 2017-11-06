package Login;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBManager extends DriverManagerDataSource {
     public DriverManagerDataSource getDataBaseSource(){
       DriverManagerDataSource dataSource= new DriverManagerDataSource();
       dataSource.setUsername("sql12203400");
       dataSource.setPassword("maddy302390");
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12203400");
       return dataSource;
   }
}
