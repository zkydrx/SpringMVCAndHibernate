package com.tyd.util;

import com.google.common.collect.Lists;
import com.tyd.entity.UserEntity;
import com.tyd.pojo.UserPoJo;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-03
 * Time: 19:37
 * Description:
 */
public class BeanMapper
{
    public DozerBeanMapper mapper = new DozerBeanMapper();

    /**
     * 两个对象之间转换
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public <T> T map(Object source,Class<T> target)
    {
        return mapper.map(source,target);
    }


    /**
     * 两个对象之间类型转换(三个参数)
     * @param source
     * @param target
     * @param key
     * @param <T>
     * @return
     */
    public <T> T map(Object source,Class<T> target,String key)
    {
        return mapper.map(source,target,key);
    }

    /**
     * 转换collection中对象的类型
     * @param sourceList
     * @param targetClass
     * @param <T>
     * @return
     */
    public <T> List<T> map(Collection<?> sourceList,Class<T> targetClass)
    {
        List<T> list = Lists.newArrayList();
        if(sourceList != null && sourceList.size()>0)
        {
            for (Object obj:sourceList)
            {
                T map = mapper.map(obj, targetClass);
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 将一个对象中的相同字段的值copy到另外一个对象中
     * @param source
     * @param target
     */
    public void copy(Object source,Object target)
    {
        mapper.map(source,target);
    }

    @Test
    public void test()
    {
        BeanMapper beanMapper = new BeanMapper();
        UserPoJo userPoJo = new UserPoJo(1,"a","b","c","d","e");
        UserEntity userEntity = new UserEntity();
        beanMapper.copy(userPoJo,userEntity);
        System.out.println(userEntity.toString());
    }

    public static void main(String[] args)
    {
        BeanMapper beanMapper = new BeanMapper();
        UserPoJo userPoJo = new UserPoJo("a","b","c","d","e");
        UserEntity userEntity = new UserEntity();
        beanMapper.copy(userPoJo,userEntity);
        System.out.println(userEntity.toString());
    }

}
