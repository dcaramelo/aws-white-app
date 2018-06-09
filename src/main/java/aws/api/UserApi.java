package aws.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

  private final UserRepository userRepository;

  @Autowired
  public UserApi(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping("/add")
  public User add(@RequestParam(value="name", defaultValue="World") String name) {
    User user = new User().setName(name).setActive(Boolean.TRUE);
    userRepository.save(user);
    return user;
  }

  @RequestMapping("/get")
  public User get(@RequestParam(value="id", defaultValue="1") Integer id) throws Exception {
    Optional<User> userOptional = userRepository.findById(Long.valueOf(id));

    return userOptional.orElseThrow(Exception::new);
  }
}
