package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 入校申报
 *
 * @author 
 * @email
 */
@TableName("ruxiaoshenbao")
public class RuxiaoshenbaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RuxiaoshenbaoEntity() {

	}

	public RuxiaoshenbaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 编号
     */
    @TableField(value = "ruxiaoshenbao_uuid_number")

    private String ruxiaoshenbaoUuidNumber;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 人员身份
     */
    @TableField(value = "zhuanye_types")

    private Integer zhuanyeTypes;


    /**
     * 入校时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "ruxiaoshenbao_time")

    private Date ruxiaoshenbaoTime;


    /**
     * 出校时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "cuxiao_time")

    private Date cuxiaoTime;


    /**
     * 处理状态
     */
    @TableField(value = "ruxiaoshenbao_yesno_types")

    private Integer ruxiaoshenbaoYesnoTypes;


    /**
     * 申请结果
     */
    @TableField(value = "ruxiaoshenbao_yesno_text")

    private String ruxiaoshenbaoYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：编号
	 */
    public String getRuxiaoshenbaoUuidNumber() {
        return ruxiaoshenbaoUuidNumber;
    }
    /**
	 * 获取：编号
	 */

    public void setRuxiaoshenbaoUuidNumber(String ruxiaoshenbaoUuidNumber) {
        this.ruxiaoshenbaoUuidNumber = ruxiaoshenbaoUuidNumber;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：人员身份
	 */
    public Integer getZhuanyeTypes() {
        return zhuanyeTypes;
    }
    /**
	 * 获取：人员身份
	 */

    public void setZhuanyeTypes(Integer zhuanyeTypes) {
        this.zhuanyeTypes = zhuanyeTypes;
    }
    /**
	 * 设置：入校时间
	 */
    public Date getRuxiaoshenbaoTime() {
        return ruxiaoshenbaoTime;
    }
    /**
	 * 获取：入校时间
	 */

    public void setRuxiaoshenbaoTime(Date ruxiaoshenbaoTime) {
        this.ruxiaoshenbaoTime = ruxiaoshenbaoTime;
    }
    /**
	 * 设置：出校时间
	 */
    public Date getCuxiaoTime() {
        return cuxiaoTime;
    }
    /**
	 * 获取：出校时间
	 */

    public void setCuxiaoTime(Date cuxiaoTime) {
        this.cuxiaoTime = cuxiaoTime;
    }
    /**
	 * 设置：处理状态
	 */
    public Integer getRuxiaoshenbaoYesnoTypes() {
        return ruxiaoshenbaoYesnoTypes;
    }
    /**
	 * 获取：处理状态
	 */

    public void setRuxiaoshenbaoYesnoTypes(Integer ruxiaoshenbaoYesnoTypes) {
        this.ruxiaoshenbaoYesnoTypes = ruxiaoshenbaoYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getRuxiaoshenbaoYesnoText() {
        return ruxiaoshenbaoYesnoText;
    }
    /**
	 * 获取：申请结果
	 */

    public void setRuxiaoshenbaoYesnoText(String ruxiaoshenbaoYesnoText) {
        this.ruxiaoshenbaoYesnoText = ruxiaoshenbaoYesnoText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Ruxiaoshenbao{" +
            "id=" + id +
            ", ruxiaoshenbaoUuidNumber=" + ruxiaoshenbaoUuidNumber +
            ", yonghuId=" + yonghuId +
            ", zhuanyeTypes=" + zhuanyeTypes +
            ", ruxiaoshenbaoTime=" + ruxiaoshenbaoTime +
            ", cuxiaoTime=" + cuxiaoTime +
            ", ruxiaoshenbaoYesnoTypes=" + ruxiaoshenbaoYesnoTypes +
            ", ruxiaoshenbaoYesnoText=" + ruxiaoshenbaoYesnoText +
            ", createTime=" + createTime +
        "}";
    }
}
