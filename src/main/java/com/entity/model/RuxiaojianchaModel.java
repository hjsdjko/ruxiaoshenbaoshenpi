package com.entity.model;

import com.entity.RuxiaojianchaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 入校检查
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RuxiaojianchaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 入校申报
     */
    private Integer ruxiaoshenbaoId;


    /**
     * 体温
     */
    private Double tiwen;


    /**
     * 健康码
     */
    private String ruxiaojianchaPhoto;


    /**
     * 行程码
     */
    private String xingchengPhoto;


    /**
     * 是否去过风险地区
     */
    private Integer ruxiaojianchaStatusTypes;


    /**
     * 检查详情
     */
    private String ruxiaojianchaContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：入校申报
	 */
    public Integer getRuxiaoshenbaoId() {
        return ruxiaoshenbaoId;
    }


    /**
	 * 设置：入校申报
	 */
    public void setRuxiaoshenbaoId(Integer ruxiaoshenbaoId) {
        this.ruxiaoshenbaoId = ruxiaoshenbaoId;
    }
    /**
	 * 获取：体温
	 */
    public Double getTiwen() {
        return tiwen;
    }


    /**
	 * 设置：体温
	 */
    public void setTiwen(Double tiwen) {
        this.tiwen = tiwen;
    }
    /**
	 * 获取：健康码
	 */
    public String getRuxiaojianchaPhoto() {
        return ruxiaojianchaPhoto;
    }


    /**
	 * 设置：健康码
	 */
    public void setRuxiaojianchaPhoto(String ruxiaojianchaPhoto) {
        this.ruxiaojianchaPhoto = ruxiaojianchaPhoto;
    }
    /**
	 * 获取：行程码
	 */
    public String getXingchengPhoto() {
        return xingchengPhoto;
    }


    /**
	 * 设置：行程码
	 */
    public void setXingchengPhoto(String xingchengPhoto) {
        this.xingchengPhoto = xingchengPhoto;
    }
    /**
	 * 获取：是否去过风险地区
	 */
    public Integer getRuxiaojianchaStatusTypes() {
        return ruxiaojianchaStatusTypes;
    }


    /**
	 * 设置：是否去过风险地区
	 */
    public void setRuxiaojianchaStatusTypes(Integer ruxiaojianchaStatusTypes) {
        this.ruxiaojianchaStatusTypes = ruxiaojianchaStatusTypes;
    }
    /**
	 * 获取：检查详情
	 */
    public String getRuxiaojianchaContent() {
        return ruxiaojianchaContent;
    }


    /**
	 * 设置：检查详情
	 */
    public void setRuxiaojianchaContent(String ruxiaojianchaContent) {
        this.ruxiaojianchaContent = ruxiaojianchaContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
