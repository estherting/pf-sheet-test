package org.primefaces.test;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class SheetDataRow implements Serializable {
    
    private Integer id;
    private String dataString;
    private Integer dataInteger;

    
    public SheetDataRow(){}
    public SheetDataRow(String inDataString, Integer inDataInteger) {
        dataString = inDataString;
        dataInteger = inDataInteger;
        id = inDataInteger;
    }


    @PostConstruct
    public void init() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDataString() { return dataString; }
    public void setDataString(String dataString) { this.dataString = dataString; }

    public Integer getDataInteger() { return dataInteger; }
    public void setDataInteger(Integer dataInteger) { this.dataInteger = dataInteger; }
}
