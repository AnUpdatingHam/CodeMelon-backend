package org.rhythm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "用户登录VO", description = "用户登录返回的数据模型")
public class ArticleVO implements Serializable {
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
    //创建时间
    @Schema(name = "创建时间", type = "LocalDateTime")
    private LocalDateTime createTime;
    //更新时间
    @Schema(name = "更新时间", type = "LocalDateTime")
    private LocalDateTime updateTime;

    @Schema(name = "目录编号", type = "String")
    private String catalogue_numbers;
    @Schema(name = "目录内容", type = "String")
    private String catalogue_contents;
    @Schema(name = "目录位置", type = "String")
    private String catalogue_positions;

    @Schema(name = "文章标签", type = "String")
    private String tags;

    @Schema(name = "文章分类名", type = "String")
    private String category_name;
    @Schema(name = "分类简介", type = "String")
    private String category_introduction;

}
