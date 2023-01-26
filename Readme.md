

Create E-commerce website where users can buy products ( amazon clone )


Classes Domains :

E-commerce Website :
- Product Class: ID, name, price , categoryID.
- Category : ID , name.
- Merchant : ID , name.
- MerchantStock : ID , productid , merchantid , stock.
- User Class : id , username , password , email , role , balance.


----------


Validation : 

Product Class :
- id ( must not be empty , have to be 3 character long ).
- name ( must not be empty , have to be 3 length long ).
- price ( must not be empty , must be positive number  ).
- categoryID ( must not be empty , have to be 3 character long ).

Category Class :
- id ( must not be empty , have to be 3 character long ).
- name ( must not be empty , have to be 3 length long ).

Merchant Class :
- id ( must not be empty , have to be 3 character long ).
- name ( must not be empty , have to be 3 length long ).

MerchantStock Class :
- id ( must not be empty , have to be 3 character long ).
- productid ( must not be empty , have to be 3 character long ).
- merchantid ( must not be empty , have to be 3 length long ).
- stock  ( must not be empty , have to be more than 10 at start ).

User Class : 
- id ( must not be empty , have to be 3 character long ).
- username ( must not be empty , have to be 5 length long ).
- password ( must not be empty , have to be 6 length long , must have characters and digits ).
- email  ( must not be empty , must be valid email ).
- role  ( must not be empty , have to be in ( “Admin”,”Customer”) ).
- balance ( must not be empty , have to be positive ).

----------

- Use project Lombok 
- Use Service layer


----------



- Create endpoint for getting and adding and deleting updating  a  Product.
- Create endpoint for getting and adding and deleting updating  a  Category.
- Create endpoint for getting and adding and deleting updating  a  Merchant.
- Create endpoint for getting and adding and deleting updating  a  MerchantStock.
- Create endpoint for getting and adding and deleting updating  a  User.


----------

### Create endpoint where user can add product to a merchantStock
- this endpoint should accept a productid and merchantid  and stock
----------
### Create endpoint where user can buy a product directly
- this endpoint should accept userid , product id , merchantid.
- check if all the given id is valid or not
- check if the merchant have the product in stock or return bad request.
- reduce the stock from the MerchantStock.
- deducted the price of the product from the user balance.
- if balance is less than the product price return bad request.






