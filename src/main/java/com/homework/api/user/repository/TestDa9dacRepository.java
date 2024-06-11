package com.homework.api.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homework.api.user.model.TestDa9dac;

@Repository
public interface TestDa9dacRepository extends JpaRepository<TestDa9dac, String> {

	@Modifying
	@Transactional
	@Query("UPDATE TestDa9dac t SET t.useYn = 'N', t.updaDt = CURRENT_TIMESTAMP, t.updaUser = :updaUser WHERE t.userId IN :userIds")
	void updateUseYnAndUpdaUserByUserIdIn(@Param("userIds") List<String> userIds, String updaUser);
}
