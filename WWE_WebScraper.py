#!/usr/bin/env python
# coding: utf-8

# In[1]:


# import statements needed for the rest of the script
import pymysql
from selenium import webdriver
import requests
import time
import numpy

# and ('article' in str(href) or ('article' in str(href) and 'shows' in str(href)))


# In[2]:


driver = webdriver.Firefox(executable_path = 'geckodriver\geckodriver.exe')


# In[12]:


'''
for i in range(2):
    
    # set url link every iteration to get articles
    url = 'https://www.wwe.com/news/' + str(i + 1) + '/'
    print("Url page: " + str(url))
    driver.get(url)
    
    # give webdriver time to load page
    time.sleep(10)
    
    # iterate through each item and get what you want from it
    atags = driver.find_elements_by_tag_name('a')
    titles = driver.find_elements_by_tag_name('span')
    imgs = driver.find_elements_by_tag_name('img')
    
    #imgs.
    
    # debugging
    print(len(atags))
    print(len(imgs))
    print(len(titles))
    
    items = []
    x = []
    y = []
    z = []
    
    for atag in atags:
        
        # url for article
        href = atag.get_attribute('href')
        
        if (('article' in str(href)) and (href not in x)):
            print(href)
            x.append(href)
        else:
            print("Href does not exist.")          
        
    for title in titles:
        
        # article title    
        article = title.text
        
        if (not(str(article) == 'None') and (article not in y) and ('|' not in str(article)) and ('WWE NETWORK' not in str(article)) and ('START YOUR FREE MONTH' not in str(article)) and ('WWE NEWS' not in str(article)) and not(str(article).isnumeric())):
            print(article)
            y.append(article)
        else:
            print("Title does not exist.")   
        
    for img in imgs:
        
        # image for article if it has one
        src = img.get_attribute('src')
            
        if (not(src == 'null') and (src not in z)):
            print("Has image.")
            z.append(src)
        else:
            print("Image does not exist.")   
    
    print("Length of href: " + str(len(x)) + " Length of articles: " + str(len(y)) + " Length of src: " + str(len(z)))
    print("")
'''


# In[20]:


for i in range(1):
    
    # set url link every iteration to get articles
    url = 'https://www.wwe.com/news/' + str(i + 1) + '/'
    print("Url page: " + str(url))
    driver.get(url)
    
    # give webdriver time to load page
    time.sleep(10)
    
    # iterate through each item and get what you want from it
    atags = driver.find_elements_by_tag_name('a')
    #titles = driver.find_elements_by_tag_name('span')
    #imgs = driver.find_elements_by_tag_name('img')
    
    # debugging
    #print(len(atags))
    #print(len(imgs))
    #print(len(titles))
    
    items = []
    x = []
    y = []
    z = []
    
    for atag in atags:
        
        # url for article
        href = atag.get_attribute('href')
        
        if (('article' in str(href)) and (href not in x)):
            print(href)
            x.append(href)
        else:
            print("Href does not exist.")          
        
    for href in x:
        
        # iterate through the hrefs
        driver.get(href)
        
        # wait a bit
        time.sleep(2)
        
        # get article name
        article = driver.find_element_by_class_name('wwe-article__hero--title').text
        
        # get image
        got_image = False
        imgs = driver.find_elements_by_tag_name('img')
        
        if (not(str(article) == 'None') and (article not in y) and ('|' not in str(article)) and ('WWE NETWORK' not in str(article)) and ('START YOUR FREE MONTH' not in str(article)) and ('WWE NEWS' not in str(article)) and not(str(article).isnumeric())):
            print(article)
            y.append(article)
        else:
            print("Title does not exist.")
            y.append("Null")
            
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
    
    print("Length of href: " + str(len(x)) + " Length of articles: " + str(len(y)) + " Length of src: " + str(len(z)))
    print("")


# In[17]:


for i in range(len(x)):
    print(str(x[i]) + ", " + str(y[i]) + ", " + str(z[i]))


# In[18]:


x = "abcd.com"
print(x[:-4])


# In[ ]:




