Build the domain model only for a checkout counter in an online retail store that scans products andgenerates an itemized bill.
The bill should also total the cost of all the products and the applicable sales tax for each product.
The total cost and total sales tax should be printed
Sales tax varies based on the type of products
- Category A products carry a levy of 10%
- Category B products carry a levy of 20%
- Category C products carry no levy

The code has been written using Java 1.8, Springboot, Spring Data JPA, H2 Database (in-memory).

Exposed rest endpoints for creating bills of products present in the inventory.


