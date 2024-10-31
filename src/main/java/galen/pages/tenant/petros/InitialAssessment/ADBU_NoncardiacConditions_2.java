package galen.pages.tenant.petros.InitialAssessment;

import galen.helpers.common.GalenReport;
import galen.helpers.tenant.petros.PetrosReport;
import galen.pages.common.BasePage;
import galen.pages.common.CheckboxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;

public class ADBU_NoncardiacConditions_2 extends CheckboxPage {
    public By nonCardiacHeader = By.className("adbuNonCardiacScreen2");

    public ADBU_NoncardiacConditions_2(WebDriver driver) {
        super(driver);
        titleText="NON-CARDIAC HEALTH CONDITIONS";
    }

    public WebElement getHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nonCardiacHeader));
    }

    public boolean verifyAtPage(@Nullable GalenReport report) {
        return basicHelpers.verifyAtPage(getHeader().isDisplayed(), "Non-Cardiac Conditions Screen 2", report);
    }

}