/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;

/**
 *
 * @author Faraz Anwer
 */
public class BookErrorList {
    private boolean idMissing = false;
    private boolean idIllegal = false;
    private boolean booknameMissing = false;
    private boolean authornameMissing = false;
    private boolean publicationMissing = false;
    private boolean categoryMissing = false;
    private boolean priceMissing = false;
    private boolean priceNotNumeric = false;
    private boolean descriptionMissing = false;
    private boolean emailMissing = false;
    private boolean emailIllegal = false;
    private boolean bookAlreadyExists = false;

    public boolean isIdMissing() {
        return idMissing;
    }

    public void setIdMissing(boolean idMissing) {
        this.idMissing = idMissing;
    }

    public boolean isIdIllegal() {
        return idIllegal;
    }

    public void setIdIllegal(boolean idIllegal) {
        this.idIllegal = idIllegal;
    }

    public boolean isBooknameMissing() {
        return booknameMissing;
    }

    public void setBooknameMissing(boolean booknameMissing) {
        this.booknameMissing = booknameMissing;
    }

    public boolean isAuthornameMissing() {
        return authornameMissing;
    }

    public void setAuthornameMissing(boolean authornameMissing) {
        this.authornameMissing = authornameMissing;
    }

    public boolean isPublicationMissing() {
        return publicationMissing;
    }

    public void setPublicationMissing(boolean publicationMissing) {
        this.publicationMissing = publicationMissing;
    }

    public boolean isCategoryMissing() {
        return categoryMissing;
    }

    public void setCategoryMissing(boolean categoryMissing) {
        this.categoryMissing = categoryMissing;
    }

    public boolean isPriceMissing() {
        return priceMissing;
    }

    public void setPriceMissing(boolean priceMissing) {
        this.priceMissing = priceMissing;
    }

    public boolean isPriceNotNumeric() {
        return priceNotNumeric;
    }

    public void setPriceNotNumeric(boolean priceNotNumeric) {
        this.priceNotNumeric = priceNotNumeric;
    }

    public boolean isDescriptionMissing() {
        return descriptionMissing;
    }

    public void setDescriptionMissing(boolean descriptionMissing) {
        this.descriptionMissing = descriptionMissing;
    }

    public boolean isEmailMissing() {
        return emailMissing;
    }

    public void setEmailMissing(boolean emailMissing) {
        this.emailMissing = emailMissing;
    }

    public boolean isEmailIllegal() {
        return emailIllegal;
    }

    public void setEmailIllegal(boolean emailIllegal) {
        this.emailIllegal = emailIllegal;
    }

    public boolean isBookAlreadyExists() {
        return bookAlreadyExists;
    }

    public void setBookAlreadyExists(boolean bookAlreadyExists) {
        this.bookAlreadyExists = bookAlreadyExists;
    }

   
    
}
