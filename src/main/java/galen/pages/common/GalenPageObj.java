package galen.pages.common;

import org.openqa.selenium.WebDriver;

public class GalenPageObj {
    public WelcomePage welcomePage;
    public PrivacyPage privacyPage;
    public PritUnlPage pritUnl;
    public Kickout kickoutPage;
    public OAuth oAuth;
    public String tenant;


    public GalenPageObj(WebDriver driver) {
        pritUnl = new PritUnlPage(driver);
        welcomePage = new WelcomePage(driver);
        privacyPage = new PrivacyPage(driver);
        oAuth = new OAuth(driver);
        kickoutPage = new Kickout(driver);
    }
}
