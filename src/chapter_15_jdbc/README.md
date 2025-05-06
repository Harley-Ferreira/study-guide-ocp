#### There are two main ways to acess a relatiuonal database from Java:
1. Java Database Connectivity (JDBC)
2. Java Persistence API (JPA)

###  JDBC URLs have three parts in common.
#### protocol:subprotocol:subname
- jdbc:hsqldb://localhost:5432/zoo
- jdbc:postgresql://localhost:5432/zoo
- jdbc:mysql://localhost:3306/zoo?rofileSQL=true

### In this section we learned more about DriveManager, but don't use a DriveManager in code someone is paying you to write.

The most important thing that you need to know about SQL for the exam is that there are four types
of statements for working with the data in tables. They are referred to as CRUD
(Create - INSERT, Read - SELECT, Update - UPDATE, Delete - DELETE).


For the exam you need to know five key interfaces of JDBC:
1. Driver: Establishes a connection to the database
2. Connection: Sends commands to a database
3. PreparedStatement: Executes a SQL query
4. CallableStatement: Executes commands stored in the database
5. ResultSet: Reads the results of a query

### TO RUN THE CODE IN THE SECTION USE THE FOLLOW
- java -cp hsqldb.jar SetupDatabase.java


### Working with PreparedStatement 
In java, we have a choice of working with Statement, PreparedStatement and CallableStatement.
Use PreparedStatement because of the following benefits:
- Prevents SQL Injection – Parameters are safely escaped.
- Performance – SQL is precompiled and can be reused.
- Cleaner code – Easier to read and maintain.
  
## 📌 Observações:
- Use executeQuery() somente quando espera um resultado de dados (tipicamente SELECT).
- Use executeUpdate() quando está modificando dados (INSERT, UPDATE, DELETE).
- Use execute() se não souber o tipo de resultado (geralmente usado em scripts dinâmicos ou procedimentos armazenados).