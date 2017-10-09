package com.tyd.service.impl;

import com.tyd.dao.UserDao;
import com.tyd.dao.impl.UserDaoImpl;
import com.tyd.entity.UserEntity;
import com.tyd.pojo.UserPoJo;
import com.tyd.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-03
 * Time: 20:44
 * Description:
 */
public class UserServiceImpl implements UserService
{

    UserDao userDao = new UserDaoImpl();
    public void addObj(UserEntity userEntity)
    {
        userDao.addObj(userEntity);
    }

    public void deleteObj(Integer id)
    {
        userDao.deleteObj(id);
    }

    public void updateObj(UserEntity userEntity)
    {
        userDao.updateObj(userEntity);
    }

    public List<UserPoJo> findAll()
    {
        List<UserPoJo> list = userDao.findAll();
        return list;
    }

    public List<UserPoJo> findByName(String name)
    {
        List<UserPoJo> list = userDao.findByName(name);
        return list;
    }

    public UserPoJo findById(Integer id)
    {
        UserPoJo byId = userDao.findById(id);
        return byId;
    }

    public List<UserPoJo> findByAddress(String address)
    {
        List<UserPoJo> byAddress = userDao.findByAddress(address);
        return byAddress;
    }

    public List<UserPoJo> findByAge(String age)
    {
        List<UserPoJo> byAge = userDao.findByAge(age);
        return byAge;
    }
}
