# AndroidTemplate


> 博客地址：[android小咖秀](https://blog.csdn.net/P876643136)

项目初衷
    做开发三五年了。项目也做了些，都是不停地撸码，有自己从0开始的，有从其他人手里接锅的，慢慢的遇到的问题多了起来也就成了经验，自然也就发现很多东西值得整理起来，以备不时之需。随着经验慢慢的有点苗头，开始想要封装一套通用模板框架，用来满足以后项目的开发需求。在这样思索的过程中，恰好网遇了轮子哥，轮子哥早已搭好自己的框架并不断完善，拜读其开源项目(https://github.com/getActivity/AndroidProject)，没啥好说的必须膜拜大神！！在此鼓励大家也都移驾去品读，更好的就赞赏支持个啦哈哈！当然，轮子哥后来在github更新会相对少点，更多的是在其QQ群会项目讲解，需要再找他要最新源码。

项目背景
> github最大的痛点在于，拿到开源项目不会用，导入各种报错，readme看不懂，模块调用花费太多时间

> 当我们日复一日年复一年的搬砖的时候，你是否曾想过提升一下开发效率

> 当项目紧急时候，我们又要如何较为出色的及时完成，如果一个模板的项目摆在你的面前，那么你还会犹豫吗

> 但是做出一个好的模板项目并非易事，有多少人愿意选择去做，还有多少人选择努力去做好，可能寥寥无几，但是你今天看到的，正是你所想要的，轮子哥已经很好的完成了基础，而我将借助巨人的肩膀进行拓展，封装各样工具类模块，组件化综合案例，融合开发中需要的各种小案例！实现一个真正能解决开发新项目时最大痛点的模板工程，不需要再麻木 Copy 原有旧项目的代码，只需改动少量代码就能得到想要的效果，多余的没用上的模块在完成项目后再移除掉，你会发现开发新项目其实是一件很快乐的事


项目集成框架

* 权限请求框架：[https://github.com/getActivity/XXPermissions](https://github.com/getActivity/XXPermissions)

* 标题栏：[https://github.com/getActivity/TitleBar](https://github.com/getActivity/TitleBar)

* 吐司工具类：[https://github.com/getActivity/ToastUtils](https://github.com/getActivity/ToastUtils)

* 状态栏沉浸：[https://github.com/gyf-dev/ImmersionBar](https://github.com/gyf-dev/ImmersionBar)

* 界面侧滑功能：[https://github.com/bingoogolapple/BGASwipeBackLayout-Android](https://github.com/bingoogolapple/BGASwipeBackLayout-Android)

* 圆形ImageView：[https://github.com/hdodenhof/CircleImageView](https://github.com/hdodenhof/CircleImageView)

* 缩放ImageView：[https://github.com/chrisbanes/PhotoView](https://github.com/chrisbanes/PhotoView)

* ButterKnife注解：[https://github.com/JakeWharton/butterknife](https://github.com/JakeWharton/butterknife)

#### 模板项目亮点，[查看详细](ProjectDetails.md)

* APP用户体验：已经集成界面侧滑以及状态栏沉浸框架

* 必备优秀框架：危险权限处理，标题栏控件，吐司工具类，圆形ImageView

* 常用页面模板：启动界面，主页界面，登录界面，注册界面，关于界面，浏览器界面

* 集成友盟统计：集成友盟统计，并且加入了友盟多渠道打包，在发布release包时可选择渠道包

* 界面样式规范：项目的严格按照 Material Design 设计进行配色，统一和规范Button和EditText控件样式

* 常用自定义View：圆形ImageView，验证码点击倒计时View，带清除按钮的EditText，正方形的FrameLayout、LinearLayout、RelativeLayout、ImageView

* 代码注释规范：代码严格按照谷歌级规范来做，如需寻找友盟相关的代码，全局搜索 "友盟" 即可，任何一处不关于原生的 API 都有非常完善的注释



#### 如果您觉得我的开源库帮你节省了大量的开发时间，请扫描下方的二维码随意打赏，要是能打赏个 10.24 :monkey_face:就太:thumbsup:了。您的支持将鼓励我继续创作:octocat:

![](picture/pay_ali.png) ![](picture/pay_wechat.png)

