package galen.tenant.dexter.Navigation_Pages;

import galen.base.BaseTest;
import galen.enums.framework.UrlType;
import galen.helpers.common.CommonPageFeatures;
import galen.helpers.common.GalenReport;
import galen.helpers.tenant.dexter.DexterHFWrappers;
import galen.helpers.tenant.dexter.DexterUser;
import galen.pages.common.PritUnlPage;
import galen.pages.tenant.dexter.InitialAssessment.DexterPageObj;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class VTP_DEX_FRD_109_Clinically_Diagnosed_No_Navigation extends BaseTest {
    static String OBJECTIVE = "To verify If the user provides a denial response on the Clinical Depression Screen, the " +
            "application shall navigate to the Know BP Numbers Screen.";
    static String NOTES = "This protocol contains the following verification scenario(s): \n" +
            "Submitting No to Clinical Depression while initially performing health survey navigates to the Know BP " +
            "Numbers Screen";
    static String REQUIREMENTS = "DEX_FRD_109";
    static String REFERENCES = "HappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker.docx";
    String reportName = "VTP_DEX_FRD_109_Clinically_Diagnosed_No_Navigation";
    ArrayList<String> VERSIONHISTORY = new ArrayList<>();
    HashMap<String, String[]> PREEXECUTION = new HashMap<>();

    VTP_DEX_FRD_109_Clinically_Diagnosed_No_Navigation() {
        VERSIONHISTORY.add("1.0;11NOV2022;Initial Test Script;Suresh Sunderraj");
        VERSIONHISTORY.add("2.0;20JUN2024;Per CADENCE-567: Remove N/A from Expected Results column when using HappyFlow \n" +
                "Per CADENCE-591: Update Test Steps for modified assessment and navigation;James Reale");
    }

    @Test
    public void VTP_DEX_FRD_109_Clinically_Diagnosed_No_Navigation_Test() throws Exception {

        report = new GalenReport(driver, reportName, OBJECTIVE, REQUIREMENTS, REFERENCES, NOTES,
                VERSIONHISTORY, PREEXECUTION);
        report.reportTitle = "VTP_DEX_FRD_109_Clinically_Diagnosed_No_Navigation";
        DexterUser user = new DexterUser();
        DexterPageObj pageObj = new DexterPageObj(driver);
        CommonPageFeatures common = new CommonPageFeatures(driver);

        new PritUnlPage(driver).authenticateUserIfRequired(UrlType.DEXTER);
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.depression, report);
        common.clickYesNoNextToPage("Yes", pageObj.diagnosedDepression, report);
        common.clickYesNoNextToPage("No", pageObj.knowBPNumber, report);
        report.addScreenshotStep("Step3_Know_BP");
    }
}