package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import javastudy.User;
import javastudy.UserMapper;
import utility.MybatisUtils;

class MapperTest {

	@Test
	void testSelectAll() throws IOException {
		SqlSession session=MybatisUtils.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
	    List<User> list=mapper.selectAll();
	    System.out.println(list);
	}
	@Test
	void testSelect() throws IOException {
		SqlSession session=MybatisUtils.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
	  User user=mapper.selectUser(1);
	  session.close();
	    System.out.println(user);
	}
	@Test
	void testAdd() throws IOException {
		SqlSession session=MybatisUtils.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
	  User user=new User();
	  user.setUserName("梁朝伟");
	  user.setUserPwd("liangchaowei");
	  mapper.addUser(user);
	  session.commit();
	  session.close();
	    System.out.println(user);
	}
	@Test
	void testUpdate() throws IOException {
		SqlSession session=MybatisUtils.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
	  User user=new User();
	  user.setId(2);
	  user.setUserName("鹿晗");
	  user.setUserPwd("luhan");
	  mapper.updateUser(user);
	  session.commit();
	  session.close();
	  }
	@Test
	void testDelete() throws IOException {
		SqlSession session=MybatisUtils.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
	    mapper.deleteUser(8);
	   session.commit();
	   session.close();
	  }
}
