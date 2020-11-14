package c3p0;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.SQLException;

import javax.activation.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.NewPooledConnection;

public class c3p0utils {
       private static final ComboPooledDataSource comboPooledDataSource=new  ComboPooledDataSource();
       
       /*
        * 获得连接
        */
       public static Connection getConnection() throws SQLException
       {
    	   
    	   return comboPooledDataSource.getConnection();
       }
       /*
        * 获得连接池
        */
       public static ComboPooledDataSource getDataSource()
       {
    	   return comboPooledDataSource;
       }
       
       /*
        * 
        */
}
