package com.cibertec.controller;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.model.Alumno;
import com.cibertec.model.Curso;
import com.cibertec.model.Matricula;
import com.cibertec.model.repository.AlumnoRepository;
import com.cibertec.model.repository.CursoRepository;
import com.cibertec.model.repository.HorarioRepository;
import com.cibertec.model.repository.MatriculaRepository;
import com.cibertec.model.repository.ProfesorRepository;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoRepository aRepo;
	@Autowired
	private CursoRepository cRepo;
	@Autowired
	private MatriculaRepository mRepo;
	@Autowired
	private ProfesorRepository pRepo;
	@Autowired
	private HorarioRepository hRepo;
	
	@GetMapping("cargaLogin")
	public String cargarLogin(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "Login";
	}
	
	Alumno a;
	@PostMapping("/validar")
	public String validarUsu(@ModelAttribute Alumno alumno, Model model) {		
		a = aRepo.findByUsualumAndPassalum(alumno.getUsualum(), alumno.getPassalum());
		if (a==null) {
			model.addAttribute("alumno", new Alumno());
			model.addAttribute("mensaje","usuario o clave incorrecto");
			return "Login";
		}else {
			model.addAttribute("alumno", a);
			return "Principal";
		}		
	}
	
	@GetMapping("/cargaRegistrar")
	public String cargarRegistrar(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "Registro";
	}
	
	@PostMapping("/registrar")
	public String registrarAlum(@ModelAttribute Alumno alumno, Model model) {
		if (alumno.getNomalum() =="" || alumno.getApealum() =="" || alumno.getDnialum() =="" || alumno.getCelalum() =="" || 
			alumno.getFechalum() =="" || alumno.getUsualum() =="" || alumno.getPassalum() =="") {
			model.addAttribute("mensaje", "Error al registrar, revise los datos");
			return "Registro";
		} else {
		aRepo.save(alumno);
		model.addAttribute("mensaje", "Se registro correctamente al alumno: "+alumno.getNomalum());
		return "Registro";
		}
	}
	
	@GetMapping("/cargaActualizar")
	public String cargarActualizar(Model model) {
		model.addAttribute("alumno", a);
		return "ActualizaDatos";
	}
	
	@PostMapping("/actualizar")
	public String actualizarAlum(@ModelAttribute Alumno alumno, Model model) {
		if (alumno.getNomalum() == "" || alumno.getApealum() == "" || alumno.getDnialum()  =="" || alumno.getCelalum()  =="" || 
			alumno.getFechalum()  =="" || alumno.getUsualum()  =="" || alumno.getPassalum()  =="") {
			model.addAttribute("mensaje", "Error al actualizar, revise los datos");
			return "ActualizaDatos";
		} else {
		aRepo.save(alumno);
		model.addAttribute("mensaje", "Se actualizaron los datos del alumno: "+alumno.getIdalumno());
		return "ActualizaDatos";
		}
	}
	
	@GetMapping("/cargaMat")
	public String cargarMat(@ModelAttribute Curso curso, Model model) {
		model.addAttribute("curso", cRepo.findById(curso.getIdcurso()));
		model.addAttribute("alumno", a);
		model.addAttribute("lstHorarios", hRepo.findAll());
		return "Matricula";
	}
	
	@RequestMapping("/mat")
    public String mat(    	
    	@RequestParam(value = "idalumno", required = false)Integer idalumno,
        @RequestParam(value = "idcurso", required = false)Integer idcurso,
        @RequestParam(value = "idhorario", required = false)Integer idhorario,
        @RequestParam(value = "idprof", required = false)Integer idprof,
        Model model)
	{
		Matricula x = mRepo.findByIdalumnoAndIdcurso(idalumno, idcurso);
		if(x==null)
		{ 
			Calendar c = Calendar.getInstance();
			String dia = Integer.toString(c.get(Calendar.DATE));
			String mes = Integer.toString(c.get(Calendar.MONTH)+1);
			String anio = Integer.toString(c.get(Calendar.YEAR));
			String fecha=anio+"/"+mes+"/"+dia;
			
	        Matricula m = new Matricula();
	        m.setIdalumno(idalumno);
	        m.setIdcurso(idcurso);
	        m.setIdhorario(idhorario);
	        m.setFechmat(fecha);
	        m.setIdprof(idprof);
	        
	        mRepo.save(m);
			model.addAttribute("mensaje", "Se ha matriculado en el curso: "+m.getIdcurso());
			model.addAttribute("curso", cRepo.findById(idcurso));
			model.addAttribute("alumno", a);
			return "Matricula";
		}
		else {			
			model.addAttribute("mensaje","Usted ya se ha matriculado en este curso");
			model.addAttribute("curso", cRepo.findById(idcurso));
			model.addAttribute("alumno", a);
			return "Matricula";
		}
		
    }
	
	@GetMapping("/cargaConso")
	public String cargarConso(Model model) {
		model.addAttribute("alumno", a);		
		model.addAttribute("lstMat", mRepo.findByIdalumno(a.getIdalumno()));
		model.addAttribute("lstCursos", cRepo.findAll());
		model.addAttribute("lstHorarios", hRepo.findAll());
		model.addAttribute("lstProfesores", pRepo.findAll());
		return "Consolidado";
	}
	
}
