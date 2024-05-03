
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 入校申报
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/ruxiaoshenbao")
public class RuxiaoshenbaoController {
    private static final Logger logger = LoggerFactory.getLogger(RuxiaoshenbaoController.class);

    @Autowired
    private RuxiaoshenbaoService ruxiaoshenbaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = ruxiaoshenbaoService.queryPage(params);

        //字典表数据转换
        List<RuxiaoshenbaoView> list =(List<RuxiaoshenbaoView>)page.getList();
        for(RuxiaoshenbaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        RuxiaoshenbaoEntity ruxiaoshenbao = ruxiaoshenbaoService.selectById(id);
        if(ruxiaoshenbao !=null){
            //entity转view
            RuxiaoshenbaoView view = new RuxiaoshenbaoView();
            BeanUtils.copyProperties( ruxiaoshenbao , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(ruxiaoshenbao.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody RuxiaoshenbaoEntity ruxiaoshenbao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,ruxiaoshenbao:{}",this.getClass().getName(),ruxiaoshenbao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            ruxiaoshenbao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<RuxiaoshenbaoEntity> queryWrapper = new EntityWrapper<RuxiaoshenbaoEntity>()
            .eq("ruxiaoshenbao_uuid_number", ruxiaoshenbao.getRuxiaoshenbaoUuidNumber())
            .eq("yonghu_id", ruxiaoshenbao.getYonghuId())
            .eq("zhuanye_types", ruxiaoshenbao.getZhuanyeTypes())
            .eq("ruxiaoshenbao_yesno_types", ruxiaoshenbao.getRuxiaoshenbaoYesnoTypes())
            .eq("ruxiaoshenbao_yesno_text", ruxiaoshenbao.getRuxiaoshenbaoYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RuxiaoshenbaoEntity ruxiaoshenbaoEntity = ruxiaoshenbaoService.selectOne(queryWrapper);
        if(ruxiaoshenbaoEntity==null){
            ruxiaoshenbao.setRuxiaoshenbaoYesnoTypes(1);
            ruxiaoshenbao.setCreateTime(new Date());
            ruxiaoshenbaoService.insert(ruxiaoshenbao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RuxiaoshenbaoEntity ruxiaoshenbao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,ruxiaoshenbao:{}",this.getClass().getName(),ruxiaoshenbao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            ruxiaoshenbao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<RuxiaoshenbaoEntity> queryWrapper = new EntityWrapper<RuxiaoshenbaoEntity>()
            .notIn("id",ruxiaoshenbao.getId())
            .andNew()
            .eq("ruxiaoshenbao_uuid_number", ruxiaoshenbao.getRuxiaoshenbaoUuidNumber())
            .eq("yonghu_id", ruxiaoshenbao.getYonghuId())
            .eq("zhuanye_types", ruxiaoshenbao.getZhuanyeTypes())
            .eq("ruxiaoshenbao_time", ruxiaoshenbao.getRuxiaoshenbaoTime())
            .eq("cuxiao_time", ruxiaoshenbao.getCuxiaoTime())
            .eq("ruxiaoshenbao_yesno_types", ruxiaoshenbao.getRuxiaoshenbaoYesnoTypes())
            .eq("ruxiaoshenbao_yesno_text", ruxiaoshenbao.getRuxiaoshenbaoYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RuxiaoshenbaoEntity ruxiaoshenbaoEntity = ruxiaoshenbaoService.selectOne(queryWrapper);
        if(ruxiaoshenbaoEntity==null){
            ruxiaoshenbaoService.updateById(ruxiaoshenbao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ruxiaoshenbaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<RuxiaoshenbaoEntity> ruxiaoshenbaoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            RuxiaoshenbaoEntity ruxiaoshenbaoEntity = new RuxiaoshenbaoEntity();
//                            ruxiaoshenbaoEntity.setRuxiaoshenbaoUuidNumber(data.get(0));                    //编号 要改的
//                            ruxiaoshenbaoEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            ruxiaoshenbaoEntity.setZhuanyeTypes(Integer.valueOf(data.get(0)));   //人员身份 要改的
//                            ruxiaoshenbaoEntity.setRuxiaoshenbaoTime(sdf.parse(data.get(0)));          //入校时间 要改的
//                            ruxiaoshenbaoEntity.setCuxiaoTime(sdf.parse(data.get(0)));          //出校时间 要改的
//                            ruxiaoshenbaoEntity.setRuxiaoshenbaoYesnoTypes(Integer.valueOf(data.get(0)));   //处理状态 要改的
//                            ruxiaoshenbaoEntity.setRuxiaoshenbaoYesnoText(data.get(0));                    //申请结果 要改的
//                            ruxiaoshenbaoEntity.setCreateTime(date);//时间
                            ruxiaoshenbaoList.add(ruxiaoshenbaoEntity);


                            //把要查询是否重复的字段放入map中
                                //编号
                                if(seachFields.containsKey("ruxiaoshenbaoUuidNumber")){
                                    List<String> ruxiaoshenbaoUuidNumber = seachFields.get("ruxiaoshenbaoUuidNumber");
                                    ruxiaoshenbaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> ruxiaoshenbaoUuidNumber = new ArrayList<>();
                                    ruxiaoshenbaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("ruxiaoshenbaoUuidNumber",ruxiaoshenbaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //编号
                        List<RuxiaoshenbaoEntity> ruxiaoshenbaoEntities_ruxiaoshenbaoUuidNumber = ruxiaoshenbaoService.selectList(new EntityWrapper<RuxiaoshenbaoEntity>().in("ruxiaoshenbao_uuid_number", seachFields.get("ruxiaoshenbaoUuidNumber")));
                        if(ruxiaoshenbaoEntities_ruxiaoshenbaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RuxiaoshenbaoEntity s:ruxiaoshenbaoEntities_ruxiaoshenbaoUuidNumber){
                                repeatFields.add(s.getRuxiaoshenbaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        ruxiaoshenbaoService.insertBatch(ruxiaoshenbaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
