package cn.itcast.mybatis.first;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description: 该类为mybatis的入门程序，包括mybatis的增删改查操作。
 * @Package cn.itcast.mybatis.induction
 * @ClassName: cn.itcast.mybatis.induction.MybatisFirst
 * @date 2017年08月17日 14:24
 */
public class MybatisFirst {

    /**
     * 根据用户id查询用户信息
     * @throws Exception
     */
    @Test
    public void testFindUserById() throws Exception {
        // mybatis全局配置文件
        String resource = "SqlMapConfig.xml";
        // 根据mybatis的全局配置文件构造 一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 使用sqlSession查询用户
        // 第一个参数：statement的id，前边要加namespace
        // 第二个参数：输入的参数对象值
        // selectOne用于返回单个对象，如果sql查询返回一个列表（多个对象），如果使用selectOne报错
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);
        // 关闭sqlsession
        sqlSession.close();
    }

    /**
     * 根据用户名称模糊查询用户信息
     * @throws Exception
     */
    @Test
    public void testFindUserByName() throws Exception {
        // mybatis全局配置文件
        String resource = "SqlMapConfig.xml";
        // 根据mybatis的全局配置文件构造 一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 根据用户名称模糊查询
        // selectList用于 将sql查询结果映射成java对象 ，返回一个List<Object>
        // 1参数：statement的id（等于namespace+statement的id）
        // 2参数：输入参数值
        List<User> list = sqlSession.selectList("test.findUserByName", "张");
        System.out.println(list);
        // 关闭sqlsession
        sqlSession.close();
    }


    /**
     * 插入用户
     * @throws Exception
     */
    @Test
    public void testInsertUser() throws Exception {
        // mybatis全局配置文件
        String resource = "SqlMapConfig.xml";
        // 根据mybatis的全局配置文件构造 一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 构造 输入参数,就是插入的用户信息
        User user = new User();
        user.setUsername("飞镖黄");
        user.setBirthday(new Date());
        user.setAddress("鸟岛");
        // 调用sqlSession插入用户
        sqlSession.insert("test.insertUser", user);
        System.out.println("新user的主键：" + user.getId());
        // 提交
        sqlSession.commit();
        // 关闭sqlsession
        sqlSession.close();

    }

    /**
     * 更新用户
     * @throws Exception
     */
    @Test
    public void testUpdateUser() throws Exception {
        // mybatis全局配置文件
        String resource = "SqlMapConfig.xml";
        // 根据mybatis的全局配置文件构造 一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 构造 输入参数,就是更新的用户信息
        User user = new User();
        // 更新的用户信息中必须要有id
        user.setId(28);
        user.setUsername("大红");
        user.setBirthday(new Date());
        user.setAddress("鸟岛");
        // 调用sqlSession插入用户
        sqlSession.update("test.updateUser", user);
        // 提交
        sqlSession.commit();
        // 关闭sqlsession
        sqlSession.close();

    }

    /**
     * 删除用户
     * @throws Exception
     */
    @Test
    public void testDeleteUser() throws Exception {
        // mybatis全局配置文件
        String resource = "SqlMapConfig.xml";
        // 根据mybatis的全局配置文件构造 一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser", 28);
        // 提交
        sqlSession.commit();
        // 关闭sqlsession
        sqlSession.close();
    }
}
