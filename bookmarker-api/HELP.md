Spring Starter IO Project Structure - 
https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.1.3&packaging=jar&jvmVersion=17&groupId=com.project&artifactId=bookmarker-api&name=bookmarker-api&description=bookmark%20api%20backend&packageName=com.project.bookmarker&dependencies=devtools,lombok,configuration-processor,web,actuator,testcontainers,data-jpa,flyway,h2,validation,mysql

@RequiredArgsConstructor - This annotation of Lombok can be used to inject the dependencies.
@JsonProperty("isFirstPage") - Customize name of a property

Way to generate Sequence : 
@Id
@SequenceGenerator(name = "bm_id_seq_gen", sequenceName = "bm_id_seq")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bm_id_seq_gen")
private Long id;


@Transactional(readOnly = true) - This can be added on top of a Service class method in case of Get operation. It helps Hibernate to optimise.