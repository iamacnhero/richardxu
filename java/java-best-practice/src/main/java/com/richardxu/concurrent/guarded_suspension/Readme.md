### Guarded Suspension 模式

Guarded Suspension 意为保护暂停，其核心思想是仅当服务进程准备好时，才提供服务。

#### Guarded Suspension 模式的结构
主要成员有：
 - Request对象：封装了客户端的请求
 - RequestQueue对象：表示客户端请求队列
 - ClientThread对象：负责不断发起请求，并将请求对象放入请求队列
 - ServerThread对象：根据自身状态，在有能力处理请求时，从RequestQueue中提取请求对象加以处理。

