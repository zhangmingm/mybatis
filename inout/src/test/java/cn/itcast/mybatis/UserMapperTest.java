package cn.itcast.mybatis;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:
 * @Package cn.itcast.mybatis
 * @ClassName: cn.itcast.mybatis.UserMapperTest
 * @date 2017年08月18日 13:45
 */
public class UserMapperTest {
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
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //生成代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper
        User user = mapper.findUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    //查询用户使用resultMap
    @Test
    public void testFindUserByIdResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //生成代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper
        User user= mapper.findUserByIdResultMap(1);
        System.out.println(user);
        sqlSession.close();
    }


    @Test
    public void testFindUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //生成代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper
        List<User> list = mapper.findUserByName("张");
        System.out.println(list);
        sqlSession.close();
    }
    @Test
    public void testInsertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //生成代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //构造 输入参数,就是插入的用户信息
        User user = new User();
        user.setUsername("张子健");
        user.setBirthday(new Date());
        user.setAddress("北京");
        //调用mapper
        mapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
