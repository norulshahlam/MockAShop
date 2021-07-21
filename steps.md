## Restful API tutorials

We will go step-by-step on how to create from scratch using a problem statement given.


### Create endpoints based on the features - For Hegderd

FOR CUSTOMER
`display product list`
  GET localhost:8080/products/all
  - pagination
`search certain products`  
  GET localhost:8080/products/{productId}
`display certain product`
  GET localhost:8080/products/productId
`view cart`
  GET localhost:8080/cart


FOR SELLER
`login`
  POST localhost:8080/seller/
  -id/pswd in body
`view seller dashboard`
  GET localhost:8080/{sellerId}
`display seller-product list`
  GET localhost:8080/products/all
`search seller-certain products`  
  GET localhost:8080/products/{productId}
  - authenticated, filter by seller-id
`display seller-certain product`
  GET localhost:8080/products/productId
  - authenticated, filter by seller-id



****************************

  1. create db
  2. Create entity / model - use lombok
  3. repository
  4. service to implement repo
  5. controller
  6. h2 / mysql config
  

## 1. create db - seller

create database mockashop;
use mockashop;
