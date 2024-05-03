package com.entity.view;

import com.entity.RuxiaojianchaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 入校检查
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("ruxiaojiancha")
public class RuxiaojianchaView extends RuxiaojianchaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 是否去过风险地区的值
		*/
		private String ruxiaojianchaStatusValue;



		//级联表 ruxiaoshenbao
			/**
			* 编号
			*/
			private String ruxiaoshenbaoUuidNumber;
			/**
			* 入校申报 的 用户
			*/
			private Integer ruxiaoshenbaoYonghuId;

	public RuxiaojianchaView() {

	}

	public RuxiaojianchaView(RuxiaojianchaEntity ruxiaojianchaEntity) {
		try {
			BeanUtils.copyProperties(this, ruxiaojianchaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 是否去过风险地区的值
			*/
			public String getRuxiaojianchaStatusValue() {
				return ruxiaojianchaStatusValue;
			}
			/**
			* 设置： 是否去过风险地区的值
			*/
			public void setRuxiaojianchaStatusValue(String ruxiaojianchaStatusValue) {
				this.ruxiaojianchaStatusValue = ruxiaojianchaStatusValue;
			}










				//级联表的get和set ruxiaoshenbao

					/**
					* 获取： 编号
					*/
					public String getRuxiaoshenbaoUuidNumber() {
						return ruxiaoshenbaoUuidNumber;
					}
					/**
					* 设置： 编号
					*/
					public void setRuxiaoshenbaoUuidNumber(String ruxiaoshenbaoUuidNumber) {
						this.ruxiaoshenbaoUuidNumber = ruxiaoshenbaoUuidNumber;
					}

					/**
					* 获取：入校申报 的 用户
					*/
					public Integer getRuxiaoshenbaoYonghuId() {
						return ruxiaoshenbaoYonghuId;
					}
					/**
					* 设置：入校申报 的 用户
					*/
					public void setRuxiaoshenbaoYonghuId(Integer ruxiaoshenbaoYonghuId) {
						this.ruxiaoshenbaoYonghuId = ruxiaoshenbaoYonghuId;
					}





}
