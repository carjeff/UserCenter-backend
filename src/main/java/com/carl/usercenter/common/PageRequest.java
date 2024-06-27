package com.carl.usercenter.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class PageRequest implements Serializable {


    private int pageSize = 10;

    private int pageNum = 1;
}
