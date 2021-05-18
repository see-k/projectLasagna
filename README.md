____________________________________
# Cat Tracker 
### Dev10 Capstone Project 
#### by Chike Okonta, Quinn Chu, Derrick Fidleman
#### 05/27/2021
Designed using 
💾 MySQL Workbench 8.0 CE
💻 Intellij IDEA
🖥️ Visual Studio Code

_______________________________________________________
![vXJrdYADVqBveqVJ4n672K](https://user-images.githubusercontent.com/40407778/118698222-bfe05800-b7d5-11eb-9957-965814c91847.jpg)

### Introduction
[Cat Tracker Application](https://stage3talent.brightspace.com/d2l/le/content/6716/viewContent/3713/View)  
```diff
+ Cat Tracker is a logging and navigation app that allows users to record sightings of outdoor cats in their area. 
+ As the application collects data, users can navigate to commonly sighted locations to increase the likelihood of spotting their favorite local cats. 
+ User’s will need to be part of a designated club that has an admin user responsible for all admissions. 
+ This application will leverage Google’s map API and Amazon Web Services (AWS) S3 bucket for data storage.
```
___________________________________________________
### High Level Requirements
The application user is an accommodation administrator. They pair guests to hosts to make reservations.

-	Main App features
  -	browse profiles by neighborhood/club.
  -	view sightings per cat profile (map markers of sightings for that cat only)
  o	view all sightings in neighborhood (click on location map markers)
•	Profiles for Cats: admin managed.
  o	alias/name
  o	picture (if applicable)
  o	owner (if applicable)
  o	description: visual description, friendliness/approachability
  o	Breed (owner only)
  o	most frequently spotted location (2-3 block radius)
  o	avg time of day spotted (1–2-hour window)
•	Profiles for User: 
  o	Username (shown publicly)
  o	First/last name (shown publicly – optional to user)
  o	List of cats owned by user (if any)
  o	List of sightings 
•	Sightings: user submission
  o	pictures/videos
  o	date and time
  o	Location
  o	Visual/physical description
  o	Description of sighting/interaction (seemed scared, friendly/asked for pets, collar/no collar, hungry, etc.)


___________________________________________________
### Instructions
To launch the application
Use MySQL workbench 8.0 CE to run queries on the following files
- cat-tracker-schema-prod.sql
- cat-tracker-schema-test.sql

Use Visual Studio code to send HTTP requests using the file below
- App.js

To launch server
- compile the program -->javac App.java
- launch the program --> java App

To lauch User Interface
- navigate to src folder
- run -> npm install
- run -> npm start
- Login or register an account

 ______________________________________________________________________
## User Interface Wire Framework
 ```diff
 + Click Link to view Flow chart in full page
 ```
 ![other_login](https://user-images.githubusercontent.com/40407778/118699032-ae4b8000-b7d6-11eb-808c-c727ef5d197f.png)
 
 ![cat_profiles_w_edit](https://user-images.githubusercontent.com/40407778/118699054-b4d9f780-b7d6-11eb-9314-d1d3eb1a9479.png)
 
 ![add_sighting_form](https://user-images.githubusercontent.com/40407778/118699068-b9061500-b7d6-11eb-8aff-2d4da40fe0d2.png)
 
 ![view-sightings](https://user-images.githubusercontent.com/40407778/118699081-bc999c00-b7d6-11eb-8ded-e302eb3d0dc8.png)



