package com.militao.certification_nlw.modules.students.useCases;


import com.militao.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.militao.certification_nlw.modules.students.repositories.CertificationStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifyIfHasCertificationUseCase {

    private final CertificationStudentRepository certificationStudentRepository;
    public boolean execute(VerifyHasCertificationDTO dto) {
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if (!result.isEmpty()) {
            return true;
        }
        return false;
    }
}