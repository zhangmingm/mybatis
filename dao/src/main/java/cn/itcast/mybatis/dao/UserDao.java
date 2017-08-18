package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  mybatis原始dao开发模式
 * @Package cn.itcast.mybatis
 * @ClassName: cn.itcast.mybatis.UserDao
 * @date 2017年08月18日 11:36
 */
public interface UserDao {

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public User findUserById(int id)throws Exception;

    /**
     * 根据用户名称模糊查询
     * @param name
     * @return
     * @throws Exception
     */
    public List<User> findUserByName(String name)throws Exception;


    /**
     * 添加用户
     * @param user
     * @throws Exception
     */
    public void insertUser(User user) throws Exception;
}

