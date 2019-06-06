This application is a resource server application.  The application works only with a Oauth2 server with database connection and role based permission schema. To know how to generate different types of access tokens please refer to spring-boot2-oauth2-auth-server-jwt-derby  github project. 
This resource server has few protected resources for  three different role users 1. role_admin 2. role_user 3. role_apiuser
@GetMapping("/test")   
 http://localhost:8080/test  no token needed
 
 @GetMapping("/customers")
 @PreAuthorize("hasAnyAuthority('role_admin','role_user','role_apiuser')")
 http://localhost:8080/customers   request header should contain  a admin or user or apiuser access_token 
 
 @GetMapping("/customers/{id}")
 @PreAuthorize("hasAnyAuthority('role_admin','role_user','role_apiuser')")
 http://localhost:8080/customers/1   request header should contain  a admin or user or apiuser access_token 
 
 @GetMapping("/good-customers")
 @PreAuthorize("hasAuthority('role_admin')")
 http://localhost:8080/good-customers   request header should contain  a admin access_token
 
 @PostMapping("/customer/post")
 @PreAuthorize("hasAuthority('role_admin')")
 http://localhost:8080/customer/post   request header should contain  a admin access_token
 
 @GetMapping("/events")   
 @PreAuthorize("hasAuthority('role_apiuser')")
 http://localhost:8080/events   request header should contain  a admin or user or apiuser access_token 


To know how to generate different types of access tokens please refer to spring-boot2-oauth2-auth-server-jwt-derby  github project for more details on server. https://github.com/anjansharmasid/spring-boot2-oauth2-auth-server-jwt-derby
 
