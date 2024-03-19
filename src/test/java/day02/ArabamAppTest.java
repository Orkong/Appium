package day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ArabamAppTest {

    AndroidDriver<AndroidElement>driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.dogan.arabam");
        // Calisacak oldugumuz uygulamayi baslatabilmek icin kullandigimiz capability
        // Buraya uygulmanin kimlik bilgisini girereek uzerinde calisacak oldugumuz uygulamayi baslatabiliriz

        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // appPackage belirledikten sonra uzerinde calisacak oldugumuz uygulamanin hangi sayfasindan baslayacagimizi
        // belirlemis oldugumuz capabilty deger.

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest() throws MalformedURLException {

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        /*
        driver.activateApp("com.dogan.arabam");
        // bu method uygulamanin ilk acilir penceresinden baslar
        */


        // 1.yol olarak uygulamanin kimlik biglisi uzerinden uygulamanin driver methoduyla aktif hale getirilebilir

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementByAccessibilityId("İlan Ver").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementById("com.dogan.arabam:id/tvAdvertSearch").click();

        // kategori olarak otomobil secilir
        driver.findElementByClassName("android.view.ViewGroup").click();



        // arac olarak Volkswagen secilir
        driver.findElementByAccessibilityId("8").click();

        // arac markasi olarak passat secilir
        driver.findElementByAccessibilityId("8").click();

        // 1.4 TSI BlueMotion secilir
        driver.findElementByAccessibilityId("2").click();

        // Paket secimi yapilir
        driver.findElementByAccessibilityId("2").click();

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementById("com.dogan.arabam:id/textViewSorting").click();
        driver.findElementByName("Fiyat - Ucuzdan Pahalıya").click();

        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir


    }
}
