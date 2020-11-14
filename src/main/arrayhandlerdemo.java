package main;

import java.awt.*;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.impl.NewPooledConnection;
import com.mysql.cj.Query;

import c3p0.c3p0utils;

public class arrayhandlerdemo {
	@Test
	public void arraylistdemo() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		Object[] res = queryRunner.query("select * from user where id = ?", new ArrayHandler(), 7);
		System.out.println(Arrays.toString(res));
	}

	@Test
	public void arraylistdemo2() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		ArrayList<Object[]> resList = (ArrayList<Object[]>) queryRunner.query("select * from user",
				new ArrayListHandler());
		for (Object[] objects : resList) {
			System.out.println(Arrays.toString(objects));
		}
	}

	/*
	 * beanhandler
	 */
	@Test
	public void demo3() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
         user user1=queryRunner.query("select * from user where id =?",new BeanHandler<user>(user.class) ,3);
         System.out.println(user1);
	}
	
	/*
	 * beanlisthandler
	 */
	@Test
	public void demo4() throws SQLException
	{
		QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
		ArrayList<user> resList=(ArrayList<user>) queryRunner.query("select * from user", new BeanListHandler<user>(user.class));
		for( user user1:resList )
		{
			System.out.println(user1);
		}
	}
	/*
	 * maphandler: 将一条记录封装到一个集合中，key是列名，value
	 * 是表中记录的值
	 */
	@Test
	public void demo5() throws SQLException
	{
		QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
		Map<String, Object> map1=queryRunner.query("select * from user where id = ?", new MapHandler()  ,7);
		System.out.println(map1);
	}
	/*
	 * maplisthandler
	 */
	@Test
	public void demo6() throws SQLException
	{
		QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
		ArrayList<Map<String, Object>> res=(ArrayList<Map<String, Object>>) queryRunner.query("select * from user ", new MapListHandler()  );
		for( Map<String,Object> obj:res )
		{
			System.out.println(obj);
		}
	}
	/*
	 * columnlisthandler:将某列的值封装到list集合中
	 */
	@Test
	public void demo7() throws SQLException {
		QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
		ArrayList<String> res= (ArrayList<String>) queryRunner.query("select username,password from user", new ColumnListHandler("username"));
		for(Object res1:res)
		{
			System.out.println(res1);
		}
	}
	/*
	 * scalarhandler:单值封装
	 */
	@Test
	public void demo8() throws SQLException
	{
		QueryRunner queryRunner=new QueryRunner(c3p0utils.getDataSource());
		Object object=queryRunner.query("select count(*) from user", new ScalarHandler());
		System.out.println(object);
	}
	/*
	 * 
	 */
}
