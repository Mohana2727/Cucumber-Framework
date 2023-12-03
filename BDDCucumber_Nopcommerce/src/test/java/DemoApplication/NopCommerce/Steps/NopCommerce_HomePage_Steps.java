package DemoApplication.NopCommerce.Steps;

import java.util.Map;
import DemoApplication.NopCommerce.Common.NopCommerce_DemoApplication_SharedResources;
import DemoApplication.NopCommerce.Common.NopCommerce_DemoApplication_Utility;
import DemoApplication.NopCommerce.Selectors.NopCommerce_Homepage_Selectors;

public class NopCommerce_HomePage_Steps {

	
	private NopCommerce_DemoApplication_Utility utils;
	private NopCommerce_DemoApplication_SharedResources sharedResources;
	private NopCommerce_Homepage_Selectors NopCommerceHomepageSelectors;
	
	public NopCommerce_HomePage_Steps(NopCommerce_DemoApplication_Utility utils,
			NopCommerce_DemoApplication_SharedResources sharedResources)

	{
		this.utils = utils;
		this.sharedResources = sharedResources;
		init();
	}

	public void init() {
		NopCommerceHomepageSelectors = new NopCommerce_Homepage_Selectors(utils, sharedResources);
	}

	public void performInputInto_edit_UserName(Map<String, String> userName) throws Throwable {
		String username = userName.get("Email");
		NopCommerceHomepageSelectors.enterText_into_edit_username(username);
	}

	public void performInputInto_edit_Password(Map<String, String> passWord) throws Throwable {
		String password = passWord.get("password");
		NopCommerceHomepageSelectors.enterText_into_edit_password(password);
	}

	public void performClickon_button_SignIn() throws Throwable {
		NopCommerceHomepageSelectors.clickOn_Button_SignIn();
	}

	public void perform_Image_Verification() {
		NopCommerceHomepageSelectors.verifyNewToursImageDisplayedOrNot();
	}

	public void performgetElementText() {
		NopCommerceHomepageSelectors.getThetextFromLogout();
	}
	
}
