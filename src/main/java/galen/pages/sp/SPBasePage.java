package galen.pages.sp;

import galen.enums.SP.AccountTabs;
import galen.helpers.common.GalenReport;
import galen.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class SPBasePage extends BasePage {

    public By defaultHeader = By.xpath("//h1[text()='Participants']"); // default first page
    public By logout = By.xpath("//a[@href='/logout']");
    public By menu = By.xpath(".account-card-nav");
    public By table = By.tagName("table");
    public By activeToggle = By.xpath("//div[contains(@class, 'react-toggle')]");
    public By inactiveToggle = By.xpath("//div[contains(@class,'react-toggle') and not (contains(@class, 'checked'))]");
    public By saveButton = By.xpath("//button[text()='Save']");
    public By saveChangesButton = By.xpath("//button[text()='Save Changes']");

    public SPBasePage(WebDriver driver) {
        super(driver);
        headingTitle = defaultHeader;
    }

    public WebElement getLogout() { return basicHelpers.getWebElement(logout);}
    public WebElement getActiveToggle() { return basicHelpers.getWebElement(activeToggle); }

    public void selectTab(AccountTabs tab, @Nullable GalenReport report) {
        basicHelpers.clickFlex(By.xpath(tab.selector), tab + " tab", report);
    }

    public void selectTabToPage(AccountTabs tab, BasePage toPage, @Nullable GalenReport report) {
        basicHelpers.verifyClickToPageTransition(toPage, By.xpath(tab.selector), tab + " tab", report);
    }

    public void clickSave(@Nullable GalenReport report) {
        basicHelpers.verifyClickToNavNotDisplayed(saveButton, "Save", saveButton,"Add modal",
                report);
    }

    public void clickSaveChangesButton(@Nullable GalenReport report) {
        basicHelpers.verifyClickToNavNotDisplayed(saveChangesButton, "Save Changes", saveChangesButton,"Edit modal",
                report);
    }

    public int findIndexOfColumn(String columnName) {
        List<WebElement> columns = basicHelpers.getAllWebElements(By.tagName("th"));
        int columnNo = 0;
        for (WebElement column : columns) {
            if (column.getText().equalsIgnoreCase(columnName)) {
                columnNo = columns.indexOf(column);
            }
        }
        return columnNo;
    }

    public List<String> getColumnValuesInText(String column) {
        int columnNo = findIndexOfColumn(column) + 1;
        List<String> columnValuesText = new LinkedList<>();
        List<WebElement> columnValues = basicHelpers.getAllWebElements(By.xpath("//tr/td[" + columnNo + "]"));
        for (WebElement columnValue : columnValues) {
            columnValuesText.add(columnValue.getText());
        }
        return columnValuesText;
    }

    public void verifyColumnDescending(String columnName, @Nullable GalenReport report) {
        boolean result = true;
        List<String> columnValuesText = getColumnValuesInText(columnName);
        boolean current;

        for (int i = 1; i < columnValuesText.size(); i++) {
            current = columnValuesText.get(i).compareToIgnoreCase(columnValuesText.get(i - 1)) <= 0;
            if (!current) {
                result = false;
                break;
            }
        }
        boolean finalResult = result;
        basicHelpers.verifyCondition(() -> finalResult, "all items in the '" + columnName + "' column" +
                " are in descending order", false, report);
    }

    public void verifyColumnAscending(String columnName, @Nullable GalenReport report) {
        boolean result = true;
        List<String> columnValuesText = getColumnValuesInText(columnName);
        boolean current;

        for (int i = 1; i < columnValuesText.size(); i++) {
            current = columnValuesText.get(i).compareToIgnoreCase(columnValuesText.get(i - 1)) >= 0;
            if (!current) {
                result = false;
                break;
            }
        }
        boolean finalResult = result;
        basicHelpers.verifyCondition(() -> finalResult, "all items in the '" + columnName + "' column are in ascending order",
                false, report);
    }

    public void verifyTabsDisplayed(List<AccountTabs> tabs, @Nullable GalenReport report) {
        LinkedHashMap<String, By> tabVerifications = new LinkedHashMap<>();
        for (AccountTabs a : tabs) {
            tabVerifications.put(a.name(), By.xpath(a.selector));
        }
        basicHelpers.verifyElementsDisplayed(tabVerifications, report);
    }

    public void verifyTabsNotDisplayed(List<AccountTabs> tabs, @Nullable GalenReport report) {
        LinkedHashMap<String, By> tabVerifications = new LinkedHashMap<>();
        for (AccountTabs a : tabs) {
            tabVerifications.put(a.name(), By.xpath(a.selector));
        }
        basicHelpers.verifyElementsNotDisplayed(tabVerifications, report);
    }

    public void logout(@Nullable GalenReport report) {
        basicHelpers.verifyClickToPageTransition(new Login(driver), logout, "Logout", report);
    }

    public void clickStatusToggle( @Nullable GalenReport report) {
        By status = (getActiveToggle()!=null)?activeToggle:inactiveToggle;
        basicHelpers.clickFlex(status, "Status Toggle", report);
    }

    public void clickColumnHeader( String columnName, @Nullable GalenReport report) {
        basicHelpers.clickFlex(By.xpath("//th[normalize-space()='"+columnName+"']"), columnName, report);
    }

    public void clickAndVerifyAscending( String columnName, @Nullable GalenReport report) {
        clickColumnHeader(columnName, report);
        verifyColumnAscending(columnName, report);
    }

    public void clickAndVerifyDescending( String columnName, @Nullable GalenReport report) {
        clickColumnHeader(columnName, report);
        verifyColumnDescending(columnName, report);
    }
}