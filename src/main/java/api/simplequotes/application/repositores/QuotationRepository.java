package api.simplequotes.application.repositores;

import org.springframework.data.repository.CrudRepository;

import api.simplequotes.application.models.Quotation;

public interface QuotationRepository extends CrudRepository<Quotation, Long> {
  boolean existsByQuotationContent(String quotationContent);
}
