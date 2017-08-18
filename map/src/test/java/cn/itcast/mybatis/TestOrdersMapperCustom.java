package cn.itcast.mybatis;

import cn.itcast.mybatis.mapper.OrdersMapperCustom;
import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
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
 * @Description:
 * @Package cn.itcast.mybatis
 * @ClassName: cn.itcast.mybatis.TestOrdersMapperCustom
 * @date 2017年08月18日 15:13
 */
public class TestOrdersMapperCustom {
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
    public void testFindOrdersAndUserByResultType() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
        List<OrdersCustom> list = mapper.findOrdersAndUserByResultType();
        System.out.println(list);

    }

    //一对一查询使用resultMap
    @Test
    public void testFindOrdersAndUserByResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
        List<Orders> list = mapper.findOrdersAndUserByResultMap();
        System.out.println(list);

    }
    //一对多查询订单和订单明细
    @Test
    public void testFindOrdersAndOrderDetail() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
        List<Orders> list = mapper.findOrdersAndOrderDetail();
        System.out.println(list);

    }
    //多对多查询
    @Test
    public void testFindUserAndItems() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
        List<User> list = mapper.findUserAndItems();
        System.out.println(list);
    }

    /**
     * 查询订单延迟加载用户
     * 如果没有cglib.jar，开启延迟加载会报错
     * @throws Exception
     */
    @Test
    public void testFindOrdersLazyLoadingUser()throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
        //此时只查询一个订单表
        List<Orders> orderList = mapper.findOrdersLazyLoadingUser();
        //取出一个订单信息
        Orders orders = orderList.get(0);
        //实现延迟加载
        //当从list中orders调用getUser的方法时执行延迟加载
        User user = orders.getUser();
        System.out.println(user);
    }
}
