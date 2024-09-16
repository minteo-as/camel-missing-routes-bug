package org.example.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRoutes extends MainRoutes {
  @Override
  public void configure() throws Exception {
    super.configure();

    this.restConfiguration()
        .component("undertow")
        .port("8090")
        .contextPath("{{server.servlet.context-path}}")
        .enableCORS(true)
        .corsAllowCredentials(true) // <-- Important
        .corsHeaderProperty("Access-Control-Allow-Origin", "*")
        .corsHeaderProperty("Access-Control-Allow-Headers", "Authorization, Content-Type")
        .corsHeaderProperty("Access-Control-Allow-Methods", "*")
        .corsHeaderProperty("Access-Control-Max-Age", "300")
        .apiContextPath("v3/api-docs")
        .apiProperty("api.title", "Example API")
        .apiProperty("api.description", "Example related API")
        .apiProperty("api.version", "1.0.0")
        .apiProperty("api.termsOfService", "https://register.example.org/terms")
        .apiProperty("api.license.name", "Commercial")
        .apiProperty("api.license.url", "https://example.org/license")
        .apiProperty("cors", "true");

    this.rest()
        .securityDefinitions()
        .oauth2("oauth2", "This API uses OAuth 2.0")
        .clientCredentials(
            "https://auth.example.org/realms/{subdomain}/protocol/openid-connect/token")
        .withScope("openid", "OpenID scope")
        .end()
        .end()
        .security("oauth2", "openid");
  }
}
