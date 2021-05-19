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
[Link to full diagram](https://viewer.diagrams.net/?highlight=0000ff&edit=_blank&layers=1&nav=1&title=Capstone.drawio#R7V1rl5s40v41fc7uh%2BYgievHviWT2c5l053MvJ%2F20DZxM8HGAzid3l%2F%2FSoBsQBIIDBhvlLObiWVxsfRUPVWlUukC3ax%2Fvo297fP7aOmHF1Bf%2FrxAtxcQItdy8H9Iy2vRYptu3rKKg2Xeph8aHoL%2F%2BnkjoK27YOknRVvelEZRmAbbauMi2mz8RVpp8%2BI4eql2%2BxaFy0rD1lv5TMPDwgvZ1j%2BCZfqctxoAHdp%2F84PVc%2FFk0ym%2BePIW31dxtNsUj7uASLfADTTyr9cevVXxO5Nnbxm9lJrQ3QW6iaMozf%2B1%2Fnnjh2Rs6aj98e71j%2FD%2Bu%2FX2938nf3tfrv%2F1%2BOHrZX6zN10u2f%2FA2N%2BkvW%2F9J3j5Co3l%2B9uXt39%2FWRlPi5ePPy6d4t4%2FvHDn02HIfmz6SseXjNFW8hXo7fw49X%2FyZt97orc9DCGGph%2Bt%2FTR%2Bxf2Kqy6hWQx7ActLFxbz9nKYZJNC9bk0wcDQi55egazV%2FvaH8cH%2FKIaoy3DB9uHCMNmSfxIc%2B%2FEFuv4WbdKH4nuAPydbbxFsVo%2FRljTouAWPCkWuUXzeIxYYecOnKAnSINrgptD%2Fhr%2B5fk7XIb1lGkff%2FZsojOLsJZAOHd3Vi4eX2u%2BMN7d35IpvQRiW2vM%2FuJ2d52bc1CeanVCZ6dL00h841uQhZvIybZgwU4h%2FUsqM6iba%2BLWBK5pKE5HNda4hocGZezJeAVZdV2GwIlO5DpZL8uW1VzQs8LjvUcObuOEniH6LHM0Arm7YVv53Rfwg0FwAATRc%2FA00HCoJpdlFOtAsB5qEUrK%2FDc5kuxp0oGW5Lu6gu%2B54k20wk%2F0lwQPLSOtLsA69fGZLc0VEZ%2FEchMt77zXakZdPUkwX9NP1cxQH%2F8X9vYMEevF%2B5i0BTvYXPZCbFY%2BJ%2FQRf9olOKKg1vfd%2BVjree0lKXzAKQ2%2BbBE97eK29eBVsrqM0jdb0KkJw%2FrL4lHz308Vz8UEEMbE2GQ18hqtZbgVwFtIAhpuBbIhhgkzDYgAHHF1DgAUZcqGG4YUcV7dsE1sC1lggMzl0gAdJ32GovcNXXuF%2FP6Qx1vYXGBQQgXwQaZeNt%2FYbO30L4iT90NYr9CQ6%2BWsvCBt7LIOEsHPx2tfYhPO9DdNr4aVJ3uPGS%2FHfF%2BZ19vdtpedxCpUqw4Lo6kozJcxJafQ%2B63NrHFo%2BF0ggTRG%2B9luYWW3PWNX6m0wiUo%2FaIeRtt1GwSTNo4J9iXmOz40bXzOwX3eDP4PAZ%2F490j7HUbPBv8YJMCnw8%2FC8%2BkcqjlbYhLTdULctLBUBYhZsG%2Flq3DKQ79khCgaVWIBUrP%2F2SCcY%2F8Id%2F5iB6h%2BluRfRyDWZFXyIhpd4C5OLOb6ikSPW%2B9zp0viOSI9UTq%2FV0l5S6ioQI98XSU%2B7ZJEykLeGM3Y8IT4SgY23gRF15wybqyxk0Udf6kIn6MQMm6lgbLaab0jfT6Btg2jwlIqF%2BIDI00zEhNiR0hO9jmGORssuon0y4lOE3R8PPBJpR9TQM29GAy%2BLKdjWT41EYCLe7I2HJ1QVUhq0gat%2BJGKzVuFv6ySIOtrlT39BvGyzSXVy7VwNVRC8b4kGS3h%2BzfzL6NNO6zQyFVaKX%2BEWnK%2FKh8ZnfYv%2Fv%2BwiPStuP8X6sHoO1f%2Bu95t1uvdQnDUqbH6%2FNXWnha7AeBWIGqJSOYC9aYnvxhsiZnLkobc%2FdHuROqv%2BnXP44fRsEAl%2BXCV%2FpKr4wdjQbr3K5LHVuF05iHpfkU%2BpHX%2B3ltNSdK6wHC03KOJW0IPmTJOpdTJGMJVmflaNNU3ZGhMY2fxKEN65NQbmLUpaTK0tgsyFPkbaElj2iUcKGNh%2FIozNJVlbuHK1cBDUbldc4jIrJ6yJ2aQtji2PsWvpYoBKFMpMCWm3mLu1HOCLvSVRdmH0U9c24pNqXSy8%2FgmSHv8aU0Ehb%2B1do61hY1Ik0m8tYzHKB0SxeWzGU92azUurHKnV3iPgpV%2FCA6Yxl%2FkKR5HUzfx9K8le6QiyEpWuI0PGu4Qojvu7rXh7lwqIluexicSedTe4RA7Akaszablzh7WgRC2aurXtt0kTduXM1gB09WOiWRpcrg6tCvCdTiYBGhdt0IqQpAsfoROv3365%2BS77%2F%2Fdb%2B8%2Bnrlxf3r3D16ZKNuh3kTBm4szRwdadi0dZX7znxXNE6gT4A03JRxUt1K5tjbRZuGG1WQbpbti3Gp82dlB5r0WONKmGMlXFrLMQ1LITf70EnZ97dU%2FBJrm%2Bnkp0TwauIaZp9D%2FGCMfMWitVPIw0uy%2BnCPBFgjCQObJy%2FiF0rTj8HTkfQ0XT9QOryCnY8TrcFGjZbvmwj9KxTa%2BJcy1KvUmB9FJglDcYZ0bkjpvOrHG9yXH5FcSfF5bIxoIT3Fo2LVpJLca1xDCUCk4jALDic3UPx2SeDpEj8PEjcotm5Mnn0YIAlTC6K2BXMXNvEGZbaeLucXS%2FqI5GgJbuyJZun1bZIpNRkHzWJpBHfIyVeByMBvGFN53OBcfkkeNm%2BPVaLZPt3zZmSXohJuAPSlNku1bHr2otU5245Se0LJEohTKIQAJTPUgcuPF4j8Bdi2LR0BgEn2WkNoFM1ES5tw2EGzNJ5W3d1NFYWP5QYrl9ip%2FUeN512Wk89XYhdsruN1lj2j9Vyc9xb3WFKim%2Bh6WiuawHDNVwd2ciuCByCmqkbjmkgy3ER1Dl%2BHrA1aDg6cADUdcNE7ORCSyvdAu03aA%2BfsOKwcdzPfrIL08dXLI5Q%2F8fdhy%2Fv%2F6kcwikcwu5QRJZOoriuDXXHRI5JZ7PAomNgoJrQJHu7dB2YrLcIdaAB3g4BNFbVDeCIwrwl3GUmlr%2FZrZVd1U%2BrHeT6qOw5ATqM8dSRKCz78OXm5u7hgbHN3334enX%2F7pZp%2F%2FDx8T9vPn75cKsQNBmCLNbSFCHIGst2AZxdfrliURx2lhyG2as3iTkDhDwFKGPzjy6z4XkNI68IQT6WlBL5Mt0zW9nCqnRZ%2B0nirfY7NePYe70P8KRDKyTQ24doVumF2jg0hJJzh0hFEuHPHE%2FJQQFNrvwMVqVAFRdreecgedgtFhhycjnWn3Jwlzo%2F8kJlbDduUA3f8H2B9nIKthzaswX%2F5bK4AfMoJQwTCQNdwpJRxkOkjQjem13HZDDgb5ZXpDwl%2FvQURoSBr5de8pyxIxkj%2FP2bgDw3mxT8qSB0ANm4RTfirIWM3hjmteWSZ%2FwM0j9x2yWhP7No%2BD%2FyAhqwreLzLbUAsg%2Bv%2B9fD40avBYC25BcjG9KGw9XZp8rln%2Fw4wONPQij7B9TbOnJ%2BEu3ihS%2Bjt7DFhOVfxhHwl5V6oY1xMkA31MU%2BSdz9Ub6Qj7vidp%2BIDJaCqFbNBHFrG%2FXyH1pcdUAvcyMEW26UjwNzo4z4S90KHSF8YUgNHRqDKraxit6r3h%2FYdk0K8zc4yOR%2BwI8RU3ah%2BMZLH%2Fz4R4BRo6zzWVrnsBrdhDa7%2FCI2v8fa3wqEG1xJzkESpFH8ut8I9vnQpAyDnobBIFsxJw8muaJaJNh0ZCxkanVmWwcZk%2FMyv02wJNv6Wq%2B7gRdXOltWJ8A2SBgKrF3%2Bcw9XXr9WlrXz7twHXL%2BSlfUej9ltl9VdizIjQ9NqQmw38N5RidxEItch%2Brav6jiCzLFLvQSNiuXPieVpKVwZKNljuXVQF9Vrq5M8AZhi%2BeNVzhAlxyZneaizodh2ls%2FLh%2Feg%2BcqFfXhe8GQh0Wf9%2BQ9q4evGJ3EJm1tUXYnPWOLTibHH8qUgrdrPqUClWPucWNuw5Wl7T64j4IkXjeXRNkWZou5jdc9Bhs%2BMukVbR5qo%2B1Aerwd9Mxf3ofCGNxDSeOma7k671AOzm2CXu%2B89WqyJ1uu5FoWwlqGS7LEku4tVgQYQbX55Ftao%2BJoLZoAHShkU8zQoWlJxDNOqpuJ0ANoA6aR8oImsjXoqjtI%2FLfqnWY7naljw31pkVwTJh10YfoyvsbL5zst6USiZBiUTp4py35qNVOebF5XXe84kZelOX5KyB%2FCJ%2BfIhG8nOAagc4mMV0twj2XyUiALZHHeS1ulo8ANZF3B%2FkTChUuj9tVza4ju2XM31HJlfWHHuZZ%2BkxGcS8enicw5xSixffti9Q1llJMXns%2BbzWhTbcjpgiSZqDo8l3o51HmNnCFOEfbQH4UjDZkaMDUV2HYexi%2BqYnQibXtOdr5uvbKHr5ou5bF3%2FdVJkXXuOkpxpJKcDWbujle9mE3hp5WJF17Oma2SjxpIDyOzrfg9xHBIfbKI84DqZUwgqPj9aK5nSuJoRnwNRaQoOnwsPi2mm9NJl3Vm99eIWYm%2B9nsvtnF8qRe%2Fs05QsTSNLXRh%2BrOSO%2FX7PijDlyHgGJQRmLU9xvQU%2FtNyNDx1hLS8xigo44Abz8CkvKkbseXT98hyk%2FgNuJ496ib2tEDCd6Zqd8E7V4IScfImMqhN9CQDd9ljGgMU5%2BAfB0fblGjz3qDaRJ6mSB3XbqI2XzTml3KbvW1vKzirnA2S6ePTQEFVHBcPHiwfXjeJfoWreAUjyEgFqp3IimupSrqtHSyNW45PjnQ5IDZdyYT1MOscS4xzL6vWZM0PXSNFOWzdNw8WzU51AC2qmA01s%2FdnAMQxOGVDkYsFEyLVN3TFcZHNmF1qaC6BFpXcQB1fw%2B9nEFJLh9%2FvyafHor7chtpwa3Azl7I7g7PbBpIMxiR1ZaLvAsLBKroLSMEhxItuyXBe7xGBf8UUqo5%2BsU5eKPI5Wq8hgs2GI%2Ff5XCYm5%2BV7GpjLW%2B%2Bq9IWqciysKaXqlMOhomGE94cvcOeWeAKqwMhFWHMAFgAR0kK25o9WjMjm%2BHsmsvw6INfGN%2BFL443U54NCyaVMR4DwIENLiSpTxdF4BEKjxjC0ARysiS88g5UbqBt582Ryh43Zh4nBPgrJq3IDbk8pGPUqtmsMsJvNB7dpjYdo6zzJmtBaZflEpQ2ZetBQhK8qfgYty5TNaB41f96yrmmsvSEbtnPaCZFTjnKQgGUSaBU0LmLaFTMOi5eAL9JrYqy3XnK%2FeXrpYGUAa%2Fr8FHQf7JQg72h0eIihkNljtMJuNhWFDVDnTZ2VLMM50tQqd6UASvynCqrrbodIYQhVfeoDz8gQwZAN4ypUejcdt%2BYWQGbvSNkvrhSv9KViku9hvOFaq6JglSnH6KVxNhKv%2BbrcJR3S7bV5ii7IYR7UYqTi3W4y0HMdJLEaaNEAzAkxds2p3kTUMLzG%2F2poLXNPQSUqgY1ZTvjAMTQ0ZtmMZuk1i4bWk7NFtQ85uz5bgU3NZUGUvzsNehC4kZh3AT7IdB9h2NRRlZut9umW7FgAY4Ly1F0FgCo1nIYoq086%2B%2Bmc1rMV7gopqndRqGaYIr0AixqvOb7NLSbQqjPLfz0ofX2Iz2HVL%2Fns1DGVDZ%2Fb%2BO7tOpfz38TSWLY2wOfvv7FJTV%2F9drZmfElQzdd4diexY5bwP7Ly7ss47XWI5hfNOzrcwNBqlol62gyB24fX9n77evAF1W7Pg3puvH1Fj2CVnvrbYObYr77DLPG2uvEQVUWU%2FzsN%2BhC7QoHPw5%2BuVexyz4s%2BzJ2cLvRdjvNOK2RWfX7dEaDVEIHxfFSc46bm9w6yaCSQNDJD%2Bwt3lhthlsryYjwoSnJWSv7RhNUhQTSMBuuFWogQdqr1AayzsqQz56bazojET5MEQde35r63WWgd218pOGH%2FIT3kGKHQwwA5lLmobRgEwLc2E9n4XKOzpjVnQcsXemIEsawpvjD%2F8nGoILc5Ya%2F1KxdLzYGnMvE2uGFaj1il9sUZ10NEVayk%2B2aO4JnHDqhUyuj2OumF971EvEcJ9W%2BWEndLGGWblY3IfrHv4ra3%2BoVL481D40LWaFL5j2PPT9y2ht6ZQVnMJQ%2BnyjCrgdQa69jzjXZC1rjMMqnDXWenVS9tqCnc5rt43J6bJZz0OeSoJZjrtBMfMgRkiOYGvU1VuwuTBrhMmHABoNAW7sH4bKNZlo4ZYF8lLOFWsC7KeDy1fqQj5zAi5ef0J6kbv9aexPB2qXRUjT8HIY%2B4qHaI6BP%2BteUfaKUYek5HptM9x%2BQkBMMXykwnB6SiZs5OqJRgpUb9d0fQ8aLptAQpYYHYBSchLATimPLwgeNmxRrzwUSoseUozY5gTEEYMSwoOHGdBjmEQbzQMsv%2FgcVp8J%2FXOjsPEiQsWD1N03TUdDWunw5%2BKArsEuks2tVnQNLGxiD%2Bx25MNw9XM0h%2BLnWgENNewCT8TrYxMWvFhhHnnxKO3W8WfA%2FPnMNgDulPdC3%2FpdtjW5IwHIlFZxjXWr2rz27G53QchHcN3HeL8Jf5r0wOYyr4qdqqo8sAD9hytoo0X3h1arxe7%2BMdeDg9SCepSebj6PspPOcCNf%2Flp%2BlqoF2%2BXRlXSEbilDU6piSz6%2BZMfB3hcCOf01Aoib7mbtmjd7QalN7vRkyZaPV1pr%2FY4vHDWRhkAneTgEGTXWN42ISNfDuIQOYCj7VCGnAU9lrd%2FhYNCYIfVNjqj1fnkzSZiZ9Ol5%2BaNMJkshWI2wSMZhn6cnLnlPdSsAXKOR9n2dirTCLNCkrZh2K7juLoB2WX3WdneiA110Vyjw9wrU3yKUFYPMJpGtdaarbMmF8Jo4xy%2BBWkJlREwxfrxZE0pKU5XrSS0iY5cVWa5HGbQILEeAUboOUgjQER03CVzBuUWD5x%2Ft0mD9JUGKT8%2B%2FYUNp32IkkTmdVGwc8BN0vyXkd%2F9fOot1LwTOttHVypgy7%2FT17wijTqBc1oBd%2BVJAMABSIAbgzZYW5LgX9kUs7cpaDbYvnzrtCYFF00mmxTIWBQEXsqaOGrhaC%2B0czUm%2BODgHVba05boZkV0PdOH%2FwqNd1Gk%2FUvI0Sw4mwYUqyedKMqePWWT6lY0LNhwDvv0tM0%2Ff6JC2xhhirWP0jZ7sT0v1uZllU7C2h0LnvPfoO0mx5RDV5z%2FS0jhPDifjf9ne0EV68%2Be9WuOOuKcS38CypeI%2FWcAU6R%2FnLqZe9yf%2F9aisL8077ZXV6Bh8q6VGQawO05M3KX7KKGaRqjmweFsEk5emUmR%2BOxJnBTHsUul1fXqbquZkDr%2FHIoKqeeIU6x%2BnAIa5PjwqVnd4pVs6MTqHSrXHV2y7vx4XcnSNLI0CzK32NUsustO0fns6dy0ak65OXFGHh9T7MIOw98UZIrBj9I6e%2FE9LwZnF2o6MnjrxuFmDu%2B471ixuJKnebM4u7p1F8dRTIGiCHymBG7UDobqgKYR%2BZtdpCH8nQZrH8%2Fgentg8PAWq7hH3F7SW6Tr2k8Sb1VQ%2FUMaZ3nCSiP10kiDHIY8OcOLCois%2FPSR4qhW2YMHpv1F73NElWsUF7Cq9X3aYfVV6kbZ8fFAjZJMrPA6DV7nwaDsUtHbMHrywrufC39LbMXfvM1S%2BcIzplK36gvzuBTR4nLVk5RG04KiIhHPGZb20Go17WvGnMBXmPVdlTbtpU2HKIPBRb092iZ9mpo0mxoYPUos9qibAY1DscfzqZxBd0a2ls6gu%2FWnr5zBz3nn1ExkmPl%2FrBLEQBWVXLNWCgIYbPY2txiERaseDT%2BdbE7Be2%2B7Pf86EMPMGQTYIC6VgbBrEwjcagE2xMzniapAcCfbZhdwSepyPuHKvp5nHTaMryroTHanJnA4SmM889oW7cRbe9vP0UvJUs33vCkTtI8JupfWY0xQLjKGMEH5r8wuQNIVH6VkZqxkoEnBRosjG%2FDkSka0VskomcOiolI0vRQNlMbLbBQNu%2B6Wp4cpNTNnNQMp1GakZnj%2BLFfN0PxDpWR6KZkhltMmVjLsWlq2tUTpmDnrGF2v%2Bktz0DGi7VCMjim2LikV00vFWNJgmY2KYcNvN54yYmatYMgRg7AWCKSVYE6oY8R18Ws6JitJoDRMLw0zxL6daTWMw8Z8aQVJpWbmrGbqIZkZ6BhHOu57KFKqFE0fRePMKfaLP8ZRlJa%2Bext72%2Bf30dInPf4f)
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
|5/18/2021| Java directories & comments | 0:30 | 3:30 PM | 4:00 PM | Not Started | Chike, Quinn
|5/18/2021| DDL: User & Location| 4| 7:00 PM | 8:10 PM | Completed | Chike
|5/18/2021| DDL: Sightings & Reports | 4 | 4:30pm | 5:00pm | Complete | Quinn
|5/18/2021| DDL: Alias & Cats | 4 | 4:30pm | 5:00pm | Completed | Derek
|5/19/2021| DML: Test Data | 3 | _ | _ | Not Started | Chike, Quinn, Derek
|5/19/2021| User & Location Models | 2 | _ | _ | Not Started | Chike
|5/19/2021| Sightings & Reports Models | 2 | _ | _ | Not Started | Quinn
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
|5/21/2021| ErrorResponse & GlobalExceptionHandler| 1 | _ | _ | Chike, Quinn, Derek
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

