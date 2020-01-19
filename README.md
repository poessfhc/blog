
# poe_blog团队博客
### 项目框架
- 框架框架
  1. 项目基于springboot
  2. 持久层框架目前使用mybatis
  3. 数据库统一使用mysql5.7
  4. 项目安全框架使用shiro
### 权限认证使用方式方式
- 权限认证
  1. 通过shiro进行每个接口的权限认证
  2. 大致方式为登录获取token，通过token放入请求头，例如key为authToken，value为8a754c58-7351-4cf0-a41d-fd6a7fd9320d得到user用户的信息
  3. 得到用户的信息，随后通过用户获取角色，随后通过角色获取权限code
  4. 通过接口上的注解，例如@RequiresPermissions("user:test")得到所需要的code，如果用户没有此code，则无法正常使用这个接口
  5. 详细写法请看shiroCofig配置
  6. 数据还未详细测试，有bug尽快说，啊哈