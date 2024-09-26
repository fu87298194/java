package com.huhu.springbootdemo.data.vo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

public class PageInfoVo {

    private Integer id;

    @DecimalMin(value = "1",message = "page 只能为正整数")
    //@Pattern(regexp="^[0-9]*$",message = "page 必须为正整数")
    private Integer page = 1;

    @DecimalMin(value = "1",message = "rows 只能为正整数")
    //@Pattern(regexp="^[0-9]*$",message = "rows 必须为正整数")
    private Integer rows = 10;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
