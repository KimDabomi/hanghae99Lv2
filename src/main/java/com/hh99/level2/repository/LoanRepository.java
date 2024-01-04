package com.hh99.level2.repository;

import com.hh99.level2.entity.Book;
import com.hh99.level2.entity.Loan;
import com.hh99.level2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByBookAndReturnStatusFalse(Book book);
    List<Loan> findByMemberAndReturnStatusFalse(Member member);
}