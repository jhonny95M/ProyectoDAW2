package com.cibertec.controller;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@RestController
public class ReporteController {

	@Autowired
	private DataSource dataSource;

	@RequestMapping("report/{reportName}")
	public void reporte(@PathVariable("reportName") final String reportName,

			@RequestParam(required = false) Map<String, Object> parameters, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		System.out.println("Se genera el repote " + reportName);
		parameters = parameters == null ? new HashMap<>() : parameters;
		ClassPathResource resource = new ClassPathResource("reportes" + File.separator + reportName + ".jasper");
		InputStream jasperStream = resource.getInputStream();
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline;");
		final OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}

}
