package api.simplequotes.application.dtos;

import javax.validation.constraints.NotBlank;

public class Dto {

  @NotBlank
  private String author;

  @NotBlank
  private String year;

  @NotBlank
  private String quotationContent;

  private String urlImgAssociatedWithIt;

  public String getAuthor() {
    return author;
  }

public void setAuthor(String author) {
    this.author = author;
}

public String getYear() {
    return year;
}

public void setYear(String year) {
    this.year = year;
}

public String getQuotationContent() {
    return quotationContent;
}

public void setQuotationContent(String quotationContent) {
    this.quotationContent = quotationContent;
}

public String getUrlImgAssociatedWithIt() {
    return urlImgAssociatedWithIt;
}

public void setUrlImgAssociatedWithIt(String urlImgAssociatedWithIt) {
    this.urlImgAssociatedWithIt = urlImgAssociatedWithIt;
}

}
