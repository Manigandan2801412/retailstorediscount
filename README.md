# Retail Shopping Store Discounts

## Overview
This Spring Boot application calculates the net payable amount for a given bill, applying various discounts based on user type and bill details.

## Prerequisites
1. **Java 8 or higher installed**
2. **Maven installed**
3. **Setup**
4. **Clone the Repository:**

## bash
git clone <repository-url>
cd retail-store-discounts
Build the Project: '''

## bash
mvn clean install
Running the Application
To run the application locally, use Maven:

## bash

mvn spring-boot:run
The application will start at http://localhost:8080.

## Testing
Running Unit Tests
To run all unit tests, use Maven:

## bash

mvn test
Generating Code Coverage Reports
To generate code coverage reports using JaCoCo with Maven:

## bash
Copy code
mvn clean test jacoco:report
After running the command above, you can find the HTML report at target/site/jacoco/index.html.

## API Usage
Calculate Net Amount Endpoint
## Endpoint: 
POST /api/bill/calculate

## Request Body: JSON object representing a Bill:

## json

{
"totalAmount": 200,
"itemType": "electronics",
"user": {
"employee": true,
"affiliate": false,
"customerDuration": 0
}
}
## Response: 

Returns the net payable amount as a double.

## Technology Stack
1. **Spring Boot**
2. **Mockito (for testing)**
3. **JUnit 5**
4. **Maven**
