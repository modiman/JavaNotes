import os
ft = open(r'sam.log','r+')
lines = [] #used to store every lines of sample.log
ip_list = [] #used to store every ip of sample.log
lines = ft.readlines() #store sample.log with list

for str in lines:  
	substr = str.split(' ',1)  #split every line by ' '
	if substr[1] not in ip_list:    
		ip_list.append(substr[1])
		print(substr[0])
