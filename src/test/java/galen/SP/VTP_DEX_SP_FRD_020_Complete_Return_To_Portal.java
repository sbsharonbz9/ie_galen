package galen.SP;

import com.itextpdf.io.IOException;
import galen.base.BaseTest;
import galen.enums.SP.RoleType;
import galen.enums.framework.UrlType;
import galen.helpers.common.BasicHelpers;
import galen.helpers.common.CommonPageFeatures;
import galen.helpers.common.GalenReport;
import galen.helpers.tenant.dexter.DexterNavigations;
import galen.helpers.tenant.dexter.DexterUser;
import galen.helpers.tenant.dexter.DexterUserTemplates;
import galen.pages.sp.Participants;
import galen.pages.sp.StudyAdminPageObj;
import galen.pages.tenant.dexter.InitialAssessment.DexterPageObj;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class VTP_DEX_SP_FRD_020_Complete_Return_To_Portal extends BaseTest {

    public static final String OBJECTIVE = "To verify once an authorized portal user has completed and submitted a " +
            "health survey for a participant, the portal shall provide notification of successful completion and " +
            "a button to return to the portal dashboard.";
    public static final String NOTES = "This protocol contains the following scenarios:\n" +
            "o\tClinician Lead user is returned to Study Portal after assessment completion\n" +
            "o\tClinician role user is returned to Study Portal after assessment completion";

    static String REQUIREMENTS = "DEX_SP_FRD_020";
    static String REFERENCES = "N/A";
    StudyAdminPageObj pageObj;
    String reportName = "VTP_DEX_SP_FRD_020_Complete_Return_To_Portal";
    ArrayList<String> VERSIONHISTORY = new ArrayList<>();
    HashMap<String, String[]> PREEXECUTION = new HashMap<>();
    public BasicHelpers bh;
    public CommonPageFeatures commonPageFeatures;

    VTP_DEX_SP_FRD_020_Complete_Return_To_Portal() {
        VERSIONHISTORY.add("1.0;28FEB2023;Per CADENCE-191: Initial Test Script;James Reale");
        VERSIONHISTORY.add("2.0;30JUL2024;Per CADENCE-624: Update Test Steps to reflect changes made to the assessment flow;James Reale\n");
    }

    @Test
    public void VTP_DEX_SP_FRD_020_Complete_Return_To_Portal_Test() throws IOException, InterruptedException, java.io.IOException {
        report = new GalenReport(driver, reportName, OBJECTIVE, REQUIREMENTS, REFERENCES, NOTES, VERSIONHISTORY, PREEXECUTION);
        report.reportTitle = "VTP_DEX_SP_FRD_020 – Completed Assessment Return to Study Portal";
        bh = new BasicHelpers(driver);
        DexterUser user = new DexterUserTemplates().createHappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker();
        pageObj = new StudyAdminPageObj(driver);
        DexterPageObj dexPageObj = new DexterPageObj(driver);
        Participants par = pageObj.participants;
        pageObj.pritUnl.authenticateUserIfRequired(UrlType.STUDY);
        pageObj.login.logIn(RoleType.CLINICIAN_LEAD.email, report);

        par.verifyAtPage(report);
        par.clickViewRecords(report);
        String original = driver.getWindowHandle();
        pageObj.viewRecords.createNewRecord(report);

        new DexterNavigations(driver).partialNavigationIA(user, dexPageObj.purchaseOptions, report );
        bh.verifyDisplayedFlex(By.tagName("a"), "Link back to SAP", report);
        report.addScreenshotStep("Step37_ClinicianLeadLink");
        bh.clickFlex(By.tagName("a"), "Study Portal link", report);
        sleep(2000);
        driver.switchTo().window(original);
        pageObj.viewRecords.verifyAtPage(report);
        report.addScreenshotStep("Step38_BackToSP");

        pageObj.viewRecords.logout(report);
        par.load(UrlType.STUDY);
        pageObj.login.logIn(RoleType.CLINICIAN.email, report);
        par.verifyAtPage(report);
        par.clickViewRecords(report);
        pageObj.viewRecords.createNewRecord(report);
        new DexterNavigations(driver).partialNavigationIA(user, dexPageObj.purchaseOptions, report );
        bh.verifyDisplayedFlex(By.tagName("a"), "Link back to SAP", report);
        report.addScreenshotStep("Step75_ClinicianLink");
        bh.clickFlex(By.tagName("a"), "Study Portal link", report);
        sleep(2000);
        driver.switchTo().window(original);
        pageObj.viewRecords.verifyAtPage(report);
        report.addScreenshotStep("Step76_BackToSP");
    }
}