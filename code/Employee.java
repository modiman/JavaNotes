import lombok.Data;

import java.util.Date;
/**
 * 介绍Employee类
 * @author modige
 * @version 1.0.0 2021-10-3
 * */
@Data
class Employee extends Person implements Comparable<Employee>,Cloneable{
    //域中的变量尽量说那个private修饰，既保证了数据安全，也体现了封装的思想
    //name与hireDay 本身就是对象，即String对象和Date对象

    private String name;
    private double salary;
    private Date hireDay;

//无参构造函数
    //构造器与类同名  ，在构造对象时被运行，以便将实例域初始化为希望的状态
    //构造器总是伴随着new关键字被调用，不能被已经存在的对象调用
    //构造器数量以及构造器参数数量没有限制
    //构造器没有返回值
    //不能再构造器中声明类中已经存在的变量，这会屏蔽已有变量
    /**
     * @param n 员工姓名
     * @param s 员工薪水
     * @param d 入职日期
     *
     * */
    public Employee(String n,double s,Date d){
        name = n;
        salary = s;
        hireDay = d;
    }

    public String getDescription(){
        return "this is a good student whose salary is "+salary;
    }



    public void raiseSalary(){

        salary = salary*1.05;

    }

    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass()!=otherObject.getClass()) return false;
        Employee other = (Employee) otherObject;
        return name.equals(other.name) && salary==other.salary && hireDay.equals(other.hireDay);
    }
    public int hashCode(){
        return 7+name.hashCode()+11+new Double(salary).hashCode() + 13 + new Date().hashCode();
    }

    public String toString(){
        return getClass().getName()+" "
                +"[name=" +name +",Salary="
                +salary + ",hireDay="
                +hireDay + "]";
    }

        //可变参数
            public  double max(double... values){
            double largest = Double.MIN_VALUE;
            for (Double v:values){
                if (v>largest) largest = v;
            }
            return largest;
            }


            //注解overrade是否可以省略？
            @Override
            public int compareTo(Employee employee) {
                if (salary<employee.salary) return -1;
                if (salary>employee.salary) return 1;
                return 0;
            }
            public Employee clone() throws CloneNotSupportedException{
            Employee cloned = (Employee)super.clone();
            cloned.hireDay = (Date)hireDay.clone();
            return cloned;
                }
}