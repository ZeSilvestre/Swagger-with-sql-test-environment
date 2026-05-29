package br.com.estudos.ambienteteste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SwaggerRedirectController {

  @GetMapping({"/api/v1/swagger-ui.html", "/api/v1/swagger-ui/index.html"})
  public RedirectView redirectLegacySwaggerUi() {
    return new RedirectView("/swagger-ui/index.html");
  }
}
