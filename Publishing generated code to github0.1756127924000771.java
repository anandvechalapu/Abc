
Controller:

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitPublishController {

    private final GitPublishService gitPublishService;

    public GitPublishController(GitPublishService gitPublishService) {
        this.gitPublishService = gitPublishService;
    }

    @PostMapping("/git/publish")
    public Response publishCode(@RequestBody Request request) {
        return gitPublishService.publish(request);
    }
}

Service:

import org.springframework.stereotype.Service;

@Service
public class GitPublishService {

    private final GitPublishRepository gitPublishRepository;

    public GitPublishService(GitPublishRepository gitPublishRepository) {
        this.gitPublishRepository = gitPublishRepository;
    }

    public Response publish(Request request) {
        // Create organization if it does not exist
        gitPublishRepository.createOrganization(request.getOrganizationName());

        // Create repository with given repo name
        gitPublishRepository.createRepository(request.getRepoName());

        // Deploy the generated code to the specified repository
        gitPublishRepository.deployCode(request.getCode());

        // Get the response indicating the success of the code publication
        Response response = gitPublishRepository.getResponse(request);

        // Update the request status and link in the Java API after the code is published
        gitPublishRepository.updateRequestStatusAndLink(request, response);

        // Update the request data based on the input
        gitPublishRepository.updateRequestData(request);

        return response;
    }
}

Repository:

import org.springframework.data.jpa.repository.JpaRepository;

public interface GitPublishRepository extends JpaRepository<Request, Long> {
    void createOrganization(String organizationName);

    void createRepository(String repoName);

    void deployCode(String code);

    Response getResponse(Request request);

    void updateRequestStatusAndLink(Request request, Response response);

    void updateRequestData(Request request);
}