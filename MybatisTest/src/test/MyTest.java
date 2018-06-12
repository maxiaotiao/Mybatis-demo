package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;



import javastudy.User;
import utility.MybatisUtils;

class MyTest {

	@Test
	void testSelect() throws IOException {
		SqlSession session=MybatisUtils.openSession();
		String statement="javastudy.UserMapper.selectUser";
		 User user=session.selectOne(statement,1);
		 System.out.println(user);
		 session.close();
	}
	@Test
	void testSelectAll() throws IOException {
		SqlSession session=MybatisUtils.openSession();
		String statement="javastudy.UserMapper.selectAll";
		 List<User> list=session.selectList(statement);
		 System.out.println(list);
		 session.close();
	}
	@Test
	void testInsert() throws IOException {
		SqlSession session=MybatisUtils.openSession();
		String statement="javastudy.UserMapper.addUser";
		User user= new User();
		user.setUserName("qwe");
		user.setUserPwd("12345678");
		session.insert(statement,user);
		session.commit();
		 session.close();
	}
	@Test
	void testUpdate() throws IOException {
		SqlSession session=MybatisUtils.openSession();
		String statement="javastudy.UserMapper.updateUser";
		User user= new User();
		user.setId(4);
		user.setUserName("周润发");
		user.setUserPwd("1597524");
		session.update(statement,user);
		session.commit();
		 session.close();
	}
	@Test
	void testDelete() throws IOException {
		SqlSession session=MybatisUtils.openSession();
		String statement="javastudy.UserMapper.deleteUser";
		session.delete(statement,1);
		session.commit();
		 session.close();
	}

}
