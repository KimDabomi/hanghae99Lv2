package com.hh99.level2.repository;

import com.hh99.level2.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepository extends JpaRepository<Loan, Long> {
    Loan findByBookIdAndMemberId(Long bookId, Long memberId);
}
