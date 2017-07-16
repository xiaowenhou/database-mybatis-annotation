package com.putaoteng.mybatis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.putaoteng.mybatis.dao.StudentDao;
import com.putaoteng.mybatis.model.Student;
import com.putaoteng.mybatis.utils.Log;
import com.putaoteng.mybatis.utils.LogLevel;

public class DatabaseCurdApp {

	public static void main(String[] args) {
		//创建数据库链接,创建SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = null;
		String resource = "sqlMapConfig.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		for (int i = 0; i < 1000; i++) {
			//获取SqlSession并建立映射
			SqlSession sqlSession = sqlSessionFactory.openSession();
			StudentDao studentDao = sqlSession.getMapper(com.putaoteng.mybatis.dao.StudentDao.class);
			
			//System.out.println("----------------------" + "执行第" + (i+1) + "次------------------------");
			List<Student> list = new ArrayList<Student>();

			Student student = new Student();
			student.setId(1);
			student.setName("zhangsan");
			student.setQqNumber(123456789);
			student.setProfession("java");
			student.setJoinDate("2017年1月1日");
			student.setSchool("清华大学");
			student.setOnlineNumber("9527");
			student.setDailyLink("www.baidu.com");
			student.setDesire("牛鼻");
			student.setMsgSource("知乎");
			student.setBrother("大师兄");
			student.setCreateAt(20170715133333L);
			student.setUpdateAt(20170715133356L);
			
			Student student2 = new Student();
			student2.setId(2);
			student2.setName("lisi");
			student2.setQqNumber(123456789);
			student2.setProfession("qianduan");
			student2.setJoinDate("2017年1月1日");
			student2.setSchool("上海交通大学");
			student2.setOnlineNumber("9527");
			student2.setDailyLink("www.baidu.com");
			student2.setDesire("牛鼻");
			student2.setMsgSource("知乎");
			student2.setBrother("二师兄兄");
			student2.setCreateAt(20170715133333L);
			student2.setUpdateAt(20170715133356L);
			
			Student student3 = new Student();
			student3.setId(3);
			student3.setName("王五");
			student3.setQqNumber(123456789);
			student3.setProfession("qianduan");
			student3.setJoinDate("2017年8月1日");
			student3.setSchool("北京大学");
			student3.setOnlineNumber("9527");
			student3.setDailyLink("www.baidu.com");
			student3.setDesire("牛鼻");
			student3.setMsgSource("知乎");
			student3.setBrother("小师弟");
			student3.setCreateAt(20170715133333L);
			student3.setUpdateAt(20170715133356L);

			// 插入数据操作
			studentDao.addStudent(student);
			Log.loggerCreate(LogLevel.INFO, "插入一条数据");
			studentDao.addStudent(student2);
			Log.loggerCreate(LogLevel.INFO, "插入一条数据");
			studentDao.addStudent(student3);
			Log.loggerCreate(LogLevel.INFO, "插入一条数据");

			// 显示数据库中所有数据
			System.out.println("---------------------插入三条数据");
			list = studentDao.queryStudentAll();
			for (Student student5 : list) {
				System.out.println(student5.toString());
			}

			// 删除数据操作
			System.out.println("---------------------删除一条数据");
			studentDao.deleteStudent(3);
			Log.loggerCreate(LogLevel.INFO, "删除一条数据");
			list = studentDao.queryStudentAll();
			for (Student student5 : list) {
				System.out.println(student5.toString());
			}

			// 通过id查询一条数据
			System.out.println("---------------------根据ID查询一条数据");
			Student student5 = studentDao.queryStudentById(2);
			Log.loggerCreate(LogLevel.INFO, "查询一条数据");
			System.out.println(student5.toString());

			// 更新一条数据
			System.out.println("---------------------更新一条数据");
			student5.setName("小强");
			student5.setName("0000000000");
			studentDao.updateStudent(student5);
			Log.loggerCreate(LogLevel.INFO, "更新一条数据");
			list = studentDao.queryStudentAll();
			for (Student student6 : list) {
				System.out.println(student6.toString());
			}

			// 通过姓名查询数据集
			System.out.println("---------------------根据姓名查询数据集");
			list = studentDao.queryStudentByName("zhangsan");
			for (Student student6 : list) {
				System.out.println(student6);
			}

			// 查看表的总长度
			System.out.println("---------------------计算表长度");
			int count = studentDao.countTableLength("*");
			System.out.println("表总长为: " + count);

			// 清空表中所有数据
			System.out.println("----------------------清空表");
			//studentDao.clearTable();
			list = studentDao.queryStudentAll();
			for (Student student6 : list) {
				System.out.println(student6.toString());
			}
			
			sqlSession.commit();
			sqlSession.close();
//		}

	}

}
