package api.simplequotes.application.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Quotations")
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 4)
    private Integer year;

    @Column(nullable = false, length = 70)
    private String author;
  
    @Column(nullable = false, columnDefinition = "text")
    private String quotationContent;

    @Column(nullable = true, columnDefinition = "text")
    private String urlImgAssociatedWhithIt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuotationContent() {
        return quotationContent;
    }

    public void setQuotationContent(String quotationContent) {
        this.quotationContent = quotationContent;
    }

    public String getUrlImgAssociatedWhithIt() {
        return urlImgAssociatedWhithIt;
    }

    public void setUrlImgAssociatedWhithIt(String urlImgAssociatedWhithIt) {
        this.urlImgAssociatedWhithIt = urlImgAssociatedWhithIt;
    }

}
