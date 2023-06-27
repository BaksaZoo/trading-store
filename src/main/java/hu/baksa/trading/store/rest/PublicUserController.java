package hu.baksa.trading.store.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicUserController {

    @GetMapping("/user")
    public @ResponseBody ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Authenticated");
    }

    @GetMapping("/api/user")
    public @ResponseBody ResponseEntity<String> getUserRoles() {
        return ResponseEntity.ok("Authorized");
    }
}
