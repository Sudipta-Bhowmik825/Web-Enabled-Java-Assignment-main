package q1;

//PaymentBean.java (Managed Bean)
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class PaymentBean {
 private String amount;
 private String creditCardNumber;
 private String expirationDate;
 private boolean valid; // Boolean to track if the form is valid

 public String getAmount() {
     return amount;
 }

 public void setAmount(String amount) {
     this.amount = amount;
 }

 public String getCreditCardNumber() {
     return creditCardNumber;
 }

 public void setCreditCardNumber(String creditCardNumber) {
     this.creditCardNumber = creditCardNumber;
 }

 public String getExpirationDate() {
     return expirationDate;
 }

 public void setExpirationDate(String expirationDate) {
     this.expirationDate = expirationDate;
 }

 public boolean isValid() {
     return valid;
 }

 public String processPayment() {
     // Here you can add your payment processing logic.
     // For now, we just set the 'valid' flag to true when the payment is processed.
     
     // Assuming all input is valid at this point
     valid = true;
     
     // Add success message to context
     FacesMessage successMessage = new FacesMessage("The credit card information is valid.");
     FacesContext.getCurrentInstance().addMessage(null, successMessage);

     return null; // Stay on the same page
 }
}
