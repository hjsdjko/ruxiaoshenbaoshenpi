package com.entity.view;

import com.entity.RuxiaoshenbaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 入校申报
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("ruxiaoshenbao")
public class RuxiaoshenbaoView extends RuxiaoshenbaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 人员身份的值
		*/
		private String zhuanyeValue;
		/**
		* 处理状态的值
		*/
		private String ruxiaoshenbaoYesnoValue;



		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;

	public RuxiaoshenbaoView() {

	}

	public RuxiaoshenbaoView(RuxiaoshenbaoEntity ruxiaoshenbaoEntity) {
		try {
			BeanUtils.copyProperties(this, ruxiaoshenbaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 人员身份的值
			*/
			public String getZhuanyeValue() {
				return zhuanyeValue;
			}
			/**
			* 设置： 人员身份的值
			*/
			public void setZhuanyeValue(String zhuanyeValue) {
				this.zhuanyeValue = zhuanyeValue;
			}
			/**
			* 获取： 处理状态的值
			*/
			public String getRuxiaoshenbaoYesnoValue() {
				return ruxiaoshenbaoYesnoValue;
			}
			/**
			* 设置： 处理状态的值
			*/
			public void setRuxiaoshenbaoYesnoValue(String ruxiaoshenbaoYesnoValue) {
				this.ruxiaoshenbaoYesnoValue = ruxiaoshenbaoYesnoValue;
			}












				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}


}
