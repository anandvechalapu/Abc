·       Help page should open when user click on any of the functionalities.
·       The user should be able to get the information when he accesses the help page.

Spring Boot Application

Controller:

The controller class will handle the web requests and will call the appropriate service methods to perform the desired operations. It will also be responsible for mapping the HTTP requests and responses to the appropriate service methods.

The controller class will contain methods for each of the functionalities that are displayed on the page. Each of these methods will accept the web request and will call the appropriate service method.

Service:

The service class will contain the logic for performing the operations requested by the controller class. It will contain methods for each of the functionalities that are displayed on the page. Each of these methods will accept the appropriate parameters, perform the desired operation, and return the results.

The service class will also contain methods for getting information from the repository and for saving the data to the repository.

Repository:

The repository class will contain the logic for interacting with the database. It will contain methods for getting the information from the database, for saving the data to the database, and for updating the data in the database.