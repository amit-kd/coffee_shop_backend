# coffee_shop_backend - Spring Boot, JAVA 8, Postgres SQL, Spring Security OAUTH2, JWT TOKEN, Heroku (Server), CI/CD Integrated
This project contains back end for the Coffee shop. It includes 3 projects. It follows microservice architecture. It includes 3 projects.
1) Parent Project(coffee_shop_parent) - Which includes all dependecies. It generates POM.xml.
2) Common Project(coffee_shop_common) - This contains all common code which can be used by all the microservices. It generates JAR library.
3) Microservice(coffee_shop_auth) - This contains backend logic for sign up, login, product listing, orderviewing, modifying saved order. It generates JAR file which be deployed in container.

# How to RUN
1) Build coffee_shop_parent first.
2) Build coffee_shop_common
3) Build & Run coffee_shop_auth

# Deployement:
Push any changes to master branch. Heoku will auto start deployment to https://i-coffee-shop.herokuapp.com (Live).
*Note: If page loading takes time, that means dynos are sleeping as I am using free version of Heroku. Just refresh should work. It is mandatory to refresh beore launching the front end application.

# URLs:
token url : https://i-coffee-shop.herokuapp.com/coffeeshop/v1/oauth/token - POST - Secured (Needs basic auth with client secret)
login url : https://i-coffee-shop.herokuapp.com/coffeeshop/v1/user/login - POST - Secured (Needs Bearer token)
signup url : https://i-coffee-shop.herokuapp.com/coffeeshop/v1/register - POST
product listing url : https://i-coffee-shop.herokuapp.com/coffeeshop/v1/products - GET
product details url : https://i-coffee-shop.herokuapp.com/coffeeshop/v1/products/{userid}/{productid} - GET
product like url : https://i-coffee-shop.herokuapp.com/coffeeshop/v1/products/{productid} - POST - Secured (Needs Bearer token)
order listing url : https://i-coffee-shop.herokuapp.com/coffeeshop/v1/user/orders/{userid} - GET - Secured (Needs Bearer token)
order details url : https://i-coffee-shop.herokuapp.com/coffeeshop/v1/user/orders/{userid}/{orderid} - GET - Secured (Needs Bearer token)
update order url : https://i-coffee-shop.herokuapp.com/coffeeshop/v1/user/order/{userid} - POST - Secured (Needs Bearer token)
create order url : https://i-coffee-shop.herokuapp.com/coffeeshop/v1/user/orders/{userid} - POST - Secured (Needs Bearer token)
