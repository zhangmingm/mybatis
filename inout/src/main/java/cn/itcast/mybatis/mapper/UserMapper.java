package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.User;

import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:
 * @Package cn.itcast.mybatis.mapper
 * @ClassName: cn.itcast.mybatis.mapper.UserMapper
 * @date 2017年08月18日 13:43
 */
public interface UserMapper {
    //根据用户id查询用户信息
    public User findUserById(int id)throws Exception;

    //查询用户使用resultMap
    public User findUserByIdResultMap(int id)throws Exception;

    //根据用户名称模糊查询
    public List<User> findUserByName(String username)throws Exception;

    //插入用户
    public void insertUser(User user)throws Exception;
}
