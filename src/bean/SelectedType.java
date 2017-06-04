package bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public final class SelectedType {
    private String[] selectedTypes;
    private List<String> types;
     
    @PostConstruct
    public void init() {
        types = new ArrayList<String>();
        types.add("Salad");
        types.add("Meal");
        types.add("Fish");
        types.add("Dessert");
    }
 
    public String[] getSelectedTypes() {
        return selectedTypes;
    }
 
    public String[] setSelectedTypes(String type) {
        return this.selectedTypes = new String []{type};
    }
    
    public List<String> getTypes() {
        return types;
    }
}
