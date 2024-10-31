package galen.pages.tenant.dexter.InitialAssessment;

import galen.pages.common.CheckboxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class DDIHepC extends CheckboxPage {
    public  By title = By.className("HepatitisCScreen");
    public ArrayList<String> hepCOptions =
            new ArrayList<>(Arrays.asList("Ombitasvir","Paritaprevir","Ritonavir with dasabuvir",
    "None of these"));
    public ArrayList<String> allButNoneHepC =
            new ArrayList<>(Arrays.asList("Ombitasvir","Paritaprevir","Ritonavir with dasabuvir"));

    public DDIHepC(WebDriver driver) {
        super(driver);
        headingTitle=title;
        titleText="Are you currently or have you recently taken (within last 2-3 weeks) any of these Hepatitis C " +
                "medications?";
        reportText = "Hepatitis C Medications Screen";
        options=hepCOptions;
    }

}