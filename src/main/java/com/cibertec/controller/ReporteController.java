package com.cibertec.controller;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReporteController {
	
	@Autowired
	private DataSource dataSource;

	/*
	 * @RequestMapping("/{reportName}") public void
	 * reporte(@PathVariable("reportName") final String reportName,
	 * 
	 * @RequestParam(required = false) Map<String, Object> parameters,
	 * HttpServletResponse response, HttpServletRequest request) throws Exception {
	 * System.out.println("Se genera el repote "+reportName); parameters =
	 * parameters == null ? new HashMap<>() : parameters; ClassPathResource resource
	 * = new ClassPathResource("reportes" + File.separator + reportName +
	 * ".jasper"); InputStream jasperStream = resource.getInputStream();
	 * JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	 * JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
	 * parameters, dataSource.getConnection());
	 * response.setContentType("application/pdf");
	 * response.setHeader("Content-Disposition", "inline;"); final OutputStream
	 * outputStream = response.getOutputStream();
	 * JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream); }
	 */

}
