package com.github.shiloh.base.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页响应数据
 *
 * @author shiloh
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class PageResp<T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = 2797729783990706693L;

    public static final Integer DEFAULT_PAGE_INDEX = 1;
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * 当前页码
     */
    private Integer pageIndex = DEFAULT_PAGE_INDEX;

    /**
     * 每页记录数
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 总页数
     */
    private Long totalPages = 0L;

    /**
     * 总记录数
     */
    private Long totalElements = 0L;

    /**
     * 数据列表
     */
    private List<T> items = Collections.emptyList();

    public PageResp(Long totalElements, List<T> items) {
        this.totalElements = totalElements;
        this.items = items;

        this.calcTotalPages();
    }

    public PageResp(Integer pageIndex, Integer pageSize, Long totalElements, List<T> items) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.items = items;

        this.calcTotalPages();
    }

    /**
     * 计算总页数
     *
     * @author shiloh
     * @date 2025/11/3 11:57
     */
    public void calcTotalPages() {
        if (this.totalElements <= 0) {
            this.totalPages = 0L;
            return;
        }

        if (this.totalElements % this.pageSize == 0) {
            this.totalPages = this.totalElements / this.pageSize;
            return;
        }

        this.totalPages = (this.totalElements / this.pageSize) + 1L;
    }

    /**
     * 获取空的分页响应数据，查询数据列表为空时可以用
     *
     * @param <T> 数据类型
     * @return 分页响应数据对象
     * @author shiloh
     * @date 2025/11/3 11:46
     */
    public static <T extends Serializable> PageResp<T> empty() {
        return new PageResp<>();
    }
}
