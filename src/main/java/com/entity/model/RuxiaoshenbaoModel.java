package com.entity.model;

import com.entity.RuxiaoshenbaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 入校申报
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RuxiaoshenbaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 编号
     */
    private String ruxiaoshenbaoUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 人员身份
     */
    private Integer zhuanyeTypes;


    /**
     * 入校时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date ruxiaoshenbaoTime;


    /**
     * 出校时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date cuxiaoTime;


    /**
     * 处理状态
     */
    private Integer ruxiaoshenbaoYesnoTypes;


    /**
     * 申请结果
     */
    private String ruxiaoshenbaoYesnoText;


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
	 * 获取：编号
	 */
    public String getRuxiaoshenbaoUuidNumber() {
        return ruxiaoshenbaoUuidNumber;
    }


    /**
	 * 设置：编号
	 */
    public void setRuxiaoshenbaoUuidNumber(String ruxiaoshenbaoUuidNumber) {
        this.ruxiaoshenbaoUuidNumber = ruxiaoshenbaoUuidNumber;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：人员身份
	 */
    public Integer getZhuanyeTypes() {
        return zhuanyeTypes;
    }


    /**
	 * 设置：人员身份
	 */
    public void setZhuanyeTypes(Integer zhuanyeTypes) {
        this.zhuanyeTypes = zhuanyeTypes;
    }
    /**
	 * 获取：入校时间
	 */
    public Date getRuxiaoshenbaoTime() {
        return ruxiaoshenbaoTime;
    }


    /**
	 * 设置：入校时间
	 */
    public void setRuxiaoshenbaoTime(Date ruxiaoshenbaoTime) {
        this.ruxiaoshenbaoTime = ruxiaoshenbaoTime;
    }
    /**
	 * 获取：出校时间
	 */
    public Date getCuxiaoTime() {
        return cuxiaoTime;
    }


    /**
	 * 设置：出校时间
	 */
    public void setCuxiaoTime(Date cuxiaoTime) {
        this.cuxiaoTime = cuxiaoTime;
    }
    /**
	 * 获取：处理状态
	 */
    public Integer getRuxiaoshenbaoYesnoTypes() {
        return ruxiaoshenbaoYesnoTypes;
    }


    /**
	 * 设置：处理状态
	 */
    public void setRuxiaoshenbaoYesnoTypes(Integer ruxiaoshenbaoYesnoTypes) {
        this.ruxiaoshenbaoYesnoTypes = ruxiaoshenbaoYesnoTypes;
    }
    /**
	 * 获取：申请结果
	 */
    public String getRuxiaoshenbaoYesnoText() {
        return ruxiaoshenbaoYesnoText;
    }


    /**
	 * 设置：申请结果
	 */
    public void setRuxiaoshenbaoYesnoText(String ruxiaoshenbaoYesnoText) {
        this.ruxiaoshenbaoYesnoText = ruxiaoshenbaoYesnoText;
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
