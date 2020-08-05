# sentinel服务限流、降级、热点

## 启动dashboard后台
<br>java -Dserver.port=18080 -Dcsp.sentinel.dashboard.server=localhost:18080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.7.2.jar
<br> dashboar.server: 限流服务地址，端点进行注册时需要向该地址注册
## 启动sentinel端点
<br>端点和控制后台的交互是通过指定的端口进行（默认8719）
<br>使用@SentinelResource注解进行端点注册

