from user_agents import parse
import os

ft = open(r'sam.log','r+')
lines = [] #used to store every lines of sample.log
browser_dict = {} #used to store every ip of sample.log
lines = ft.readlines() #store sample.log with list
for line in lines:
    try:
        user_agent = parse(line)
        brow = user_agent.browser.family
        if brow not in browser_dict:
            browser_dict[brow] =1
        else:
            browser_dict[brow] = browser_dict[brow] + 1


    except:
        continue
for browser in browser_dict :
    print(browser,end=' ')
    print(browser_dict[browser])
