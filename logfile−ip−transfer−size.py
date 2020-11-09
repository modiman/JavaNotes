#如果ip多次出现，以累加的方式计算其transfer size还是取最大值？ （本代码累加）

import os
ft = open(r'sam.log','r+')
lines = [] #used to store every lines of sample.log
ip_transfer_size = {} #used to store every ip of sample.log
lines = ft.readlines() #store sample.log with list
pattern = "GET"

for str in lines:
    if pattern in str:
        substr = str.split(' ')
        if substr[0] in ip_transfer_size:
            ip_transfer_size[substr[0]] = ip_transfer_size[substr[0]] + int(substr[9])
        else:
            ip_transfer_size[substr[0]] = int(substr[9])
for i in range(5):

    max = 0
    max_ip = ""
    for key in ip_transfer_size.keys():
        if (ip_transfer_size[key] > max):
            max = ip_transfer_size[key]
            max_ip = key
    print(key,end=":")
    print(max)
    del ip_transfer_size[key]
