#!/usr/bin/env python
# coding: utf-8

# In[1]:


# import statements needed for the rest of the script
from selenium import webdriver
import requests
import time
import csv


# In[2]:


driver = webdriver.Firefox(executable_path = '..\geckodriver\geckodriver.exe')


# In[43]:


# lists for the combined article/image/url, and lists for each of those categories
items = []
x = []
y = []
z = []
duplicates = []

# variable for article id and keep track of duplicates
article_id = 0
d = 0

for i in range(2):
    
    # set url link every iteration to get articles
    url = 'https://wrestletalk.com/news/page/' + str(i + 1) + '/'
    print("Url page: " + str(url))
    driver.get(url)
    
    # give webdriver time to load page
    time.sleep(10)
    
    # get tags of articles and images
    atags = driver.find_elements_by_class_name('post-preview__title  ')
    imgs = driver.find_elements_by_xpath("//div[@class='responsive-media']/img")
    
    # print length of <a> and <img> tags (for debugging)
    print(len(atags))
    print(len(imgs))
    
    # loop through the <a> tags
    for atag in atags:
        
        # url and article title for each <a> tag
        href = atag.get_attribute('href')
        article = atag.text
        
        # if href is not in a list, append it to the list and append the article to another list
        if href not in x:
            print(href)
            print(article)
            x.append(href)
            y.append(article)
        
    # loop through all the <img> tags... duplicate images cause issues here, so keep track of them.
    for img in imgs:
        
        # get images of articles
        src = img.get_attribute('data-srcset').split(" ")[0]
        
        # if image not in a list, append it, else if the image is in a list, then its a duplicate so keep track of it for debugging
        if src not in z:
            z.append(src)
        elif src in z and not d >= len(x):
            z.append(src)
            duplicates.append(d)
            
        d += 1

    # print the duplicate indexes to help with debugging
    print(duplicates)
    
    # print the length of each list for further debugging
    print("Length of href: " + str(len(x)) + " Length of articles: " + str(len(y)) + " Length of src: " + str(len(z)))
    print("")

# modify the image url if needed, get rid of all commas inside the article title, and then append the entire item
for a in range(len(y)):
    y[a] = y[a].replace(",", "")
    items.append([article_id, x[a], y[a], z[a]])
    article_id += 1 


# In[44]:


for item in items:
    print(item)


# In[46]:


# put everything into a CSV file
fields = ('Article ID', 'Article URL', 'Article Title', 'Article Image URL')

with open('../Data/WrestleTalk_Data.csv', 'w', newline = '') as csvFile:
    writer = csv.writer(csvFile)
    writer.writerow(fields)
    writer.writerows(items)


# In[ ]:




