## 日期和时间 API

### 要点
 - 所有 java.time 对象都是不可变的。
 - 一个瞬间（Instant）是时间线上的一个点
 - 在Java事件中，每天都是86400秒（即没有闰秒） 
 - 持续时间（Duration）是两个瞬间之间的时间
 - LocalDateTime 没有时区信息
 - TemporalAjuster 的方法可以处理常用的日历计算，例如找到某个月的第一个星期二
 - ZoneDateTime 是指定时区中的某一个时间点（类似于Gregorian Calendar）
 - 当处理带时区的时间时，请使用时段（Period），而非Duration，以便将夏令时的变化考虑在内
 - 使用 DateTimeFormatter 来格式化和解析日期和时间
 
### 时间线
在1967年，科学家们根据铯133原子的固有属性重新对“1秒”进行了精确的定义，同时与历史定义相匹配。此后，官方时间一直由原子钟网络所保持。

Java 日期和时间API规范要求Java使用如下时标：
 - 每天都有86400秒
 - 每天正午与官方时间准确匹配
 - 其他时间也要以一种精确定义的方式与其紧急匹配
 
原点（我们也称之为“元年”）被规定为1970年1月1日的午夜，此时本初子午线正在穿过伦敦格林威治皇家天文台。UNIX/POSIX时间也使用了一样的约定。
从原点开始，时间按照每天86400秒进行计算，向前向后分别以纳秒为单位。
```java
System.out.println(Instant.MAX);        // 10亿年前
System.out.println(Instant.MIN);        // 10亿年后

// 计算两个瞬时点之间的时间距离: Duration.betwen
Instant start = Instant.now();
for (int i = 0; i < 100000L; i++) {
    // heavy task
    URL url = new URL("http://www.baidu.com");
    URLConnection connection = url.openConnection();
}
Instant end = Instant.now();
Duration timeElapsed = Duration.between(start, end);
long millis = timeElapsed.toMillis();
System.out.println(millis + "ms");
```

Instant 和 Duration 类都是不可变的，它们的所有方法，如multipliedBy或minus都会返回一个新的实例。

### 本地日期
在新的Java API中，有两种时间：本地日期/时间和带时区的时间。 API的设计者推荐使用不带时区的时间。
LocalDate 是一个带有年份、月份、当月天数的日期。
```java
// 创建一个LocalDate，可以使用静态方法 now 或者 of
LocalDate today = LocalDate.now();
System.out.println(today);

LocalDate birthday = LocalDate.of(1981, 1, 1);
System.out.println(birthday);
birthday = LocalDate.of(1981, Month.JANUARY, 1);
System.out.println(birthday);

// 程序员日是一天中的第256天        
LocalDate programmerDay = LocalDate.of(2014, 1, 1).plusDays(255);
```

