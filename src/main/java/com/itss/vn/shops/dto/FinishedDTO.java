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
public class FinishedDTO implements Serializable {

    private Integer finishedId;
    private String finishedCode;
    private String finishedName;
    private int quantity;
    private int quantityRes;
    private float price;
    private String staffCodeCreate;
    private String staffCodeUpdate;
    private Integer status;
    private Date updatedTime;
    private Date createdTime;


}
