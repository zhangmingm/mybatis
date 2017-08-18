package cn.itcast.mybatis.mapper;


import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;

import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  高级映射对应mapper接口
 * @Package cn.itcast.mybatis.mapper
 * @ClassName: cn.itcast.mybatis.mapper.OrdersMapperCustom
 * @date 2017年08月18日 14:11
 */
public interface OrdersMapperCustom {

    /**
     * 一对一查询，查询订单关联查询用户
     * @return
     * @throws Exception
     */
    public List<OrdersCustom> findOrdersAndUserByResultType() throws Exception;

    /**
     * 一对一查询，使用resultMap
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersAndUserByResultMap() throws Exception;

    /**
     * 一对多查询，查询订单及明细
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersAndOrderDetail()throws Exception;

    /**
     * 多对多查询，查询用户及用户购买订单
     * @return
     * @throws Exception
     */
    public List<User> findUserAndItems()throws Exception;

    /**
     * 查询订单延迟加载用户信息
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersLazyLoadingUser()throws Exception;
}
