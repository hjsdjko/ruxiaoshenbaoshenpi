package com.entity.vo;

import com.entity.RuxiaoshenbaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 入校申报
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ruxiaoshenbao")
public class RuxiaoshenbaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
