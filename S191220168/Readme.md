# W04

#### 1.写下对代码工作原理的理解；

A：首先在SteganographyFactory.java中运行main，主要是通过encodeFile函数，将文件BubbleSorter.class文件转换成字节码，然后再将字节码作为参数传到函数encode中，将数据mask一下作为信息传到图片当中，这样就返回了新的图片。

而在Scene.java中运行的main，主要通过SteganographyClassLoader.java，他会根据图片的url来加载图片对应的类（我们之前保证了图片名和对应的class名一样）。这样在运行自己生成的图片时，会加载原来自己的class，这样就能从class中找到对应的排序方法。如果是网页图片，本地没有对应的类的话，就会调用函数findClass()，再使用decodeByteArray()函数来从图片中获得之前放进去的排序方法的字节码（主要通过decode()函数）。然后通过defineClass()函数把字节码还原成对应的类，这样就能从类中获得排序方法。

2.

使用选择排序得到的图片:

![](https://raw.githubusercontent.com/jwork-2021/jw03-kiaye/main/example.SelectSorter.png)

使用快速排序得到的图片：

![](https://raw.githubusercontent.com/jwork-2021/jw03-kiaye/main/example.QuickSorter.png)

3.

第一次得到快速排序，第二次得到选择排序，结果如下。

[![asciicast](https://asciinema.org/a/oZOmQg5l111yEtmRd2cvz2aKe.svg)](https://asciinema.org/a/oZOmQg5l111yEtmRd2cvz2aKe)

4.

从同学那里得到图片得到图片https://github.com/jwork-2021/jw03-EnxIII/blob/main/191220053/SteganographyPics/example.QuickSorter.png

得到了快速排序，结果是正确的。

视频如下：

[![asciicast](https://asciinema.org/a/wUCK5CvSHlvw1hRnklBXX2Oau.svg)](https://asciinema.org/a/wUCK5CvSHlvw1hRnklBXX2Oau)