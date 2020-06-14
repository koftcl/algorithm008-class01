学习笔记

# lc191
1. 开始用 n & -n 来检测末尾的 1 没有注意是无符号
2. 改为 & 1

# lc1244
1. 使用插入排序解决
    1. 可以使用调表来改进
2. 若要提高性能需要考虑读写比例，k的取值范围等因素
3. 如果k比较小，n比较大，可以考虑使用堆

# lc52
1. 使用回溯算法
2. 检查竖、撇、捺
3. 递归搜索答案
4. 与lc51相同的方法

# lc493
1. 保证不重复计数
2. 保证效率，在有序的数组上进行比较
3. 使用归并排序可以满足上面2条
4. 时间复杂度nlog(n)

# 总览
1. 比较类排序
    1. 通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn),因此也称为非线性时间比较类排序。
2. 非比较类排序
    1. 不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。

# 基础排序
1. 选择排序
2. 插入排序
3. 冒泡排序

# 高级排序
1. 快速排序
2. 归并排序
3. 堆排序 - 参考之前堆的章节

# 资料
[极客时间网页](https://u.geekbang.org/lesson/13?article=243698)
1. [布隆过滤器的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)
2. [使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)
3. [代码示例](https://shimo.im/docs/xKwrcwrDxRv3QpKG/)
4. [实现示例](https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/)
5. [高性能实现示例](https://github.com/jhgg/pybloof)

# Cache
1. 记忆
2. 根据使用频率分配缓存资源

# LRU Cache
1. LRU 最近被使用
2. 要素
    1. 大小
    2. 替换策略
2. 实现： Hash Table + Double LinkedList
3. 时间复杂度
    1. O(1) 查询 通过 hash table
    2. O(1) 修改、更新

# 比较
1. LFU least frequently used
2. LRU least recently used
3. [替换算法总览](https://en.wikipedia.org/wiki/Cache_replacement_policies)

# 课外知识
1. [了解meltdown漏洞](https://www.sqlpassion.at/archive/2018/01/06/understanding-the-meltdown-exploit-in-my-own-simple-words/)

# LRU代码模板
[文档](https://shimo.im/docs/tTxRkGwJpXG6WkGY)
## python
```python
class LRUCache(object): 


        def __init__(self, capacity): 
                self.dic = collections.OrderedDict() 
                self.remain = capacity


        def get(self, key): 
                if key not in self.dic: 
                        return -1 
                v = self.dic.pop(key) 
                self.dic[key] = v   # key as the newest one 
                return v 


        def put(self, key, value): 
                if key in self.dic: 
                        self.dic.pop(key) 
                else: 
                        if self.remain > 0: 
                                self.remain -= 1 
                        else:   # self.dic is full
                                self.dic.popitem(last=False) 
                self.dic[key] = v
```