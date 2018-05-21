package com.casic.core.base.provider;

import com.casic.core.base.entity.PageEntity;

import java.util.List;
import java.util.Map;

/**
 * 基础生产者接口
 * @param <T>
 */
public interface BaseProvider<T> {
    /**
     * 保存实体
     * @param t
     */
    void save(T t);

    /**
     * 保存实体
     * @param t
     */
    T saveEntity(T t);
    /**
     * 批量新增数据
     * @param list
     */
    void saveBatch(List<T> list);

    /**
     *  修改实体
     * @param t
     * @return
     */
    T edit(T t);
    /**
     *  批量修改实体
     * @param list
     * @return
     */
    int editBatch(List<T> list);
    /**
     *  删除数据（map参数,逻辑删除）
     * @param map
     * @return
     */
    int delete(Map<String, Object> map);

    /**
     *  批量删除数据
     * @param list
     * @return
     */
    int deleteBatch(List<T> list);

    /**
     * id 查询详情
     * @param id
     * @return
     */
    T findById(String id);

    /**
     * 分页查询（Map参数）
     * @param map
     * @return
     */
    PageEntity<T> findListByPage(Map<String, Object> map);

    /**
     * 按照参数查询数据
     * @param params
     * @return
     */
    List<T> findList(Map<String, Object> params);
}
