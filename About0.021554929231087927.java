·       Ability to fill the mail form and send mail without login.

@RestController
public class IntroductionController {

    @Autowired
    private IntroductionService introductionService;

    @GetMapping("/introduction")
    public Introduction getIntroduction() {
        return introductionService.getIntroduction();
    }

    @PostMapping("/email")
    public void sendEmail(@RequestBody EmailRequest emailRequest) {
        introductionService.sendEmail(emailRequest.getEmail(), emailRequest.getMessage());
    }
}

@Service
public class IntroductionService {

    @Autowired
    private IntroductionRepository introductionRepository;

    public Introduction getIntroduction() {
        return introductionRepository.getIntroduction();
    }

    public void sendEmail(String email, String message) {
        introductionRepository.sendEmail(email, message);
    }
}

@Repository
public class IntroductionRepository {

    public Introduction getIntroduction() {
        // Retrieve introduction from the database
    }

    public void sendEmail(String email, String message) {
        // Send email with the given parameters
    }
}