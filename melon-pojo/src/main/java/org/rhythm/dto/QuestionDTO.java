package org.rhythm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QuestionDTO {
    @ApiModelProperty("用户问的问题")
    private String question;
}
