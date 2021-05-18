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

Main App features
  -	browse profiles by neighborhood/club.
  -	view sightings per cat profile (map markers of sightings for that cat only)
  -	view all sightings in neighborhood (click on location map markers)

Profiles for Cats: admin managed.
  -	alias/name
  -	picture (if applicable)
  -	owner (if applicable)
  -	description: visual description, friendliness/approachability
  -	Breed (owner only)
  -	most frequently spotted location (2-3 block radius)
  -	avg time of day spotted (1–2-hour window)

Profiles for User: 
  -	Username (shown publicly)
  -	First/last name (shown publicly – optional to user)
  -	List of cats owned by user (if any)
  -	List of sightings 
	
Sightings: user submission
  -	pictures/videos
  -	date and time
  -	Location
  -	Visual/physical description
  -	Description of sighting/interaction (seemed scared, friendly/asked for pets, collar/no collar, hungry, etc.)


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
## User Interface Wire Framework/ UX DESIGN
 ```diff
 + Click Link to view Flow chart in full page
 ```
 LOGIN PAGE
 ![other_login](https://user-images.githubusercontent.com/40407778/118699032-ae4b8000-b7d6-11eb-808c-c727ef5d197f.png)
 
 PROFILE PAGE
 ![cat_profiles_w_edit](https://user-images.githubusercontent.com/40407778/118699054-b4d9f780-b7d6-11eb-9314-d1d3eb1a9479.png)
 
 ADD FORM
 ![add_sighting_form](https://user-images.githubusercontent.com/40407778/118699068-b9061500-b7d6-11eb-8aff-2d4da40fe0d2.png)
 
 VIEW SIGHTINGS
 ![view-sightings](https://user-images.githubusercontent.com/40407778/118699081-bc999c00-b7d6-11eb-8ded-e302eb3d0dc8.png)

______________________________________________________________________
## UI FLOW Chart
 ```diff
 + Click the link below to view UML chart in full page
 ```
[Link to full diagram](https://viewer.diagrams.net/?highlight=0000ff&edit=_blank&layers=1&nav=1&title=UI%20Flow%20Chart.drawio#R7V1bc6M4Fv41eZmquJC4PyZ2MlNT6e1Up3ems2%2FEKDYdjDwYJ%2FH%2B%2BpEA2QjJQLjbnX7oBIG46Jzv3I9yoU5X77%2BHznr5BbvIv4CK%2B36hzi4g1HVVIT%2FoyC4ZgZqZjixCz03GMgMP3v9RMgjY6NZz0Ya7MMLYj7x1OgiSwTkOAjSPuDEnDPEbf9kz9l1uYO0skDDwMHd8cfRvz42WyailK4fxP5C3WLInAyU98%2BTMXxYh3gbp8y6gqhhgCrXk9Mph90qv3ywdF79lhtSbC3UaYhwlv63ep8ini8sv2%2B2Rs%2Fv3DlEQVZnwqqy311f48U39x3kGXxfuytQu07u8Ov4Wsc8wfHK%2F6yU5ZSzob2xks3YCNjZ1IjLte0jWAIXsAvLs7DWZYfFmx26vbKJdShrjny1dm%2BtnHESXm5hxrsgFAK7fyY94phKfe0vpQ88GOFw5%2FmEye8rTjpycLr0XRH5%2BfSHTnJLXfgorfYjrvbIhRZ8AcwIVSpv9jMx5yZTChxVPvfUJNxFcLJ2Q0oKAyFsE8ZKQeykz9EoR9sHX4Em83kQ4oOt1H%2BKfFHuldO7sY78vvQ3ldvYiVBxEjhfQwWiJEuCTBfGCBfn9p%2FPqbOaht45ihMxfCIg3lZ91SSaFyOG%2Bt%2BKMSyIPIhReunhV%2FWMhx%2FUwQu8xQKKVTwYApUoU4hc0xT6hrDoLKE0IKjzfzw0RoszpAqgz%2FXD0Ha%2FJwGUMmLelF6EHMk4f9UYEOhnDryh89mPBtPRcFwVkLJZqiMoNOmvzgqL5Mj2ggGOPJRLv9ub26kbZf0ZWGjHRgkLyRZmhVDr9jvAKRSGFZXr20tLSOUyXpIdvB7msQj0ZW2ZksqaaqT5IdcFif%2B%2BDPCS%2FpCLxI%2BIRCuRBLlEf6SEOoyVe4MDxbw6j1%2FNt%2BLpfvMNSgvxSHmbf4ZhI9IqfKIp2qZZ0thHmOYEsbrj7QedPdHb4mN4uPpi9c0c7RkKOgwjdZrMroN8U0NN3npB%2FvVdxmUugpRrAKiL5Bm%2FDOSpY1nRVIydcoHTqd7TcfZnfPX69%2BduJZj%2BiW7z661JNrqNLXshAIfKdyHvlNbqMGdKp99gLogzjQUbnlPGAavP3SN40nZbjqf171GczKGjhhyiW6nne831iFqEjSM7wSQGAC1ghI1HI%2BPXUmEK9Y8hDM7fymoh5wCyoLOYtpSPIGzUtoqv7%2B4%2FYQfexeUgsFsNZUeIFT5v1kTtPyMSr9Xryc1PyAFHV1FK%2Bn%2FooVT%2B6VaaOoClhTWDDjnjTrMmb36hV0iF3TgkRQuzfOwHyW2LTdrwBjTpreVegEAlVDNtPgDBf2NZ46W2KwtuWIES11Y4QYtX1Z%2FFqTWgSVPBxaqNkzp5BAHL729EHfXJXKlsVoPLcZYnyFwCRu%2FahpSbcpT%2FqL87L9GH1dn%2F9p%2F%2B%2FxdflAjPu%2BpA3wC%2FeKGx%2BqVVdz5K3RUteunJAa2i5N5IKtiAViD0l0JKnVImFPWqbmseNaknEssymNrqyqZnTPhY3uhN3eENdtisakT6I4ErAkgJGF4Elj1DYUjQPhTTmvmWgFmAp8e%2FoivJkcXwawVRnc7JaiCzvNWV6b%2B74V%2BmJFdFIiVBFxAJ0nuL7UfKsqWcef4t%2BfaHPmhFSJFohUwvI3Ocq0he8yMb7ZYhVJqqu8phlgfm6kQ12CX5%2B3qBuYhbGuDB9JqExINGo8vVXxgV8MYZ1tsBnIaIWgG8YdrvA30kntCIG5HpKG8QmfveiH5nfHw%2B4J0cHpNMDBvSDgODEw0FaDGlHy2AvX291SJQD0ZKeOtSfzZvSS7x62m7KzehTCVTvfUqGL5ulDDJGtdVRnFrOCPYgwGsdRMfN5laAxS4sB5bVE7CkTzfF0O4w6vODqo0nSgGjHndXlQnUYC7S3kwHvksndKcDzTqmcGs68KD3HjNn5DqwF122L%2BMqg5x6xDrqR5ex18xGhdyVF%2Fx6yowcixGiXpWZYZ4KgkZtRVZWdobREHnxVKK1nV3mglSbHBXIdp7vVEXLsU5yy3als2iz7pBosp6kbk1wU%2BBfKoZtcmt%2BAoElkV5%2FeYiWOt6HmEhLCe3q58iqk1cm%2B4dJjBk2R1Fg2YYgvYEhqZODXcX3VTHqm5LMCVzy%2F5VL%2F3%2BgbxIXaP7S5NP5IkdgMobPko9d1A%2F5xNhdQrGEev9duw4tH1GSou91gsJfnIpmTpUptqRwjdWl9kNFXaBiRJafVtEQ02dJPpUsaUQW6uztW83kdZ7BGJyjjSbSBih2c%2BLI89%2BnZ98OW21QVA9cmhs5EnFo3a8seskMDL%2FR1oAZXk2%2BIULQUATgmRQeqHpOKBqiZoOmxDBpo%2FBASgtRJIrlYF8c6vPLS7jKOn72FWAKLfDyCBXf%2BfrHthpiWtO1J14URkxNvuQQqhIWk4QuzBYku5TFLBmP5WV94OYi3K6zWe5T3xky0nHCVMQMCuIRqKh74rL2RFgD3scFRZNsdmnuOUMVXUIUNtYw0GtpfPiYvLnB3yPRLEL%2FRumdGC3b7wOR85Ks%2BeCTl%2FrkJZDnJK0eJ%2BU62fplI1mfwCcb9cpGppLnpHxXSGVOyt%2BqM2aSei6ahHdOMc8sZY%2FWajPlS9dXRVbRW2abCo8F4MYYAZCEyQVaVS%2FXMEx7omT%2B6YLV2Gu%2BCwyT7xqJb1%2FQIVCllUAfElVA7DA6l0INUJxMooUaaq4lclTZJPlHnUmZVMdIK4go950l1hSex4zUK%2Bo0SQxFbXk2SWJQXoAF5SZm030V%2BJte5m7QIeg1gZp3eHEipT2NDB9g8eGxEaQ%2B4CC2Tj%2BStKonAJvW2zSzWUTh9g0tvE0ky0WcOyIsU1It0TMiBukj7gURrDemvNx6SEBAMc76B7n1%2BYNB2OhIseGY%2FGJJ7dcdfnraCZQ5uWKTRmTT81QzxKxXZyVD8tLtYbZCOOGChoIK%2BCql8kd8837kpaYMQu0xO9GVKdfY9KvlRF%2FauVIMTedKrUsnAJB6Dp263arYg%2FEfTN%2FqNt5X9%2Fz1MbMx92RirutQGlj9jJfJZW8fm9zUgjrM1yxYaYz6KNSBaTecYaQp5m6Fg5jGvsN0e1%2B8FbfGPEPRkCOrzjA%2FlGjQRtSktTfzRt2kVZAVrpI%2BHtRH1kUf%2BVwSXVp5oisnU9kOYuPNc2lnorfruHiDgHPQ7QJ0UTWeTbpKK01XqQrgzRFW6zJieIodcnGL1blbMWAfWh9pJQ6Lmg0kN0FbcrNNGShpsxlhVksTG21CFG1D2vBG1hsqvjRyzO86VwqziHwJpjKRBkhagYQpRFoUKGBANSTR3DbaZAoszZynNY%2B%2FPG5nabKEbQgRK9dYBHRZt2VXW5rK5cYwIdET3veswIyqYm%2F1te9Z4Wvy6pvV044EI5DHiKmJ%2B2X3jBFRQk%2Bd6M7bRCNZsdz%2B4rakmazfFTPgkFLlbEIselWpYvS1A5X86ee8Mw0sBB%2Fx4pR97ybz4lJPYbxeHEu7fwZZeoLnoA00ppicPJcIqHHEmsqik3kgDJ1WM3TmaoJ72JlYarOJZscZhlwMjnIQKNaYQi7GCW4ZPYFc8RCoLXpbFKNG1RKUxr5Tvbw0VHkJAhVLzTJP%2BQzAOhE6zTMbopwngoJ4KiPxUnIbXij64F5KnT%2Fn0ln3Yn0s1hEJbeK3cq5pGPyqrG9gvxkGj8byGf0UkbF1zOA32bJuPBDOK2S2F8BwEB76T5mZI9SnVXsXhsKjkcNjbvvc8hlA0frAo1g5MkM%2BGhMec%2FVv0BSrLnv%2BC2miDHtNdlD9htZY8qegx%2Bi2NNrZy8rvqDn4puSMKQq30TnJ8I%2Bw9089KVp59%2F8Clm8qRUWhl698B6xu8cMb74iOtCZ1pBvvxEMOQ0z%2FRvHhcoLj5Rfs0rDSzb8%3D)
![flowChart](https://user-images.githubusercontent.com/40407778/118699884-a809d380-b7d7-11eb-97da-b2c456fe5985.JPG)

