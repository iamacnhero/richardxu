### Future 模式

主要成员有：
 - Main：系统启动，调用Client发出请求
 - Client：返回Data对象，立即返回FutureData，并开启ClientThread线程装配RealData
 - Data：返回数据的接口
 - FutureData：Future数据，构造很快，但是是一个虚拟的数据，需要装配RealData
 - RealData：真实数据，其构造是比较慢的