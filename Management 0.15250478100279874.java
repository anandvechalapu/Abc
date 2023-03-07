·       Ability to access the management functionality.
·       Ability to access and click the sub screens of the management functionality, sub screens are
o   Branches
o   Publications
o   Publishers
o   Users
o   Wholesalers
o   Executive memos
o   Global settings
o   Archived data
o   Restore wizard

Solution:
To implement this user story, you need to generate a Spring Boot application with the following components:

1. Controller: This will provide the REST endpoints for the user to access the management functionality and its sub-screens.

2. Service: This will provide methods to handle the requests from the controller.

3. Repository: This will provide the methods to interact with the database and fetch the required data.