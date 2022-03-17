package api.simplequotes.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api.simplequotes.application.dtos.Dto;
import api.simplequotes.application.models.Quotation;
import api.simplequotes.application.services.QuotationService;

@RestController
@RequestMapping(path = "/application")
public class MainController {

  @Autowired
  private QuotationService quotationService;

  @PostMapping
  public @ResponseBody ResponseEntity<Object> addQuotation(@RequestBody @Valid Dto dto) {
    Quotation quotation = new Quotation();

    if (quotationService.existsQuotationByContent(dto.getQuotationContent())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLICT: This quotation already exists.");
    }

    quotation.setYear(Integer.parseInt(dto.getYear()));
    quotation.setAuthor(dto.getAuthor());
    quotation.setQuotationContent(dto.getQuotationContent());
    quotation.setUrlImgAssociatedWhithIt(dto.getUrlImgAssociatedWithIt());
    return ResponseEntity.status(HttpStatus.CREATED).body(quotationService.add(quotation));
  }

  @PutMapping("/{id}")
  public @ResponseBody ResponseEntity<Object> replace(@RequestBody Dto dto, @PathVariable(value = "id") int id) {

    Quotation quotation = new Quotation();

    quotation.setYear(Integer.parseInt(dto.getYear()));
    quotation.setAuthor(dto.getAuthor());
    quotation.setQuotationContent(dto.getQuotationContent());
    quotation.setUrlImgAssociatedWhithIt(dto.getUrlImgAssociatedWithIt());
    return ResponseEntity.status(HttpStatus.OK).body(quotationService.update(quotation, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> remove(@PathVariable(value = "id") int id) {
    if (!quotationService.existsQuotationById(id)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quotation not found.");
    }

    quotationService.deleteQuotation(id);
    return ResponseEntity.status(HttpStatus.OK).body("The quotation was succesfully deleted.");
  }

  @GetMapping
  public @ResponseBody ResponseEntity<Object> allQuotes() {
    return ResponseEntity.status(HttpStatus.OK).body(quotationService.getAll());
  }

  @GetMapping("/{id}")
  public @ResponseBody ResponseEntity<Object> getSomeQuote(@PathVariable(value = "id") int id) {
    if (!quotationService.existsQuotationById(id)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quotation not found.");
    }

    return ResponseEntity.status(HttpStatus.OK).body(quotationService.getQuotation(id));
  }

}
