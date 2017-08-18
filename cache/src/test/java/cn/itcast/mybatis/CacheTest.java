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
import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  测试一级缓存与二级缓存
 * @Package cn.itcast.mybatis
 * @ClassName: cn.itcast.mybatis.CacheTest
 * @date 2017年08月18日 15:40
 */
public class CacheTest {
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

    // 一级缓存测试
    @Test
    public void testCache1() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 生成代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 第一次查询，查询id为1的用户
        // 调用mapper
        User user = mapper.findUserById(1);
        System.out.println(user);

        // 中间执行commit，清空缓存
        user.setUsername("张明");
        mapper.updateUser(user);
        sqlSession.commit();

        // 第二次查询，查询id为1的用户，两次查询使用相同 的sqlsession
        user = mapper.findUserById(1);
        System.out.println(user);

        sqlSession.close();

    }

    //

    /**
     *  二级缓存测试 分为2种，
     *  第一种使用mybatis自己的耳机缓存，只需要在需要开启耳机缓存的mapper文件添加cache标签，
     *  第二种使用第三方如ehcache，需要在cache中配置相应的类(org.mybatis.caches.ehcache.EhcacheCache)
     * @throws Exception
     */
    @Test
    public void testCache2() throws Exception {
        //二级缓存是跨sqlsession的是基于mapper级别的缓存，sqlsession可以使用多个对象，多个对象必须要访问同一个mapper下的sql语句

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        SqlSession sqlSession4 = sqlSessionFactory.openSession();


        // 生成代理对象
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
        UserMapper mapper4 = sqlSession4.getMapper(UserMapper.class);
        // 第一次查询，查询id为1的用户
        // 调用mapper
        User user = mapper1.findUserById(1);
        System.out.println(user);

        //第一次查询用户列表
        List<User> list = mapper4.findUserByName("张");
        System.out.println(list);

        //关闭sqlsession1，此时将数据写入二级缓存
        sqlSession1.close();
        sqlSession4.close();

        // 中间执行commit，清空缓存，将userMapper下手所有缓存数据全部
//		user.setUsername("张明明");
//		mapper3.updateUser(user);
//		sqlSession3.commit();
//		sqlSession3.close();

        // 第二次查询，查询id为1的用户，两次查询使用相同 的sqlsession
        user = mapper2.findUserById(1);
        System.out.println(user);

        List<User> list2 = mapper2.findUserByName("张");
        System.out.println(list2);

        sqlSession2.close();

        sqlSession3.close();

    }
}
