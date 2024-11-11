package q2;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LanguageBean {

    private String selectedState;
    private String selectedLanguage;

    public void updateLanguage() {
        if ("Karnataka".equals(selectedState)) {
            selectedLanguage = "Kannada";
        } else if ("Maharashtra".equals(selectedState)) {
            selectedLanguage = "Marathi";
        } else if ("Tamil Nadu".equals(selectedState)) {
            selectedLanguage = "Tamil";
        } else if ("Kerala".equals(selectedState)) {
            selectedLanguage = "Malayalam";
        } else {
            selectedLanguage = "English"; // Default language
        }
    }

    public String getSelectedState() {
        return selectedState;
    }

    public void setSelectedState(String selectedState) {
        this.selectedState = selectedState;
        updateLanguage(); // Update language whenever state changes
    }

    public String getSelectedLanguage() {
        return selectedLanguage;
    }
}
