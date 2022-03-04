package com.bear.book.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

/**
 * 购物车模型
 *
 * @author Spring-_-Bear
 * @datetime 2022/3/4 16:06
 */
public class Cart {
    private final LinkedHashMap<Integer, CartItem> items = new LinkedHashMap<>();

    /**
     * 添加商品项到购物车
     *
     * @param cartItem 商品项
     */
    public void addItem(CartItem cartItem) {
        // 先判断购物车中是否存在此商品项，存在则数量 + 1，修改金额，不存在则添加到购物车
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            // 购物车中不存在对应的商品项
            items.put(cartItem.getId(), cartItem);
        } else {
            // 数量自增一
            item.setCount(item.getCount() + cartItem.getCount());
            // 总价 = 原总价 + 单价
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除商品项
     *
     * @param id 商品项 id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 修改商品项的数量
     *
     * @param id    商品项 id
     * @param count 新商品项数量
     */
    public void updateCount(Integer id, Integer count) {
        CartItem item = items.get(id);
        if (item != null) {
            // 修改商品数量
            item.setCount(count);
            // 修改商品总价
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem value : items.values()) {
            totalCount += value.getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem value : items.values()) {
            totalPrice = totalPrice.add(new BigDecimal(value.getTotalPrice().toString()));
        }
        return totalPrice;
    }

    public LinkedHashMap<Integer, CartItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
