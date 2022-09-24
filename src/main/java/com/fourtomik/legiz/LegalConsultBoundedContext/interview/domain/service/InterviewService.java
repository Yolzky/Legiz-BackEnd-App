package com.fourtomik.legiz.LegalConsultBoundedContext.interview.domain.service;

import com.fourtomik.legiz.LegalConsultBoundedContext.interview.domain.model.Interview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface InterviewService {
    Interview createInterview(Long consultLegalId, Interview interview);
    Page<Interview> getAllInterviewByConsultLegalId(Long consultLegalId, Pageable pageable);
    Page<Interview> getAllInterview(Pageable pageable);
    Interview updateInterview(Long consultLegal, Long interviewId, Interview interviewRequest);
    ResponseEntity<?> deleteInterview(Long consultLegalId, Long interviewId);
}
