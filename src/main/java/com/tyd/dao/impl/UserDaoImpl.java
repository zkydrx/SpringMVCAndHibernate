package com.tyd.dao.impl;

import com.tyd.dao.UserDao;
import com.tyd.entity.UserEntity;
import com.tyd.pojo.UserPoJo;
import com.tyd.util.BeanMapper;
import com.tyd.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-03
 * Time: 20:10
 * Description:
 */
@Repository
public class UserDaoImpl implements UserDao
{

    BeanMapper beanMapper = new BeanMapper();
    public void addObj(UserEntity userEntity)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(userEntity);
        session.flush();
        session.clear();

        transaction.commit();
        session.close();
    }

    public void deleteObj(Integer id)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        session.delete(userEntity);
        session.flush();
        session.clear();
        transaction.commit();
        session.close();
    }

    public void updateObj(UserEntity userEntity)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(userEntity);
        session.flush();
        session.clear();
        transaction.commit();
        session.close();
    }

    public List<UserPoJo> findAll()
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query query = session.createQuery("from UserEntity ");

        List<UserEntity> list = query.list();
        transaction.commit();
        session.close();
        List<UserPoJo> userPoJos = beanMapper.map(list, UserPoJo.class);
        return userPoJos;
    }

    public List<UserPoJo> findByName(String name)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query query = session.createQuery("from UserEntity u where u.name like :_name");
        query.setParameter("_name","%"+name+"%");
        List<UserEntity> list = query.list();
        transaction.commit();
        session.close();
        List<UserPoJo> userPoJoList = beanMapper.map(list, UserPoJo.class);
        return userPoJoList;
    }

    public UserPoJo findById(Integer id)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query query = session.createQuery("from UserEntity u where u.id=:_id");
        query.setParameter("_id", id);
        List<UserEntity> list = query.list();
        transaction.commit();
        session.close();
        List<UserPoJo> map = beanMapper.map(list, UserPoJo.class);
        if(list.size()>0)
        {
            return map.get(0);
        }
        else
        {
            return null;
        }
    }

    public List<UserPoJo> findByAddress(String address)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query query = session.createQuery("from UserEntity u where u.address like :_address");
        query.setParameter("_address","%"+address+"%");
        List<UserEntity> list = query.list();

        transaction.commit();
        session.close();
        List<UserPoJo> map = beanMapper.map(list, UserPoJo.class);
        return map;
    }

    public List<UserPoJo> findByAge(String age)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query query = session.createQuery("from " +
                "UserEntity u " +
                "where u.age =:_age ");
        query.setParameter("_age",age);
        List<UserEntity> list = query.list();
        transaction.commit();
        session.close();
        List<UserPoJo> map = beanMapper.map(list, UserPoJo.class);
        return map;
    }
}
