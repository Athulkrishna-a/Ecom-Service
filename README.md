
# E-commerce Backend

This repository contains the backend code for an e-commerce platform built with Java Spring Boot. The project provides essential functionality for managing products in an online store.

## Features

- **Retrieve Products**: Get details of all products.
- **Add Product**: Add new products to the inventory.
- **Update Product**: Modify details of existing products.
- **Delete Product**: Remove products from the inventory.
- **Search Products**: Find products by name or description.

## Setup and Installation

To run this project locally, follow these steps:

#### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/ecommerce-backend.git
cd ecommerce-backend
```
#### 2. Configure the Database
Ensure that MySQL is installed and running on your system. Create a database named ecommerce.

Update the application.properties file with your database credentials:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
#### 3. Build the Project
Use Maven to build the project:

```bash
mvn clean install
```
#### 4. Run the Application

Start the application using:
```bash
mvn spring-boot:run
```
#### 5. Access the Application
The backend will be running at http://localhost:8080.

### API Endpoints
- `GET /api/products` - Retrieve all product listings.
- `POST /api/product` - Add a new product.
- `PUT /api/product/{id}` - Update an existing product.
- `DELETE /api/product/{id}` - Delete a product.
- `GET /api/products/search` - Search for products by name or description.

### Contributing
If you'd like to contribute to this project, please fork the repository and create a pull request with your changes.

### License
This project is licensed under the MIT License. See the LICENSE file for more details.


This `README.md` provides a concise overview of your e-commerce backend project, including setup instructions and API details.
