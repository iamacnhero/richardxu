## 对象 (Objects)
### 原型 (Prototype)
每个对象都连接到一个原型对象，并且它可以从中继承属性。所有通过对象字面量创建的对象都连接到 Object.prototype ，它是 JavaScript 中的标配对象。

如果我们尝试云获取对象的某个属性值，但该对象没有此属性值，那么 JavaScript 会试着从原型对象中获取属性值。如果原型对象也没有该属性，那么再从它的原型中寻找，依此类推，直到该过程最后到达终点 Object.prototype 。如果想要的属性完全不存在于原型链中，那么结果就是 undefined 值。这个过程称为委托。

### 反射 (Reflection)
typeof 操作符可用来确定属性的类型：
```javascript
var flight = {
  airline: "Oceanic",
  number: 815,
  departure: {
    IATA: "SYD",
    time: "2004-09-22 14:55",
    city: "Sydney" 
  },
  arrival: {
    ITATA: "LAX",
    time: "2004-09-23 10:42",
    city: "Los Angeles"
  }
};

console.log(typeof flight.number);          // number
console.log(typeof flight.departure);       // object
console.log(typeof flight.dd);              // undefined
// 注意：原型链中的任何属性都会产生值
console.log(typeof flight.toString);        // function
console.log(typeof flight.constructor);     // function

// 如果对象拥有独有的属性，可使用hasOwnProperty 方法，它不会检查原型链
console.log(flight.hasOwnProperty('number'));         // true
console.log(flight.hasOwnProperty('constructor'));    // false
``` 

### 枚举 (Enumeration)
for in 语句可用来遍历一个对象中的所有属性名。该枚举过程会列出所有的属性——包括函数和原型中的属性——所以有必要过滤掉那些你不想要的值。常用的过滤器是 hasOwnProperty 方法，以及使用 typeof 来排除函数：
```javascript
var name;
for (name in flight) {
  if (typeof flight[name] !== 'function') {
    document.writeln(name + ': ' + flight[name]);
  }
}
```
属性名出现的顺序是不确定的。如果想确保属性以特定的顺序出现，最好的办法是创建一个数组，在其中以正确的顺序包含属性名：
```javascript
var i;
var properties = ['airline', 'departure', 'number'];
for (i=0; i<properties.length; i++) {
  document.writeln(name + ': ' + flight[properties[i]]);
}
```

### 删除
delete 运算符可用来删除对象的属性。
```javascript
delete flight.airline;
```

### 减少全局变量污染
JavaScript 可以很随意地定义全局变量来容纳应用的所有资源。但全局变量消弱了程序的灵活性，应该避免使用。

最小化使用全局变量的方法之一是只创建一个唯一的全局变量：
```javascript
var MYAPP = {};
MYAPP.stooge = {
  "first-name": "Joe",
  "last-name": "Howard"
}
```
该变量此时变成了应用的容器。只要把全局性的资源都纳入一个名称空间之下，你的程序与其他应用程序、组件或类库之间发生冲突的可能性就会显著降低。


## 函数 Function
### 函数对象 Function Objects
JavaScript 中的函数就是对象。对象是KV对的集合并拥有一个连到原型对象的隐藏连接。对象字面量产生的对象连接到 Object.prototype 。函数对象连接到 Function.prototype (该原型对象本身连接到 Object.prototype)。

因为函数是对象，所以它们可以像任何其他的值一样被使用。函数可以保存在变量、对象和数组中。函数可以被当做参数传递给其他函数，函数也可以再返回函数。而且，因为函数是对象，所以函数可以拥有方法。

### 函数字面量 Function Literal
函数对象通过函数字面量来创建：
```javascript
var add = function(a, b) {
  return a + b;
};
```
通过函数字面量创建的函数对象包含一个连到外部上下文的连接。这被称为闭包(closure)。

### 调用 Invocation
除了声明时定义的形参，每个函数还接收两个附加的参数： this 和 arguments 。this 的值取决于调用的模式。

### 方法调用模式 The Method Invocation Pattern
当一个函数被保存为对象的一个属性时，称它为一个方法。当一个方法被调用时，this 被绑定到该对象。
```javascript
var myObject = {
  value: 0,
  increment: function(inc) {
    this.value += typeof inc === 'number' ? inc : 1;
  }
};

myObject.increment();
document.writeln(myObject.value);     // 1

myObject.increment(2);
document.writeln(myObject.value);     // 3
```

### 函数调用模式 The Funtion Invocation Pattern
当一个函数并非一个对象的属性时，那么它就是被当做一个函数来调用的：
```javascript
function add(a, b) {
  return a + b;
}
var sum = add(3, 4);
```
以此模式调用函数时，this 被绑定到全局对象。这是语言设计上的一个错误。有一个很容易的解决方案：如果该方法定义一个变量并给它赋值为 this，那么内部函数就可以通过那个变量访问到this。按照约定，把那个变量命名为 that :
```javascript
var myObj = {
  value: 3
};

myObj.double = function() {
  var that = this;        // 解决方法

  var helper = function() {
    that.value = add(that.value, that.value);
  }

  helper();               // 以函数的形式调用 helper
}
// 以方法的形式调用 double
myObj.double();
document.writeln(myObj.value);
```

### 构造器调用模式 The Constructor Invocation Pattern
JavaScript 是一门基于原型继承的语言。这意味着对象可以直接从其他对象继承属性。该语言是无类型的。

如果在一个函数前面带上 new 来调用，那么背地里将会创建一个连接到该函数的 prototype 成员的新对象，同时 this 会被绑定到那个新对象上。
```javascript
// 创建一个名为 Quo 的构造器函数，它构造一个带有 status 属性的对象
var Quo = function(string) {
  this.status = string;
};

// 给 Quo 的所有实例提供一个名为 get_status 的公共方法
Quo.prototype.get_status = function() {
  return this.status;
};

// 构造一个 Quo 实例
var myQuo = new Quo("confused");
document.writeln(myQuo.get_status());       // 显示 "confused"
```
一个函数，如果创建的目的就是希望结合 new 前缀来调用，那它就被称为*构造器函数*。

### Apply 调用模式 The Apply Invocation Pattern
因为 JavaScript 是一门函数式的面向对象语言，所以函数可以拥有方法。

apply 方法让我们构建一个参数数组传递给调用函数。它也允许我们选择 this 的值。 apply 方法接收两个参数，第1个是要绑定给 this 的值，第2个就是一个参数数组。
```javascript
var arr = [3, 4];
var sum = add.apply(null, arr);   // apply 方法接收两个参数，第1个是要绑定给 this 的值，第2个就是一个参数数组

var statusObj = {
  status: 'A-OK'
};

// statusObj 并没有继承自 Quo.prototype , 但我们可以在 statusObj 上调用 get_status 方法，
// 尽管 statusObj 并没有一个名为 get_status 的方法
var status = Quo.prototype.get_status.apply(statusObj);
console.log(status);            // A-OK
```

### 参数 Arguments
当参数被调用时，会得到一个“免费”配送的参数，那就是 arguments 数组。函数可以通过此参数访问所有它被调用时传递给它的参数列表，包括那些没有被分配给函数声明时定义的形参的多余参数。这使得编写一个无须指定参数个数的函数成为可能：
```javascript
// 构造一个将大量的值相加的函数 
// 注意该函数内部定义的变量 sum 不会与函数外部定义的 sum 产生冲突

```

### 返回 Return
一个函数总是会返回一个值。如果没有指定返回值，则返回 undefined

### 异常 Exceptions
```javascript
function add(a, b) {
  if (typeof a !== 'number' || typeof b != 'number') {
    throw {
      name: 'TypeError',
      message: 'add needs numbers'
    };
  }
  return a + b;
}
```
该 exception 对象将被传递到一个 try 语句的 catch 从句：
```javascript
// 以不正确的方式调用之前的 add 函数
try {
  add("seven");  
} catch (e) {
  document.writeln(e.name + ': ' + e.message);
}
```

### 扩充类型的功能 Augmenting Types
JavaScript 允许给语言的基本类型扩充功能。前面，我们看到通过给 Object.prototype 添加方法，可以让该方法对所有对象都可用。这样的方式对函数、数组、字符串、数字、正则表达式和布尔值都适用。
```javascript
// 通过给 Function.prototype 增加方法，使得该方法对所有函数可用
// 下次给对象增加方法的时候就不必键入 prototype 这几个字符，省掉了一点麻烦
Function.prototype.method = function(name, func) {
  if (!this.prototype[name]) {      // 基本类型的原型是公用结构，保险的做法是在确定没有该方法时才添加它
    this.prototype[name] = func;
  }
  return this;
}

// 通过给 Number.prototype 增加一个 integer 方法，提取数字中的整数部分
Number.method('integer', function() {
  // 根据数字的正负来判断是使用 Math.ceiling 还是 Math.floor 
  return Math[this < 0 ? 'ceil' : 'floor'](this);
});

// 给字符串添加一个移除首尾空白的方法
String.method('trim', function() {
  return this.replace(/^\s+|\s+$/g, '');
});

document.writeln('"' + "   our country  ".trim() + '"');
```

注意， for in 语句用在原型上表现很差。可以使用 hasOwnProperty 方法筛选出继承而来的属性，或者可以查找特定的类型。

### 递归 Recursion
```javascript
// 汉诺塔
var hanoi = function(disc, src, aux, dst) {
  if (disc > 0) {
    hanoi(disc - 1, src, dst, aux);
    document.writeln('Move disc ' + disc + ' from ' + src + ' to ' + dst);
    hanoi(disc - 1, aux, src, dst);
  }
};

hanoi(3, 'Src', 'Aux', "Dst");
```

### 作用域
JavaScript 并不支持块级作用域。 JavaScript 有函数作用域，即定义在函数中的参数和变量在函数外部是不可见的，而在一个函数内部任何位置定义的变量，在该函数内部任何地方都可见。
```javascript
var foo = function() {
  var a = 3, b = 5;
  var bar = function() {
    var b = 7, c = 11;
    // 此时 a = 3, b = 7, c = 11
    a += b + 3;
    // 此时 a = 21, b = 7, c = 11
  };
  // 此时 a = 3, b = 5, 而 c 还没有定义
  bar();
  // 此时 a = 21, b = 5
}
```

### 闭包 Closure
作用域的好处是内部函数可以访问定义它们的外部函数的参数和变量（除了 this 和 arguments ）。

### 模块
可以使用函数和闭包来构造模块。模块是一个提供接口却隐藏状态与实现的函数或对旬。如给String增加一个 deentityify 方法，作用是寻找字符串中的HTML字符实体并把它们替换为对应的字符：
```javascript
String.method('deentityify', function() {
  var entity = {      // 字符实体表
    quot: '"',
    lt: '<',
    gt: '>'
  };

  // 返回 deentityify 方法
  return function() {
    // 这才是 deentityify 方法，它调用字符串的 replace 方法
    return this.replace(/&([^&;]+);/g, function(a, b) {
      var r = entity[b];
      return typeof r === 'string' ? r : a;
    });
  }
}());     // 注意最后一行的()运算符立刻调用我们刚刚构造出来的函数。

document.writeln('&lt;&quot;&gt;'.deentityify());
```
模块模式的一般形式是：一个定义了私有变量和函数的函数；利用闭包创建可以访问私有变量和函数的特权函数；最后返回这个特权函数，或者把它们保存到一个可访问到的地方。
```javascript
var serial_maker = function() {
  // 返回一个用来产生唯一字符串的对象
  // 唯一对象由两部分组成：前缀 + 序列号
  // 该对象包含一个设置前缀的方法，一个设置序列号的方法，和一个产生唯一字符串的 gensym 方法
  var prefix = '';
  var seq = 0;
  return {
    set_prefix: function(p) {
      prefix = String(p);
    },
    set_seq: function(s) {
      seq = s;
    },
    gensym: function() {
      var result = prefix + seq;
      seq += 1;
      return result;
    }
  };
};
var seqer = serial_maker();
seqer.set_prefix('Q');
seqer.set_seq(1000);
for(var i = 0; i < 10; i++) {
  document.writeln(seqer.gensym());
}
```

## 数组 Arrays
### 数组字面量 Array Literals
一个数组字面量是在一对方括号中包围零个或多个用逗号分隔的值的表达式。数组的第一个值将获得属性名'0'，第二个值将获得属性名'1'，依此类推。
```javascript
var empty = [];
var numbers = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
console.log(empty.length);          // 0
console.log(numbers.length);        // 10

// 对象字面量
var numbers_object = {
  0: 'zero', 1: 'one', 2: 'two', 3: 'three', 4: 'four', 5: 'five', 6: 'six', 7: 'seven', 8: 'eight', 9: 'nine'
};
```

### 长度
每个数组都有一个 length 属性。和其他语言不同， JavaScript 数组的 length 是没有上界的。如果你用大于或等于当前 length 的数字作为下标来存储一个元素，那么 length 值会被增大以容纳新元素，不会发生数组越界错误。

通过把下标定为一个数组的当前 length ，可以附加一个新元素到该数组的尾部，有时用 push 方法可以更方便地完成同样的事情：
```javascript
var numbers = ['zero', 'one', 'two', 'three', 'four'];
numbers[numbers.length] = ['five'];
document.writeln(numbers);        // zero,one,two,three,four,five
numbers.push('six');
document.writeln(numbers);        // zero,one,two,three,four,five,six
```

JavaScript 没有一个好的机制来区别数组和对象，但我们可以自定义 is_array 函数来弥补这个缺陷：
```javascript
var numbers_object = {
  0: 'zero', 1: 'one', 2: 'two', 3: 'three', 4: 'four', 5: 'five', 6: 'six', 7: 'seven', 8: 'eight', 9: 'nine'
};
var numbers = ['zero', 'one', 'two', 'three', 'four'];

var is_array = function(value) {
  return Object.prototype.toString.apply(value) === '[object Array]'; 
};

document.writeln(is_array(numbers));          // true
document.writeln(is_array(numbers_object));   // false
```


## 正则表达式 Regular Expressions
