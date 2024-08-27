package Blaze;


import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class DemonblazeTest {
    
    private WebDriver driver;
    
    @BeforeAll
    public static void configurationinit (){
        System.out.println("Conectarse a la base de datos");
    }
    @BeforeEach
    public void configuration (){
        System.out.println("Abrir el navegador, configurarlo y abrir la pagina de google");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://www.demoblaze.com/");
    }
    @Test
    public void IngresoSamsung (){ 

        //Buscar la categoria de telefonos
        WebElement catelement = driver.findElement(By.id("itemc"));
        catelement.click();
        //Seleccionar el modelo de Telefono solicitado
        WebElement OptionSamsung = driver.findElement(By.cssSelector( "a[href='prod.html?idp_=1']"));
        OptionSamsung.click();
        //Buscar por la clase el  precio en la hoja seleccionada 
        WebElement Samsungprecio = driver.findElement(By.className("price-container"));
        String Samsungpreciotext = Samsungprecio.getText();
        if (Samsungpreciotext.contains("$360")) {
            System.out.println("El precio se encontró y es: " + Samsungpreciotext);
        } else {
            System.out.println("No se pudo tomar el valor del precio.");
        }
    }
    @Test
    public void IngresoNokia (){ 

        //Buscar la categoria de telefonos
        WebElement catelement = driver.findElement(By.id("itemc"));
        catelement.click();
        //Buscar la categoria de telefonos
        WebElement OptionNokia= driver.findElement(By.xpath("//a[@class='hrefch' and text()='Nokia lumia 1520']"));
        OptionNokia.click();
        //Buscar por la clase el  precio en la hoja seleccionada 
        WebElement nokiaprecio = driver.findElement(By.className("price-container"));
        String nokiapreciotext = nokiaprecio.getText();
        if (nokiapreciotext.contains("$820")) {
            System.out.println("El precio se encontró y es: " + nokiapreciotext);
        } else {
            System.out.println("No se pudo tomar el valor del precio.");
        }
    }
    @Test
    public void IngresoLaptops (){ 

        //Buscar la categoria de Laptops
        WebElement catelement = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]"));
        catelement.click();
        //Buscar el modelo de la laptop solicitada
        WebElement OptionLaptop= driver.findElement(By.xpath("//a[@class='hrefch' and text()='Sony vaio i5']"));
        OptionLaptop.click();
        //Buscar por la clase el precio en la hoja seleccionada 
        WebElement Laptopprecio = driver.findElement(By.className("price-container"));
        String Laptoppreciotext = Laptopprecio.getText();


        if (Laptoppreciotext.contains("$790")) {
            System.out.println("El precio se encontró y es: " + Laptoppreciotext);
        } else {
            System.out.println("No se pudo tomar el valor del precio.");
        }
    }
    @Test
    public void IngresoLaptopsMacbook (){ 

        //Buscar la categoria de Laptops
        WebElement catelement = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]"));
        catelement.click();
        //Buscar el modelo de la laptop solicitada
        WebElement OptionMacbook= driver.findElement(By.xpath("//a[@class='hrefch' and text()='MacBook air']"));
        OptionMacbook.click();
        //Buscar por la clase el precio en la hoja seleccionada 
        WebElement Macbookprecio = driver.findElement(By.className("price-container"));
        String Macbookpreciotext = Macbookprecio.getText();
        if (Macbookpreciotext.contains("$790")) {
            System.out.println("El precio se encontró y es: " + Macbookpreciotext);
        } else {
            System.out.println("No se pudo tomar el valor del precio.");
        }



        //PUNTO DE CONTROL 
        WebElement imgDemon = driver.findElement(By.id("imgp"));
        assertTrue("Se enconntro la imagen",imgDemon.isDisplayed());
    }
   
    @Test
    public void IngresoMonitors (){ 

        //Buscar la categoria de Laptops
        WebElement catelement = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[4]"));
        catelement.click();
        //Buscar el modelo de la laptop solicitada
        WebElement Optionmonitor= driver.findElement(By.xpath("//a[@class='hrefch' and text()='ASUS Full HD']"));
        Optionmonitor.click();
        //Buscar por la clase el precio en la hoja seleccionada 
        WebElement monitorprecio = driver.findElement(By.className("price-container"));
        String monitorpreciotext = monitorprecio.getText();
        if (monitorpreciotext.contains("$230")) {
            System.out.println("El precio se encontró y es: " + monitorpreciotext);
        } else {
            System.out.println("No se pudo tomar el valor del precio.");
        }

    }
    @AfterEach
    public void cerrarnavegador() {
        System.out.println("cierra el navegador");
        driver.close();      
    }
    @AfterAll
    public static void configurationFin(){
        System.out.println("Desconectarse de la base de datos");
    }
}