# 一、功能演示
## 1.1、用户登录
> 使用正则表达式验证用户输入的信息是否合法，不合法则阻止表单提交；当用户点击登录时，通过表单请求服务器 UserServlet 中的 login 方法，由服务器辨别用户名密码正确性，从而完成用户登录功能

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/fdcfc2e0507f4050ad67ac8caeded87d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 1.2、用户注册

   > 1. 根据用户输入的信息，首先使用正则表达式验证各表单项内容不允许为空且符合特定格式要求
   > 2. 给用户名输入框绑定失去焦点事件，使用 jQuery 版本的 AJAX 向服务器发起异步请求验证用户名是否存在，存在则提醒用户重新输入用户名，信息一切正常则由服务器保存用户信息并返回到登录页面
   > 3. 图片验证码使用谷歌的 `kaptcha-2.3.2.jar` 生成，由客户端访问服务器 `verifyCode.jpg` 请求获取验证码，同时给验证码图片绑定单击事件，当用户点击图片时刷新验证码

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/fc31a6639bf841c79eec2eb36ad49618.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 1.3、尚书房首页

   > 1. 从服务器的 Session 域中获取登入系统的用户信息，并回显在界面上
   > 2. 主页提供用户购物车、图书管理、退出登录等功能的入口
   > 3. 用户进入主页时默认从服务器查询第一页的图书信息并显示在页面上，同时提供分页查看图书信息的功能
   > 4. 用户可以根据价格区间对图书信息进行筛选，同时回显用户购物车中的信息以及用户上一次添加到购物车的图书名称
   > 5. 当用户退出登录系统时返回默认主页，可浏览图书信息

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/f6d1846c758e4746a42515b965c53b7c.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 1.4、图书筛选
> 根据价格区间过滤图书信息，并演示添加到购物车功能，购物车的数据保存到服务器 Session 域中，不作数据库保存

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/a176e55aa5ff41edb9e9da33cf334089.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 1.5、购物车

   > 1. 购物车提供返回商城功能
   > 2. 购物车中需显示用户本次登录添加到购物车中的商品信息，若购物车中无商品，则友好提示用户返回商城
   > 3. 购物车中需提供删除购物车项、清空购物车、结账等功能

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/3d4f5d6e1aaf4aab8a8907968126a124.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


   ![在这里插入图片描述](https://img-blog.csdnimg.cn/f0d0aae3efcc40fc877b47391aeab1ba.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 1.6、结账页面
> 显示用户本次下单所购买的商品信息和由服务器生成的独一无二的订单号

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/4ca3816868904fe8ba7aa0eb00efed83.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 1.7、图书管理

   > 1. 提供修改图书信息的功能，更新的图书数据保存到数据库，同时提供删除图书功能
   > 2. 提供添加图书功能，跳转到图书编辑页面
   > 3. 根据服务器图书数据库表中的信息分页显示图书数据

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/82c1de91315c43b890db5450f2efc81d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


## 1.8、图书编辑
> 可修改图书数据并提交到数据库保存

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/ab971be9e3f848c2b8e00cc4ded3f630.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU3ByaW5nLV8tQmVhcg==,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)