package com.robert.export.exportlargeobjectstocsv.infra.printers;

import com.robert.export.exportlargeobjectstocsv.domain.Contract;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

public class ContractCsvPrinter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractCsvPrinter.class);

    private static final String HEADER = generateHeader();

    private final CSVPrinter printer;

    public ContractCsvPrinter(PrintWriter writer) throws IOException {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter('#').withHeader(HEADER);
        this.printer = new CSVPrinter(writer, csvFormat);
    }

    public void writeContract(Contract contract) {
        try {
            ContractDataPrinter.printContract(contract, printer);
            ContractListPrinter.printLists(contract, printer);
            printer.println();
        } catch (IOException e) {
            LOG.error("Error writing contract: ", e);
        }
    }

    private static String generateHeader() {
        return String.join("#","DATA1", "DATA2", "DATA3", "DATA4",
                "DATA5", "DATA6", "DATA7", "TITLE", "LIST1", "LIST2");
    }
}
