package com.hh99.level2.global;

import com.hh99.level2.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SchedulerMember {

    private final LoanService loanService;

    @Scheduled(cron = "0 0 12 * * *")
    public void memberPenaltyTask() {
        loanService.getLoanOverdueBooks();
    }
}
