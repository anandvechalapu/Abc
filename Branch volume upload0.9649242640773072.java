·       Ability to enter the details in the fields.
·       Ability to choose file type as text/plain.
·       Ability to select the check box to overwrite the file.
·       Ability to click Validate and Store button.
·       Ability to display records processed successfully.

@SpringBootApplication
public class BranchVolumeUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(BranchVolumeUploadApplication.class, args);
	}

}

@RestController
@RequestMapping("/branch-volume-upload")
public class BranchVolumeUploadController {

	@Autowired
	private BranchVolumeUploadService branchVolumeUploadService;
	
	@GetMapping("/data-entry")
	public ResponseEntity<String> getDataEntry() {
		return ResponseEntity.ok("Data Entry functionality");
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file, @RequestParam("overwrite") boolean overwrite) {
		if (branchVolumeUploadService.upload(file, overwrite)) {
			return ResponseEntity.ok("Records processed successfully");
		}
		return ResponseEntity.badRequest().body("Error while processing records");
	}

}

@Service
public class BranchVolumeUploadService {

	@Autowired
	private BranchVolumeUploadRepository branchVolumeUploadRepository;
	
	public boolean upload(MultipartFile file, boolean overwrite) {
		// code for processing and validating the file
		if (file.getContentType().equals("text/plain")) {
			if (overwrite) {
				// code for overwriting the file
			} else {
				// code for not overwriting the file
			}
			// code for storing the file in the database
			branchVolumeUploadRepository.save(/*data*/);
			return true;
		}
		return false;
	}

}

@Repository
public interface BranchVolumeUploadRepository extends JpaRepository</*Entity Class*/, Long> {

}