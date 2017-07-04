# spring-microservices

### 操作方式
- 先啟動 eureka-server，啟動後進入 [eureka server 管理介面](http://localhost:1111/)，目前尚未有任何的 instance 註冊
- 啟動 calculate-prem-client、calculate-prem-client2、load-balanced-clien-feign、load-balanced-clien-rest-template
 ，啟動完後重新整理 [eureka server 管理介面](http://localhost:1111/) 會看到已註冊 4 個 instance
- LOAD-BALANCED-FEIGN-SERVICE: [http://localhost:2220/calculate/3/6](http://localhost:2220/calculate/3/6)
- LOAD-BALANCED-REST-TEMPLATE-SERVICE: [http://localhost:3000/calculate/3/6](http://localhost:2220/calculate/3/6)