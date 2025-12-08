package com.github.shiloh.base.dao;

import org.jooq.*;

import java.util.List;

/**
 * 持久层通用接口
 *
 * @param <R> Record 类型
 * @param <P> Pojo 类型
 * @param <T> 表的主键类型
 * @author shiloh
 */
public interface BaseDao<R extends UpdatableRecord<R>, P, T> extends DAO<R, P, T> {
    /**
     * 获取 {@link DSLContext}
     *
     * @return {@link DSLContext}
     * @author shiloh
     * @date 2025/11/3 11:13
     */
    DSLContext create();

    /**
     * 按条件查询单条记录
     *
     * @param condition 查询条件
     * @return Pojo 对象
     * @author shiloh
     * @date 2025/11/3 11:14
     */
    P fetchOne(Condition condition);

    /**
     * 按条件查询列表，可指定排序字段
     *
     * @param condition  查询条件
     * @param sortFields 排序字段
     * @return Pojo 列表
     * @author shiloh
     * @date 2025/11/3 11:16
     */
    List<P> fetch(Condition condition, SortField<?>... sortFields);
}
