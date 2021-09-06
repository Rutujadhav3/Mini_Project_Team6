package com.loginTests;
import Utils.ExcelUtils;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Pass_Validate_01 {
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void Vrfy_Uname() throws IOException, InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[2]/a")).click();
	  driver.findElement(By.name("username")).sendKeys(ExcelUtils.getUsername());
	  driver.findElement(By.name("password")).sendKeys(ExcelUtils.getPassword());
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/div/button")).submit();
	  Thread.sleep(2000);
	  
	  String name[]=driver.findElement(By.xpath("/html/body/div[1]")).getText().split(" ");
	  String ActualName=name[1];
	  System.out.println("ActualName="+ActualName);
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	 FileReader reader=new FileReader("Info.properties");
	 Properties prop=new Properties();
	 prop.load(reader); 
	 String url=prop.getProperty("url");
	 driver.get(url);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}