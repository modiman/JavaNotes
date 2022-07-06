# 15 常用技巧

## List

### add()方法

使用add方法向list对象中添加元素时需要new

**当使用以下方法向ans中添加path时，并不会添加x个path，而是添加一次path，之后都是修改path的值**

```java
List<List<Integer>> ans = ArrayList<>();
List<Integer> path = new ArrayList<>();
for(){
    list.add(path);
    path=XXX;
}
```

**正确的添加方式\*是新开辟一块空间，将path中的值复制到这块空间再添加到ans中去**

```java
List<List<Integer>> ans = ArrayList<>();
List<Integer> path = new ArrayList<>();
for(){
     List<Integer> a = new ArrayList<>();
    
     a.addAll(path);

    
    list.add(a);
   
    path=XXX;
}
```

#### 翻转ArrayList

```java
Collections.reverse(a);//无返回值
```

### Queue

#### 声明

```java
Queue <E> q = new LinkedList<>();
//常用方法
q.offer(element);
q.
```

### Deque

#### 声明

```java
Deque <E> deq = new LinkedList();
//常用方法
//入队
q.offer(element);
//取队尾元素
q.getLast()
```

### 卫语句

如果条件语句极其复杂，就应该将条件语句拆解开，然后逐个检查，并在条件为真时立刻从函数中返回，这样的单独检查通常被称之为“卫语句”（guard clauses）

1.什么是卫语句

```
    卫语句就是把复杂的条件表达式拆分成多个条件表达式，减少嵌套。嵌套了好几层的if - then-else语句，转换为多个if语句，实现它的逻辑，这多条的if语句就是卫语句。

    卫语句将某些关键条件优先判断，简化程序流程走向。卫语句往往用于对 if 条件嵌套代码的优化。

    在《阿里巴巴Java开发手册》中强制规定：超过 3 层的 if-else 的逻辑判断代码可以使用卫语句、策略模式、状态模式等来实现，其中卫语句即代码逻辑先考虑失败、异常、中断、退出等直接返回的情况，以方法多个出口的方式，解决代码中判断分支嵌套的问题，这是逆向思维的体现。
```

2.举例

嵌套的话语句很繁琐，可读性差。

```java
public void get(int t) {
    if (t == 1) {
        return;
    } else {
        if (t == 2) {
            return;
        } else {
            if (t == 3) {
                return;
            } else {
                set();
            }
        }
    }
}   

```

使用卫语句：

```
public void get(int t) {
if (t == 1) {
    return;
}
if (t == 2) {
    return;
}
if (t == 3) {
    return;
}
set();
}
```

## Java

#### 输入

```java
import java.util.Scanner
class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
    }
}
```

#### 可变参数

...表示长度不固定的参数

```java
static void printString(String... strs){
         for (String s:strs) System.out.println(s);
    }
```

#### Lambda表达式+Stream API

```java
package com.example.book.leetcode;

import com.example.book.chapter3.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: modige
 * @date: 2022/6/2 9:42
 * @description:
 */
public class Lambda {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        for(int i=0;i<5;i++){
            Employee e = new Employee();
            e.setName("modige"+i);
            e.setAge(20+i*5);
            e.setSalary(4000+i*300.0);
            employees.add(e);
        }
        List<Employee> emps = new ArrayList<>();
        employees.stream()
                .filter((employee -> employee.getAge()>20))
                .limit(4)


                .forEach(x->emps.add(x));
        System.out.println(emps);


    }



}
```

#### 深拷贝&浅拷贝

```java
List<Integer> res = new ArrayList();
//浅拷贝,此时对于copy进行操作同时会改变res
List<Integer> copy = res;
//或
List<Integer> copy = new ArrayList();
copy = res
    
//深拷贝，新声明一个List，并将res中的元素拷贝给copy
//对copy的操作不会影响res
List<Integer> copy = new ArrayList(res);
```

#### 数组比较

Arrays.equals(a,b)

按位比较a,b中的元素，全部相等返回true，否则返回false.

如果只是想比较元素值而不在意元素顺序，可以对两个数组排序后进行比较

#### 随机数

```java
int x = (int) (Math.random() * total) + 1;
```

#### 二分查找

```java
 private int binarySearch(int x) {
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
```

#### 求二叉树高度

```java
   public void firstOrder(TreeNode root,HashMap<Integer,Integer>map,int height){

        if(!map.containsKey(height)){
            map.put(height,root.val);
        }
        if(root.left!=null) firstOrder(root.left,map,height+1);
        if(root.right!=null) firstOrder(root.right,map,height+1);

    }
```

#### 参数传递

* 基本数据类型：值传递
* 引用数据类型：地址传递

```java
public class VariousTest {
    public static void main(String[] args) {
        int b=0;
        change(b);
        System.out.println(b);
    }

    public static void change(int []b){
        b++;
    }

}
```

当传递的参数是基本数据类型时，传的是b的值的一个副本，函数中对b进行的修改不会影响到b原来的值，此处输出0

```java
public class VariousTest {
//    static int a = 0;

    public static void main(String[] args) {

        int b[] = {0};
        change(b);
        System.out.println(b[0]);
    }
    public static void change(int []b){
        b[0]++;
    }

}
```

当传递的是引用数据类型时（比如数组），传递的是变量的地址，在函数中对变量修改后会永久保存，此时输出1

## Python

#### 输入

```python
a = input()
```

#### 遍历字母

[牛妹的字符串](https://www.nowcoder.com/question/next?pid=35148606\&qid=2335440\&tid=55752678)

```
def processStr(s , k):
    minChar = 'a'
    while k>0:
        for i in range(ord(minChar),ord('z')+1):
            if chr(i) in s:
                s = s.replace(chr(i),"")
                minChar = chr(i)
                break
        k -= 1
    return s
```
