package javastudy;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
	@Select("select * from User where id = #{id}")
    public User selectUser(int id);
	@Select(" select * from User ")
    public List<User> selectAll();
	@Insert("insert into user(userName,userPwd) values (#{userName},#{userPwd})")
    public void addUser( User user);
	@Update("update user set userName=#{userName},userPwd=#{userPwd} where id=#{id}")
    public void updateUser(User user);
	@Delete("delete from user where id=#{id}")
    public void deleteUser(int id);
}
