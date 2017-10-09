package com.tyd.service;

import com.tyd.entity.UserEntity;
import com.tyd.pojo.UserPoJo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-03
 * Time: 19:31
 * Description:
 */
@Repository
public interface UserService
{
    /**
     * 添加用户信息
     * @param userEntity
     */
    void addObj(UserEntity userEntity);

    /**
     * 根据id来删除用户信息
     * @param id
     * @return
     */
    void deleteObj(Integer id);

    /**
     * 更新用户信息
     * @param userEntity
     * @return
     */
    void updateObj(UserEntity userEntity);

    /**
     * 全查
     * @return
     */
    List<UserPoJo> findAll();

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    List<UserPoJo> findByName(String name);

    /**
     * 根据用户ID查询
     * @param id
     * @return
     */
    UserPoJo findById(Integer id);

    /**
     * 根据地址模糊查询
     * @param address
     * @return
     */
    List<UserPoJo> findByAddress(String address);

    /**
     * 根据年龄模糊查询
     * @param age
     * @return
     */
    List<UserPoJo> findByAge(String age);
}
