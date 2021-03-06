package utility;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtils {
 public static SqlSession openSession() throws IOException {
	String rescourse="mybatis-cfg.xml";
	InputStream in=Resources.getResourceAsStream(rescourse);
	SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(in, "users");
    return sessionFactory.openSession();
 }
}
