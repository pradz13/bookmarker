Spring Starter IO Project Structure - 
https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.1.3&packaging=jar&jvmVersion=17&groupId=com.project&artifactId=bookmarker-api&name=bookmarker-api&description=bookmark%20api%20backend&packageName=com.project.bookmarker&dependencies=devtools,lombok,configuration-processor,web,actuator,testcontainers,data-jpa,flyway,h2,validation,mysql

@RequiredArgsConstructor - This annotation of Lombok can be used to inject the dependencies.
@JsonProperty("isFirstPage") - Customize name of a property

Way to generate Sequence : 
@Id
@SequenceGenerator(name = "bm_id_seq_gen", sequenceName = "bm_id_seq")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bm_id_seq_gen")
private Long id;

@Transactional(readOnly = true) - This can be added on top of a Service class method in case of Get operation. It helps Hibernate to optimize.

===============================================================================================================================================

Flyway migration :
Flyway migration scripts are auto detected by Spring Boot if they are kept under src/main/resources/db.migration.

Scripts can be named like -  V<version>__<file_name>.sql
Table and Sequence creation scripts looks like below :

create sequence bm_id_seq start with 1 increment by 50;

create table bookmarks (
id bigint default nextval('bm_id_seq') not null,
title varchar(255) not null,
url varchar(255) not null,
created_at timestamp(6) with time zone,
primary key (id)
);

All the history of the sql query executions are maintained in the table flyway_schema_history.

Once the flyway script gets executed, do not change it. Always write a new script.

This property can be used for specifying database specific migration scripts - 
spring.flyway.locations=classpath:/db/migration/{vendor}

H2 console can be viewed in - http://localhost:8080/h2-console

DTO projection can be done like this from repository layer to avoid using mappers -
@Query("select new com.project.bookmarker.dto.BookmarksDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b")
Page<BookmarksDTO> findBookmarks(Pageable pageable);

==============================================================================================
Github actions : build.yml should be placed in .github/workflows folder.
Secrets need to be created in Github - Dockerhub Username and Password in this case.
Docker image is created using the Jib plugin.