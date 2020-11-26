# Simulator of Banking Transactions

It's a simple application to get a list of banking transactions from some input data.

##Requeriments
- jdk 1.8 or later
- maven
- spring boot 2.4

To simplify, was used a H2 in-memory database. So, it's not necessary install and setup a RDBMS.

##Running

Import this project on your IDE and run file SimulatorApplication as java application.

The app will load some data into database. Four bank accounts, with numbers 0, 123, 456 e 789. The password provided is the same.

For each account will be loaded a json file with a list of transactions (see resources folder).

The API has one endpoint at simulator/transactions/{accountId}. 

It is necessary a basic authentication, using same account number and password. Otherwise Forbidden HttpCode will return.

The return of API will be a list of account transactions, with required changes.

In this particular sample, account number 0 does not have transactions. For this case, Not Found HttpCode will return.


##TODO list

- Implement unit tests
- Use mapstruct, or another tool, to map dto from/to entity

