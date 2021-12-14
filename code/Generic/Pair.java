package Generic;

import lombok.Data;

/**
 * @description :一个简单的泛型类例子
 * 引入了一个类型变量T
 *
 * @author      :modige
 * @date        :2021-10-9
 * */
@Data
public class Pair<T> {
    //实例域
    private T first;
    private T secend;

     //构造方法
     public Pair(){first = null;secend=null;}
     public Pair(T first,T secend){
         this.first = first;
         this.secend = secend;
     }

     public T getFirst(){return first;}
     public T getSecond(){return secend;}
     public void setFirst(T newValue){first = newValue;}
     public void setSecond(T newValue){secend = newValue;}
     /**
      * 一个泛型方法*/

     public static <T> T gerMiddle(T[] a){
         return a[a.length/2];
     }

}
