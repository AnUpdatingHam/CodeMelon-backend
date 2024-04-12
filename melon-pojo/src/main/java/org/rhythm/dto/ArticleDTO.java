package org.rhythm.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleDTO implements Serializable {
    //ID
    @Schema(name = "ID", type = "Long")
    private Long id;
    //标题
    @Schema(name = "标题", type = "String")
    private String title;
    //内容
    @Schema(name = "内容", type = "String")
    private String content;
    //分类ID
    @Schema(name = "分类ID", type = "Long")
    private Long category_id;
    //简介
    @Schema(name = "简介", type = "String")
    private String introduction;
    //状态
    @Schema(name = "状态", type = "Integer")
    private Integer status; //0被禁用
}
