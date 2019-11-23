#!/usr/bin/env python
# coding: utf-8

# In[1]:


# import statements needed for the rest of the script
from selenium import webdriver
import requests
import time
import csv


# In[17]:


driver = webdriver.Firefox(executable_path = 'geckodriver\geckodriver.exe')


# In[21]:


# lists for the combined article/image/url, and lists for each of those categories
items = []
x = []
y = []
z = []

# variable for article id
article_id = 0

for i in range(1):
    
    # set url link every iteration to get articles
    url = 'https://www.wwe.com/news/' + str(i + 1) + '/'
    print("Url page: " + str(url))
    driver.get(url)
    
    # give webdriver time to load page
    time.sleep(10)
    
    # get tags of articles
    atags = driver.find_elements_by_tag_name('a')
    
    # loop through the <a> tags
    for atag in atags:
        
        # url for article
        href = atag.get_attribute('href')
        
        # if article not in a list and it has the word "article" in it, append it
        if (('article' in str(href)) and (href not in x)):
            print(href)
            x.append(href)
        else:
            print("Href does not exist.")          
    
    # loop through each href
    for href in x:
        
        # set url link to an href
        driver.get(href)
        
        # wait a bit
        time.sleep(3)
        
        # get article name
        article = driver.find_element_by_class_name('wwe-article__hero--title').text
        
        # get image
        got_image = False
        imgs = driver.find_elements_by_tag_name('img')
        
        # bunch of conditions needed to get only what we want from the article titles, append article title
        if (not(str(article) == 'None') and (article not in y) and ('|' not in str(article)) and ('WWE NETWORK' not in str(article)) and ('START YOUR FREE MONTH' not in str(article)) and ('WWE NEWS' not in str(article)) and not(str(article).isnumeric())):
            print(article)
            y.append(article)
        else:
            print("Title does not exist.")
            y.append("Null")
        
        # loop through the <img> tags
        for img in imgs:
            src = img.get_attribute('srcset')
            if ((src not in z) and (not(src == 'null') or not(src == ''))):
                print("Has image.")
                z.append(src)
                got_image = True
                break
        
        if not(got_image):
            print("Image does not exist.")
            z.append("Null")
            
    for a in range(len(z)):
        if not(z[a] == 'Null'):
            z[a] = 'https://www.wwe.com' + z[a].split(" ")[0]
        y[a] = y[a].replace(",", "") 
        items.append([article_id, x[a], y[a], z[a]])
        article_id += 1
    
    print("Length of href: " + str(len(x)) + " Length of articles: " + str(len(y)) + " Length of src: " + str(len(z)))
    print("")


# In[22]:


for i in range(len(x)):
    print(str(x[i]) + ", " + str(y[i]) + ", " + str(z[i]))
    print("")


# In[23]:


# put everything into a CSV file
fields = ('Article ID', 'Article URL', 'Article Title', 'Article Image URL')

with open('../Data/WWE_Data.csv', 'w', newline = '') as csvFile:
    writer = csv.writer(csvFile)
    writer.writerow(fields)
    writer.writerows(items)


# In[ ]:




