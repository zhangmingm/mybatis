package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.QueryUserVo;
import cn.itcast.mybatis.po.User;

import java.util.List;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  输入映射 使用pojo包装类型
 * @Package cn.itcast.mybatis.mapper
 * @ClassName: cn.itcast.mybatis.mapper.UserMapperCustom
 * @date 2017年08月18日 12:16
 */
public interface UserMapperCustom {


    /**
     * 综合条件查询用户信息
     * @param queryUserVo
     * @return
     * @throws Exception
     */
    public List<User> findUserList(QueryUserVo queryUserVo) throws Exception;


    /**
     * 综合条件查询用户记录总数
     * @param queryUserVo
     * @return
     * @throws Exception
     */
    public int findUserCount(QueryUserVo queryUserVo) throws Exception;
}
