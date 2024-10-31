package galen.pages.tenant.dexter.InitialAssessment;

import galen.pages.Checkout.*;
import galen.pages.common.DocAttestationNo;
import galen.pages.common.GalenPageObj;
import org.openqa.selenium.WebDriver;

public class DexterPageObj extends GalenPageObj {
    public Numbers numbers;
    public UsedProduct usedProduct;
    public OrderForSelf orderForSelf;
    public Smoking smoking;
    public SmokingDisclaimer smokingDisclaimer;
    public Menstrual menstrual;
    public EverHadCancer everHadCancer;
    public CancerList cancerList;
    public BloodPressureMeds bloodPressureMeds;
    public BirthYear birthYear;
    public BirthControl birthControl;
    public BirthControlB birthControlB;
    public PreventPregnancy pregnancy;
    public Antifungal antifungal;
    public AntifungalMeds antifungalMeds;
    public BloodClot bloodClot;
    public CardiacRisk cardiacRisk;
    public BreastFeeding breastFeeding;
    public DDICondition ddiCondition;
    public DDIHepC ddiHepC;
    public DDIEpBipolar ddiEpBipolar;
    public DDIThyroid ddiThyroid;
    public DDIHIV ddihiv;
    public DDIHighCholesterol ddiHighCholesterol;
    public Depression depression;
    public DiagnosedDepression diagnosedDepression;
    public Diabetes diabetes;
    public ReviewAnswers review;
    public ADBU adbu;
    public ADBUBP adbubpScreen;
    public ADBUBPNormal adbubpNormal;
    public ADBUBC adbuddi;
    public EnterBP enterBP;
    public EnterBPEnd enterBPEnd;
    public Gallbladder gallbladder;
    public IrregularHeartBeat irregularHeartBeat;
    public KnowBPNumber knowBPNumber;
    public LiverCancer liverCancer;
    public Migraines migraines;
    public OAuthPostReview oAuthPostReview;
    public ObesityBMI obesity;
    public OrderConfirmation orderConfirmation;
    public OtherMedication otherMedication;
    public PurchaseOptions purchaseOptions;
    public PaymentInfo paymentInfo;
    public PaymentMethod paymentMethod;
    public PregnancyLoss pregnancyLoss;
    public Pregnant pregnant;
    public PreviewOrder previewOrder;
    public Product product;
    public PurchasePage purchase;
    public ShippingAddress shippingAddress;
    public ShippingMethod shippingMethod;
    public VaginalBleeding vaginalBleeding;
    public WelcomePage welcomePage;
    public DNUPreventPregnancyScreen dnuPreventPregnancy;
    public DocAttestationNo docAttestationNo;

    public DexterPageObj(WebDriver driver) {
        super(driver);
        welcomePage = new WelcomePage(driver);
        numbers = new Numbers(driver);
        usedProduct = new UsedProduct(driver);
        orderForSelf = new OrderForSelf(driver);
        smoking = new Smoking(driver);
        smokingDisclaimer = new SmokingDisclaimer(driver);
        menstrual = new Menstrual(driver);
        everHadCancer = new EverHadCancer(driver);
        cancerList = new CancerList(driver);
        bloodPressureMeds = new BloodPressureMeds(driver);
        cardiacRisk = new CardiacRisk(driver);
        birthYear = new BirthYear(driver);
        birthControl = new BirthControl(driver);
        birthControlB = new BirthControlB(driver);
        pregnancy = new PreventPregnancy(driver);
        antifungal = new Antifungal(driver);
        antifungalMeds = new AntifungalMeds(driver);
        bloodClot = new BloodClot(driver);
        breastFeeding = new BreastFeeding(driver);
        cardiacRisk = new CardiacRisk(driver);
        ddiCondition = new DDICondition(driver);
        ddiHepC = new DDIHepC(driver);
        ddiEpBipolar = new DDIEpBipolar(driver);
        ddihiv = new DDIHIV(driver);
        ddiThyroid = new DDIThyroid(driver);
        ddiHighCholesterol = new DDIHighCholesterol(driver);
        depression = new Depression(driver);
        diagnosedDepression = new DiagnosedDepression(driver);
        diabetes = new Diabetes(driver);
        review = new ReviewAnswers(driver);
        adbu = new ADBU(driver);
        adbubpScreen = new ADBUBP(driver);
        adbubpNormal = new ADBUBPNormal(driver);
        adbuddi= new ADBUBC(driver);
        oAuthPostReview = new OAuthPostReview(driver);
        enterBP = new EnterBP(driver);
        enterBPEnd = new EnterBPEnd(driver);
        gallbladder = new Gallbladder(driver);
        irregularHeartBeat = new IrregularHeartBeat(driver);
        knowBPNumber = new KnowBPNumber(driver);
        liverCancer = new LiverCancer(driver);
        migraines = new Migraines(driver);
        obesity = new ObesityBMI(driver);
        orderConfirmation = new OrderConfirmation(driver);
        otherMedication = new OtherMedication(driver);
        paymentInfo = new PaymentInfo(driver);
        paymentMethod = new PaymentMethod(driver);
        pregnancyLoss = new PregnancyLoss(driver);
        pregnant = new Pregnant(driver);
        purchaseOptions = new PurchaseOptions(driver);
        previewOrder = new PreviewOrder(driver);
        product = new Product(driver);
        purchase = new PurchasePage(driver);
        shippingAddress = new ShippingAddress(driver);
        shippingMethod = new ShippingMethod(driver);
        vaginalBleeding = new VaginalBleeding(driver);
        dnuPreventPregnancy=new DNUPreventPregnancyScreen(driver);
        docAttestationNo = new DocAttestationNo(driver);
    }
}