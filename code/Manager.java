import java.util.Date;

/**
 * manager类，继承(inheritance)Employee类
 * 此时Employee类称为超类  基类或父类
 * manager称为子类subclass 或派生类derived class
 * 子类比父类拥有更加丰富的内容
 * 重载薪水方法
 *
 * */

public class Manager extends Employee {
     private double bonus;
     //加上从父类中继承得来的三个域，本类有四个域

  //super在构造器中的使用
    public Manager(String n, double s, Date d){
        super(n,s,d);
        bonus = 0;

    }

     public void setBonus(double b){
         bonus = b;
     }
     public double getBonus(){
         return bonus;
     }

     //由于经理的薪水需要加上奖金，所以要有一个新的薪水方法来覆盖
    public double getSalary(){
         //如果直接以如下方法返回薪水，程序会报错
//         return super.getSalary()+getBonus();
        //这是因为此时子类 父类各有一个getSalary方法，程序会一直调用自己的getSalary方法直到报错
        //这时需要使用  super 关键字告诉程序调用父类的方法而非自己的
        return super.getSalary()+getBonus();

    }

    public String toString(){
        return super.toString()+"[bonus="+bonus+"]";
    }

}
