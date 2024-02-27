# Spring-Security-Online-Lesson
  > Spring Tool Suite 4: 4.15.1.RELEASE

  > Marketplace: Thymeleaf Plugin for Eclipse 3.0.0

  > pom.xml
    <dependencies>
  		<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-security</artifactId>
  		</dependency>
  		<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-thymeleaf</artifactId>
  		</dependency>
  		<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-web</artifactId>
  		</dependency>
  		<dependency>
  			<groupId>org.thymeleaf.extras</groupId>
  			<!-- spring-boot-starter-parent, v3.2.2, no thymeleaf-extras-springsecurity5 -->
  			<!-- <artifactId>thymeleaf-extras-springsecurity6</artifactId> -->
  			<artifactId>thymeleaf-extras-springsecurity5</artifactId>
  		</dependency>
  
  		<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-tomcat</artifactId>
  			<scope>provided</scope>
  		</dependency>
  		<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-test</artifactId>
  			<scope>test</scope>
  		</dependency>
  		<dependency>
  			<groupId>org.springframework.security</groupId>
  			<artifactId>spring-security-test</artifactId>
  			<scope>test</scope>
  		</dependency>
  		<!-- Database Driver - MySQL -->
  		<dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>8.0.26</version>
          </dependency>
          <!-- Hibernate Entity Manager -->
          <dependency>
              <groupId>org.hibernate</groupId>
              <artifactId>hibernate-core</artifactId>
          </dependency>
          <!-- Spring Boot Starter for Data JPA -->
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-data-jpa</artifactId>
          </dependency>
  	</dependencies>
