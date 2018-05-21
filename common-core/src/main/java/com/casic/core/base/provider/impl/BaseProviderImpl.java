package com.casic.core.base.provider.impl;

import com.casic.core.base.entity.BaseEntity;
import com.casic.core.base.entity.PageEntity;
import com.casic.core.base.mapper.BaseMapper;
import com.casic.core.base.provider.BaseProvider;
import com.casic.core.utils.ConstantUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 基础生产者实现类
 * @param <baseMapper>
 * @param <T>
 */
public abstract class BaseProviderImpl <baseMapper extends BaseMapper<T>, T extends BaseEntity>  implements BaseProvider<T> {

    protected  baseMapper provider;

    /** 生成主键策略 */
    public String createId() {
        return UUID.randomUUID().toString().replaceAll("\\-", "");
    }
    /**
     * 保存实体
     * @param t
     */
    @Override
    @Transactional
    public void save(T t){
        t.setId(createId());
        t.setCreateDate(new Date());
        t.setDeleteState(ConstantUtils.DELETE_STATE_NO);
        provider.insert(t);
    }

    /**
     * 保存实体
     * @param t
     */
    @Override
    @Transactional
    public T saveEntity(T t){
        String id=createId();
        t.setId(createId());
        t.setCreateDate(new Date());
        t.setDeleteState(ConstantUtils.DELETE_STATE_NO);
        provider.insert(t);
        return findById(id);
    }
    /**
     * 批量新增数据
     * @param list
     */
    @Override
    @Transactional
    public void saveBatch(List<T> list){
        for(T t:list){
            String id=createId();
            t.setId(createId());
            t.setCreateDate(new Date());
            t.setDeleteState(ConstantUtils.DELETE_STATE_NO);
        }
        provider.insertBatch(list);
    }

    /**
     *  修改实体
     * @param t
     * @return
     */
    @Override
    @Transactional
    public T edit(T t){
        t.setModifyDate(new Date());
        provider.update(t);
        return findById(t.getId());
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
            t.setModifyDate(new Date());
        }
        return provider.updateBatch(list);
    }
    /**
     *  删除数据（map参数,逻辑删除）
     * @param map
     * @return
     */
    @Override
    @Transactional
    public int delete(Map<String, Object> map){
        map.put("deleteState",ConstantUtils.DELETE_STATE_YES);
        map.put("modifyDate",new Date());
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
            t.setModifyDate(new Date());
            t.setDeleteState(ConstantUtils.DELETE_STATE_YES);
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
        return provider.selectById(id);
    }

    /**
     * 分页查询（Map参数）
     * @param params
     * @return
     */
    @Override
    public PageEntity<T> findListByPage(Map<String, Object> params){
        int currentPage=1;
        int pageSize=10;
        if(params.get("currentPage")!=null){
            currentPage=Integer.parseInt((String)params.get("currentPage"));
        }
        if(params.get("pageSize")!=null){
            pageSize=Integer.parseInt((String)params.get("pageSize"));
        }
        params.put("deleteState",ConstantUtils.DELETE_STATE_NO);
        PageHelper.startPage(currentPage, pageSize);
        List<T> list=provider.selectListByPage(params);
        return new PageEntity<T>(list);
    }

    /**
     * 按照参数查询数据
     * @param params
     * @return
     */
    @Override
    public List<T> findList(Map<String, Object> params){
        params.put("deleteState",ConstantUtils.DELETE_STATE_NO);
        return provider.selectList(params);
    }
}
