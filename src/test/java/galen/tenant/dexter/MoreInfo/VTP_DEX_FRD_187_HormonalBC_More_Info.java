package galen.tenant.dexter.MoreInfo;

import galen.base.BaseTest;
import galen.helpers.common.CommonPageFeatures;
import galen.helpers.common.GalenReport;
import galen.helpers.tenant.dexter.DexterHFWrappers;
import galen.helpers.tenant.dexter.DexterUser;
import galen.helpers.tenant.dexter.DexterUserTemplates;
import galen.pages.common.PritUnlPage;
import galen.pages.tenant.dexter.InitialAssessment.DexterPageObj;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class VTP_DEX_FRD_187_HormonalBC_More_Info extends BaseTest {


    static String OBJECTIVE = "To verify on the Hormonal BC (A) screen, the application shall provide a control which navigates to the Hormonal BC more information modal. ";
    static String NOTES = "None";

    static String REQUIREMENTS = "DEX_FRD_187";
    static String REFERENCES = "HappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker.docx";
    String reportName = "VTP_DEX_FRD_187_HormonalBC_More_Info";
    ArrayList<String> VERSIONHISTORY = new ArrayList<>();
    HashMap<String, String[]> PREEXECUTION = new HashMap<>();

    VTP_DEX_FRD_187_HormonalBC_More_Info() {
        VERSIONHISTORY.add("1.0;09MAR2023;Initial Test Script ;Name Redacted");
        VERSIONHISTORY.add("2.0;21JUN2024;Per CADENCE-478: Updated Test Steps for FDA changes \n"+
                "Per CADENCE-529: Removed N/A from Actual Result column for Happy flow execution related steps \n" +
                "Per CADENCE-591: Update Test Steps for modified assessment and navigation ;Name Redacted");
    }

    @Test
    public void VTP_DEX_FRD_187_HormonalBC_More_Info_Test() throws Exception {

        report = new GalenReport(driver, reportName, OBJECTIVE, REQUIREMENTS, REFERENCES, NOTES,
                VERSIONHISTORY, PREEXECUTION);
        report.reportTitle = "VTP_DEX_FRD_187_HormonalBC_More_Info";

        DexterUser user = new DexterUserTemplates().createHappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker();
        DexterPageObj pageObj = new DexterPageObj(driver);
        CommonPageFeatures common = new CommonPageFeatures(driver);

        new PritUnlPage(driver).authenticateUserIfRequired();
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.birthControl, report);
        common.verifyMoreInfoLinkDisplayed(report);
        report.addScreenshotStep("Step2_MoreInfoLink");
        common.clickMoreInfo(report);
        common.verifyMoreInfoDisplayed(report);
        report.addScreenshotStep("Step3_MoreInfoScreen");

    }
}
