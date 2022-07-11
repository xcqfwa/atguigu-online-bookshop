>  开发时间：2022.02.17 - 2022.04.19

# 一、快速开始

方案一：

1. 克隆仓库：使用 Git 克隆仓库或直接下载仓库压缩包到您的计算机
2. 打开工程：使用 `IntelliJ IDEA`  打开克隆的仓库或解压的工程文件，而后使用 `Maven` 工具更新工程依赖
3. 创建数据库和表并插入数据：登录 MySQL ，创建 `online_bookstore` 数据库，将 `src/main/resources/online_bookstore.sql` 文件中的数据库表导入 online_bookstore 数据库中
4. 修改数据库连接信息：修改 `src/main/resources/druid.properties` 中的数据库连接信息，设置你自己的用户名和密码 
5. 部署访问：在 IntelliJ IDEA 中部署 `Tomcat` 服务器即可访问在线书城首页
6. 登录系统：默认用户名和密码均为 `admin`

方案二：

1. 克隆仓库：使用 Git 克隆仓库或直接下载仓库压缩包到您的计算机

2. 拷贝 war 包：将 `RELEASE` 目录下的 `online-bookstore.war` 包拷贝到 `Tomcat` 安装目录下的 `webapps` 目录中

3. 创建数据库和表并插入数据：登录 MySQL，创建 `online_bookstore` 数据库，将 `RELEASE/online_bookstore.sql` 文件中的数据库表导入 online_bookstore 数据库中

4. 创建数据库用户：在 MySQL 控制台创建 `admin` 用户，密码也为 `admin`，并赋予 admin 用户所有操作权限

   ```sql
   create user 'admin'@'localhost' identified by 'admin';
   grant all on online_bookhouse.* to 'admin'@'localhost' with grant option;
   ```

5. 启动 Tomcat：双击 `Tomcat` 安装目录下 `bin` 目录中的 `startup.bat` 启动 Tomcat

6. 访问首页：在浏览器地址栏输入 `http://localhost:8080/online-bookstore/` 即可访问在线书城首页

7. 登录系统：默认用户名和密码均为 `admin`

# 二、功能演示

## 1、用户登录
使用正则表达式验证用户输入的信息是否合法，不合法则阻止表单提交；当用户点击登录时，通过表单请求服务器 UserServlet 中的 login 方法，由服务器辨别用户名密码正确性，从而完成用户登录功能

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/fdcfc2e0507f4050ad67ac8caeded87d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 2、用户注册

1. 根据用户输入的信息，首先使用正则表达式验证各表单项内容不允许为空且符合特定格式要求
2. 给用户名输入框绑定失去焦点事件，使用 jQuery 版本的 AJAX 向服务器发起异步请求验证用户名是否存在，存在则提醒用户重新输入用户名，信息一切正常则由服务器保存用户信息并返回到登录页面
3. 图片验证码使用谷歌的 `kaptcha-2.3.2.jar` 生成，由客户端访问服务器 `verifyCode.jpg` 请求获取验证码，同时给验证码图片绑定单击事件，当用户点击图片时刷新验证码

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/fc31a6639bf841c79eec2eb36ad49618.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 3、尚书房首页

1. 从服务器的 Session 域中获取登入系统的用户信息，并回显在界面上
2. 主页提供用户购物车、图书管理、退出登录等功能的入口
3. 用户进入主页时默认从服务器查询第一页的图书信息并显示在页面上，同时提供分页查看图书信息的功能
4. 用户可以根据价格区间对图书信息进行筛选，同时回显用户购物车中的信息以及用户上一次添加到购物车的图书名称
5. 当用户退出登录系统时返回默认主页，可浏览图书信息

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/f6d1846c758e4746a42515b965c53b7c.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 4、图书筛选
根据价格区间过滤图书信息，并演示添加到购物车功能，购物车的数据保存到服务器 Session 域中，不作数据库保存

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/a176e55aa5ff41edb9e9da33cf334089.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 5、购物车

1. 购物车提供返回商城功能
2. 购物车中需显示用户本次登录添加到购物车中的商品信息，若购物车中无商品，则友好提示用户返回商城
3. 购物车中需提供删除购物车项、清空购物车、结账等功能

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/3d4f5d6e1aaf4aab8a8907968126a124.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


   ![在这里插入图片描述](https://img-blog.csdnimg.cn/f0d0aae3efcc40fc877b47391aeab1ba.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 6、结账页面
显示用户本次下单所购买的商品信息和由服务器生成的独一无二的订单号

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/4ca3816868904fe8ba7aa0eb00efed83.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 7、图书管理

1. 提供修改图书信息的功能，更新的图书数据保存到数据库，同时提供删除图书功能
2. 提供添加图书功能，跳转到图书编辑页面
3. 根据服务器图书数据库表中的信息分页显示图书数据

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/82c1de91315c43b890db5450f2efc81d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 8、图书编辑
可修改图书数据并提交到数据库保存

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/ab971be9e3f848c2b8e00cc4ded3f630.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)
