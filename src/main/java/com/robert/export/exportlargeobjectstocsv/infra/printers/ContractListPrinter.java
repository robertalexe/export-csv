package com.robert.export.exportlargeobjectstocsv.infra.printers;

import com.robert.export.exportlargeobjectstocsv.domain.Contract;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static java.util.stream.Collectors.joining;

public class ContractListPrinter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractCsvPrinter.class);

    public static void printLists(Contract contract, CSVPrinter printer) {
        try {
            printer.print(contract.list1.stream().collect(joining(",")));
            printer.print(contract.list2.stream().collect(joining(",")));
        } catch (IOException e) {
            LOG.error("Error writing contract: ", e);
        }
    }
}
