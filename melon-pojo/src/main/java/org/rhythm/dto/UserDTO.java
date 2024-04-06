package org.rhythm.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
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
    //就业意向
    private String employmentIntention;
    //监护人姓名
    private String guardianName;
    //监护人手机号
    private String guardianPhone;
    //状态
    private Integer status;
}
