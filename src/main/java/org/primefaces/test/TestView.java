package org.primefaces.test;
import org.primefaces.extensions.component.sheet.Sheet;
import org.primefaces.extensions.event.SheetEvent;
import org.primefaces.extensions.model.sheet.SheetUpdate;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.*;

@Named
@ViewScoped
public class TestView implements Serializable {
    
    private String testString;
    private HashMap<Integer, List<SheetDataRow>> testMap;
    private List<Integer> testList;
    private String testAjaxValue;
    
    @PostConstruct  
    public void init() {
        testString = "Welcome to PrimeFaces!!!";

        // generate sheet data
        testMap = new HashMap<>(3);
        testList = new ArrayList<>(3);
        for(int i = 0; i < 3; i++) {
            List<SheetDataRow> sheetDataRows = new ArrayList<>(2);
            for(int j = 0; j < 2; j++) {
                SheetDataRow row = new SheetDataRow("String data " + i + j, i + j);
                sheetDataRows.add(row);
            }

            testMap.put(i, sheetDataRows);
            testList.add(i);
        }

        testAjaxValue = "click 'Test AJAX update' button to change me";
    }

    public String getTestString() { return testString; }
    public void setTestString(String testString) { this.testString = testString; }

    public HashMap<Integer, List<SheetDataRow>> getTestMap() { return testMap; }
    public void setTestMap(HashMap<Integer, List<SheetDataRow>> inMap) { testMap = inMap; }

    public List<Integer> getTestList() { return testList; }
    public void setTestList(List<Integer> testList) { this.testList = testList; }

    public String getTestAjaxValue() { return testAjaxValue; }
    public void setTestAjaxValue(String testAjaxValue) { this.testAjaxValue = testAjaxValue; }

    public void cellChangeEvent(SheetEvent event) {
        System.out.println("inside cellChangeEvent()");

        Sheet sheet = event.getSheet();
        List<SheetUpdate> updates = sheet.getUpdates();
        if(updates != null && updates.size() > 0) {
            for(SheetUpdate sheetUpdate : updates)
            {
                System.out.println("updates are getting through :)");
            }
        } else {
            System.out.println("updates NOT getting through :(");
        }

        sheet.commitUpdates();
    }

    public void testAjax() {
        testAjaxValue = "AJAX update via commandButton works!";
    }
}
