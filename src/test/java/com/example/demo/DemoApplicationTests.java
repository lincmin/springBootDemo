package com.example.demo;

import com.example.demo.model.AyUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Resource
@SpringBootTest
class DemoApplicationTests {
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Test
	void contextLoads() {
	}

	@Test
	public void mySqlTest(){
		String sql = "select id,name,password from ay_user";
		List<AyUser> userList = (List<AyUser>) jdbcTemplate.query(sql, new RowMapper<AyUser>() {
			@Override
			public AyUser mapRow(ResultSet rs, int rowNum) throws
					SQLException{
					AyUser user = new AyUser();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					return user;
			}
		});
		System.out.println("查询成功：");
		for(AyUser user:userList){
			System.out.println("[id]:"+user.getId()+";[name]:"+user.getName());
		}
	}

}
