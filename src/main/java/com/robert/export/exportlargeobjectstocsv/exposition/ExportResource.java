package com.robert.export.exportlargeobjectstocsv.exposition;

import com.robert.export.exportlargeobjectstocsv.domain.ExportToCsv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.requireNonNull;

@RestController
public class ExportResource {

    private ExportToCsv export;

    public ExportResource(ExportToCsv export) {
        this.export = requireNonNull(export);
    }

    @GetMapping("/export-db")
    public void downloadFile(HttpServletResponse response) throws IOException {
        export.exportToCsv(response.getWriter());
    }
}
