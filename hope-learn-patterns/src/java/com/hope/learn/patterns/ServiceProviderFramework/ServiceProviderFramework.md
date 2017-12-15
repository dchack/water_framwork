####  服务提供者框架  
服务提供者框架中有三个重要的组件：  
服务接口（Service Interface），这是提供者实现的；    
提供者注册API（Provider Registration API），这是系统用来注册实现，让客户端访问它们的；   
服务访问API（Service Access API）  

第四个组件是可选的：  
服务提供者接口（Service Provider Interface），这些提供者负责创建其服务实现的实例  

对于JDBC来说，Connection就是它的服务接口，DriverManager.registerDriver是提供者注册API，DriverManager.getConnection是服务访问API，Driver就是服务提供者接口。  
