package com.robert.export.exportlargeobjectstocsv.infra;

import com.robert.export.exportlargeobjectstocsv.domain.ExportToCsv;
import com.robert.export.exportlargeobjectstocsv.infra.printers.ContractCsvPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;

import static java.util.Objects.requireNonNull;

@Service
public class ExportToCsvImpl implements ExportToCsv {

    private ContractSdj sdj;

    public ExportToCsvImpl(ContractSdj sdj) {
        this.sdj = requireNonNull(sdj);
    }

    @Override
    public void exportToCsv(PrintWriter out) throws IOException {
        ContractCsvPrinter contractCsvPrinter = new ContractCsvPrinter(out);
        sdj.findAll().forEach(contractCsvPrinter::writeContract);
    }
}
