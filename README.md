# magzineManager
This is the code that is helpful for any Enterprise where they have to manage subscribers and number of years of subscriptions and also search for people and their subscription expiry etc.

Following are the basic needs that are required for such kind of products:
1. Option to create a new entry with firstname, lastname, mobile number, number of years subscriptions etc
2. Successfully register the entries and display them in a format that is desired.
3. Option to list all the subscribers in table format, label formats
4. classify users based on number of years of subscriptions, expiry of their subscriptions and color code them accordingly.
5. Generate download of the subscribers information into a CSV file
6. Optimize search to find by any of the fields as easily as possible. For example search by subscription period, street name, pin code, lastname, part of the name, mobile number, and many more such search options
7. Display given subscriber on the sample magzine last page where it will be really printed to give a feel of real magzine of the subscriber.

# Installation instructions from source code
1. git clone / download zip
2. goto main folder where you find pom file
3. mvn install
4. locate war file in the target folder and deploy it into tomcat server

# Installation instructions from war
1. Download the release version war rile
2. Deploy the war file in tomcat
3. Access the webapplication to try the features

# Following are the examples of the usage:

# Registering a new users
![REgisterPage](https://user-images.githubusercontent.com/7045200/57367318-6b498180-71a6-11e9-8dc8-7946949e2c36.JPG)

# Search based on specific strings
![specificSearch](https://user-images.githubusercontent.com/7045200/59262616-2a3d0500-8c5d-11e9-97fd-95a364392c48.jpg)

# Search on subscription period
![SubscriptionsSearch](https://user-images.githubusercontent.com/7045200/57367320-6be21800-71a6-11e9-9b54-09c50b228847.JPG)

# The front page
![FrontPage](https://user-images.githubusercontent.com/7045200/57367321-6be21800-71a6-11e9-9f59-12dc97b07b6b.JPG)

Thanks,
Madhava
