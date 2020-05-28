package yu.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author jobob
 * @since 2020-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户宠家账号")
    private String petNum;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "盐")
    private String salt;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "用户等级积分")
    private Long grade;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "头像")
    private String headPic;

    @ApiModelProperty(value = "性别 0-女 1-男")
    private Integer sex;

    @ApiModelProperty(value = "背景墙")
    private String backgroundImg;

    @ApiModelProperty(value = "心情签名")
    private String moodLog;

    @ApiModelProperty(value = "关注数量")
    private Integer followNum;

    @ApiModelProperty(value = "粉丝数量")
    private Integer fansNum;

    @ApiModelProperty(value = "0否1是")
    private Integer isLive;

    @ApiModelProperty(value = "状态  0：禁用   1：正常")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    @ApiModelProperty(value = "0否 1是 2已经申请待通过3不通过")
    private Integer verification;

    @ApiModelProperty(value = "正面")
    private String positive;

    @ApiModelProperty(value = "反面")
    private String back;

    @ApiModelProperty(value = "手持身份证")
    private String handheldCertificates;

    @ApiModelProperty(value = "申请时间")
    private Long verificationTime;

    @ApiModelProperty(value = "省")
    private Integer province;

    @ApiModelProperty(value = "市")
    private Integer city;

    @ApiModelProperty(value = "区")
    private Integer district;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    private Integer regType;

    private String openid;

    private String unionid;


}
