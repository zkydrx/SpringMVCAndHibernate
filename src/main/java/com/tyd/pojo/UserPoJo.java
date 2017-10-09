package com.tyd.pojo;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-03
 * Time: 19:30
 * Description:
 */
@Component
public class UserPoJo
{
    private int id;
    private String name;
    private String password;
    private String age;
    private String address;
    private String sex;

    public UserPoJo()
    {
    }

    public UserPoJo(int id, String name, String password, String age, String address, String sex)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }

    public UserPoJo(String name, String password, String age, String address, String sex)
    {
        this.name = name;
        this.password = password;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    @Override
    public String toString()
    {
        return "UserPoJo{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + ", age='" +
                age + '\'' + ", address='" + address + '\'' + ", sex='" + sex + '\'' + '}';
    }
}
