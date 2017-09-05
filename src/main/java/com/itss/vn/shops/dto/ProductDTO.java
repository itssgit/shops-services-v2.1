package com.itss.vn.shops.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ProductDTO implements Serializable {

    private Integer productId;
    private String productCode;
    private String productName;
    private String productDesc;
    private String staffCodeCreate;
    private String staffCodeUpdate;
    private Integer status;
    private Date updatedTime;
    private Date createdTime;


}
