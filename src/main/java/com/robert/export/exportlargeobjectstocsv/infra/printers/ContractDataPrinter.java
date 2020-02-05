package com.robert.export.exportlargeobjectstocsv.infra.printers;

import com.robert.export.exportlargeobjectstocsv.domain.Contract;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ContractDataPrinter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractDataPrinter.class);

    public static void printContract(Contract contract, CSVPrinter printer) {
        try {
            printer.print(contract.data1);
            printer.print(contract.data2);
            printer.print(contract.data3);
            printer.print(contract.data4);
            printer.print(contract.data5);
            printer.print(contract.data6);
            printer.print(contract.data7);
        } catch (IOException e) {
            LOG.error("Error writing contract data: ", e);
        }
    }
}
