### 外观模式

#### 定义
为子系统中的一组接口提供一个一致的界面，Facade(外观)模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。

这里的界面主要是指：从一个组件外部来看这个组件，能够看到什么，这就是这个组件的界面，也就是所说的外观。
这里提到的接口主要是指：外部和内部交互的一个通道，通常是指一些方法，可以是类的方法，也可以是interface的方法。

外观模式就是通过引入一个外观类，在这个类里面定义客户端想要的简单的方法，然后在这些方法的实现里面，
由外观类再去分别调用内部的多个模块来实现功能，从而让客户端变得简单。这样一来，客户端就只需要和外观类交互就可以了。

#### 结构
 - Facade: 定义子系统的多个模块对外的高层接口，通常需要调用内部多个模块，从而把客户的请求代理给适当的子系统对象。
 - 模块: 接受Facade对象的委派，直正实现功能，各个模块之间可能有交互。
 注意：Facade对象知道各个模块，但是各个模块不应该知道Facade对象。

#### 外观模式的目的
不是给子系统添加新的功能接口，而是为了让外部减少与子系统内多个模块的交互，松散耦合，从而让外部能够更简单地使用子系统。 

#### 实现
 - 可以实现为一个单例。
 - 也可以直接把外观中的方法实现成为静态方法，不需要创建外观对象的实例而直接调用，相当于把外观类当成一个辅助工具类实现。
 - Facade 可以实现成为interface，会增加系统的复杂度，但这样有一个好处，就是能够有选择性的暴露接口的方法，尽量减少模块对子系统外提供的接口方法。
 
### 优缺点
#### 优点
 - 松散耦合
 - 简单易用
 - 更好地划分访问的层次 

#### 缺点
 - 过多的或者是不合理的Facade也容易让人迷惑。到底是调用Facade好呢，还是直接调用模块好。

#### 本质
封装交互，简化调用