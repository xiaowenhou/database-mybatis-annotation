package com.putaoteng.mybatis.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import com.putaoteng.mybatis.dao.StudentDao;
import com.putaoteng.mybatis.model.Student;
import com.putaoteng.mybatis.utils.Log;
import com.putaoteng.mybatis.utils.LogLevel;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StudentDaoTest {

	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void initFactory() {
		String resource = "sqlMapConfig.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 增加用户测试
	@Test
	public void testAddStudent() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(com.putaoteng.mybatis.dao.StudentDao.class);

		Student student = new Student();
		long studentId = 0;
		student.setId(1);
		student.setName("zhangsan");
		student.setQqNumber(123456789);
		student.setProfession("java");
		student.setJoinDate("20170101");
		student.setSchool("清华大学");
		student.setOnlineNumber("9527");
		student.setDailyLink("www.baidu.com");
		student.setDesire("牛鼻");
		student.setMsgSource("知乎");
		student.setBrother("大师兄");
		student.setCreateAt(20170715133333L);
		student.setUpdateAt(20170715133356L);
		studentId = studentDao.addStudent(student);
		System.out.println(studentId);

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
		studentId = studentDao.addStudent(student2);
		System.out.println(studentId);

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
		studentId = studentDao.addStudent(student3);
		System.out.println(studentId);

		sqlSession.commit();
		sqlSession.close();

		testQueryStudentAll();
	}

	// 删除用户测试
	@Test
	public void testDeleteStudent() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(com.putaoteng.mybatis.dao.StudentDao.class);

		boolean result = studentDao.deleteStudent(3);

		Assert.assertTrue(result);

		sqlSession.commit();
		sqlSession.close();
		testQueryStudentAll();
	}

	// 更新用户测试
	@Test
	public void testUpdateStudent() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(com.putaoteng.mybatis.dao.StudentDao.class);

		Student student = studentDao.queryStudentById(2);

		student.setName("zzzzzzzz");
		student.setSchool("xxxxxxxx");

		boolean result = studentDao.updateStudent(student);
		Assert.assertTrue(result);

		sqlSession.commit();
		sqlSession.close();
		testQueryStudentAll();
	}

	// 按用户ID查询测试
	@Test
	public void testQueryUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(com.putaoteng.mybatis.dao.StudentDao.class);

		Student student = studentDao.queryStudentById(1);
		System.out.println(student);

		// 测试日志输出情况
		Log.loggerCreate(LogLevel.INFO, "Hello, Java");
		sqlSession.commit();
		sqlSession.close();
	}

	// 按用户姓名查询测试
	@Test
	public void testQueryStudentByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(com.putaoteng.mybatis.dao.StudentDao.class);

		String name = "zhangsan";
		List<Student> list = studentDao.queryStudentByName(name);

		for (Student student : list) {
			System.out.println(student.toString());
		}
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询所有用户测试
	@Test
	public void testQueryStudentAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(com.putaoteng.mybatis.dao.StudentDao.class);

		List<Student> list = studentDao.queryStudentAll();

		for (Student student : list) {
			System.out.println(student.toString());
		}
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testCountTableLength() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(com.putaoteng.mybatis.dao.StudentDao.class);

		String field = "school";
		int result = studentDao.countTableLength(field);

		System.out.println(result);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testClearTable() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(com.putaoteng.mybatis.dao.StudentDao.class);

		studentDao.clearTable();
		sqlSession.commit();
		sqlSession.close();
		testQueryStudentAll();
	}


}
