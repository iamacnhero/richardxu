## Stream API

Stream 是Java 8中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，但是将执行操作的时间交给具体实现来决定。

### 2.1 从迭代器到 Stream 操作
```java
// 统计一本书的长单词
String contents = new String(
        Files.readAllBytes(Paths
                .get("/Users/xufeng/DEV/dubbo-master/dubbo-admin/dubbo-governance.log")),
        StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

int count = 0;
for (String w : words) {
    if (w.length() > 12) {
        count++;
    }
}
System.out.println(count);

long counts = words.stream().filter(w -> w.length() > 12).count();
System.out.println(counts);
```
stream 方法会为单词列表生成一个Stream。filter方法会返回另一个只包含单词长度大于12的Stream。count方法会将Stream化简为一个结果。
Stream与集合的区别：
 - Stream 自己不会存储元素
 - Stream 操作符不会改变源对象，相反，它们会返回一个持有结果的新 Stream
 - Stream 操作符可能是延迟执行的。这意味着它们会等到需要结果的时候才执行
Stream 还很容易进行并行执行，如下一段并行统计长单词的代码：
```java
long counts = words.parallelStream().filter(w -> w.length() > 12).count();
```
只需要将Stream 方法改成 parallelStream 方法，就可以让 Stream API并行执行过滤和统计操作。

Stream 遵循“做什么，而不是怎么去做”的原则。
当使用Stream时，通过三个阶段来建立一个操作流水线：
 - 创建一个Stream
 - 在一个或多个步骤中，指定将初始Stream转换为另一个Stream 的中间操作
 - 使用一个终止操作来产生一个结果。该操作会强制它之前的延迟操作立即操行。在这之后，该Stream就不会再被使用了。

### 2.2 创建 Stream
通过Java 8在Collection接口中新添加的stream方法，可以将任何集合转化为一个Stream。如果面对的是一个数组，可以用静态的Stream.of方法将它转化为一个Stream：
```java
// split方法会返回一个String[]数组
Stream<String> words = Stream.of(contents.split("[\\P{L}]+"));
```
of 方法接受变长的参数，因此你可以构造一个含有任意个参数的Stream:
```java
Stream<String> song = Stream.of("gently", "down", "the", "stream");
```

创建一个不包含任何元素的Stream，可以使用静态的Stream.empty方法：
```java
Stream<String> silence = Stream.empty();
```