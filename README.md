## AddViewAdapter
重写RecyclerView的Adapter,实现addHead和addFoot功能

RecyclerView是google推出替代ListView和GridView的控件,很好用自带封装了ViewHodler

但是我在项目里需要用到addFoot这个功能,却发现RecyclerView并没有提供这个方法,但是翻看ListView,发现addHead和addFoot也不难实现,便自己封装了一个Adapter

其实就是将head和foot看成普通的item条目就好,将head角标放前,foot角标放后,比较简单

ps: 代码值提供思路

![image](https://github.com/Zhaoss/AddViewAdapter/blob/master/image/1.jpg?raw=true)
![image](https://github.com/Zhaoss/AddViewAdapter/blob/master/image/2.jpg?raw=true)
