package com.santhosh.subscriptionsplitter.repository;

import com.santhosh.subscriptionsplitter.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
