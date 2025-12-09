package com.example.SSO_BE.Service;

import com.example.SSO_BE.DTO.SsoRequestDTO;
import com.example.SSO_BE.DTO.SsoResponseDTO;
import com.example.SSO_BE.Entity.SsoEntity;
import com.example.SSO_BE.Repository.SsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Timestamp;

@Service
public class SsoService {

    @Autowired
    private SsoRepository ssoRepository;

    public SsoResponseDTO createSso(SsoRequestDTO ssoRequestDTO) {
        try {
            validfield(ssoRequestDTO);
            SsoEntity sos = new SsoEntity();

            sos.setRequestDate(new Timestamp(System.currentTimeMillis()));
            sos.setSsoType(ssoRequestDTO.getSsoType());
            sos.setSystemId(ssoRequestDTO.getSystemId());
            sos.setSystemName(ssoRequestDTO.getSystemName());
            sos.setSystemTransactions(ssoRequestDTO.getSystemTransactions());
            sos.setSystemPrivileges(ssoRequestDTO.getSystemPrivileges());
            sos.setSystemUserGroup(ssoRequestDTO.getSystemUserGroup());
            sos.setSystemLocationGroup(ssoRequestDTO.getSystemLocationGroup());
            sos.setUserId(ssoRequestDTO.getUserId());
            sos.setUserFullName(ssoRequestDTO.getUserFullName());
            sos.setUserRdOfficeCode(ssoRequestDTO.getUserRdOfficeCode());
            sos.setUserOfficeCode(ssoRequestDTO.getUserOfficeCode());
            sos.setClientLocation(ssoRequestDTO.getClientLocation());
            sos.setLocationMachineNumber(ssoRequestDTO.getLocationMachineNumber());
            sos.setTokenId(ssoRequestDTO.getTokenId());

            ssoRepository.save(sos);

            SsoResponseDTO sosResponse = new SsoResponseDTO();
            sosResponse.setUserId(sos.getUserId());
            sosResponse.setTokenId(sos.getTokenId());
            return sosResponse;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void validfield(SsoRequestDTO ssoRequestDTO) {

        if (ssoRequestDTO == null
                || ObjectUtils.isEmpty(ssoRequestDTO.getSsoType())
                || ObjectUtils.isEmpty(ssoRequestDTO.getSystemId())
                || ObjectUtils.isEmpty(ssoRequestDTO.getSystemName())
                || ObjectUtils.isEmpty(ssoRequestDTO.getSystemTransactions())
                || ObjectUtils.isEmpty(ssoRequestDTO.getSystemPrivileges())
                || ObjectUtils.isEmpty(ssoRequestDTO.getSystemUserGroup())
                || ObjectUtils.isEmpty(ssoRequestDTO.getSystemLocationGroup())
                || ObjectUtils.isEmpty(ssoRequestDTO.getUserId())
                || ObjectUtils.isEmpty(ssoRequestDTO.getUserFullName())
                || ObjectUtils.isEmpty(ssoRequestDTO.getUserRdOfficeCode())
                || ObjectUtils.isEmpty(ssoRequestDTO.getUserOfficeCode())
                || ObjectUtils.isEmpty(ssoRequestDTO.getClientLocation())
                || ObjectUtils.isEmpty(ssoRequestDTO.getLocationMachineNumber())
                || ObjectUtils.isEmpty(ssoRequestDTO.getTokenId())
        ) {
            throw new IllegalArgumentException("ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้");
        }
    }
}
