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
 * 入校检查
 *
 * @author 
 * @email
 */
@TableName("ruxiaojiancha")
public class RuxiaojianchaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RuxiaojianchaEntity() {

	}

	public RuxiaojianchaEntity(T t) {
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
     * 入校申报
     */
    @TableField(value = "ruxiaoshenbao_id")

    private Integer ruxiaoshenbaoId;


    /**
     * 体温
     */
    @TableField(value = "tiwen")

    private Double tiwen;


    /**
     * 健康码
     */
    @TableField(value = "ruxiaojiancha_photo")

    private String ruxiaojianchaPhoto;


    /**
     * 行程码
     */
    @TableField(value = "xingcheng_photo")

    private String xingchengPhoto;


    /**
     * 是否去过风险地区
     */
    @TableField(value = "ruxiaojiancha_status_types")

    private Integer ruxiaojianchaStatusTypes;


    /**
     * 检查详情
     */
    @TableField(value = "ruxiaojiancha_content")

    private String ruxiaojianchaContent;


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
	 * 设置：入校申报
	 */
    public Integer getRuxiaoshenbaoId() {
        return ruxiaoshenbaoId;
    }
    /**
	 * 获取：入校申报
	 */

    public void setRuxiaoshenbaoId(Integer ruxiaoshenbaoId) {
        this.ruxiaoshenbaoId = ruxiaoshenbaoId;
    }
    /**
	 * 设置：体温
	 */
    public Double getTiwen() {
        return tiwen;
    }
    /**
	 * 获取：体温
	 */

    public void setTiwen(Double tiwen) {
        this.tiwen = tiwen;
    }
    /**
	 * 设置：健康码
	 */
    public String getRuxiaojianchaPhoto() {
        return ruxiaojianchaPhoto;
    }
    /**
	 * 获取：健康码
	 */

    public void setRuxiaojianchaPhoto(String ruxiaojianchaPhoto) {
        this.ruxiaojianchaPhoto = ruxiaojianchaPhoto;
    }
    /**
	 * 设置：行程码
	 */
    public String getXingchengPhoto() {
        return xingchengPhoto;
    }
    /**
	 * 获取：行程码
	 */

    public void setXingchengPhoto(String xingchengPhoto) {
        this.xingchengPhoto = xingchengPhoto;
    }
    /**
	 * 设置：是否去过风险地区
	 */
    public Integer getRuxiaojianchaStatusTypes() {
        return ruxiaojianchaStatusTypes;
    }
    /**
	 * 获取：是否去过风险地区
	 */

    public void setRuxiaojianchaStatusTypes(Integer ruxiaojianchaStatusTypes) {
        this.ruxiaojianchaStatusTypes = ruxiaojianchaStatusTypes;
    }
    /**
	 * 设置：检查详情
	 */
    public String getRuxiaojianchaContent() {
        return ruxiaojianchaContent;
    }
    /**
	 * 获取：检查详情
	 */

    public void setRuxiaojianchaContent(String ruxiaojianchaContent) {
        this.ruxiaojianchaContent = ruxiaojianchaContent;
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
        return "Ruxiaojiancha{" +
            "id=" + id +
            ", ruxiaoshenbaoId=" + ruxiaoshenbaoId +
            ", tiwen=" + tiwen +
            ", ruxiaojianchaPhoto=" + ruxiaojianchaPhoto +
            ", xingchengPhoto=" + xingchengPhoto +
            ", ruxiaojianchaStatusTypes=" + ruxiaojianchaStatusTypes +
            ", ruxiaojianchaContent=" + ruxiaojianchaContent +
            ", createTime=" + createTime +
        "}";
    }
}
