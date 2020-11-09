2020 11 06
几个shell命令的使用

1 
awk '{print $1}' sam.log|uniq -c|sort -g|tail -10

用空格切割字符串并取第一项，去重并显示每条出现次数，按出现次数排序，取前十
（awk命令用来按行切割文本中的字符串，默认以空格为分隔符  print $1 代表输出切分后的第一项 sam.log是被处理的文件名
  uniq  命令指去除重复的行， -c代表 显示每行出现过的次数  没有文件名时默认以标准输出作为输入
   sort 指排序
   tail  -10 取最后10项）

２ 
 grep GET sam.log |awk '{print $1}' sam.log|uniq -c|sort -g|tail -5

 
筛选出含“GET“ 的行，。。。
(grep GET　sam.log命令指筛选出文件sam.log中含＂ＧＥＴ＂的字符串)

３
awk '{print $4}' sam.log |cut -c 14-18|uniq -c|sort -g|tail -5
取出时间所在的项，切出时，分，去重，排序

４
cut -d '"' sam.log -f 4 |cut -d '/' -f 3| sort | uniq -c
用 “ 切割每一行，取第四项，用 / 切割，取第三项 去重

