package com.hotelreservations.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", // Özellik dosyalarının yolu
        glue = "com.hotelreservations", // Adım tanımlamalarının paket yolu
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Raporlama formatı
)
public class TestRunner {

}
