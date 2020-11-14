package main;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import c3p0.c3p0utils;

public class dbutilsdemo {
	
       
       @Test
       public void demo1() throws SQLException
       {
    	   QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
    	   queryRunner.update("insert into user values ( null,?,?,? )","hahaj","1234","huanjun");     
           
       }
       @Test
       public void demo2() throws SQLException
       {
    	   QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
    	   queryRunner.update("update user set name=? , password=? where username=?","dsg","dsg","huanjun");
       }
       @Test
       public void demo3() throws SQLException
       {
    	   QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
    	   queryRunner.update("delete  from user where name=?","Û¨¿¥");
       }
}
