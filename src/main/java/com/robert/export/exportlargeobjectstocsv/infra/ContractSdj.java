package com.robert.export.exportlargeobjectstocsv.infra;

import com.robert.export.exportlargeobjectstocsv.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractSdj extends JpaRepository<Contract, String> {
}
