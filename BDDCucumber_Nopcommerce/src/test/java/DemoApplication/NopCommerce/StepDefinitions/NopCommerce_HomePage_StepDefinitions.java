package DemoApplication.NopCommerce.StepDefinitions;

import java.util.Map;
import DemoApplication.NopCommerce.Common.NopCommerce_DemoApplication_SharedResources;
import DemoApplication.NopCommerce.Common.NopCommerce_DemoApplication_Utility;
import DemoApplication.NopCommerce.Steps.NopCommerce_HomePage_Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NopCommerce_HomePage_StepDefinitions {

	private NopCommerce_DemoApplication_Utility utils;
	private NopCommerce_DemoApplication_SharedResources sharedResources;
	private NopCommerce_HomePage_Steps NopCommercePageSteps;
	
	public NopCommerce_HomePage_StepDefinitions(NopCommerce_DemoApplication_Utility utils,
			NopCommerce_DemoApplication_SharedResources sharedResources) {
		this.utils = utils;
		this.sharedResources = sharedResources;
		init();
	}

	public void init() {
		NopCommercePageSteps = new NopCommerce_HomePage_Steps(utils, sharedResources);
	}

	@When("^User Launch the required NopCommerce URL$")
	public void user_Launch_the_required_NopCommerce_URL() {

		if (NopCommerce_DemoApplication_SharedResources.performAppLaunch) {

			System.out.println("OrangeHRM URL Launched");
		}
	}

	@Given("^The user is in NopCommerce application$")
	public void the_user_is_in_NopCommerce_application() throws Throwable {
		NopCommercePageSteps.perform_Image_Verification();
	}

	@When("^He input the Email into Login Name field$")
	public void he_input_the_Email_into_Login_Name_field(Map<String, String> Email) throws Throwable {
		NopCommercePageSteps.performInputInto_edit_UserName(Email);
	}

	@When("^He input required password into Password field$")
	public void he_input_required_password_into_Password_field(Map<String, String> PASSWORD) throws Throwable {
		NopCommercePageSteps.performInputInto_edit_Password(PASSWORD);
	}

	@Then("^Click on Login button$")
	public void click_on_Login_button() throws Throwable {
		NopCommercePageSteps.performClickon_button_SignIn();
	}

	@Then("^Application Navigates to Dashboard Information Page$")
	public void application_Navigates_to_Dashboard_Information_Page() throws Throwable {
		NopCommercePageSteps.performgetElementText();
	}
}


