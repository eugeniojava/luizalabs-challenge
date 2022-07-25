# luizalabs-challenge

## Running the application

### Requirements

You should have installed:

- Docker
- Docker Compose
- JDK 17+

After cloning the project and having the requirements done, do the following commands, according to your system architecture (either x86-64 or ARM64V8):

x86-64:

`cd wishlist-service && ./mvnw clean package && cd .. && docker-compose -f docker-compose.x86-64.yml up -d`

ARM64:

`cd wishlist-service && ./mvnw clean package && cd .. && docker-compose -f docker-compose.arm64v8.yml up -d`

## Using

### Endpoints

#### Add a product to the customer wishlist

POST http://localhost:8080/api/wishlists/customer/{customerId}/product/{productId}

Example:

`curl -X POST http://localhost:8080/api/wishlists/customer/userid1/product/productid1`

#### Remove a product from the customer wishlist

DELETE http://localhost:8080/api/wishlists/customer/{customerId}/product/{productId}

Example:

`curl -X DELETE http://localhost:8080/api/wishlists/customer/userid1/product/productid1`

#### Get all products from a customer wishlist

GET http://localhost:8080/api/wishlists/customer/{customerId}

Example:

`curl http://localhost:8080/api/wishlists/customer/userid1`

#### Check if a given product is in a customer wishlist

GET http://localhost:8080/api/wishlists/customer/{customerId}/product/{productId}

Example:

`curl http://localhost:8080/api/wishlists/customer/userid1/product/product1`
