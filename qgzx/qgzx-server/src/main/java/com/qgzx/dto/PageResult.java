package com.qgzx.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * <Description>
 *
 * @createDate 2019/07/03 11:02
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    private int pageNumber;

    private int pageSize;

    private long total;

    private int totalPage;

    private List<T> list;
}
