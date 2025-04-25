package com.jee.hopital.web;

import com.jee.hopital.entities.Patient;
import com.jee.hopital.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    setValue(text.isEmpty() ? null : dateFormat.parse(text));
                } catch (ParseException e) {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                return getValue() == null ? "" : dateFormat.format((Date) getValue());
            }
        });
    }
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "pages", defaultValue = "0") int page,
                        @RequestParam(name = "pageSize", defaultValue = "4")  int pageSize,
                        @RequestParam(name = "keyword", defaultValue = "")  String kw,
                        @RequestParam(name = "message", required = false) String message
                        ) {
       Page<Patient> patientList = patientRepository.findByNomContaining(kw,PageRequest.of(page,pageSize));

        model.addAttribute("patientList", patientList.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        model.addAttribute("totalPages", patientList.getTotalPages());

        int[] pages = new int[patientList.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pageNumbers", pages);

        if (message != null) {
            model.addAttribute("message", message);
        }

        return "patients";
    }

    @GetMapping("/delete")
    public String delete( Long id,
                          @RequestParam(name="keyword", defaultValue = "") String keyword,
                          @RequestParam(name="page", defaultValue = "0") int page) {
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword+"&message=Patient supprimé avec succès";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/formPatient")
    public String formPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatient";
    }

    @PostMapping("/savePatient")
    public String savePatient(Patient patient, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "Veuillez corriger les erreurs dans le formulaire");
            return "formPatient";
        }
        patientRepository.save(patient);
        return "redirect:/index?message=Patient ajouté avec succès";
    }

    @GetMapping("/editPatient")
    public String editPatient(Model model, Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) throw new RuntimeException("Patient not found");
        model.addAttribute("patient", patient);
        return "editPatient";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(Patient patient, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "Veuillez corriger les erreurs dans le formulaire");
            return "editPatient";
        }
        patientRepository.save(patient);
        return "redirect:/index?message=Patient modifié avec succès";
    }



}
