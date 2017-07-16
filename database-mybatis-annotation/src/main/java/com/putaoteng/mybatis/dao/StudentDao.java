package com.putaoteng.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.putaoteng.mybatis.model.Student;

public interface StudentDao {
	
	/**
	 * 增加数据
	 * @param	student	要增加的Student类对象
	 * @return	成功返回插入的用户ID, 失败返回0
	 * 
	 */
	@Insert("insert into student (id, name, qq_number, profession, join_date, school, online_number, daily_link, desire, msg_source, brother, create_at,update_at) "
			+ "values(#{id}, #{name}, #{qqNumber}, #{profession}, #{joinDate}, #{school}, #{onlineNumber}, #{dailyLink}, #{desire}, #{msgSource}, #{brother}, #{createAt}, #{updateAt})")
	@Results({  
	    @Result(id=true,property="id",column="id"),  
	    @Result(property="name",column="name"),  
	    @Result(property="qqNumber",column="qq_number"),
	    @Result(property="profession",column="profession"), 
	    @Result(property="joinDate",column="join_date"),
	    @Result(property="school",column="school"),
	    @Result(property="onlineNumber",column="online_number"),
	    @Result(property="dailyLink",column="daily_link"),
	    @Result(property="desire",column="desire"),
	    @Result(property="msgSource",column="msg_source"),
	    @Result(property="brother",column="brother"),
	    @Result(property="createAt",column="create_at"),
	    @Result(property="updateAt",column="update_at")
	}) 
	public long addStudent(Student student);
	
	/**
	 * 删除数据
	 * @param	id	要删除的数据的ID
	 * @return	成功返回true, 失败返回false
	 */
	@Delete("delete from student where id=#{id}")
	public boolean deleteStudent(long id);
	
	/**
	 * 更新数据
	 * @param	student	更新后的Student对象
	 * @return	成功返回true, 失败返回false
	 */
	@Update("update student set id=#{id}, name=#{name}, qq_number=#{qqNumber}, profession=#{profession}, join_date=#{joinDate}, school=#{school}, online_number=#{onlineNumber},"
			+ " daily_link=#{dailyLink}, desire=#{desire}, msg_source=#{msgSource}, brother=#{brother}, create_at=#{createAt}, update_at=#{updateAt} where id=#{id}")
	@Results({  
	    @Result(id=true,property="id",column="id"),  
	    @Result(property="name",column="name"),  
	    @Result(property="qqNumber",column="qq_number"),
	    @Result(property="profession",column="profession"), 
	    @Result(property="joinDate",column="join_date"),
	    @Result(property="school",column="school"),
	    @Result(property="onlineNumber",column="online_number"),
	    @Result(property="dailyLink",column="daily_link"),
	    @Result(property="desire",column="desire"),
	    @Result(property="msgSource",column="msg_source"),
	    @Result(property="brother",column="brother"),
	    @Result(property="createAt",column="create_at"),
	    @Result(property="updateAt",column="update_at")
	}) 
	public boolean updateStudent(Student student);
	
	/**
	 * 计算表中的数据总数
	 * @param	field	表中的字段名
	 * @return	返回该表的长度
	 */
	@Select("select count(#{field}) from student")
	public int countTableLength(String field);
	
	/**
	 *	根据用户id查询单个用户的数据
	 *	@param	id	要查询的用户的ID
	 *	@return	返回查询到的用户对象,没有查询到返回一个空对象 
	 */
	@Select("select * from student where id=#{id}")
	@Results({  
	    @Result(id=true,property="id",column="id"),  
	    @Result(property="name",column="name"),  
	    @Result(property="qqNumber",column="qq_number"),
	    @Result(property="profession",column="profession"), 
	    @Result(property="joinDate",column="join_date"),
	    @Result(property="school",column="school"),
	    @Result(property="onlineNumber",column="online_number"),
	    @Result(property="dailyLink",column="daily_link"),
	    @Result(property="desire",column="desire"),
	    @Result(property="msgSource",column="msg_source"),
	    @Result(property="brother",column="brother"),
	    @Result(property="createAt",column="create_at"),
	    @Result(property="updateAt",column="update_at")
	}) 
	public Student queryStudentById(long id);
	
	/**
	 * 查询表中的所有数据 
	 * @param	无参数
	 * @return	返回一个Student类型的列表,该列表中存储所有表中数据,空表则返回空list
	 */
	@Select("select * from student")
	@Results({  
	    @Result(id=true,property="id",column="id"),  
	    @Result(property="name",column="name"),  
	    @Result(property="qqNumber",column="qq_number"),
	    @Result(property="profession",column="profession"), 
	    @Result(property="joinDate",column="join_date"),
	    @Result(property="school",column="school"),
	    @Result(property="onlineNumber",column="online_number"),
	    @Result(property="dailyLink",column="daily_link"),
	    @Result(property="desire",column="desire"),
	    @Result(property="msgSource",column="msg_source"),
	    @Result(property="brother",column="brother"),
	    @Result(property="createAt",column="create_at"),
	    @Result(property="updateAt",column="update_at")
	}) 
	public List<Student> queryStudentAll();
	
	/**
	 * 根据姓名查询数据
	 * @param	要查询的用户的姓名
	 * @return	返回一个Student类型的列表,该列表中存储所有符合查询条件的数据 ,没有则返回空
	 */
	@Select("select * from student where name=#{name}")
	@Results({  
	    @Result(id=true,property="id",column="id"),  
	    @Result(property="name",column="name"),  
	    @Result(property="qqNumber",column="qq_number"),
	    @Result(property="profession",column="profession"), 
	    @Result(property="joinDate",column="join_date"),
	    @Result(property="school",column="school"),
	    @Result(property="onlineNumber",column="online_number"),
	    @Result(property="dailyLink",column="daily_link"),
	    @Result(property="desire",column="desire"),
	    @Result(property="msgSource",column="msg_source"),
	    @Result(property="brother",column="brother"),
	    @Result(property="createAt",column="create_at"),
	    @Result(property="updateAt",column="update_at")
	}) 
	public List<Student> queryStudentByName(String name);
	
	/**
	 * 清空整个表
	 * @param	无参数
	 * @return	无返回值
	 */
	@Select("truncate table student")
	public void clearTable();
}
