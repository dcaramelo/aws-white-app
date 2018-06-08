package aws.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

  @RequestMapping("/hello")
  public User greeting(@RequestParam(value="name", defaultValue="World") String name) {
    return new User(name, Boolean.TRUE);
  }
}
