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
  -	Display locations (map markers)
-	report profile/sighting to be taken down by admin.
-	Image SRC for individual sightings, SVG for images

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

______________________________________________________________________
## JAVA/SPRING UML CHART 
 ```diff
 + Click the link below to view UML chart in full page
 ```
[Link to full diagram](https://viewer.diagrams.net/?highlight=0000ff&edit=_blank&layers=1&nav=1&title=Capstone.drawio#R7V1rl5s40v41fc7uh%2BagC7ePfUsms53LpjuZeT%2FtoW3SzQQbD6bT6f31rwTIBiSBwIDxRjm7mVgWF0tP1VNVKpXO0NXq59vE3zy9j5dBdAbN5c8zdH0GIXRcRP5DW17zFmS6Xt7ymITLvM3cN9yF%2Fw3yRsBan8NlsC3a8qY0jqM03FQbF%2FF6HSzSSpufJPFLtdu3OFpWGjb%2BY8A13C38iG%2F9I1ymT3krBmjf%2FlsQPj4VT7bYD37wF98fk%2Fh5XTzujPx0G1xBnH%2B98tmtit%2B5ffKX8UupCd2coaskjtP8X6ufV0FEx5aN2h%2FvXv%2BIbr%2Fbb3%2F%2F9%2FZv%2F8vlv%2B4%2FfD3Pb%2FamyyW7H5gE67T3rf8EL18hXr6%2Ffnn795dH%2FLB4%2Bfjj3C3u%2FcOPngM2DNmPTV%2FZ%2BNIx2ii%2BArtdkKTBT9Hs%2Bw%2FstvshJNAM4lWQJq%2BkX3HVObSKYS9gee7BYt5e9pNsWQVUn0oTDLBZ9PQLZD3ubr8fH%2FKPYoi6DBdsHy4Ckw39J8VxkJyhy2%2FxOr0rvgfk83bjL8L14328oQ0maSGjwpCLi887xAKcN3yKt2EaxmvSFAXfyDeXT%2BkqYrdMk%2Fh7cBVHcZK9BDKha3pm8fBS%2Bw1%2Bc31Dr%2FgWRlGpPf9D2vl5bsZNfaL5CVWZLsMs%2FYFjTR7iJi%2FThltuCslPSrlRXcfroDZwRVNpIrK5zjUkxIK5p%2BMVEtV1EYWPdCpX4XJJv7z0i4YFGfcdakQTN%2FwEsW%2BRa2Dgmdix878r4geB4QEIIPbINxC7TBJKs4tMYNgutJBX%2FI0Fk%2B0Z0IW27Xmkg%2Bl540025ib7y5YMLCetL%2BEq8vOZLc0VFZ3FUxgtb%2F3X%2BJm%2B%2FDYldME%2BXT7FSfhf0t%2FfS6Cf7GbeluBkd9EdvVnxmCTYkss%2BsQkFtab3%2Fs9Kx1t%2Fm7IXjKPI32zDhx28Vn7yGK4v4zSNV%2BwqSnDBsvi0%2FR6ki6figwxicm0yGviwZ9heBXA2MgCBG0YOJDBBFrY5wAHXNBDgQYY8aBB4IdczbcciloA9FsgsAR2QQTKfCdTekSsvyL%2Fv0oRo%2BzMCCohAPoisy9pfBY2dvoXJNv3Q1ivyFToFKz%2BMGnsswy1l5%2BK1L4kJF%2FhrrtfCT7d5jys%2FJX%2BfWZfZ39eVnocpVKYMC6KrK82UMiej0duszzXet3wukECbYnLttyiz2p6Iqg3WmUSkPrND6Ntu4nCdZtAgP8W6JGbHlWlY2S%2B6Ip%2FB%2FjP5H%2B2eEKlZk9%2Fih5kUBGT4XwIqlQcrbawsN0wtq0sFQESFW5h8bdqYGPnOSEJBpFYiFY9B%2BiUTjH%2BQD%2F%2FMQfSO0N0j1cs1mBV9qYSUekuQSzq%2FYZKi1PvW79D5hkqOUs932%2BtChkrdZYJE%2BhMJ2pZ6NgkUbdsKxu9HTCZD0rE2eLKuoqGT9RUMnKxrfdhk%2FYSDJutcGzGum9Y70%2BgdYDkiZaKghiDChuVakBgUJiL3wdZY5OxxaigTMG0AztEAtICBqx4HdlwDeDyuHM%2BwBJ4FRqTdGwlLnimhNGINMTtPxmStRt4y2C6ScJM79w39NuEifU6a7xW%2FrKn3SHt8zP5Z7xDutG0zOxFV6G%2BDwtK7oB%2B0rTeszvWURaTB1pMIA8BjuTyAOVMi6%2B6KSoOacadsfV3vpUOp%2F6dcSpT6ZiJS6ikWmR6G3UUuPaXOzSK0t26UjDtFC0w8dLLe%2FMDJetaHbRDLjh8yrqfWOZPrHODwcT6Z0oG2MyID8%2FG8O%2FroTLK1STdHkw5Bw0HlwD6u2Hce4tdzCLYElp1tjgUqWfxuW0CrzbZj%2Fa79tLDLbmOiSLKPsr734areN2uq9%2F8Rbp%2FJ10SHN9LY7hXaOqqYj6rWoVoQMItNkt%2B4t2xv2Setyw%2FV5d4QsUKhvAHLHct4hDKB62Y83pXErnSFXPZK11BZE10jlEFy3dedGCqZlHclcRzcXh05vkgDo4WA1kaIk9mOBqtkwtq61%2BZK1l04RYebuYMGJln8tDK%2BOoB5NGUIWMyzTRtCthB%2BiDa0f%2F%2Ft4rft97%2FfOn8%2BfP3y4v0VPX4652NKe1HTFu0sLVrTrZiw9TVqQbRSFgU3B%2BBYIapECV1lQ6zNpI3i9WOYPi%2FblpzT5k5aj7XosUaVMMb6rz0W4hqWe293oFMz7G4Z%2BBRXcVPFzlvJq8hpmn8P%2BZIo9xaa1Y8jDR7P6dJsCIBHEgc%2BPl7EfjWnnwKnI%2BgaprkndXUFOx6nOxINmy3StRF61qk1PaxlIVMrsD4KzFYG44zo3JXT%2BUWONzUuv2C4U%2BJy1ejPVvQWjWtKiotlraEMLQKTiMAsOJzfKfA5oIOkSfw0SNxmOagq2eJggDVLIYr4Jctc2yQZltp4u5xDLuujkH6kupQlzULSeq%2BP3kPKEO6RyW2CkRDbsDzzuQCteu62at8eCz%2Bq%2FTslD22FP7IpwVqpY9c1EqXOiqk9WnYnkV0A1fOfgQcPF17xIgif8Mwh4Ch7eQF0q%2FR87mCXGzDbFG0ONdFY%2BeFQYbh%2Bib28O9x02ss79XQhfrnsOl4R2T9Uy81x926HKWF1HCzX8DwbYA97JnKQUxE4BA3LxK6Fke16CJoCHws4BsSuCVwATRNbiJ9caBulW6DdFuDh00RcPob6Odg%2BR%2Bn9KxFHaP7j5sOX9%2F%2FUztgUzlh3KCLbpBFUz4GmayHXYrNZYNHFBKgWtOiuIdMEFu%2BpQRMYQJTVjsaq6wBcWYi1hLvMxArWzyttV%2FXTanu5PihnTYIOPJ46koVE775cXd3c3XEG%2BrsPXy9u311z7R8%2B3v%2FnzccvH641giZDkM1bmjIE2WPZLkCwfyxXLJrDTpLDCHv1JjF3gHCjBGV87s95NjyvUewX4b%2F7klKiX6Y7ZitbWJUuq2C79R93ewGTxH%2B9DcmkQzui0NtFUx7TM71LZwgl5w2RBiTDnzWekoMSmnwMMliVAlVCrLEtCHfPiwWBnFqK86cc3KXO96J4Gd9NGFkjN3xfoL2cAa2G9myxfbksbsA9SgvDRMLAlo9UlPEQKRuS9%2BbXEDkMBOvlBS2ASD49RDFl4Mulv33K2JGOEfn%2BTUifm00K%2BVQQOoB83KIbcdZCRm%2BwdWl79Bk%2Fw%2FRP0nZO6c8qGv6PvoABHLv4fM0sgOzD6%2B71yLixawFgLfnFyIGsYX919qly%2BacgCcn40xDK7gH1to6cv42fk0WgoreIxUTkX8URCJaVipSNcTLAdq8lAU2a%2FVG%2BUIy74nafqAyWgqh2zQTxarvi8h9aXLVHL3cjBFtulI8Dd6OM%2BEvdCh0hfWHIDB0Wgyr2jMreq94fOE5NCvM32MvkbsAPEVN%2BkfbKT%2B%2BC5EdIUKOt81la57Aa3YQOv%2FwiN7%2FH2kwKpLtJ6Xr%2FNkxjitRiH9bnfZM2DHoaBoNsgJw8mOTJ6mcQ05GzkJnVme3c40zO8%2Fw24ZLuqmu97gqeXZiCCoPEBokiibUrfu7%2BysvXymp13l34gMtXumDe4zHPm2V106DKyLCUlojYDaJ31CI3kch1iL7t6gaOIHP8Ui9Fo2b5U2J5VmxVBUrOWG4dNGWVwOokTwGmWf5wlTNEmazJWR6afCi2neXzAtU9aL5yYR%2BelzxZSvRZf%2FGDWvi68UlCwhaW7dbiM5b4dGLssXwpyOrCC8o9adY%2BJdbGjjpt78h1BDyJorEi2mYo09R9qO7Zy%2FCJUbds20YTde9r0fWgb%2B7iPhTe8AZSGi9d091pV3pgdhPicve9R4s10Xq90KKQFg7Ukj2WZHexKtAAoi0ujcIbFV9zwQzJQGmDYp4GRUsqDrbsaipOB6ANkE4qBprM2qin4mj906J%2FmuV4roaF%2BK1ldkW4%2FfAcRR%2BTS6JsvouyXjRKpkHJxKmiwrfmI9X5nkTt9Z4ySdmm25eknAF8YrF8qEaycwBqh%2FhQhTT3SLYYJbJAtsCdZDUyGvxA3gXcXSRNqJR6fy2XtviOLVcLPUfuF1ace9UnafGZRHy6%2BJxDnEMqlh9%2B71BWlUjz%2Baz5vBbFtt0OWGKJmsNjSbRjXcTYGcI0YR%2FsQbjKsJkRY0OZXSdg7KIyZSfCZtd05%2BvmK1vouvliIVvXf50SWdeeoyVnGsnpQNbeaKWz%2BQReVjVY0%2FWs6Ro5qLHkALL6ut9DnD0kBpssD7hO5gyCms8P1kqWMq5mxOdAVppCwOfSs1qaKb10WXdWb724hdhbrxdyu%2BCXKtE7%2FzQtS9PIUheGHyu5Y7ffsyJMOTKeQAmBWctDUm8hDy13E0NHWstLjqICDqTB2n%2FKi4pRex5dvjyFaXBH2umjXhJ%2FIwVMZ7rmJ7xTNTgpJ58jXHWizwFg2x7LGLAFh%2B4gONq%2BXCxyj2oTeZQqedB0cG28HMH51w5739pSdla1HiDLI6OHhigQKhk%2BUTy4bhT%2FClXz9kBSlwhQOwITsVSXcl09VhqxGp8c70w%2BZriUC%2BsR0jmUGOdYVq%2FPnGHToEU7HdOysEdmpzqBNjQsF1rE%2BnOAi7GgDCjyiGAi5DmW6WIPOYLZhbbhAWgz6R3EwZX8fj4xhWb4%2Fb58WNwHq01ELKcGN0M7uyM4u30w6RJMEkcWOh7ANlHJVVBiTIsTObbtecQlBruKL0oZ%2FXSdulTkcbRaRZjPhqH2%2B18lJObmexmb2ljvq%2FeGKEcuryhkmJXCoKNhhveEz3PnVHj6psbKRFhxgRAACtBBjuGNVo%2FKEvh6NLP%2BMqTWxDfqS5GPl%2BWAQ8umTU2A8yBAyIorMcYzRQVAoCEytgAcrYgsO%2F9TGKkbePNlc4RO2IWLwz1IyqoJA24POhv1ILVqDbOYLAa154yFafs0y5ixWmTmWaUMmXXWUoSsKH8GzsqVz1gdNHHds65qrr0gGbNz2guSMY1zlIJkEBk2tGxgOTaysM3KwRfotYhXW645X729crEygAzyfxu6LvFLEHG0OzxEUshssNphDh8LI4aodqZPypbgnOlqFTrLhTR%2BU4RVTa9DpTGEKr70AGfVSWDIB%2FC0Kz0ajzvqCyEzdqUdntYLV%2FpTuEifk4B3pyvrrKRjligl6KdxNRGu%2BrvdFhzR7XZEiS3aYhzVYmTi3G4xsnIcR7EYWdIAywiwTMOu3UXVMDwn%2FOoYHvAsbNKUQNeqpnwRGFoGwo5rY9OhsfBaUvbotqFgt2dL8Km5LKi2F%2BdhL0IPUrMOkCc5rgscpxqKsrL1PtN2PBsAAnDR2oskMIXGsxBllWlnX%2F2zGtYSPUFHtY5qtQxThFciEeNV53f4pSRWFUb77yelj8%2BJGex5Jf%2B9GoZyoDt7%2F51fp9L%2B%2B3gay1FG2Jz9d36pqav%2FrtfMjwmqmTrvrkJ2rHbeB3bePVXnnS2xHMN5p%2BdbYINFqZiX7SJIXHhz96evN4%2Bh6Rg23Hnz9SNqsFNy5muLnWO78i6%2FzNPmyitUEdX24zzsR%2BgBA7p7f75euce1Kv48f3K21HvB451WzK%2F4%2FLolQqshAun76jjBUc%2FtHWbVTCJpYID0F%2BEuN8Qvk%2BXFfHSQ4KSU%2FLkDq0GCahoJMLFXiRJ0qPYC7bGwpzPkp9vOisZMkAdD1LUXv7Zeax3YXSs7YeIhP%2BYZoNAlANuXuahtGAXAsg0LOrtdoLCnN2ZD25N7YxjZ9hTemHj4BdUQWpyx1vqVmqXnwdKEeZtcMaJG7WP6Yo3qoKMr1lJ8skdxTeqGVStkdHscc8P63qNeIkT4ttoJO6aNM8zKx%2BQ%2BWPfwW1v9Q63w56HwoWc3KXwXO%2FPT9y2ht6ZQVnMJQ%2BXyjDrgdQK69jTjXZC3rjMM6nDXSenVc8duCne5ntk3J6bJZz0MeToJZjrtBMfMgRkiOUGsU3VuwuTBriMmHACIm4JdRL8NFOtyUEOsi%2BYlHCvWBXnPh5Wv1IR8YoTcvP4ETdx7%2FWksT4dpV83IUzDymLtKh6gOIX5r0ZF2mpHHZGQ27XNcfkIATLH8ZEFwPEoW7KRqCUYq1G%2FXND0Pmm5bgAI2mF1AEopSAA4pDy8JXnasES99lA5LHtPMGOYEhBHDkpIDx3mQExgka4OA7D9knBbfab2zwzBx5ILFwxRd9yzXINpp%2F6eiwM6B6dFNbTa0LGIskk%2F89mSMPcMq%2FbH5iUbA8LBD%2BZlqZWSxig8jzLsgHr3ZaP4cmD%2BHwR4w3epe%2BHOvw7YmdzwQycoyroh%2B1ZvfDs3t3gvpGL7rEOcviV%2BbHcBU9lWJU8WUBxmwp%2FgxXvvRzb71cvGc%2FNjJ4V4qQV0q91ffxvkpB6TxryBNXwv14j%2BncZV0JG5pg1NqIZt9%2FhQkIRkXyjk9tYLMW%2B6mLVp3u0HlzW7spIlWT1fZqz0ML4K1UQ5ARzk4BDk1lncsyMmXiwREDuBoO5ShYEGP5%2B1f4aAQ2GG1jc1odT5Fs4n42fTYuXkjTCZPoYRNyEhGUZBsT9zyHmrWAD3Ho2x7u5VphFkhSQdjx3Ndz8SQX3afle2N%2BFAXyzXaz702xacIZfUAo4WrtdYckze5EEGb4PAtyEqojIAp3o%2Bna0rb4nTVSkKb7MhVbZarYQYNEuuRYISdgzQCRGTHXXJnUG7IwAU36zRMX1mQ8uPDX8Rw2oUoaWTelAU7B9wkLX4Z9d3Px95CLTqhs310lQK24jt9zSvS6BM4pxVwT50EAByABIQxaMzbkhT%2F2qaYvU3BssF25VunNSmEaLL4pEDOoqDw0tbEQQtHO6GdqzEhBofosNKetkQ3K6LrmT7iV2i8iybtX0KOZsHZLKBYPelEU%2FbsKZtWt2JhwYZz2KenbfH5ExXaJgjTrH2QttmJ7WmxtiirdBLW7ljwXPwGbTc5pBy65vxfQgrnwfl8%2FD%2FbC6pZf%2FasX3PUkeBc%2BiNQvkLsPwOYJv3D1M3c4%2F7it5aF%2FZV5t726AguTd63MMIDdcWTiLt1HC9U0QjUPDueTcPLKTJrEZ0%2FitDiOUyqtblZ3W82E1MXnUFRIPUecZvXDFNAgx4dPzeq2qGRDJ1bvULnu4JJ1p8frWpamkaVZkLnNr2axXXaazmdP55Zdc8qtiTPyxJjiF3Y4%2FmYg0wx%2BkNbZie9pMTi%2FUNORwVs3DjdzeMd9x5rFtTzNm8X51a2bJIkTBhRN4DMlcFw7GKoDmkbkb36RhvJ3Gq4CMoOrzZ7Bo2ui4u5Je0lv0a6rYLv1Hwuqv0uTLE9Ya6ReGmmQw5AnZ3hZAZHHIL1nOKpV9hCBaXfR%2BxxR5RrFBaxqfR%2BeifoqdWPseL%2BnRkUm1nidBq%2FzYFB%2BqehtFD%2F40c3PRbChtuJv%2FnqpfeEZU6lX9YVFXIpYcbnqSUqjaUFZkYinDEs7aLWa9jVjTuIrzPquWpv20qZDlMEQot4ZbZM%2BS02aTQ2MHiUWe9TNgHhf7PF0KmewnZGtpTPYbv3pK2eIc94FNRM5Zv4fqwQxUEUlz6qVggCYz94WFoOwWdWj4aeTzyl47282p18HYpg5g4AYxKUyEE5tAoFXLcCGuPk8UhUI4WQ7%2FAIuTV3OJ1zb1%2FOsw0bwVQWdxe%2FUBK5AaYxnXjuynXgrf%2FM5filZqvmeN22C9jFBd9J6iAkqRMYQJqj4lfkFSLbio5XMjJUMtBjYWHFkDI%2BuZGRrlZyS2S8qakXTS9FAZbzMRtHw6255ephWM3NWM5BBbUZqRuTPCtUMyz%2FUSqaXkhliOW1iJcOvpWVbS7SOmbOOMc2qvzQHHSPbDsXpmGLrklYxvVSMrQyW2agYPvx25WsjZtYKhh4xCGuBQFYJ5og6Rl4Xv6ZjspIEWsP00jBD7NuZVsO4fMyXVZDUambOaqYekpmBjnGV4777IqVa0fRRNO6cYr%2FkYxLHaem7t4m%2FeXofLwPa4%2F8B)
![UML CHART](https://user-images.githubusercontent.com/40407778/118700409-41d18080-b7d8-11eb-94ec-79ad8d543119.JPG)

______________________________________________________________________
## DATABASE SCHEMA 
 ```diff
 + Click the link below to view UML chart in full page
 ```
[Link to full diagram](https://viewer.diagrams.net/?highlight=0000ff&edit=_blank&layers=1&nav=1#R7V1bc%2BI2FP41zGwfNuM78BjY0M6UtOlm2%2B72paNgBdwYiwqRQH99JVvmYhlix5atrDWT2cVCli%2FfOZ90PumInj1ebn%2FEYLW4RT4Me5bhb3v2p55lmZ5t0f9YyS4pGZhmUjDHgc8rHQrug%2F8gLzR46Sbw4fqkIkEoJMHqtHCGogjOyEkZwBi9nFZ7ROHpVVdgDoWC%2BxkIxdI%2FA58s%2BFO4xqH8JxjMF%2BmVTYN%2F8wBmT3OMNhG%2FXs%2ByTdMZuZPk6yVI2%2BL11wvgo5eTIrglExQR%2FgR3EC9BBCNCv7kF%2BAninnuzIIS9iOueRdudPLLaV3OE5iEEq2B9NUNLWjxb0yqTR7AMQobCUUMj3hC9nH3Ts8cYIZJ8Wm7HMGRQpigl9zQ58%2B3%2BNWHWboETxh%2Bfd9Mng0Q%2Fvdh%2FkNvb%2BV3%2F4SO3lWcQbvjrHwP6%2BMn7IbsUE%2FqqVuwjAQ%2BsaLQmABNuOrZBC6gxEBBE9MHsT2Z8HIZgtQ7i6knJIgj9KdihDUkbSo9Gj8EW%2Bp8Ty2F1qRFNaWPskDXOXvI9vxn2NQiDeUQ%2Fz%2BiTsyuOMFzTe5mCNeE1HoMwHKMQ4fj27YnjjrxhfN8YPcGjbwxrYAzTaxyV3ziTTzesJfEt8xf%2FDDGB26Mi%2FtZ%2FhGgJCd7RKvxbx3KTU7hDuqnBvhzM20rNe3Fk2pbBTwTcIOf7tg840w8c6hKw2wLsZyGnj04CEH6mrg6ieYz%2BKbjs7fkYrb4APIeEF6xQwLC5eYaJNxkZUCIUwbRa%2FHDuiP7RdzA2rtyeS29gTI%2FNwzH9Y9UxBSmiKFJbY5eCFPIXyGAfEbTi1wnhY3obmL9M9vkBEUKdMzGQOgzhokO9bh3cGuyCxpDWq90WHMEW7n4uYw2IPutjGBPpIvB9GCV0wPoGcLCQHPBzEdujlIUvSwLSELQLI3gEmd0kYq6A2AyQv%2Bkp9Ly4s%2Frl1y%2Fs39%2BnUwWBTNk7qTtar8AsiObT5Ewvg7SrBtLb875qNYm812XeNpTiba9oJy6rD%2B8LtjBRkbelIeYVRuwVnpaG0EBAaLOG%2BPshagWgLUnM0qAeamJWhZgHbssD6lRIeaMxvHdeHhYGrK3xcyqIHQEUgSWMS%2FBsAfAH1%2FihN7Z614aCwLVHy8WRVWW8bIpCx2fISE9LXLVKXAMO4F7hKsjB5lAa8qKs0aEeWapAYhaPm1XRuExRMum2yLV3D4V7aVHswDF3swAq7pzFGOpd9teN6V0lQFemAxdVjg7RuNRxenkaLyp5ybMGUVHplua1dweFaVuUQtbsspTzDsqXjq0qIKsKN1vVdA7NzXVy87BtbrZEUUVBB5cnUxqFEWuLmVNAzs0ba1KuAKoypCwqXlNEYQ4o4Z3FVmteb9C8%2BimGnIHNohMPpjzwtegljQren%2BhladHrjHso3EeLolfI6fvcuoF32WU3pnmVwFyZLlxrXuqweOualyVqXgo6vDzE1Fe8LFHxCiljk43PlhT4cBYsQfhhwJzGMrwfFESvxQhLadkL%2F%2FbzPw6cXYfB9uu3vwj%2Bej%2F646OocwTL%2Bd8rll10WEBiGkZngS6fIOOeJsh4VtsYi0qJD9czHKzYQOwIZlvDXAFmt22YxXD5nk9VaK2k5hS4jFZiFh1WmbKwF4PjDg2y6wqzL3qVkkpJ7h2LQXdnhJKLvqHEmDv3DsUQWZxkfu%2FpFTI0kopwqzIGrxYTv3Pyriveroe8C%2BfBybIFMfr%2BbtcEXfSF6nlw0iJmcaGIToSrGduyiXDSsK62DERTc43UPChIzY40YxB1FAXdWxpgZvE4%2BRVqloeQuFzktflG5fBrj55LAFySn%2BUBLmpe2c1DKMrXo%2BlNV5F%2Bg655Km7ts8zbm6IQxa3vdkxcXYscinA1qmXkJDpptM6hledczaIlSk%2B%2F02BGTxjITCg286aK0vWWtScU5%2BPeac1JqtxcIvflwoxBnjnIYwFRder2lIFZmwwlb1L%2FkgyVTOez1Tl6caUM0C%2FEP26TjlsxTemd07hcuaM0jefNHTRK4yn4HRWoSozLWiNtUaBipJ3Zr4lyiMDcmyj4l56iHpzt6VXlx%2BHt83WnU5paC7sz8ddej2xtiU5OMpOCri3Pc5VKXcq%2FRVHGEli6s4tlq4KqysIbnZukBB33G9zjNN8OOpOVdNkNFKZjUaGCSxCER3zsdjd5oSqqqvCxLfIxrQD0bITUX%2FDp9wsOh2vZ6iEfeD0dIYsG7FqmIxrtjm09HXHGPdTtoNOQ%2BggzwKhb7%2FMgGXBV%2Bm5HT0WoQ%2BFN7vOQbw3dnopw1J%2BKcMSpiO%2Fqd9dUwFYVbnZFMVPv8lDzMlm37WWyrhg8M4fO3%2BpBY10F67y9EZvFWoyX9xnDGvDaAbfN1gEXQ2KQKGMZhHWvXX0rl0He8Nlscp2AJwZTfrBmSLDh2QNCIQRRNqL24SPYhOSDdvS3O3reVFSjju6JgZNGXgLy%2Bz179qJn68iLAZlGvgG29%2FISi5tFXlwVpjdoq93DvdYjNE8nMhZeFOJZ%2FauWc%2BM8UTU5BFmAxNuh0v9IsOzsutzqAy6ndacssAYsnvdJVheY9OFGC7IMe8mcH4z8a4xjNG8%2BU5y%2BoFsQ7dgX24B8ZVhcufzoG0eGff60PT7YpbiCBxiOwOxpjtEm8o8wME1n5E7qRW2NNnjGn%2FDSj1VDfw4vYnuEHQ1CRez2hRiyrYSf4clt5CHKr3GHEiWaG49rnvbcTjY9MnkiftbBLsSGMla4T8tNGyLxvJPQUGxg%2BwevYHM5eyyjaJ7dZHnY9U2Wy%2F%2BKiZdR6lqP59K1NXXTS7NUoQwFZH%2BmxupnmihKAV7%2FlYYkU0C%2FQAYAe%2BvpcgOEyQLNUQTCm0PpqKjl%2FAcxOvRMkT8JwrReRw3JMrIDkTf2JdktHdxsQ2cMiYIDdkfV%2BLKF8zecoTaHhzfn7kuoP7xc3x5Uq58%2B98FPkies12vEIXktbErNFO%2B%2BpkMydvDtMHRjh4fxWnzUzoCNpKthzr0eRzEns73TAZuVHpd1smx06BR0srrsbiD24pk9H%2FUA7W2iTOu7Sw3EqRYtypwRZdy2N5caWBqswuv6B3YxtCxXFlrijEbNvfWhg96LK0r21hd%2FFlmZ7locE7%2B1u8405HgNd9cF0ux10F3YLrIhjvfWWMm2X2lItl00GnSfUFb4EJcyNg9mIDxmMfO9xBz5LKZa0JG11n2gWtpaMyqxmx3W1BTZZ2%2F4tcg%2Be19l66fqt9RIfSA9Ur9ynRPP%2BWhcGebwFeeJj%2B4gDujzxcmhCkbxabqHMh7lZqSkfvZnrIp6VL8vi%2F%2FpIUaIHFfHYLW4RT5kNf4H)
![SCHEMA](https://user-images.githubusercontent.com/40407778/118700868-b73d5100-b7d8-11eb-9fab-deff1207df62.JPG)
______________________________________________________________________
## Time Tracker
### First Sprint: 05-17-2021 to 05-19-2021
|DATE |TASK ID|ESTIMATED TIME (HRS) | START TIME (HRS:MINS)|END TIME (HRS:MINS)| STATUS | ASSIGNED TO
|:---:| :---: | :---:               | :---:                |:---:              |:---: | :---:
|5/18/2021| Database directories & comments | 0:30 | 3:30 PM | 3:50 PM | Completed | Chike, Quinn
|5/18/2021| Java directories & comments | 0:30 | 3:30 PM | 4:00 PM | Completed  | Chike, Quinn
|5/18/2021| DDL: User & Location| 4| 7:00 PM | 8:10 PM | Completed | Chike
|5/18/2021| DDL: Sightings & Reports | 4 | 4:30pm | 5:00pm | Complete | Quinn
|5/18/2021| DDL: Alias & Cats | 4 | 4:30pm | 5:00pm | Completed | Derek
|5/19/2021| DML: Test Data | 3 | 9:00 AM | 12:00 PM | Completed  | Chike, Quinn, Derek
|5/19/2021| User & Location Models | 2 | 1:30 PM | _ | In progress | Chike
|5/19/2021| Sightings & Reports Models | 2 | 1:40pm | _ | In proggress | Quinn
|5/19/2021| Alias & Cats Models | 2 | _ | _ | Not Started | Derek
|5/19/2021| User & Location Mappers | 2 | _ | _ | Not Started | Chike
|5/19/2021| Sightings & Reports Mappers | 2 | _ | _ | Not Started | Quinn
|5/19/2021| Alias & Cats Mappers | 2 | _ | _ | Not Started | Derek
|5/19/2021| JdbcTemplate Interface & Repo: U & L | 2 | _ | _ | Not Started | Chike
|5/19/2021| JdbcTemplate Interface & Repo: S & R | 2 | _ | _ | Not Started | Quinn
|5/19/2021| JdbcTemplate Interface & Repo: A & C | 2 | _ | _ | Not Started | Derek

### Second Sprint: 05-20-2021 to 05-23-2021
|DATE |TASK ID|ESTIMATED TIME (HRS) | START TIME (HRS:MINS)|END TIME (HRS:MINS)| STATUS | ASSIGNED TO
|:---:| :---: | :---:               | :---:                |:---:              |:---: |:---: 
|5/20/2021| Result, ResultType, Validations | 2 | _ | _ | Not Started | Chike, Quinn, Derek
|5/20/2021| U & L Service | 4 | _ | _ | Not Started | Chike
|5/20/2021| S & R Service | 4 | _ | _ | Not Started | Quinn
|5/20/2021| A & C Service | 4 | _ | _ | Not Started | Derek
|5/21/2021| ErrorResponse & GlobalExceptionHandler| 1 | _ | _ | Not Started |Chike, Quinn, Derek
|5/21/2021| U & L Controller | 4 | _ | _ | Not Started | Chike
|5/21/2021| S & R Controller | 4 | _ | _ | Not Started | Quinn
|5/21/2021| A & C Controller | 4 | _ | _ | Not Started | Derek
|5/21/2021| React Setup | 1.5 | _ | _ | Not Started | Chike, Quinn, Derek
|5/21/2021| Component Setup | 1.5 | _ | _ | Not Started | Chike, Quinn, Derek
|5/21/2021| Roles & Authentication | 1 | _ | _ | Not Started | Chike
|5/21/2021| Static Pages (About us, contact, FAQ) | 2 | _ | _ | Not Started | Quinn
|5/21/2021| Navigation Bar | 2 | _ | _ | Not Started | Derek
|5/22/2021| ViewSightings | 4 | _ | _ | Not Started |
|5/22/2021| AddSighting | 2 | _ | _ | Not Started |
|5/22/2021| DeleteSighting | 2 | _ | _ | Not Started |
|5/22/2021| ViewCatProfiles | 3 | _ | _ | Not Started |
|5/22/2021| UpdateCatProfile | 2 | _ | _ | Not Started |
|5/22/2021| DeleteCatProfile | 2 | _ | _ | Not Started |
|5/23/2021| Debugging | 4 | _ | _ | Not Started |


### Third Sprint: 05-24-2021 to 05-26-2021
|DATE |TASK ID|ESTIMATED TIME (HRS) | START TIME (HRS:MINS)|END TIME (HRS:MINS)| STATUS
|:---:| :---: | :---:               | :---:                |:---:              |:---:
|| Stretch Goals | _ | _ | _ | Not Started |

# Stretch Goals
-	Directions to cat from current location
-	share sightings on social media (embed link)
-	like and comment on sightings in app
-	user account page to view all your own recorded sightings.

