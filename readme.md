1. Hibernate - ORM Framework
2. Maven Dependencies
org.hibernate : hibernate-core : 4.3.6.Final

org.hibernate.javax.persistence : hibernate-jpa-2.0-api : 1.0.1.Final

org.hibernate : hibernate-entitymanager : 4.3.6.Final

org.hibernate : hibernate-ehcache : 4.3.6.Final

javax.validation : validation-api : 1.0.0.GA

org.slf4j : slf4j-api : 1.6.4

org.jboss.logging : jboss-logging : 3.1.0.CR2

org.slf4j : slf4j-log4j12 : 1.6.4

mysql : mysql-connector-java : 5.1.10

3. Database Connectivity can be achieved using
    1. JDBC - a. Driver Manage
           b. DataSource
    2. ORM - Object Relational Mapping

4. ORM has JPA - Java Persistence API

5. JPA - Specification - Rules - Interfaces

6. JPA Implementations - Hibernate, Mybatis , Open JPA, TopLink, Eclipse Link

7. hibernate.cfg.xml
<hibernate-configuration> -- <session-factory> -- <hibernate-properties>
           
8. Core Interfaces in Hibernate
    1. Configuration
    2. SessionFactory
    3. Session
    4. Criteria
    5. Transaction
         
Buiding Hibernate 4 SessionFactory
https://stackoverflow.com/questions/7986750/create-session-factory-in-hibernate-4

UnknownServiceException
https://stackoverflow.com/questions/26469263/org-hibernate-service-unknownserviceexception-unknown-service-requested

         
Steps
1. Create a Maven Project
2. Update pom file with Hibernate Dependencies
3. Create hibernate.cfg.xml file with hibernate-configuration and session-factory properties
4. Create ORM class
5. Create SessionFactory using Configuration and StandardServiceRegistryBuilder
6. Create a Session from SessionFactory

create/insert
session.save(); // return type primary key
session.persist();//return type void

load/get
session.load();//returns ObjectNotFoundException if entity is not present
session.get();//returns null if entity is not present

update
Transaction tran = session.beginTransaction();
session.update();
tran.commit();

saveOrUpdate
session.saveOrUpdate();//saves if primary key is null 
                       //updates if primary key is present

-----------------------------------------------------------------------------------

Java to Database associatations
One to One Mapping
Customer Class
@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
private PhoneInformation phoneInfo;
    
PhoneInformation Class
@OneToOne
@JoinColumn(name="customerId") //Foreign key in PhoneInfo table
private Customer customer;

One To Many Mapping
Customer Class
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @OrderColumn(name="idx")
    private List<Order> orders = new ArrayList<>();


Order Class
    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @Column(name="order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    