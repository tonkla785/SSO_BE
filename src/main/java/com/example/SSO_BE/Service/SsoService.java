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
        if (ssoRequestDTO == null) {
            throw new IllegalArgumentException("ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getSsoType())) {
            throw new IllegalArgumentException("ssoType ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getSystemId())) {
            throw new IllegalArgumentException("systemId ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getSystemName())) {
            throw new IllegalArgumentException("systemName ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getSystemTransactions())) {
            throw new IllegalArgumentException("systemTransactions ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getSystemPrivileges())) {
            throw new IllegalArgumentException("systemPrivileges ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getSystemUserGroup())) {
            throw new IllegalArgumentException("systemUserGroup ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getSystemLocationGroup())) {
            throw new IllegalArgumentException("systemLocationGroup ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getUserId())) {
            throw new IllegalArgumentException("userId ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getUserFullName())) {
            throw new IllegalArgumentException("userFullName ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getUserRdOfficeCode())) {
            throw new IllegalArgumentException("userRdOfficeCode ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getUserOfficeCode())) {
            throw new IllegalArgumentException("userOfficeCode ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getClientLocation())) {
            throw new IllegalArgumentException("clientLocation ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getLocationMachineNumber())) {
            throw new IllegalArgumentException("locationMachineNumber ไม่สามารถเป็นค่าว่างได้");
        }
        if (ObjectUtils.isEmpty(ssoRequestDTO.getTokenId())) {
            throw new IllegalArgumentException("tokenId ไม่สามารถเป็นค่าว่างได้");
        }
    }

}
