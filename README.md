# discount_backend
discount shopping web application

Backend
to run the backend:

1.add local database password in /discount_backend/src/main/resources/application.properties

2./discount_backend/src/main/java/com/webapplication/discounthero/domain/AmazonCloth.java 

   change "@Table(name = "baseline_amazon_clothes")" to your local table name


The spring server side is running at http://localhost:5005

postman test
get all data in cloth catagory
http://localhost:5005/cloth/all

get one item from cloth database by asin
http://localhost:5005/cloth/user/0681256036 (example)
