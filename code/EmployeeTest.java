import lombok.Data;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class EmployeeTest {
    public static void main(String[] args) {

        //遍历
        List<Employee> employees = new ArrayList();
        employees.add(new Employee("modige",1000.0,new Date()));
        employees.add(new Employee("modige",1000.0,new Date()));
        for (Employee e:employees) {
            System.out.println(e.hashCode());
            System.out.println(e.toString());
            e.raiseSalary();
        }

        //继承
        Manager manager = new Manager("modige",1000.0,new Date());
        System.out.println(manager.toString());
        manager.setSalary(100.0);
        manager.setBonus(200.0);
        System.out.println(manager.getSalary() );

        //多态
        //正确写法 (超类可以引用子类)
        Employee employee = new Manager("modige",1000.0,new Date());
        //错误写法（子类不能引\用   超类）
        //Manager manager1 = new Employee("modige",1000.0,new Date());
        //这是因为如果manage1调用bonus会报错
        //这可以理解为所有的经理都是员工，但并非所有的员工都是经理


        //抽象类

        Person[] persons = new Person[2];
        persons[0] = new Employee("modige",1000.0,new Date());
        persons[1] = new Student();


        //
        String s = "OK";
        StringBuffer sb = new StringBuffer(s);
        System.out.println(s.hashCode() + "  "+ sb.hashCode());

        String t = new String("OK");
        StringBuffer tb = new StringBuffer(t);
        System.out.println(t.hashCode()  + "  "+ tb.hashCode());


        System.out.println(manager.max(10.0));

//        ActionListener al = new MyTimer();
//        Timer timer = new Timer(1000,al);
//
//


    }
}
