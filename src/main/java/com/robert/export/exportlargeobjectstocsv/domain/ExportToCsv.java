package com.robert.export.exportlargeobjectstocsv.domain;

import java.io.IOException;
import java.io.PrintWriter;

public interface ExportToCsv {
    void exportToCsv(PrintWriter out) throws IOException;
}
