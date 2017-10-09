package com.tyd.dao.impl;

import com.tyd.dao.UserDao;
import com.tyd.entity.UserEntity;
import com.tyd.pojo.UserPoJo;
import com.tyd.util.BeanMapper;
import com.tyd.util.FactoryUtil;
import com.tyd.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

    /**
     * login checking.
     *
     * @param name
     * @param password
     * @return
     */
    public boolean loginCheck(String name, String password)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query query = session.createQuery("from UserEntity u where u.name=:_name and u.password=:_password");
        query.setParameter("_name",name);
        query.setParameter("_password",password);
        List<UserEntity> list = query.list();
        transaction.commit();
        if(list.size() > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * get all sex of man.
     *
     * @param man
     * @return
     */
    public List<UserPoJo> getMan(String man)
    {
        SessionFactory sessionFactory = FactoryUtil.getSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String s = "from UserEntity u where u.sex =:_sex";
        javax.persistence.Query query = entityManager.createQuery(s);
        query.setParameter("_sex",man);
        List<UserEntity> resultList = query.getResultList();
        List<UserPoJo> map = beanMapper.map(resultList, UserPoJo.class);
        transaction.commit();
        sessionFactory.close();
        return map;
    }

    /**
     * Checking the address.
     *
     * @param regex
     * @return
     */
    public boolean checkAddress(String regex)
    {
        SessionFactory sessionFactory = FactoryUtil.getSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String s = "from UserEntity u where u.address =:_address";
        javax.persistence.Query query = entityManager.createQuery(s);
        query.setParameter("_address",regex);
        List<UserEntity> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        sessionFactory.close();
        if(resultList.size() > 0)
        {
            return true;
        }
        return false;
    }
}
