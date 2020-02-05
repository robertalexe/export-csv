package com.robert.export.exportlargeobjectstocsv;

import com.robert.export.exportlargeobjectstocsv.domain.Contract;
import com.robert.export.exportlargeobjectstocsv.infra.ContractSdj;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.UUID;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static net.bytebuddy.utility.RandomString.make;

@Profile("INSERT_DATA")
@Component
public class InsertDataRunner implements CommandLineRunner {

    private ContractSdj sdj;

    public InsertDataRunner(ContractSdj sdj) {
        this.sdj = requireNonNull(sdj);
    }

    @Override
    public void run(String... args) {
        for(int i=1; i<=5000; i++) {
            sdj.save(generateRandom());
        }
        sdj.flush();
    }

    private Contract generateRandom() {
        Contract contract = new Contract();
        contract.id = UUID.randomUUID().toString();
        contract.data1 = make(20);
        contract.data2 = make(20);
        contract.data3 = make(20);
        contract.data4 = make(20);
        contract.data5 = make(20);
        contract.data6 = make(20);
        contract.data7 = make(20);
        contract.title = make(100);
        contract.list1 = new HashSet<>(asList(make(15), make(15), make(15), make(15)));
        contract.list2 = new HashSet<>(asList(make(40), make(40), make(40), make(40)));
        return contract;
    }
}
