package cn.itcast.mybatis.po;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  订单信息的扩展对象
 * @Package cn.itcast.mybatis.po
 * @ClassName: cn.itcast.mybatis.po.OrdersCustom
 * @date 2017年08月18日 14:38
 */
public class OrdersCustom extends Orders{
    //应该包括 订单及订单关联信息的属性

    //由于继承订单类只需要添加一些关联属性

    //用户信息
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrdersCustom{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

