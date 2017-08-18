package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.User;

import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  mybatis mapper dao开发模式
 * @Package cn.itcast.mybatis.mapper
 * @ClassName: cn.itcast.mybatis.mapper.UserMapper
 * @date 2017年08月18日 11:48
 */
public interface UserMapper {


    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public User findUserById(int id)throws Exception;


    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     * @throws Exception
     */
    public List<User> findUserByName(String username)throws Exception;


    /**
     * 插入用户
     * @param user
     * @throws Exception
     */
    public void insertUser(User user)throws Exception;

}
