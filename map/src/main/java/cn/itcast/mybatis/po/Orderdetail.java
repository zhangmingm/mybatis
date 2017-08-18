package cn.itcast.mybatis.po;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  订单详情pojo
 * @Package cn.itcast.mybatis.po
 * @ClassName: cn.itcast.mybatis.po.Orderdetail
 * @date 2017年08月18日 14:36
 */
public class Orderdetail {
    private Integer id;

    private Integer ordersId;

    private Integer itemsId;

    private Integer itemsNum;

    //明细所对应的商品信息
    private Items items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Integer itemsNum) {
        this.itemsNum = itemsNum;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", itemsId=" + itemsId +
                ", itemsNum=" + itemsNum +
                ", items=" + items +
                '}';
    }
}
