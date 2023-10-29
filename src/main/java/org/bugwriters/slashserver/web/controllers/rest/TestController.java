package org.bugwriters.slashserver.web.controllers.rest;

import org.bugwriters.slashserver.models.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600000)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public ResponseEntity<MessageResponse> allAccess() {
    return ResponseEntity.ok(new MessageResponse("Public Board"));
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('CLIENT') or hasRole('BUSINESS')")
  public ResponseEntity<MessageResponse> userAccess() {
    return ResponseEntity.ok(new MessageResponse("User Board"));
  }

  @GetMapping("/client")
  @PreAuthorize("hasRole('CLIENT')")
  public ResponseEntity<MessageResponse> moderatorAccess() {
    return ResponseEntity.ok(new MessageResponse("CLIENT Board"));
  }

  @GetMapping("/business")
  @PreAuthorize("hasRole('BUSINESS')")
  public ResponseEntity<MessageResponse> adminAccess() {
    return ResponseEntity.ok(new MessageResponse("BUSINESS Board"));
  }
}
