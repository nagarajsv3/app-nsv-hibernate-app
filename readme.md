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
    
Many To Many Mapping
Reviewer Class
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="reviewer_task",
               joinColumns = {@JoinColumn(name="reviewer_id")},
               inverseJoinColumns = {@JoinColumn(name = "task_id")})
    private List<Task> tasks = new ArrayList<>();

Task Class
    @ManyToMany(mappedBy = "tasks")
    private List<Reviewer> reviewers = new ArrayList<>();  
    
Natural Key
CREATE TABLE javatraining.CLERK
(
	ssn VARCHAR(11) not null,
	name VARCHAR(255) not null,
	joinedDate DateTime not null,
	terminationDate DateTime default null,
	active tinyint(1) not null,
    primary key(ssn)
);

Inheritence Types in Hibernate
3 Approach
1. Single Table Approach
2. Joined
3. Table Per Class

Inheritence Type : Single Table 
@Entity
@Table(name="cd")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="cd_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Cd")
public class Cd {
    @Id
    @GeneratedValue
    @Column(name="cd_id")
    private Long id;

@Entity
@Table(name="cd")
@DiscriminatorValue("InternationalCd")
public class InternationalCd extends Cd {

Inheritence Type : Joined : Common Data is persisted in separate table and distinct data is persisted in its own table
@Entity
@Table(name="person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue
    @Column(name="person_id")
    private Long id;

@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name="student_id",  referencedColumnName = "person_id")
public class Student extends Person {


Query in Hibernate :
1. Criteria
2. Named Queries
3. HQL

 Criteria & Projection
 Note : Association Did not work with Criteria
//Count
 Criteria criteria = session.createCriteria(Customer.class);
         criteria.add(Restrictions.eq("name","Sai"));
         criteria.add(Restrictions.eq("city","Newark"));
         criteria.setProjection(Projections.count("name"));
         List list = criteria.list();
         
//Group By          
criteria.setProjection(Projections.projectionList()
                .add(Projections.groupProperty("state"))
                .add(Projections.count("state"))

        );         