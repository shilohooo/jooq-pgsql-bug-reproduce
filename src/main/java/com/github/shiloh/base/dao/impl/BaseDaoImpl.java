package com.github.shiloh.base.dao.impl;

import com.github.shiloh.base.dao.BaseDao;
import org.jooq.*;
import org.jooq.impl.DAOImpl;

import java.util.List;

/**
 * 持久层通用接口基础实现
 *
 * @author shiloh
 */
public abstract class BaseDaoImpl<R extends UpdatableRecord<R>, P, T> extends DAOImpl<R, P, T> implements BaseDao<R, P, T> {
    protected BaseDaoImpl(Table<R> table, Class<P> type) {
        super(table, type);
    }

    protected BaseDaoImpl(Table<R> table, Class<P> type, Configuration configuration) {
        super(table, type, configuration);
    }

    @Override
    public DSLContext create() {
        return null;
    }

    @Override
    public P fetchOne(Condition condition) {
        return null;
    }

    @Override
    public List<P> fetch(Condition condition, SortField<?>... sortFields) {
        return this.create().selectFrom(this.getTable())
                .where(condition)
                .fetch(this.mapper());
    }
}
