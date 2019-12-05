package com.sky.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.sky.test.vo.UserVO;

@Repository
public class UserDAO {
	
	@Resource
	private SqlSessionFactory ssf;
	
	public List<UserVO> getUserList(UserVO user){
		SqlSession ss = ssf.openSession();
		try {
			return ss.selectList("com.sky.test.dao.UserInfoMapper.selectUserList",user);
		}catch (Exception e) {
			
		}finally {
			ss.close();
		}
		return null;
	}

}
