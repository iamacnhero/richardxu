## lambda 表达式

### 1.1 为什么要使用lamba表达式
**"lamba表达式"** 是一段可以传递的代码，因此它可以被执行一次或多次。

### 1.2 lamba表达式的语法
Java中lamba表达式的格式：参数、箭头->，以及一个表达式。如果负责计算的代码无法用一个表达式表示，那么可以用编写方法的方式来编写：即用{}包裹代码并明确使用return语句，如：
```java
(String first, String second) -> {
    if (first.length() < second.length()) return -1;
    else if (first.length() > second.length()) return 1;
    else return 0;
}
```

不需要为一个lambda表达式执行返回类型，它会从上下文中被推导出来，如表达式：
```java
(String first, String second) -> Integer.compare(first.length(), second.length())
```

### 1.3 函数式接口
对于只包含一个抽象方法的接口，可以通过lambda表达式来创建该接口的对象，这种接口被称为**函数式接口**。
最好将一个lambda表达式想象成一个函数，而不是一个对象，它可以被转换成一个函数式接口：
```java
String[] strings = {"aaad", "bbbff", "ccc"};
Arrays.sort(strings, (first, second) -> Integer.compare(first.length(), second.length()));
System.out.println(Arrays.toString(strings));
```

Java API 在java.util.function包中定义了许多非常通用的函数式接口。

### 1.4 方法引用
表达式System.out:println是一个方法引用，::操作符将方法名和对象或类的名字分隔开来，以下是3种主要的使用情况：
- 对象::实例方法
- 类::静态方法
- 类::实例方法
示例：
```java
String[] strings = {"aaad", "bbbff", "ccc"};
Arrays.sort(strings, String::compareToIgnoreCase);
System.out.println(Arrays.toString(strings));
```
在前两种情况中，方法引用等同于提供参数的lambda表达式。如：Math::pow等同于(x, y) -> Math.pow(x, y)。
在第三种情况中，第一个参数会成为执行方法的对象。如：String::compareToIgnoreCase等同于(x, y) -> x.compareToIgnoreCase(y)。

你还可以捕获方法引用中的this参数。如this::equals等同于x -> this.equals(x)。
还可以使用super对象，以下方法表达式：
```java
super::实例方法
```
会使用this作为执行方法的对象，并调用父类中指定的方法。示例：
```java
class Greeter {
    public void greet() {
        System.out.println("Hello world!");
    }
}

class ConcurrentGreeter extends Greeter {
    public void greet() {
        Thread t = new Thread(super::greet);
        t.start();
    }
}
```
当线程启动时，会调用它的Runnable方法，然后执行super::greet并调用父类中的greet方法。

### 1.5 构造器引用
构造器引用与方法引用类似，不同的是在构造器引用中方法名是new。如Button::new表示Button类的构造器引用。

### 1.6 变量作用域
我们希望能在lambda表达式的闭合方法或类中访问其他的变量，如：
```java
public static void repeatMsg(String text, int count) {
    Runnable r = () -> {
        for (int i = 1; i < count+1; i++) {
            System.out.println(i + ": " + text);
            Thread.yield();
        }
    };
    new Thread(r).start();
}
```
调用：repeatMsg("hello", 100);

在lambda表达式中，被引用的变量的值不可以被更改。

lambda 表达式的方法体与**嵌套代码块有着相同的作用域**。因此也适用同样的命名冲突和屏蔽规则。在 lambda 表达式中不允许声明一个与局部变量同名的参数或者局部变量。如：
```java
Path first = Paths.get("/usr/bin");
// 错误, 变量first已经被定义了
Comparator<String> comp = 
        (first, second) -> Integer.compare(first.length(), second.length());
```

### 1.7 默认方法
Java 设计者们希望允许接口包含带有具体实现的方法(称为默认方法)，这些方法可以被安全地添加到已有的接口中。
在Java 8中，通过默认方法机制，forEach方法已被添加到Iterable接口中，如下：
```java
default void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action);
    for (T t : this) {
        action.accept(t);
    }
}
```

### 1.8 接口中的静态方法
在Java 8中，你可以为接口添加静态方法。例如，Comparator接口提供了一个comparing方法，它接收一个“键提取”函数，并产生一个用来比较所提取出的键的比较器。如要根据名称对Person对象进行比较，可以使用函数 Comparator.comparing(Person::get name)。

