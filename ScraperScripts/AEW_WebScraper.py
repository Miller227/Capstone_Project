#!/usr/bin/env python
# coding: utf-8

# In[19]:


# import statements needed for the rest of the script
from selenium import webdriver
import requests
import time
import csv


# In[20]:


driver = webdriver.Firefox(executable_path = '..\geckodriver\geckodriver.exe')


# In[41]:


# lists for the combined article/image/url, and lists for each of those categories
items = []
x = []
y = []
z = []

# variable for article id
article_id = 0
    
# set url link
url = 'https://www.wrestlinginc.com/news/aew-news/' 
print("Url page: " + str(url))
driver.get(url)

# give webdriver time to load page
time.sleep(10)

# get tags of articles and images
atags = driver.find_elements_by_tag_name('a')
imgs = driver.find_elements_by_xpath('//li/div/img')

# loop-stop variable (loop break is needed for Wrestle Inc since the end of the page has a NoneType)
k = 0

# print length of <a> and <img> tags (for debugging)
print(str(len(atags)))
print(str(len(imgs)))
    
# loop through the <a> tags
for atag in atags:

    # url for article
    href = atag.get_attribute('href')

    # bunch of conditions needed to get only what we want from the hrefs, append the href and article title
    if (('/news/' in href) and ('-news' not in href) and ('interview' not in href) and not(href == 'None') and (href not in x) and ('#disqus_thread' not in str(href))):
        print(href)
        x.append(href)
        y.append(atag.get_attribute('title'))
        k += 1
    else:
        print("Href does not exist.")
        k += 1
        
    # right before we pass through all the hrefs, break (don't worry, the last 13 or so hrefs are useless for our goal)
    if (k > 130):
        break
                  
# loop through all the <img> tags
for img in imgs:
    
    src = img.get_attribute('data-src')
    
    # get images of articles
    if not(str(src) == 'None'):
        z.append(src)
    else:
        z.append('Null')

# print the length of each list for further debugging
print("Length of href: " + str(len(x)) + " Length of articles: " + str(len(y)) + " Length of src: " + str(len(z)))
print("")

# remove all the Nulls
z.remove('Null')
        
# modify the image url if needed, get rid of all commas inside the article title, and then append the entire item
for a in range(len(z)):
    if (('https://' not in z[a])):
        z[a] = 'https://www.wrestlinginc.com' + z[a].split(" ")[0]
    y[a] = y[a].replace(",", "") 
    items.append([article_id, x[a], y[a], z[a]])
    article_id += 1


# In[42]:


for i in range(len(x)):
    print(str(i) + ", " +str(x[i]) + ", " + str(y[i]) + ", " + str(z[i]))
    print("")


# In[43]:


# put everything into a CSV file
fields = ('Article ID', 'Article URL', 'Article Title', 'Article Image URL')

with open('../Data/AEW_Data.csv', 'w', newline = '') as csvFile:
    writer = csv.writer(csvFile)
    writer.writerow(fields)
    writer.writerows(items)


# In[ ]:




