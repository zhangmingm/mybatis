package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  mybatis原始dao开发模式 测试类
 * @Package cn.itcast.mybatis
 * @ClassName: cn.itcast.mybatis.UserDaoImplTest
 * @date 2017年08月18日 11:42
 */
public class UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    // @Before注解标识 的方法在测试方法执行之前去执行
    @Before
    public void setUp() throws Exception {
        // 创建sqlSessionFactory
        // mybatis全局配置文件
        String resource = "SqlMapConfig.xml";
        // 根据mybatis的全局配置文件构造 一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        //调用userDao的方法
        User user = userDao.findUserById(1);
        System.out.println(user);

    }
}
