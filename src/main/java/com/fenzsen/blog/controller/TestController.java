package com.fenzsen.blog.controller;

import com.fenzsen.blog.dao.LabelDao;
import com.fenzsen.blog.pojo.Label;
import com.fenzsen.blog.pojo.TeseUser;
import com.fenzsen.blog.pojo.TestHouse;
import com.fenzsen.blog.response.ResponseResult;
import com.fenzsen.blog.utils.Constants;
import com.fenzsen.blog.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional  // 数据库事务管理
@Slf4j  // Log 库注解
@RestController    // @RestController 注解处理 http请求,并且整个类的方法都以 body 的形式返回数据。
@RequestMapping("/test")    // @RestController 注解处理,整个类的请求都含有的公共路径
public class TestController {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private LabelDao labelDao;

    // 定义一个全局的 Log
    // public static final Logger log= LoggerFactory.getLogger(TestController.class);

    // @ResponseBody 注解以 body 的形式返回
    // @RequestMapping 指定请求路径、方法、参数
    @RequestMapping( value = "/testString",method = RequestMethod.GET)
    public String testString(){
        log.info("Hello World");
        return "Hello World";
    }

    @GetMapping("/testJson")    // get请求注解，直接传递路径
    // get请求方法参数直接定义和使用
    public TeseUser testJson(String name ,String password){
        log.info("userName:" + name);
        log.info("password：" + password);
        TeseUser teseUser = new TeseUser("大雄",20,"男");
        teseUser.setHouse(new TestHouse("故宫","北京"));
        // 返回对象就是返回json形式的数据，在一个对象中添加另一个对象就形成json的嵌套
        return  teseUser;
    }

    @PostMapping("/postParameter")   // post请求
    // post方法参数可以是实体类的对象，其中请求参数为该对象内的成员变量   请求头为：raw 以json的形式传递
    public ResponseResult postRequest(@RequestBody TeseUser user){
        log.info("userName:" + user.getName());
        log.info("password：" + user.getPassword());
        return ResponseResult.SUCCESS("post请求成功，参数为：userName:" + user.getName() + "password：" + user.getPassword());
    }

    /* 数据操作：增 */
    @PostMapping("/label")
    // post方法参数可以是实体类的对象，其中请求参数为该对象内的成员变量   请求头为：raw 以json的形式传递
    public ResponseResult addLable(@RequestBody Label label){
        // 判断数据是否有效
        // 补全数据
        label.setId(String.valueOf(idWorker.nextId()));
        label.setCreateTime(new Date());
        label.setUpdateTime(new Date());
        // 保存数据
        labelDao.save(label);

        return ResponseResult.SUCCESS("标签添加成功");
    }

    /* 数据库操作：删 */
    @DeleteMapping("/{labelId}")
    public ResponseResult deleteLable(@PathVariable String labelId){
        int deleteResult = labelDao.customDeleteItemById(labelId);
        if (deleteResult > 0) return ResponseResult.SUCCESS("标签删除成功");
        else return ResponseResult.FAILED("标签不存在");
    }

    /* 数据库操作：改 */
    @PutMapping("/label/{labelId}")
    public ResponseResult updateLable(@PathVariable String labelId,@RequestBody Label label){
        // 根据 ID 查找这个 Label，再对该 Label 属性值进行修改
        Label dbLabel = labelDao.findOneById(labelId);
        if(dbLabel == null)  return ResponseResult.FAILED("标签不存在");
        dbLabel.setName(label.getName());
        dbLabel.setCount(label.getCount());
        dbLabel.setUpdateTime(new Date());
        labelDao.save(dbLabel);
        return ResponseResult.SUCCESS("标签修改成功");
    }

    /* 数据库操作：查 */
    @GetMapping("/label/{labelId}")
    public ResponseResult getLable(@PathVariable String labelId){
        // 根据 ID 查找这个 Label，再对该 Label 属性值进行修改
        Label dbLabel = labelDao.findOneById(labelId);
        if(dbLabel == null)  return ResponseResult.FAILED("标签不存在");
        return ResponseResult.SUCCESS("标签查询成功").setData(dbLabel);
    }

    /* 数据库操作：分页查询 */
    @GetMapping("/label/list/{page}/{size}")
    public ResponseResult listLables(@PathVariable int page, @PathVariable int size){
        if(page < 1)  page = 1;
        if(size <= 0)  size = Constants.DEFAULT_SIZE;
        // 排序查询条件   DESC 升序  ASC 降序  参数二：数据表实体类的成员变量名，而不是数据库的字段名
        Sort sort = Sort.by(Sort.Direction.ASC,"createTime");
        // 分页查询条件
        Pageable pageable = PageRequest.of(page - 1, size,sort);
        Page<Label> result = labelDao.findAll(pageable);
        return ResponseResult.SUCCESS("标签分页查询成功").setData(result);
    }

    /* 数据库操作：条件查询及模糊查询 */
    @GetMapping("/label/serch")
    public ResponseResult doLableSerch(@RequestParam("keyword")String keyword,@RequestParam("count")String count){
        List<Label> all = labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                // 查询 name 这个字段，指定类型为 String,进行匹配的是参数 keyword
                // Predicate namePre = cb.equal(root.get("name").as(String.class), keyword);

                // 进行模糊查询
                Predicate namePre = cb.like(root.get("name").as(String.class), "%" + keyword + "%");
                Predicate countPre = cb.equal(root.get("count").as(Integer.class), count);
                // 将两个限制条件合并查询
                Predicate and = cb.and(namePre, countPre);

                return and;
            }
        });
        if (all.size() <= 0) return ResponseResult.FAILED("结果为空");
        return ResponseResult.SUCCESS("模糊查询成功").setData(all);
    }

}
