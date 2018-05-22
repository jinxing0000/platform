package com.casic.core.base.service.impl;

import com.casic.core.base.entity.BaseEntity;
import com.casic.core.base.entity.PageEntity;
import com.casic.core.base.provider.BaseProvider;
import com.casic.core.base.service.BaseService;
import com.casic.core.utils.ConstantUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<baseProvider extends BaseProvider<T>, T extends BaseEntity>  implements BaseService<T> {

    protected baseProvider provider;

    /**
     * 保存实体
     * @param t
     */
    @Override
    @Transactional
    public void save(T t){
        t.setCreateUserId("111111");
        provider.save(t);
    }

    /**
     * 保存实体
     * @param t
     */
    @Override
    @Transactional
    public T saveEntity(T t){
        t.setCreateUserId("111111");
        return provider.saveEntity(t);
    }
    /**
     * 批量新增数据
     * @param list
     */
    @Override
    @Transactional
    public void saveBatch(List<T> list){
        for(T t:list){
            t.setCreateUserId("111111");
        }
        provider.saveBatch(list);
    }

    /**
     *  修改实体
     * @param t
     * @return
     */
    @Override
    @Transactional
    public T edit(T t){
        t.setModifyUserId("111111");
        return provider.edit(t);
    }
    /**
     *  批量修改实体
     * @param list
     * @return
     */
    @Override
    @Transactional
    public int editBatch(List<T> list){
        for(T t:list){
            t.setModifyUserId("111111");
        }
        return provider.editBatch(list);
    }
    /**
     *  删除数据（map参数,逻辑删除）
     * @param map
     * @return
     */
    @Override
    @Transactional
    public int delete(Map<String, Object> map){
        map.put("modifyUserId","111111");
        return provider.delete(map);
    }

    /**
     *  批量删除数据
     * @param list
     * @return
     */
    @Override
    @Transactional
    public int deleteBatch(List<T> list){
        for(T t:list){
            t.setModifyUserId("111111");
        }
        return provider.deleteBatch(list);
    }

    /**
     * id 查询详情
     * @param id
     * @return
     */
    @Override
    public T findById(String id){
        return provider.findById(id);
    }

    /**
     * 分页查询（Map参数）
     * @param params
     * @return
     */
    @Override
    public PageEntity<T> findListByPage(Map<String, Object> params){
        return provider.findListByPage(params);
    }

    /**
     * 按照参数查询数据
     * @param params
     * @return
     */
    @Override
    public List<T> findList(Map<String, Object> params){
        return provider.findList(params);
    }
}
