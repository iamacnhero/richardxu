### 单例模式(Singleton)

#### 定义
保证一个类仅有一个实例，并提供一个访问它的全局访问点。

#### 双重加锁机制：
并不是每次进入getInstance方法都需要同步，而是先不同步，进入方法过后，先检查实例是否存在，如果不存在才进入下面的同步块，这是第一重检查。进入同步块过后，再次检查实例是否存在，如果不存在，就在同步块的情况下创建一个实例，这是第二重检查。

#### 本质
单例模式的本质：控制实例数目