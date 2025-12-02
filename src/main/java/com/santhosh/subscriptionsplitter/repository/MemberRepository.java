package com.santhosh.subscriptionsplitter.repository;

import com.santhosh.subscriptionsplitter.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
