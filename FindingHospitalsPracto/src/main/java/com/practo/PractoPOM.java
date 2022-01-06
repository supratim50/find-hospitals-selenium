package com.practo;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class PractoPOM {



WebDriver driver1;
static By submitbutton=By.id("button-style");
static By location=By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div/input");
static By cityname=By.xpath("//div[text()='Bangalore']");
static By hospital=By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div/input");
static By hospitalname=By.xpath("//div[text()='Hospital']");
static By c24x7=By.xpath("//div[@data-qa-id='Open_24X7_checkbox']");
static By allfilters=By.xpath("//span[text()='All Filters']");
static By hasparking=By.xpath("//span[text()='Has Parking']");
static By totalhospitals=By.xpath("//span[@data-qa-id='results_count']");
static By ratings=By.xpath("//span[@class='common__star-rating__value']");
static By hnames=By.xpath("//*[@data-qa-id='hospital_name']");
static By diagnosticpage=By.xpath("//span[text()='Book Diagnostic Tests']");
static By topcities= By.xpath("//div[@class='u-margint--standard o-f-color--primary']");
static By providersdropdown=By.xpath("//div[@class='providers-marketing nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']/span[2]");
static By corporatewellness=By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div/div[4]/a");
static By name=By.xpath("//*[@id=\"name\"]");
static By organisation=By.xpath("//*[@id=\"organization_name\"]");
static By mailbox=By.xpath("//*[@id=\"official_email_id\"]");
static By contactno=By.xpath("//*[@id=\"official_phone_no\"]");
static By orgsize=By.id("organization_size");



}