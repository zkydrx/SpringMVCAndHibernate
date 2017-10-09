package com.tyd.controller;

import com.tyd.entity.UserEntity;
import com.tyd.pojo.UserPoJo;
import com.tyd.service.UserService;
import com.tyd.service.impl.UserServiceImpl;
import com.tyd.util.BeanMapper;
import org.junit.Test;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-03
 * Time: 19:30
 * Description:
 */
public class Domain
{
    private UserService userService = new UserServiceImpl();
    private BeanMapper beanMapper = new BeanMapper();
    /**
     * 测试添加
     */
    @Test
    public void testAddObj()
    {
        UserPoJo userPoJo = new UserPoJo("x","y","z","a","man");
        UserEntity userEntity = new UserEntity();
        beanMapper.copy(userPoJo,userEntity);
        userService.addObj(userEntity);
    }

    /**
     * 测试删除
     */
    @Test
    public void testDeleteObj()
    {
        UserService userService = new UserServiceImpl();
        userService.deleteObj(1);
    }

    /**
     * 测试更新
     */
    @Test
    public void  testUpdate()
    {
        UserPoJo userPoJo = new UserPoJo(3,"a20171009","b","c","d","e");
        UserEntity userEntity = new UserEntity();
        beanMapper.copy(userPoJo,userEntity);
        userService.updateObj(userEntity);
    }

    /**
     * 测试全查
     */
    @Test
    public void testFindAll()
    {
        List<UserPoJo> all = userService.findAll();
        System.out.println(all);
    }

    /**
     * 测试通过姓名查找
     */
    @Test
    public void testFindByName()
    {
        List<UserPoJo> b = userService.findByName("a");
        System.out.println(b);
    }

    /**
     * 测试通过地址查找
     */
    @Test
    public void testFindByAddress()
    {
        List<UserPoJo> z = userService.findByAddress("z");
        System.out.println(z);
    }

    /**
     * 测试通过年龄查找
     */
    @Test
    public void testFindByAge()
    {
        List<UserPoJo> byAge = userService.findByAge("3");
        for (UserPoJo b : byAge)
        {
            System.out.println(b);
        }
        System.out.println(byAge);
    }

    /**
     * 测试通过id查找。
     */
    @Test
    public void testFindById()
    {
        UserPoJo byId = userService.findById(2);

        System.out.println(byId);

    }


    @Test
    public void testLoginChecking()
    {
        boolean b = userService.loginCheck("z", "z");
        if(b)
        {
            System.out.println("Login successful!");
        }
        else
        {
            System.out.println("The name or password not patch.");
        }
    }


    @Test
    public void testGetMan()
    {
        List<UserPoJo> man = userService.getMan("man");

        System.out.println(man);
    }


}
