# 1-3 知识点

 ### ## 1.javac

javac 把java 程序编译成字节码，java 运行javac产生的.class

* 在命令行使用javac之后，如果源代码有package会报无法加载主类的错误
* javac执行成功后会生成.class文件，之后通过java执行时不加.class后缀

正例 java HelloJava

反例：java HelloJava.class

###  main方法须声明为public,必须为静态

## 2.基本数据类型

8种

### 整型

* long 8

* int 4
* short 2
* byte 1

长整型有后缀L        4325352L

十六进制有前缀0x

八进制有前缀0

### 浮点

float 4   有后缀F

double 8  默认为无后缀的浮点数

### char

单个字符

### boolean

### 常量

* java 利用关键字final生命常量

* 例如

```java
final int AGE = 30 ;
```

* 关键字final表示这个变量只能被赋值一次，一旦被赋值就不能更改了，习惯上常量名使用大写
* java中经常希望在一个类的多个方法中使用某个常量，通常讲这些常量称为类常量，例

```java
public static final double CCC = 3.3 
```

* 类常量的定义位于main方法的外部，因此，在同一个类的其他方法也可以使用，而且如果被声明为public,其他类也可以使用

### 位运算

* 与运算 & ，可以利用2的幂进行位屏蔽，例如n&8可以屏蔽除了右数第四位以外的位
* 或运算 |
* 异或 ^
* 非 ~
* 右移 >>
* 左移 <<
* 》》》高位用0填充

### 数学函数

Math类中的方法

* sqrt()平方根
* pow(x,a) x 的a次幂
* 三角函数 sin cos tan...
* 指数函数exp（）
* 对数函数 log()
* PI  E圆周率和自然常数近似值

### 类型转换

* double + 其他 = double
* 否则 float + 其他 = float
* 否则 long + 其他 = long
* 否则两者都转为int

### 强制类型转换

强制将一个数值转换为另一种，又超出了目标类型的表示范围就会截断为一个完全不同的制如  （byte ）300 = 40

### 优先级

+=右优先

a+=b+=c  = a+=(b+=c)

### 枚举类型

有时候，变量的取值只在一个有限的集合内，例如披萨只有大中小三种尺寸，如果使用普通变量，可能会保存一个错误的值，这时可以使用枚举类型

枚举类型包含有限个命名的值

例如：

```java
enum Size{SMALL,MEDIUM,LARGE};
//现在可以声明一个这种变量
Size s = Size.MEDIUM;
```

### 数组

#### 定义

两种方法

* int[]a
* int a []

#### 初始化

* int [] a = {1};

#### 匿名数组

new int[]{1}

#### 数组拷贝

int  [] b =Arrays.copyOf(a,a.length) 

### 命令行参数

main函数有一个字符串数组的形参

在命令行运行程序时可以传参

java Test -hello world





 

1-3 知识点

### 1.javac

javac 把java 程序编译成字节码，java 运行javac产生的.class

- 

  在命令行使用javac之后，如果源代码有package会报无法加载主类的错误

- 

  javac执行成功后会生成.class文件，之后通过java执行时不加.class后缀

正例 java HelloJava

反例：java HelloJava.class

### main方法须声明为public,必须为静态

## 2.基本数据类型

8种

### 整型

- 

  long 8

- 

  int 4

- 

  short 2

- 

  byte 1

长整型有后缀L 4325352L

十六进制有前缀0x

八进制有前缀0

### 浮点

float 4 有后缀F

double 8 默认为无后缀的浮点数

### char

单个字符

### boolean

### 常量

- 

  java 利用关键字final生命常量

- 

  例如

1

final int AGE = 30 ;



Copied!

- 

  关键字final表示这个变量只能被赋值一次，一旦被赋值就不能更改了，习惯上常量名使用大写

- 

  java中经常希望在一个类的多个方法中使用某个常量，通常讲这些常量称为类常量，例

1

public static final double CCC = 3.3 



Copied!

- 

  类常量的定义位于main方法的外部，因此，在同一个类的其他方法也可以使用，而且如果被声明为public,其他类也可以使用

### 位运算

- 

  与运算 & ，可以利用2的幂进行位屏蔽，例如n&8可以屏蔽除了右数第四位以外的位

- 

  或运算 |

- 

  异或 ^

- 

  非 ~

- 

  右移 >>

- 

  左移 <<

- 

  》》》高位用0填充

### 数学函数

Math类中的方法

- 

  sqrt()平方根

- 

  pow(x,a) x 的a次幂

- 

  三角函数 sin cos tan...

- 

  指数函数exp（）

- 

  对数函数 log()

- 

  PI E圆周率和自然常数近似值

### 类型转换

- 

  double + 其他 = double

- 

  否则 float + 其他 = float

- 

  否则 long + 其他 = long

- 

  否则两者都转为int

### 强制类型转换

强制将一个数值转换为另一种，又超出了目标类型的表示范围就会截断为一个完全不同的制如 （byte ）300 = 40

### 优先级

+=右优先

a+=b+=c = a+=(b+=c)

### 枚举类型

有时候，变量的取值只在一个有限的集合内，例如披萨只有大中小三种尺寸，如果使用普通变量，可能会保存一个错误的值，这时可以使用枚举类型

枚举类型包含有限个命名的值

例如：

1

enum Size{SMALL,MEDIUM,LARGE};//现在可以声明一个这种变量Size s = Size.MEDIUM;



Copied!

### 数组

**定义**

两种方法

- 

  int[]a

- 

  int a []

**初始化**

- 

  int [] a = {1};

**匿名数组**

new int[]{1}

**数组拷贝**

int [] b =Arrays.copyOf(a,a.length)

### 命令行参数

main函数有一个字符串数组的形参

在命令行运行程序时可以传参

java Test -hello world



## 权限修饰符

作用域

当前类

同一包

其他包的子孙类

其他包的类

public

√

√

√

√

protected

√

√

√

×

friendly

√

√

×

×

private

√

×

×

×





![img](https://2468732199.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2F2O7gJns9kXvSQmqxeoqU%2Fuploads%2FSl6lm6zhR4MSfLq6RzVX%2Fimage.png?alt=media&token=ad65f958-5fcf-4e80-a177-28ca603a7137)

## 思路

- 

  中序遍历搜索二叉树，使用队列存放结点

- 

  取出队列中的结点，构建双向链表

## 代码

```JAVA
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root==null) return root;
        Node pre = new Node(-1);
        Node a = pre;
        Queue <Node> q = new LinkedList<>();
        InOrderTraverse(root,q);
        for(Node n:q){
            pre.right = n;
            n.left = pre;
            pre = n;
        }
        pre.right = a.right;
        a.right.left = pre;
        return a.right;
    }

    void InOrderTraverse(Node root,Queue<Node> q){
        if(root!=null){
            InOrderTraverse(root.left,q);
            q.offer(root);
            InOrderTraverse(root.right,q);
        }
    }

    
}
```

