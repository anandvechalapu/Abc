·       No error messages should be displayed when clicking on logout button.
·       User should be redirected to the login page.

Spring Boot Application

@SpringBootApplication
public class LogoutApplication {
	public static void main(String[] args) {
		SpringApplication.run(LogoutApplication.class, args);
	}
}

Controller

@RestController
public class LogoutController {

	@Autowired
	private LogoutService logoutService;

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout() {
		logoutService.logout();
	}

}

Service

@Service
public class LogoutService {

	@Autowired
	private LogoutRepository logoutRepository;

	public void logout() {
		logoutRepository.logout();
	}

}

Repository

@Repository
public class LogoutRepository {

	public void logout() {
		// Perform logout functionalities
	}

}