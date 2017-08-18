package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  mybatis原始dao开发模式
 * @Package cn.itcast.mybatis.dao
 * @ClassName: cn.itcast.mybatis.dao.UserDaoImpl
 * @date 2017年08月18日 11:38
 */
public class UserDaoImpl implements UserDao {
    // 接口实现类中注入SqlSessionFactory
    private SqlSessionFactory sqlSessionFactory;

    // 通过构造 方法注入
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public User findUserById(int id) throws Exception {
        // Sqlsession定义为局部变量
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        // 关闭会话
        sqlSession.close();
        return user;
    }

    /**
     * 根据用户名称模糊查询
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public List<User> findUserByName(String name) throws Exception {
        // Sqlsession定义为局部变量
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("test.findUserByName", "张");
        // 关闭会话
        sqlSession.close();
        return list;
    }

    /**
     * 添加用户
     * @param user
     * @throws Exception
     */
    @Override
    public void insertUser(User user) throws Exception {
        // Sqlsession定义为局部变量
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
