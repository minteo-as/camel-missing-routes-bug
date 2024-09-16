package org.example.routes;

import org.springframework.stereotype.Component;

@Component
public class AuthenticateRoutes extends MainRoutes {
  public static final String DIRECT_AUTHENTICATE = "direct:authenticate";

  @Override
  public void configure() throws Exception {
    super.configure();

    this.from(DIRECT_AUTHENTICATE)
        .to("log:org.example?level=INFO&showHeaders=true");
  }
}
