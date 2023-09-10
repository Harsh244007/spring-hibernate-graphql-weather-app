
api routes

get /weather
get /weather/country

post /weather
get /weather

Home and error pages are all set with error handling.

running with h2 driver and using graphql for schema

spring.datasource.url=jdbc:h2:mem:weather
spring.datasource.username=harsh
spring.datasource.password=harsh
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true