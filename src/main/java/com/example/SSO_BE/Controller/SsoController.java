package com.example.SSO_BE.Controller;

import com.example.SSO_BE.DTO.SsoRequestDTO;
import com.example.SSO_BE.DTO.SsoResponseDTO;
import com.example.SSO_BE.Service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/service")
public class SsoController {

    @Autowired
    private SsoService ssoService;

    @PostMapping("/gentoken")
    public ResponseEntity<?> createData(@RequestBody SsoRequestDTO ssoRequestDTO) {
        try {
            SsoResponseDTO data = ssoService.createSso(ssoRequestDTO);
            return ResponseEntity.ok(Map.of(
                    "responseCode", "I07000",
                    "responseMessage", "ทำรายการเรียบร้อย",
                    "responseData", data
            ));
        } catch (IllegalArgumentException e) {
            SsoResponseDTO data = new SsoResponseDTO();
            data.setUserId("WS233200");
            data.setTokenId("");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "responseCode", "E000001",
                    "responseMessage", e.getMessage(),
                    "responseData", data
            ));
        } catch (
                Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "responseStatus", 500,
                    "responseMessage", "ไม่สามารถเชื่อมต่อ database ได้"
            ));
        }
    }
}
