package org.rhythm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    //用户名
    private String username;
    //姓名
    private String name;
    //密码
    private String password;
    //年龄
    private Short age;
    //性别
    private String gender;
    //身份证号
    private String idNumber;
    //手机号
    private String phone;
    //邮箱
    private String email;
    //学历
    private Short education;
    //对应病症表id
    private Long userDiseasesId;
    //个人履历
    private String personalExperience;
    //求职意向
    private String employmentIntention;
    //监护人姓名
    private String guardianName;
    //监护人手机号
    private String guardianPhone;
    //状态
    private Integer status;
    //用户创建时间
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //用户信息更新时间
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //private Integer status;
}
