package com.qgzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("分页返回数据")
public class PageResult<T> {

    @ApiModelProperty("当前页")
    private int pageNumber;

    @ApiModelProperty("每页大小")
    private int pageSize;

    @ApiModelProperty("总记录数")
    private long total;

    @ApiModelProperty("总页数")
    private int totalPage;

    @ApiModelProperty("结果集")
    private List<T> list;
}
