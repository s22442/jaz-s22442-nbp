package com.pjatk.jazs22442nbp.goldrate.repository;

import com.pjatk.jazs22442nbp.goldrate.model.GoldRateRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoldRateRepository extends JpaRepository<GoldRateRequest, Integer> {
}
