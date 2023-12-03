package DemoApplication.NopCommerce.Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.StringUtil;

public class NopCommerce_DemoApplication_Utility {

	
	public WebDriver driver;
	public static Properties pf = null;
	
	public static void ReadProperties() throws IOException
	{
		pf = new Properties();
		FileInputStream f1 = new FileInputStream(System.getProperty("user.dir") +"\\Resources\\DemoApplication.properties");
		pf.load(f1);
	}
	

	// ====================================================================================
	// NavigateToRequiredModule
	//=====================================================================================
	public void NavigateToRequiredModule(String requiredModule) throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			if(!driver.findElement(By.className("")).isDisplayed())
			{
				System.out.println("-------------  In Refresh Mode  ----------"+requiredModule);
				driver.navigate().refresh();
				Thread.sleep(5000);
			}
		}
		catch(Exception e)		
		{
			System.out.println("------   Exception In Refresh Mode ------");
			driver.navigate().refresh();
			Thread.sleep(5000);
		}		
		@SuppressWarnings("unused")
		boolean booleanNavigateToRequiredModule = false;
		int intCounter = 0;
		String[] arrRequiredmodule = null;
		if(!requiredModule.trim().isEmpty())
		{
			arrRequiredmodule = requiredModule.split("\\|");
			for(int i=0;i<arrRequiredmodule.length-1;i++)
			{
				List<WebElement> listOfItems = driver.findElements(By.tagName("a"));
				for(WebElement we:listOfItems)
				{
					if(we.getText().equals(arrRequiredmodule[i]))
					{
						we.click();
						System.out.println("Clicked on Link -"+we.getText());
						Thread.sleep(5000);
						intCounter++;
						booleanNavigateToRequiredModule = true;
						break;
					}
				}
			}
		}
		if(booleanNavigateToRequiredModule = false |intCounter!=arrRequiredmodule.length)
		{
			System.out.println("Unable to navigate required module");
		}	
	}
	//========================================================================================
	// Set Text On Edit
	//========================================================================================
	public void setTextOnEdit(By objElementName,String editValue) throws Throwable
	{
		@SuppressWarnings("unused")
		boolean boolsetTextOnEdit = false;
		int attempt=0;
		while(attempt < 3)
		{
			try
			{
				if(driver.findElements(objElementName).size()!=0)
				{
					String strName = driver.findElement(objElementName).getAttribute("name");					
					driver.findElement(objElementName).clear();
				    driver.findElement(objElementName).sendKeys(editValue);
					boolsetTextOnEdit =true;
					System.out.println("Set Text On edit named : "+ strName +"  and Value "+editValue);
					break;
				}
			}
			catch(Exception e)
			{
				
			}
			attempt++;			
		}
		if(boolsetTextOnEdit=false)
		{
			System.out.println("WebEdit with Name :"+driver.findElement(objElementName).getAttribute("name")+" was not found");
		}
	}
	//======================================================================================================================
	public void selectItemFromWebList(By objElementName,String ItemValue) throws InterruptedException,NoSuchElementException 
	{
		@SuppressWarnings("unused")
		boolean selectItemFromWebList=false;
		try
		{
			// StringUtil.isnotBlank(ItemValue)    to   StringUtil.isBlank(ItemValue)
			if(driver.findElements(objElementName).size()!=0&& StringUtil.isBlank(ItemValue))
			{
				Select itemstoSelect = new Select(driver.findElement(objElementName));
				System.out.println("Inside selectItemFromWebList ");
				String strName = driver.findElement(objElementName).getAttribute("name");
				itemstoSelect.selectByVisibleText(ItemValue);
				selectItemFromWebList = true;
				System.out.println("Selected Item in weblist : "+strName+ " Value "+ItemValue);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			try
			{
				if(driver.findElements(objElementName).size()!=0&& StringUtil.isBlank(ItemValue))
				{
					Select itemstoSelect = new Select(driver.findElement(objElementName));					
					String strName = driver.findElement(objElementName).getAttribute("name");
					List<WebElement> allOptions = itemstoSelect.getOptions();
					for(WebElement i:allOptions)
					{
						if(i.getText().equalsIgnoreCase(ItemValue))
						{
							String tValue = i.getText(); 
							itemstoSelect.selectByVisibleText(tValue);
							selectItemFromWebList = true;
							System.out.println("Selected Item in weblist : "+strName+ " Value "+tValue);;
						}
					}
						
				}
		    }
			catch(Exception s)
			{
				
			}
	    }
	}
	//======================================================================================================================
	public void clickOnButton(By objElementName) throws Throwable
	{
		@SuppressWarnings("unused")
		boolean boolclickOnButton = false;
		int attempts = 0;
		while(attempts < 3 && driver.findElements(objElementName).size()!=0)
		{
			try
			{
				if(driver.findElements(objElementName).size()!=0)
				{
					String strName = driver.findElement(objElementName).getAttribute("name");
					driver.findElement(objElementName).click();
					Thread.sleep(5000);
					boolclickOnButton = true;					
					System.out.println("Clicked on Button : "+strName);
					break;
				}
				break;
			}
			catch(StaleElementReferenceException e)
			{
				
			}
			attempts++;			
		}
		if(boolclickOnButton = false)
		{
			System.out.println("WebButton with nmae : "+driver.findElement(objElementName).getAttribute("name")+" was not found");
		}
	}
	//======================================================================================================================
	public String getElementText(By objElementName)
	{		
		try
		{
			if(driver.findElement(objElementName).isDisplayed())
			{
				return driver.findElement(objElementName).getText();
			}
		}
		catch(Exception e)
		{
			return null;
		}
		return null;	
	}
	//======================================================================================================================
		public String getTheImageElementText(By objElementName)
		{		
			try
			{
				if(driver.findElement(objElementName).isDisplayed())
				{
					return driver.findElement(objElementName).getAttribute("alt");
				}
			}
			catch(Exception e)
			{
				return null;
			}
			return null;	
		}
	//========================================================================================
	// get Text On Edit
	//========================================================================================
		public String getTextOnEdit(By objElementName) throws Throwable
		{			
			int attempt=3;
			while(attempt < 3)
			{
				try
				{
					if(driver.findElements(objElementName).size()!=0)
					{																	
					    return driver.findElement(objElementName).getText();
					}
				}
				catch(Exception e)
				{
					
				}
				attempt++;			
			}			
			return null;
		}
	//======================================================================================================================
	public void waitUntilWebElementExist(By strItem)
	{
		System.out.println("Searching for the Element - Started");
		WebDriverWait wb = new WebDriverWait(driver,20);
		wb.until(ExpectedConditions.presenceOfElementLocated(strItem));
		System.out.println("Searching for the Element - Ended");
	}
	
	//======================================================================================================================
	
	public void VerifyWebElementExist(By strItem)
	{
		try
		{
			//WebDriverWait wb = new WebDriverWait(driver,20);
			//wb.until(ExpectedConditions.presenceOfElementLocated(strItem));
			if(driver.findElement(strItem).isDisplayed())
			{
				System.out.println("Searching for the Element - is displayed");
			}
		}
		catch(NoSuchElementException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	//======================================================================================================================
	
	public void clickonLink(By objElementName)
	{
		@SuppressWarnings("unused")
		boolean boolclickonlink=false;
		int attempts=0;
		while(attempts<3)
		{
			try
			{
				waitUntilWebElementExist(objElementName);
				if(driver.findElements(objElementName).size()!=0)
				{
					String strName = driver.findElement(objElementName).getAttribute("name");
					driver.findElement(objElementName).click();
					boolclickonlink = true;
					System.out.println("Clicked on Link :"+strName); 
					break;
				}
			}
			catch(StaleElementReferenceException e)			
			{
				
			}
			attempts++;
		}
		if(boolclickonlink=false)
		{
			System.out.println("Link with the name : "+driver.findElement(objElementName).getAttribute("name")+" was not found");
		}
	}
	
	
}
