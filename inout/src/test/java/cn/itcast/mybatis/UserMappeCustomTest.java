package cn.itcast.mybatis;

import cn.itcast.mybatis.mapper.UserMapperCustom;
import cn.itcast.mybatis.po.QueryUserVo;
import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  输入映射 使用pojo包装类型 测试类
 * @Package cn.itcast.mybatis
 * @ClassName: cn.itcast.mybatis.UserMappeCustomTest
 * @date 2017年08月18日 12:19
 */
public class UserMappeCustomTest {

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

    /**
     * 模糊查询用户，使用pojo包装类
     * @throws Exception
     */
    @Test
    public void testFindUserList() throws Exception {
        SqlSession sqlSession  =sqlSessionFactory.openSession();
        //创建代理对象
        UserMapperCustom mapper = sqlSession.getMapper(UserMapperCustom.class);
        QueryUserVo queryUserVo = new QueryUserVo();
        User user = new User();
		user.setSex("1");
        user.setUsername("张");
        //输入参数是多个id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        queryUserVo.setIds(ids);
        queryUserVo.setUser(user);
        List<User> list = mapper.findUserList(queryUserVo);
        System.out.println(list);
        sqlSession.close();
    }


    /**
     * 查询用户总数
     * @throws Exception
     */
    @Test
    public void testFindUserCount() throws Exception {
        SqlSession sqlSession  =sqlSessionFactory.openSession();
        //创建代理对象
        UserMapperCustom mapper = sqlSession.getMapper(UserMapperCustom.class);
        QueryUserVo queryUserVo = new QueryUserVo();
        User user = new User();
        user.setSex("1");
        user.setUsername("张");
        queryUserVo.setUser(user);
        int count= mapper.findUserCount(queryUserVo);
        System.out.println(count);
        sqlSession.close();
    }
}
