package cn.itcast.mybatis.mapper;

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
 * @Description:  mybatis mapper dao开发模式 测试类
 * @Package cn.itcast.mybatis.mapper
 * @ClassName: cn.itcast.mybatis.mapper.UserMapperTest
 * @date 2017年08月18日 11:52
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
        user.setUsername("赵六北京");
        user.setBirthday(new Date());
        user.setAddress("北京");
        //调用mapper
        mapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
