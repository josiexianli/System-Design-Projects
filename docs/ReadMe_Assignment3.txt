CreateAccountService and ReturnItemService are both calling DAL(Data Access Layer) to retrive data, where their corresponding tests are testing the features.

In DAL, I have implemented getConnection and executeStatement to create connection and execute scripts to interact with the database. hasDuplicate first checks for duplicates
of the account when user is trying to create an account. If there is no duplicate, it will insert a new row in the database.

When a user is trying to return an item, it first checks if the item is reserved. If it is reserved, then it will update the row and send out an email (in this case, simply print out "Email has 
been sent to <email>").

The tests should only throw an error if there is a problem in DAL, otherwise it will not generate any outputs other than the proper rows getting updated.