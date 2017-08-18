package cn.itcast.mybatis.po;

import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  用户pojo包装类
 * @Package cn.itcast.mybatis.po
 * @ClassName: cn.itcast.mybatis.po.QueryUserVo
 * @date 2017年08月18日 10:40
 */
public class QueryUserVo {


    //定义了很多的查询条件，可以将条件的pojo包装进来组成一个包装对象

    //用户信息查询条件
    private User user;

    //用户id列表，用于向mybatis传多个id
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    //商品信息查询条件
//	private Items items;

    //订单信息查询条件
    //....

    //...
}
