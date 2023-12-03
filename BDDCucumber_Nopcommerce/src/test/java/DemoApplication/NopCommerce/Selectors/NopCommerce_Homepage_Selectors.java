package DemoApplication.NopCommerce.Selectors;

import org.openqa.selenium.By;

import DemoApplication.NopCommerce.Common.NopCommerce_DemoApplication_SharedResources;
import DemoApplication.NopCommerce.Common.NopCommerce_DemoApplication_Utility;


public class NopCommerce_Homepage_Selectors {


	private By edit_LoginName;
	private By edit_Password;
	private By button_Login;
	private By image_NopCommerce;
	private By button_Logout;
	
	public void NopCommerce_HomePage_Selectors_Objects() {

		edit_LoginName = By.id("Email");
		edit_Password = By.name("Password");
		button_Login = By.name("submit");
		image_NopCommerce = By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[1]/strong");
		button_Logout = By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a");

	}

	private NopCommerce_DemoApplication_Utility utils;
	private NopCommerce_DemoApplication_SharedResources sharedResources;

	public NopCommerce_Homepage_Selectors(NopCommerce_DemoApplication_Utility utils,
			NopCommerce_DemoApplication_SharedResources sharedResources) {
		this.utils = utils;
		this.sharedResources = sharedResources;
		NopCommerce_HomePage_Selectors_Objects();
	}

	public void verifyNewToursImageDisplayedOrNot() {
		utils.VerifyWebElementExist(image_NopCommerce);
		System.out.println("New Tours Image Imgae is displayed");
	}

	public void enterText_into_edit_username(String uName) throws Throwable {
		utils.setTextOnEdit(edit_LoginName, uName);
		Thread.sleep(1000);
	}

	public void enterText_into_edit_password(String uPassword) throws Throwable {
		utils.setTextOnEdit(edit_Password, uPassword);
		Thread.sleep(1000);
	}

	public void clickOn_Button_SignIn() throws Throwable {
		utils.clickOnButton(button_Login);
	}

	public String getThetextFromLogout() {
		return utils.getElementText(button_Logout);
		//neeed to validate the text Logout text presence on logout button
	}
	
}
