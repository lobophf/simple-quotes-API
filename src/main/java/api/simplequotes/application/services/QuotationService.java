package api.simplequotes.application.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.simplequotes.application.models.Quotation;
import api.simplequotes.application.repositores.QuotationRepository;

@Service
public class QuotationService {

  @Autowired
  private QuotationRepository quotationRepository;

  @Transactional
  public Quotation add(Quotation quotations) {
    return quotationRepository.save(quotations);
  }

  public Object getAll() {
    return quotationRepository.findAll();
  }

  @Transactional
  public void deleteQuotation(int id) {
    quotationRepository.deleteById(id);
  }

  public Optional<Quotation> update(Quotation quotation, int id) {
    return quotationRepository.findById(id)
        .map(newQuotation -> {
          quotation.setAuthor(quotation.getAuthor());
          quotation.setQuotationContent(quotation.getQuotationContent());
          quotation.setYear(quotation.getYear());
          quotation.setUrlImgAssociatedWhithIt(quotation.getUrlImgAssociatedWhithIt());
          return quotationRepository.save(quotation);
        });
  }

  public Object getQuotation(int id) {
    return quotationRepository.findById(id);
  }

  public boolean existsQuotationById(int id) {
    return quotationRepository.existsById(id);
  }

  public boolean existsQuotationByContent(String content) {
    return quotationRepository.existsByQuotationContent(content);
  }

}
