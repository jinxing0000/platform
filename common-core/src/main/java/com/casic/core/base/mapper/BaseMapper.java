package com.casic.core.base.mapper;

import java.util.List;
import java.util.Map;

/**
 * 基础mapper（需要在xml中对应SQL）
 * @param <T>
 */
public interface BaseMapper<T> {
    /**
     * 保存实体
     * @param t
     */
    void insert(T t);

    /**
     * 批量新增数据
     * @param list
     */
    void insertBatch(List<T> list);

    /**
     *  修改实体
     * @param t
     * @return
     */
    int update(T t);
    /**
     *  批量修改实体
     * @param t
     * @return
     */
    int updateBatch(T t);
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
    T selectById(String id);

    /**
     * 分页查询（Map参数）
     * @param map
     * @return
     */
    List<T> selectListByPage(Map<String, Object> map);

    /**
     * 按照参数查询数据
     * @param params
     * @return
     */
    List<T> selectList(Map<String, Object> params);
}
